package _s.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _a.model.ArticleBean;
import _a.model.ArticleDAO;
import _s.model.SearchBean;
import _s.model.SearchDAO;

@WebServlet("/_s/sHomeSearch")
public class SHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String s_type = "";
		Cookie[] allCookies = request.getCookies();
		if (allCookies != null) {
			for (int i = 0; i < allCookies.length; i++) {
				if (allCookies[i].getName().equals("bottomSelect")) {
					s_type = allCookies[i].getValue();
				}
			}
		}
		
		System.out.println("bottomSelect:"+s_type);
		String s_pet_type = "o";//
		if (s_type.equals("lost")) {
			request.setAttribute("bottomSelect", s_type);
			List<SearchBean> list = new SearchDAO().selectSearchAllType("l", s_pet_type);
			request.setAttribute("selectSearchAllType", list);
			RequestDispatcher rd = request.getRequestDispatcher("sLostQuery.jsp");
			rd.forward(request, response);
//			response.sendRedirect("_s/sLostQuery.jsp");
			return;
		} else if (s_type.equals("found")) {
			System.out.println("found");
			request.setAttribute("bottomSelect", s_type);
			List<SearchBean> list = new SearchDAO().selectSearchAllType("f", s_pet_type);
			request.setAttribute("selectSearchAllType", list);
			RequestDispatcher rd = request.getRequestDispatcher("sFoundQuery.jsp");
			rd.forward(request, response);
//			response.sendRedirect("_s/sFoundQuery.jsp");
			return;
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("進入SHomeServlet");
		request.setCharacterEncoding("UTF-8");
		String topSelect = request.getParameter("topSelect");//-------
		String bottomSelect = request.getParameter("bottomSelect");
		System.out.println("topSelect= "+topSelect);
		System.out.println("bottomSelect= "+bottomSelect);
		String m_id = "25";
		
		String s_pet_type = "o";
//		HttpSession session = request.getSession();
		Cookie cookie = new Cookie("bottomSelect", bottomSelect);
		response.addCookie(cookie);
		if (topSelect.equals("search") && bottomSelect.equals("lost")) {
			request.setAttribute("topSelect", topSelect);
			request.setAttribute("bottomSelect", bottomSelect);
			List<SearchBean> list = new SearchDAO().selectSearchAllType("l", s_pet_type);
			request.setAttribute("selectSearchAllType", list);
			RequestDispatcher rd = request.getRequestDispatcher("sLostQuery.jsp");
			rd.forward(request, response);
//			response.sendRedirect("_s/sLostQuery.jsp");
			return;
		} else if (topSelect.equals("search") && bottomSelect.equals("found")) {
			request.setAttribute("topSelect", topSelect);
			request.setAttribute("bottomSelect", bottomSelect);
			List<SearchBean> list = new SearchDAO().selectSearchAllType("f", s_pet_type);
			request.setAttribute("selectSearchAllType", list);
			RequestDispatcher rd = request.getRequestDispatcher("sFoundQuery.jsp");
			rd.forward(request, response);
//			response.sendRedirect("_s/sFoundQuery.jsp");
			return;
		} else if (topSelect.equals("insert") && bottomSelect.equals("lost")) {
			request.setAttribute("topSelect", topSelect);
			request.setAttribute("bottomSelect", bottomSelect);
			RequestDispatcher rd = request.getRequestDispatcher("sLostReg.jsp");
			rd.forward(request, response);
//			response.sendRedirect("_s/sLostReg.jsp");
			return;
		} else if (topSelect.equals("insert") && bottomSelect.equals("found")) {
			request.setAttribute("topSelect", topSelect);
			request.setAttribute("bottomSelect", bottomSelect);
			RequestDispatcher rd = request.getRequestDispatcher("sFoundReg.jsp");
			rd.forward(request, response);
//			response.sendRedirect("_s/sFoundReg.jsp");
			return;
		} else if (topSelect.equals("edit")) {
			request.setAttribute("topSelect", topSelect);
			request.setAttribute("bottomSelect", bottomSelect);
			System.out.println();
			List<ArticleBean> list = new ArticleDAO().selectArticlesByM_id(Integer.parseInt(m_id));
			request.setAttribute("Articles", list);

			RequestDispatcher rd = request.getRequestDispatcher("/_a/aRecord.jsp");
			rd.forward(request, response);
			return;
		}
	}
}
