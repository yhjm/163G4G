package com.qhit.sbm.goods.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qhit.sbm.goods.bean.Goods;
import com.qhit.sbm.goods.service.Impl.GoodsServiceImpl;

public class goodsServlet extends HttpServlet {

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
		case "goodsByName":
			goodsByName(request,response);
			break;

		default:
			break;
		}
	}

	private void goodsByName(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String goodsName = request.getParameter("goodsName");
		String businessNum = request.getParameter("businessNum");
	//	String providerId = request.getParameter("providerId");
		String goodsId = request.getParameter("goodsId");
		//String isPayed = request.getParameter("isPayed");
		GoodsServiceImpl gsi = new GoodsServiceImpl();
		int row = gsi.updateGoodsNum(goodsName, Integer.parseInt(goodsId), Integer.parseInt(businessNum));
		if(row > 0){
			Goods goods = gsi.getGoods(goodsName,  Integer.parseInt(goodsId));
			request.setAttribute("goods", goods);
			request.getRequestDispatcher("account?cmd=addAccount").forward(request, response);
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
