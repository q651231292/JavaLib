package code;

import java.applet.Applet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;



public class CodeApplet extends Applet {
	//请求路径
	String reqPath;
	// 超时间隔
	private static int connectTimeOut = 60000;
	// 让connectionmanager管理httpclientconnection时是否关闭连接
	private static boolean alwaysClose = false;
	// 返回数据编码格式
	private String encoding = "UTF-8";

	private final HttpClient client = new HttpClient(new SimpleHttpConnectionManager());

	public HttpClient getHttpClient() {
		return client;
	}
	@Override
	public void init() {
		super.init();
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void inputCodeInfo(String jyId,String codeNum,String jymxId,String patientId) throws Exception {//单条打印
		System.out.println("单条打印---进入到Applet方法,开始打印参数");
		String CodeBase = getCodeBase().toString();
		reqPath = CodeBase+"addTM.action";
		System.out.println("请求路径->"+reqPath);
		System.out.println("打印JYID ->"+jyId);
		System.out.println("打印条码次数->"+codeNum);
		System.out.println("检验申请单Id->"+jymxId);
		System.out.println("病人Id"+patientId);
		Map date = new HashMap();
		date.put("jyidApplet", jyId);
		date.put("codeNumApplet", codeNum);
		date.put("jymxIdApplet", jymxId);
		date.put("patientIdApplet", patientId);
		System.out.println("准备进入Action方法");
		String reponsePicPath = doRequest(reqPath,date, null, null);
		System.out.println("响应图片路径->"+reponsePicPath);
		System.out.println("开始打印图片");
		PrintCode.printCode(reponsePicPath);
	}
	
	public void printCodes(String [] ids) throws Exception{//批量打印
		String CodeBase = getCodeBase().toString();
		reqPath = CodeBase+"addTM.action";
		System.out.println("ArrayVal->"+Arrays.toString(ids));
		Map date = new HashMap();
		for(String id:ids){
			if(id!=null){
				String[] str = id.split("/");
				for(int i=0;i<str.length;i++){
					if(i==0){date.put("jymxIdApplet", str[i]);System.out.println("Put jymxId->"+str[i]);}
					if(i==1){date.put("jyidApplet", str[i]);System.out.println("Put JyId->"+str[i]);}
					if(i==2){date.put("codeNumApplet", str[i]);System.out.println("Put codeNum->"+str[i]);}
					if(i==3){date.put("patientIdApplet", str[i]);System.out.println("Put PatientId->"+str[i]);}
				}
				System.out.println("批量打印--准备进入Action方法");
				String reponsePicPath = doRequest(reqPath,date, null, null);
				System.out.println("响应图片路径->"+reponsePicPath);
				System.out.println("开始打印图片");
				PrintCode.printCode(reponsePicPath);
			}
		}
	}
	
	public String doRequest(String url, Map postData, Map header, String encoding) throws Exception {
		String responseString = null;
		// 头部请求信息
		Header[] headers = null;
		if (header != null) {
			Set entrySet = header.entrySet();
			int dataLength = entrySet.size();
			headers = new Header[dataLength];
			int i = 0;
			for (Iterator itor = entrySet.iterator(); itor.hasNext();) {
				Map.Entry entry = (Map.Entry) itor.next();
				headers[i++] = new Header(entry.getKey().toString(), entry.getValue().toString());
			}
		}

		// post方式
		if (postData != null) {
			PostMethod postRequest = new PostMethod(url.trim());
			if (headers != null) {
				for (int i = 0; i < headers.length; i++) {
					postRequest.setRequestHeader(headers[i]);
				}
			}
			Set entrySet = postData.entrySet();
			int dataLength = entrySet.size();
			NameValuePair[] params = new NameValuePair[dataLength];
			int i = 0;
			for (Iterator itor = entrySet.iterator(); itor.hasNext();) {
				Map.Entry entry = (Map.Entry) itor.next();
				params[i++] = new NameValuePair(entry.getKey().toString(), entry.getValue().toString());
			}
			postRequest.setRequestBody(params);
			try {
				responseString = this.executeMethod(postRequest, encoding);
			} catch (Exception e) {
				throw e;
			} finally {
				postRequest.releaseConnection();
			}
		}
		return responseString;
	}
	private String executeMethod(HttpMethod request, String encoding) throws Exception {
		String responseContent = null;
		InputStream responseStream = null;
		BufferedReader rd = null;
		try {
			this.getHttpClient().executeMethod(request);
			if (encoding != null) {
				responseStream = request.getResponseBodyAsStream();
				rd = new BufferedReader(new InputStreamReader(responseStream, encoding));
				String tempLine = rd.readLine();
				StringBuffer tempStr = new StringBuffer();
				String crlf = System.getProperty("line.separator");
				while (tempLine != null) {
					tempStr.append(tempLine);
					tempStr.append(crlf);
					tempLine = rd.readLine();
				}
				responseContent = tempStr.toString();
			} else
				responseContent = request.getResponseBodyAsString();
			Header locationHeader = request.getResponseHeader("location");
			// 返回代码为302,301时，表示页面己经重定向，则重新请求location的url，这在一些登录授权取cookie时很重要
			if (locationHeader != null) {
				String redirectUrl = locationHeader.getValue();
				this.doRequest(redirectUrl, null, null, null);
			}
		} catch (HttpException e) {
			throw new Exception(e.getMessage());
		} catch (IOException e) {
			throw new Exception(e.getMessage());

		} finally {
			if (rd != null)
				try {
					rd.close();
				} catch (IOException e) {
					throw new Exception(e.getMessage());
				}
			if (responseStream != null)
				try {
					responseStream.close();
				} catch (IOException e) {
					throw new Exception(e.getMessage());

				}
		}
		return responseContent;
	}
	
}
