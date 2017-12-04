package com.qhit.sbm.provider.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qhit.sbm.common.bean.PageBean;
import com.qhit.sbm.goods.bean.GoodsId;
import com.qhit.sbm.goods.service.Impl.GoodsServiceImpl;
import com.qhit.sbm.provider.bean.Provider;
import com.qhit.sbm.provider.bean.ProviderId;
import com.qhit.sbm.provider.service.Impl.ProviderServiceImpl;

public class ProviderServlet extends HttpServlet {

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
				case "getProviderId":
					getProviderId(request,response);
					break;
				case "getProvider":
					getProvider(request,response);
					break;
				case "selectProvider":
					selectProvider(request,response);
					break;
				case "changeProviderPage":
					changeProviderPage(request,response);
					break;
				case "addProvider":
					addProvider(request,response);
					break;

				default:
					break;
				}
	
	}


	private void addProvider(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		 String providerName = request.getParameter("providerName");
		 String providerDetail = request.getParameter("providerDetail");
		 String contact = request.getParameter("contact");
		 String telephone = request.getParameter("telephone");
		 String facsimile = request.getParameter("facsimile");
		 String address = request.getParameter("address");
		 Provider addProvider = new Provider(providerName, providerDetail, contact, telephone, facsimile, address);
		 ProviderServiceImpl psi = new ProviderServiceImpl();
		 int row = psi.addProvider(addProvider);
		 if(row > 0 ){
			 response.sendRedirect("commonServlet?cmd=getcountProvider");
			 return ;
		 }else{
			 PrintWriter out = response.getWriter();
			out.println("<script>location.href = 'JSP/providerAdd.jsp?add=error'</script>");
		 }
	}

	private void changeProviderPage(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<Provider> listpro = null;
		PageBean providerPage = (PageBean) request.getSession().getAttribute("providerPage");
		ProviderServiceImpl psi = new ProviderServiceImpl();
		listpro = (ArrayList<Provider>) psi.selectProvider(providerPage);
		if(listpro != null){
			providerPage.setData(listpro);
			request.getSession().setAttribute("providerPage", providerPage);
			response.sendRedirect("JSP/providerAdmin.jsp");
			return ;
		}else{
			PrintWriter out = response.getWriter();
			out.println("<script>location.href = 'JSP/providerAdmin.jsp?select=error'</script>");
		}
	}

	private void selectProvider(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<Provider> listpro = null;
		PageBean providerPage = (PageBean) request.getSession().getAttribute("providerPage");
		ProviderServiceImpl psi = new ProviderServiceImpl();
		listpro = (ArrayList<Provider>) psi.selectProvider(providerPage);
		if(listpro != null){
			providerPage.setData(listpro);
			request.getSession().setAttribute("providerPage", providerPage);
			response.sendRedirect("JSP/providerAdmin.jsp");
			return;
		}else{
			PrintWriter out = response.getWriter();
			out.println("<script>location.href = 'JSP/providerAdmin.jsp?select=error'</script>");
		}
	}


	private void getProvider(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Provider> listp = null;
		ArrayList<GoodsId> listsgId = null;
		ProviderServiceImpl psi = new ProviderServiceImpl();
		GoodsServiceImpl  gsi = new GoodsServiceImpl();
		listsgId = (ArrayList<GoodsId>) gsi.getGoodsId();
		listp = (ArrayList<Provider>) psi.getProvider();
		if(listp != null && listsgId !=null){
			request.setAttribute("listp", listp);
			request.setAttribute("listsgId", listsgId);
			request.getRequestDispatcher("JSP/modify.jsp").forward(request, response);;
		}else{
			PrintWriter out = response.getWriter();
			out.println("<script>location.href = 'JSP/admin_bill_list.jsp'</script>");
		}
	}

	private void getProviderId(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<ProviderId> listpId = null;
		ProviderServiceImpl psi = new ProviderServiceImpl();
		listpId = (ArrayList<ProviderId>) psi.getProviderId();
		if(listpId != null){
			request.setAttribute("listpId", listpId);
			request.getRequestDispatcher("JSP/modify.jsp").forward(request, response);;
		}else{
			PrintWriter out = response.getWriter();
			out.println("<script>location.href = 'JSP/admin_bill_list.jsp'</script>");
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
