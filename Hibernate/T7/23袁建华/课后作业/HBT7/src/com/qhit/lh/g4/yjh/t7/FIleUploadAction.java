/**
 * 
 */
package com.qhit.lh.g4.yjh.t7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FIleUploadAction  extends ActionSupport{
private String username;
//与上传文件有关的三个属性
private File   uploadfile;
private String uploadfileFileName;
private String uploadfileContentType;


public String upload(){
	if(uploadfile!=null){
		try {
			InputStream is=new FileInputStream(uploadfile);
							
			String destfile =ServletActionContext.getServletContext().getRealPath("/")+"upfile/";
			File file=new File(destfile);
			if(!file.exists()){
				file.mkdirs();
			}
			OutputStream os=new FileOutputStream(destfile+uploadfileFileName);
			byte[] buffer =new byte[8096];
			int len =0;
			while((len=is.read(buffer))!=-1){
				os.write(buffer, 0, len);
			}
			is.close();
			os.flush();
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			super.addFieldError("uploadFile", "文件未找到");
			return "input";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			super.addFieldError("uploadFile", "文件未保存成功");
			return "input";
		}
	}
	return "info";
}


public String getUsername() {
	return username;
}


public void setUsername(String username) {
	this.username = username;
}


public File getUploadfile() {
	return uploadfile;
}


public void setUploadfile(File uploadfile) {
	this.uploadfile = uploadfile;
}


public String getUploadfileFileName() {
	return uploadfileFileName;
}


public void setUploadfileFileName(String uploadfileFileName) {
	this.uploadfileFileName = uploadfileFileName;
}


public String getUploadfileContentType() {
	return uploadfileContentType;
}


public void setUploadfileContentType(String uploadfileContentType) {
	this.uploadfileContentType = uploadfileContentType;
}


}
