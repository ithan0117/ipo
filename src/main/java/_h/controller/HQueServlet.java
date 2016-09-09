package _h.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _a.model.ArticleBean;
import _a.model.ArticleDAO;
import _h.model.HomelessBean;
import _h.model.HomelessDAO;

@MultipartConfig(
		location = "",
		fileSizeThreshold = 1024 * 1024,
		maxFileSize = 1024 * 1024 * 500,
		maxRequestSize = 1024* 1024 * 500 * 5)

@WebServlet("/HQueServlet")
public class HQueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int a_id = -1;
		a_id = Integer.parseInt(request.getParameter("a_id"));
		System.out.println("a_id");
		
		if (a_id != -1) {
//			HomelessDAO hDao = new HomelessDAO();
//			HomelessBean hBean  = hdao.selectHomelessDetail(a_id);
			HomelessBean hBean  = new HomelessDAO().selectHomelessDetail(a_id);
			request.setAttribute("Bean", hBean);
			RequestDispatcher rd = request.getRequestDispatcher("/_h/hQueryDetail.jsp");
			rd.forward(request, response);
			System.out.println("浪浪單筆成功");
			return;
		} else {
			System.out.println("error a_id");
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int a_id = -1;
		a_id = Integer.parseInt(request.getParameter("a_id"));
		System.out.println("a_id");
		
		if (a_id != -1) {
			InputStream is = new ArticleDAO().selectImage(a_id);
			OutputStream os = response.getOutputStream();
			int len;
			byte[] buf = new byte[is.available()];
			while ((len = is.read(buf)) != -1) {
				os.write(buf, 0, len);
			}
			return;
		} else {
			System.out.println("error a_id");
			RequestDispatcher rd = request.getRequestDispatcher(request.getServletPath());
			rd.forward(request, response);
		}
	}
}

