package com.qhit.sbm.account.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qhit.sbm.account.bean.ShowAccount;
import com.qhit.sbm.account.service.Impl.AccountServiceImpl;
import com.qhit.sbm.common.bean.PageBean;
import com.qhit.sbm.goods.bean.Goods;

public class AccountServlet extends HttpServlet {

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
		case "accountPage":
			accountPage(request,response);
			break;
		case "changePage":
			changePage(request,response);
			break;
		case "selectChangePage":
			selectChangePage(request,response);
			break;
		case "selectPage":
			selectPage(request,response);
			break;
		case "selectCount":
			selectCount(request,response);
			break;
		case "updateAccount":
			updateAccount(request,response);
			break;
		case "addAccount":
		addAccount(request,response);
			break;
		case "deleteAccount":
			deleteAccount(request,response);
			break;

		default:
			break;
		}
	}

	private void addAccount(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String providerId = request.getParameter("providerId");
		String isPayed = request.getParameter("isPayed");
		Goods goods = (Goods) request.getAttribute("goods");
		String businessNum = request.getParameter("businessNum");
		AccountServiceImpl asi = new AccountServiceImpl();
		int row = asi.addAccount(goods, Integer.parseInt(isPayed), 
											Integer.parseInt(providerId), 
											Integer.parseInt(businessNum));
		List<ShowAccount> salist =null;
		PageBean pagebean = new PageBean ();
		int count = asi.accountPage();				
		pagebean.setCount(count);
		pagebean.setPageNum(1);
		salist = asi.allPage(pagebean);
		if(row > 0){
			pagebean.setData(salist);
			request.getSession().setAttribute("PageBean", pagebean);
			PrintWriter out = response.getWriter();
			out.print("<script>location.href='JSP/admin_bill_list.jsp'</script>");
		}else{
			PrintWriter out = response.getWriter();
			out.print("<script>location.href='JSP/admin_bill_list.jsp'</script>");
			//response.sendRedirect("JSP/admin_bill_list.jsp");
			return;
		}
	}

	private void deleteAccount(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String accountId = request.getParameter("accountId");
		 AccountServiceImpl asi = new AccountServiceImpl();
		   	int i = asi.deleteAccount(accountId);
		   	List<ShowAccount> salist =null;
			PageBean pagebean = new PageBean ();
			int count = asi.accountPage();				
			pagebean.setCount(count);
			pagebean.setPageNum(1);
			//System.out.println(pagebean.getCount()+"  "+pagebean.getPageNum()+"  "+pagebean.getPageSize());
			salist = asi.allPage(pagebean);	
		if(i > 0){
				pagebean.setData(salist);
				request.getSession().setAttribute("PageBean", pagebean);
				PrintWriter out = response.getWriter();
				out.print("<script>location.href='JSP/admin_bill_list.jsp'</script>");
		
		}else{
			PrintWriter out = response.getWriter();
			out.print("<script>location.href='JSP/admin_bill_list.jsp'</script>");
			//response.sendRedirect("JSP/admin_bill_list.jsp");
			return;
		}
	}

	private void updateAccount(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String accountId = request.getParameter("accountId");
		String isPayed = request.getParameter("isPayed");
	   AccountServiceImpl asi = new AccountServiceImpl();
	   	int i = asi.updateAccount(accountId, Integer.parseInt(isPayed));
	if(i > 0){
		PrintWriter out = response.getWriter();
		out.print("<script>location.href='JSP/admin_bill_list.jsp'</script>");
		return;
	}else{
		PrintWriter out = response.getWriter();
		out.print("<script>location.href='JSP/admin_bill_list.jsp'</script>");
		//response.sendRedirect("JSP/admin_bill_list.jsp");
		return;
	}
	
	}
	private void selectChangePage(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		List<ShowAccount> salist =null;
		PageBean selectPages = (PageBean) request.getSession().getAttribute("selectPages");
		AccountServiceImpl asi = new AccountServiceImpl ();
		String goodsName = (String) request.getSession().getAttribute("goodsName");
		String isPayed = (String) request.getSession().getAttribute("isPayed");
		String str = isPayed + "1";
		String sts = goodsName + "2";
		if(str.equals("1")){
			isPayed = "5";
		}else if(sts.equals("2")){
			goodsName = "?";
		}
		salist = asi.selectPage(selectPages, goodsName, Integer.parseInt(isPayed));
		if(salist != null){
			selectPages.setData(salist);
			request.getSession().setAttribute("selectPages", selectPages);
			PrintWriter out = response.getWriter();
			out.print("<script>location.href='JSP/select.jsp'</script>");
			//response.sendRedirect("JSP/admin_bill_list.jsp");
			return;
		}else{
			   //response.sendRedirect("JSP/admin_bill_list.jsp?changePage=error");
				PrintWriter out = response.getWriter();
				out.print("<script>location.href='JSP/select.jsp?select=error'</script>");
			   return;
		}
	}

	private void selectCount(HttpServletRequest request,
			HttpServletResponse response) throws   IOException {
		// TODO Auto-generated method stub
		String goodsName = (String) request.getSession().getAttribute("goodsName");
		String isPayed = (String) request.getSession().getAttribute("isPayed");
		String str = isPayed + "1";
		String sts = goodsName + "2";
		if(str.equals("1")){
			isPayed = "5";
		}else if(sts.equals("2")){
			goodsName = "?";
		}
		PageBean selectPages = (PageBean) request.getSession().getAttribute("selectPages");
		AccountServiceImpl asi = new AccountServiceImpl();
		int count = asi.selectCount(goodsName, Integer.parseInt(isPayed));
		if(count > 0){
			selectPages.setCount(count);
			request.getSession().setAttribute("selectPages", selectPages);
			//request.getRequestDispatcher("account?cmd=selectPage").forward(request, response);
			response.sendRedirect("account?cmd=selectPage");
			return;
		}else{
			PrintWriter out = response.getWriter();
			out.print("<script>location.href='JSP/admin_bill_list.jsp?select=error'</script>");
			return;
		}
	}

	private void selectPage(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		PageBean selectPages = (PageBean) request.getSession().getAttribute("selectPages");
		List<ShowAccount> salist =null;
		String goodsName = (String) request.getSession().getAttribute("goodsName");
		String isPayed = (String) request.getSession().getAttribute("isPayed");
		String str = isPayed + "1";
		String sts = goodsName + "2";
		if(str.equals("1")){
			isPayed = "5";
		}else if(sts.equals("2")){
			goodsName = "?";
		}
		selectPages.setPageNum(1);
		AccountServiceImpl asi = new AccountServiceImpl();
		salist = asi.selectPage(selectPages, goodsName, Integer.parseInt(isPayed));
		if(salist != null){
			selectPages.setData(salist);
			request.getSession().setAttribute("selectPages", selectPages);
			//response.sendRedirect("JSP/admin_bill_list.jsp");
			PrintWriter out = response.getWriter();
			out.print("<script>location.href='JSP/select.jsp'</script>");
			return;
		}else{
			  // response.sendRedirect("JSP/login.jsp?doLogin=error");
			PrintWriter out = response.getWriter();
			out.print("<script>location.href='JSP/admin_bill_list.jsp?select=error'</script>");
			 return;
		}
	}

	private void changePage(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		List<ShowAccount> salist =null;
		PageBean pagebean = (PageBean) request.getSession().getAttribute("PageBean");
		AccountServiceImpl asi = new AccountServiceImpl ();
		salist = asi.allPage(pagebean);
		if(salist != null){
			pagebean.setData(salist);
			request.getSession().setAttribute("PageBean", pagebean);
			PrintWriter out = response.getWriter();
			out.print("<script>location.href='JSP/admin_bill_list.jsp'</script>");
			//response.sendRedirect("JSP/admin_bill_list.jsp");
			return;
		}else{
			   //response.sendRedirect("JSP/admin_bill_list.jsp?changePage=error");
				PrintWriter out = response.getWriter();
				out.print("<script>location.href='JSP/admin_bill_list.jsp?changePage=error'</script>");
			   return;
		}
	}

	private void accountPage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//ShowAccount sa = new ShowAccount();
		List<ShowAccount> salist =null;
		AccountServiceImpl asi = new AccountServiceImpl ();
		PageBean pagebean = new PageBean ();
		int count = asi.accountPage();				
		pagebean.setCount(count);
		pagebean.setPageNum(1);
		//System.out.println(pagebean.getCount()+"  "+pagebean.getPageNum()+"  "+pagebean.getPageSize());
		salist = asi.allPage(pagebean);
		if(salist != null){
			pagebean.setData(salist);
			request.getSession().setAttribute("PageBean", pagebean);
			//response.sendRedirect("JSP/admin_bill_list.jsp");
			PrintWriter out = response.getWriter();
			out.print("<script>location.href='JSP/admin_index.jsp'</script>");
			return;
		}else{
			  // response.sendRedirect("JSP/login.jsp?doLogin=error");
			PrintWriter out = response.getWriter();
			out.print("<script>location.href='JSP/admin_index.jsp'</script>");
			   return;
		}
		/*request.setAttribute("PageBean", pagebean);
		RequestDispatcher rd =  request.getRequestDispatcher("JSP/admin_bill_list.jsp");
		rd.forward(request, response);
		*/
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
