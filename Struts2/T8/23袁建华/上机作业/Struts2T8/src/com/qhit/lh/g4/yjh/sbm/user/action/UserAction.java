/**
 * 
 */
package com.qhit.lh.g4.yjh.sbm.user.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.g4.yjh.sbm.user.bean.User;
import com.qhit.lh.g4.yjh.sbm.user.service.UserService;
import com.qhit.lh.g4.yjh.sbm.user.service.impl.UserServiceImpl;

/**
 * @author 袁建华
 * TODO
 * 2017年12月8日下午4:36:02
 */
public class UserAction  extends ActionSupport {
	private User user;
	private List<User> users;
	private File fileupload;
	private String fileuploadFileName;
	private String fileuploadContentType;
	private UserService userService =new UserServiceImpl();
	public String login(){
		user=userService.doLogin(user.getUserName(), user.getUserPassword());
		if(user!=null){
			ServletActionContext.getRequest().getSession().setAttribute("user", user);
		}else{
			super.addFieldError("loginFail", "账户名密码错误！");
		}
		return "loginSuccess";
		
	}
	public String getAll(){
		users=userService.getUser();
		return "listSuccess";
		
	}
	public String upload(){
		if(fileupload!=null){
			try {
				InputStream is=new FileInputStream(fileupload);
								
				String destfile =ServletActionContext.getServletContext().getRealPath("/")+"upfile/";
				File file=new File(destfile);
				if(!file.exists()){
					file.mkdirs();
				}
				user.setPic("/upfile/"+fileuploadFileName);
				OutputStream os=new FileOutputStream(destfile+fileuploadFileName);
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
		return "uploadSuccess";
	}
	public String  add(){
		int row=userService.addUser(user);
		if(row>0){
			return "addSuccess";
		}
		return "error";
		
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public File getFileupload() {
		return fileupload;
	}
	public void setFileupload(File fileupload) {
		this.fileupload = fileupload;
	}
	public String getFileuploadFileName() {
		return fileuploadFileName;
	}
	public void setFileuploadFileName(String fileuploadFileName) {
		this.fileuploadFileName = fileuploadFileName;
	}
	public String getFileuploadContentType() {
		return fileuploadContentType;
	}
	public void setFileuploadContentType(String fileuploadContentType) {
		this.fileuploadContentType = fileuploadContentType;
	}
	
	
	
}
