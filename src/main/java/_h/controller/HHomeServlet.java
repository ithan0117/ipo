package _h.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import _a.model.JoinBean;
import _h.model.HomelessDAO;

@WebServlet("/_h/HHomeServlet")
public class HHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<JoinBean> list = new HomelessDAO().selectHomelessHeadAndDetail();
		request.setAttribute("homelessList", list);
		RequestDispatcher rd = request.getRequestDispatcher("hHomepage.jsp");
		rd.forward(request, response);
	}
}
