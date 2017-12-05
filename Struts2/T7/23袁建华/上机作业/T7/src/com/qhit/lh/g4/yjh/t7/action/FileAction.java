package com.qhit.lh.g4.yjh.t7.action;
/**
 * @author 袁建华
 *TODO
 *2017年12月5日下午4:37:34
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileAction extends ActionSupport {
	private String username;
	private File uploadFile;
	private String uploadFileFileName;
	private String uploadFileContentType;



	public String upload() throws IOException{
		if(uploadFile != null){
			try {
				//1,读入上传文件的输入流
				InputStream is = new FileInputStream(uploadFile);
				//2,得到保存的路径
				String savePath = ServletActionContext.getServletContext().getRealPath("/")+"uploadFileFileName";
				File file = new File(savePath);
				if(!file.exists()){
					file.mkdirs();
				}
				//3,保存到服务器，将上传的内容写入到savePath文件中
				OutputStream os = new FileOutputStream(savePath+"/"+uploadFileFileName);
				//4,写入数据
				byte[] buffer  = new byte[8096];
				int len = 0;
				while((len=is.read(buffer)) !=-1){
					os.write(buffer,0,len);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				super.addFieldError("uploadFile", "文件未找到");
				e.printStackTrace();
				super.addFieldError("uploadFile", "文件保存服务器失败");
			}
		}else{
			super.addFieldError("uploadFile", "文件未找到");
			return "input";
		}
		return "uploadSuccess";
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}



	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}



	/**
	 * @return the uploadFile
	 */
	public File getUploadFile() {
		return uploadFile;
	}



	/**
	 * @param uploadFile the uploadFile to set
	 */
	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}



	/**
	 * @return the uploadFileFileName
	 */
	public String getUploadFileFileName() {
		return uploadFileFileName;
	}



	/**
	 * @param uploadFileFileName the uploadFileFileName to set
	 */
	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}



	/**
	 * @return the uploadFileContentType
	 */
	public String getUploadFileContentType() {
		return uploadFileContentType;
	}



	/**
	 * @param uploadFileContentType the uploadFileContentType to set
	 */
	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}
}
