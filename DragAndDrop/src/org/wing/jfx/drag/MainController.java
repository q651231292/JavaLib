package org.wing.jfx.drag;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class MainController implements Initializable {
	@FXML
	private AnchorPane mRoot;//界面根节点
	@FXML
	private Label m_drag, m_drop;//文本标签
	@FXML
	private ImageView m_imageView;//图片
	@FXML
	private TextArea m_textArea;//文本域

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {//初始化

		//当拖的时候触发
		m_drag.setOnDragDetected(new EventHandler<MouseEvent>() {//设置检测到拖拽事件

			@Override
			public void handle(MouseEvent event) {
				//Dragboard dragboard 托板对象
				//TransferMode.ANY转移模式.任何
				Dragboard dragboard = m_drag.startDragAndDrop(TransferMode.ANY);
				ClipboardContent content = new ClipboardContent();//剪切板
				content.putString(m_drag.getText());//把标签的内容放入剪切板
				dragboard.setContent(content);//设置托板对象的内容
			}
		});

		//当托进一个对象的时候,把m_drop对象的全部文本变成红色
		m_drop.setOnDragEntered(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
				m_drop.setTextFill(Color.RED);
			}
		});

		//当托离一个对象的时候,把m_drop对象的全部文本变成黑色
		m_drop.setOnDragExited(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
				m_drop.setTextFill(Color.BLACK);
			}
		});

		//
		m_drop.setOnDragOver(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
				//先得到event对象的手势源头,如果手势源头不相同(说明不是自己托自己)并且拖的是一个文本(就是里面全是字符串的)
				if (event.getGestureSource() != m_drop && event.getDragboard().hasString()) {
					//就设置event对象的拖动模式(这里设置的是剪切)
					event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
				}
			}
		});

		//当松开拖拽的对象时
		m_drop.setOnDragDropped(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
				Dragboard dragboard = event.getDragboard();
				m_drop.setText(dragboard.getString());
			}
		});

		//当已经执行完拖动时
		m_drag.setOnDragDone(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
				m_drag.setText("");
			}
		});
		
		//当拖到图片上方时
		m_imageView.setOnDragOver(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
				if (event.getGestureSource() != m_imageView) {
					//设置拖放事件的传输模式//TransferMode.ANY包含所有传输模式的数组
					event.acceptTransferModes(TransferMode.ANY);
				}				
			}
		});
		//当松开拖动对象时
		m_imageView.setOnDragDropped(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
				Dragboard dragboard = event.getDragboard();
				List<File> files = dragboard.getFiles();
				if(files.size() > 0){
					try {
						m_imageView.setImage(new Image(new FileInputStream(files.get(0))));
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}
			}
		});
		//当拖到文本域对象上面时
		m_textArea.setOnDragOver(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
				if (event.getGestureSource() != m_imageView) {
					event.acceptTransferModes(TransferMode.ANY);//声明event对象的拖动模式
				}				
			}
		});
		//当在文本域对象上面松开时
		m_textArea.setOnDragDropped(new EventHandler<DragEvent>() {//释放拖动

			@Override
			public void handle(DragEvent event) {
				Dragboard dragboard = event.getDragboard();//从event对象里得到拖动板
				List<File> files = dragboard.getFiles();
				if(files.size() > 0){
					m_textArea.setText(FileTools.readFile(files.get(0)));//取出拖动文件中的文字,设置给文本域
				}
			}
		});
		
	}

}
