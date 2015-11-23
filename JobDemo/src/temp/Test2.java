
package temp;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Test2 {
	public static void main(String[] args) throws Exception {
		String str = "http://f.youku.com/player/getFlvPath/sid/130258503437697_01/st/flv/fileid/03000201004DA277E47AC503E2C7936B543E15-DFED-EE85-31E0-869A7BE2F5B8?K=457eb55affadc5c5161b9af9&hd=0";
		URL url = new URL(str);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.getResponseCode();
		String realUrl = conn.getURL().toString();
		conn.disconnect();
		System.out.println("真实URL:" + realUrl);

	}

}