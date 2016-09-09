package _s.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _a.model.ArticleBean;
import _a.model.ArticleDAO;
import _s.model.SearchBean;
import _s.model.SearchDAO;

/**
 * Servlet implementation class SQueryServlet
 */
@WebServlet("/_s/SQueryServlet")
public class SQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String a_id = request.getParameter("a_id");
		System.out.println("進入SQueryServlet");
		System.out.println("a_id:"+a_id);
		request.setAttribute("a_id", a_id);
		
		ArticleBean ab = new ArticleDAO().selectArticleByA_id(Integer.parseInt(a_id));
		SearchBean sb = new SearchDAO().selectSerch(a_id);
		request.setAttribute("a_head", ab);
		request.setAttribute("s_detail", sb);
		RequestDispatcher rd = request.getRequestDispatcher("sLostQueryDetail.jsp");
		rd.forward(request, response);
	}
}
