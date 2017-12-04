package com.qhit.sbm.common.commonServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qhit.sbm.common.bean.PageBean;
import com.qhit.sbm.common.service.Impl.CommonServiceImpl;
import com.qhit.sbm.provider.bean.Provider;

public class CommonServlet extends HttpServlet {

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
		case "getCount":
			getCount(request,response);
			break;
		case "changePage":
			changePage(request,response);
			break;
		case "selectPage":
			selectPage(request,response);
			break;
		case "selectChangePage":
			selectChangePage(request,response);
			break;
		case "getcountProvider":
			getcountProvider(request,response);
			break;
		case "changeProviderPage":
			changeProviderPage(request,response);
			break;
		case "getCountUser":
			getCountUser(request,response);
			break;
		case "changeUserPage":
			changeUserPage(request,response);
			break;

		default:
			break;
		}
	}

	private void changeUserPage(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String pageNum = request.getParameter("pageNum");
		PageBean userPage = (PageBean) request.getSession().getAttribute("userPage");
		userPage.setPageNum(Integer.parseInt(pageNum));
		request.getSession().setAttribute("userPage", userPage);
		response.sendRedirect("user?cmd=changeUserPage");
		return;
		
	}

	private void getCountUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		CommonServiceImpl csi = new CommonServiceImpl();
		int count = csi.getCount("tb_user", null, null);
		PageBean userPage = new PageBean();
		userPage.setCount(count);
		request.getSession().setAttribute("userPage", userPage);
		response.sendRedirect("user?cmd=selectUser");
		return;
	}

	private void changeProviderPage(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String pageNum = request.getParameter("pageNum");
		PageBean providerPage = (PageBean) request.getSession().getAttribute("providerPage");
		providerPage.setPageNum(Integer.parseInt(pageNum));
		request.getSession().setAttribute("providerPage", providerPage);
		response.sendRedirect("provider?cmd=changeProviderPage");
		return;
	}

	private void getcountProvider(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		CommonServiceImpl csi = new CommonServiceImpl();
		int count = csi.getCount("tb_provider", null, null);
		PageBean providerPage = new PageBean();
		providerPage.setCount(count);
		request.getSession().setAttribute("providerPage", providerPage);
		response.sendRedirect("provider?cmd=selectProvider");
		return;
	}

	private void selectChangePage(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String pageNum = request.getParameter("pageNum");
		PageBean selectPages = (PageBean) request.getSession().getAttribute("selectPages");
		selectPages.setPageNum(Integer.parseInt(pageNum));
		request.getSession().setAttribute("selectPages", selectPages);
		response.sendRedirect("account?cmd=selectChangePage");
		return;
	}

	private void selectPage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String goodsName = request.getParameter("goodsName");
		String isPayed = request.getParameter("isPayed");
		PageBean selectPages = new PageBean();
		String str = isPayed + "1";
		String sts = goodsName + "2";
		if(str.equals("1") && sts.equals("2")){
			PrintWriter out = response.getWriter();
			out.print("<script>location.href='JSP/admin_bill_list.jsp?select=error'</script>");
			   return;
		
		}else{
			request.getSession().setAttribute("goodsName",goodsName);
			request.getSession().setAttribute("isPayed", isPayed);
			request.getSession().setAttribute("selectPages", selectPages);
			response.sendRedirect("account?cmd=selectCount");
			return;
		}
			
		
		
	
		// request.getRequestDispatcher("account?cmd=selectCount").forward(request, response);
	}

	private void changePage(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String pageNum = request.getParameter("pageNum");
		PageBean pagebean = (PageBean) request.getSession().getAttribute("PageBean");
		pagebean.setPageNum(Integer.parseInt(pageNum));
		request.getSession().setAttribute("PageBean", pagebean);
		response.sendRedirect("account?cmd=changePage");
		return;
		
	}

	private void getCount(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		CommonServiceImpl csi = new CommonServiceImpl();
		int count = csi.getCount("tb_account", null, null);
		PageBean pagebean = new PageBean();
		pagebean.setCount(count);
		request.getSession().setAttribute("PageBean", pagebean);
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
