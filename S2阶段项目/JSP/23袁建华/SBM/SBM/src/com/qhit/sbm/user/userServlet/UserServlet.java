package com.qhit.sbm.user.userServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.qhit.sbm.common.bean.PageBean;
import com.qhit.sbm.user.bean.User;
import com.qhit.sbm.user.service.Impl.UserServiceImpl;
import com.qhit.sbm.utils.Contanst;
import com.qhit.sbm.utils.IDUtil;

public class UserServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String cmd = request.getParameter("cmd");
			switch (cmd) {
			case "login":
				doLogin(request,response);
				break;
			case "exit":
				doExit(request,response);
				break;
			case "updatePassword":
				updatePassword(request,response);
				break;
			case "selectUser":
				selectUser(request,response);
				break;
			case "changeUserPage":
				changeUserPage(request,response);
				break;
			case "uploadUser":
				uploadUser(request,response);
				break;

			default:
				break;
			}
	}

	private void uploadUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException  {
		// TODO Auto-generated method stub
		SmartUpload su = new SmartUpload();
		su.initialize(getServletConfig(), request, response);
		su.setAllowedFilesList("jpg,png,gif,jpng");
		su.setMaxFileSize(1024*1024*5);
		try {
			su.upload();
			File file = su.getFiles().getFile(0);
			String picName = IDUtil.getUUID();
			String picFilePath = Contanst.FILE_USER_PHOTO_PATH;
			//getRealPath为从盘符目录开始的路径到JSP目录为止
			java.io.File filePath = new java.io.File(request.getRealPath("/")+picFilePath);
			if(!filePath.exists()){
				filePath.mkdirs();
			}
			
			String extName = file.getFileExt();
			String picPath = picFilePath + picName + "." +extName;
			//savePath 为保存的目录以及图片名
			String savePath = request.getRealPath("/") + picPath;
			file.saveAs(savePath);
			Request sRequest = su.getRequest();
			//如果保存成功了将继续往下执行，然后添加用户数据，因为需要使用原请求的用户参数，所以必须使用请求转发
			String userName =  sRequest.getParameter("userName");
			String userPassword =  sRequest.getParameter("userPassword");
			String userSex =  sRequest.getParameter("userSex");
			String userAge =  sRequest.getParameter("userAge");
			String telephone =  sRequest.getParameter("telephone");
			String address =  sRequest.getParameter("address");
			String type =  sRequest.getParameter("type");
			String pic =  picPath;//第2步得到的图片保存的相对路径，需要存在数据库中
			User addUser = new User(
					Integer.parseInt(userAge), 
					Integer.parseInt(type),
					userName, 
					userPassword, 
					userSex, 
					telephone, 
					address, 
					pic);
			UserServiceImpl usi = new UserServiceImpl();
			int row = usi.addUser(addUser);
			if(row > 0){
				response.sendRedirect("user?cmd=selectUser");
				return;
			}else{
				PrintWriter out = response.getWriter();
				out.println("<script>location.href = 'JSP/userAdd.jsp?add=error'</script>");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void changeUserPage(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		PageBean userPage = (PageBean) request.getSession().getAttribute("userPage");
		UserServiceImpl usi = new UserServiceImpl();
		ArrayList<User> listu = null;
		listu = (ArrayList<User>) usi.selectUser(userPage);
		if(listu != null){
			userPage.setData(listu);
			request.getSession().setAttribute("userPage", userPage);
			response.sendRedirect("JSP/userAdmin.jsp");
			return;
		}else{
			PrintWriter out = response.getWriter();
			out.println("<script>location.href = 'JSP/userAdmin.jsp?select=error'</script>");
		}
	}

	private void selectUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		PageBean userPage = (PageBean) request.getSession().getAttribute("userPage");
		UserServiceImpl usi = new UserServiceImpl();
		ArrayList<User> listu = null;
		listu = (ArrayList<User>) usi.selectUser(userPage);
		if(listu != null){
			userPage.setData(listu);
			request.getSession().setAttribute("userPage", userPage);
			response.sendRedirect("JSP/userAdmin.jsp");
			return;
		}else{
			PrintWriter out = response.getWriter();
			out.println("<script>location.href = 'JSP/userAdmin.jsp?select=error'</script>");
		}
	}

	private void updatePassword(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String newPwd = request.getParameter("newPwd");
		String userId = request.getParameter("userId");
		User user = (User) request.getSession().getAttribute("user");
		UserServiceImpl usi = new UserServiceImpl();
		int i = usi.updatePassword(newPwd, Integer.parseInt(userId));
		if(i > 0 ){
			user.setUserPassword(newPwd);
			request.getSession().setAttribute("user", user);
			response.sendRedirect("JSP/admin_bill_list.jsp?update=update");
			return ;
		}else{
			response.sendRedirect("JSP/updatePassworld.jsp");
			return ;
		}
	}

	private void doExit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		request.getSession().invalidate();
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		PrintWriter out = response.getWriter();
		out.println("<script>window.top.location.href='"+basePath+"'</script>");
		//response.sendRedirect("JSP/login.jsp");
		return;
	}

	private void doLogin(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		User user = null;
		ArrayList <User> online = null;
		String name = request.getParameter("userName");
		String passWord = request.getParameter("userPassword");
		//String userPassword = request.getParameter("userPassword");
	    UserServiceImpl us = new UserServiceImpl();
	   user =  us.doLogin(name, passWord);
	   if(user !=  null){
		   online =  (ArrayList<User>) request.getServletContext().getAttribute("online");
		   if(online.size()==0){
			   online.add(user);
			   request.getSession().setAttribute("user", user);
			   request.getServletContext().setAttribute("online", online);
			  // response.sendRedirect("JSP/admin_index.jsp");
			    response.sendRedirect("account?cmd=accountPage");
			   return;
		   }else{
			   for(User u:online){
					 if(u.getUserId()==user.getUserId()){
						 request.getSession().setAttribute("user", user);
						// response.sendRedirect("JSP/login.jsp?doLogin=error");
						 response.sendRedirect("account?cmd=accountPage");
						 return;
					 }
				 }	
				      online.add(user);
					   request.getSession().setAttribute("user", user);
					   request.getServletContext().setAttribute("online", online);
					   //response.sendRedirect("JSP/admin_index.jsp");
					   response.sendRedirect("account?cmd=accountPage");
					   return;
		   }		
	   }else{
		   response.sendRedirect("JSP/login.jsp?doLogin=error");
		   return;
	   }
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
