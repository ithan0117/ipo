package _a.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _a.model.ArticleDAO;

@WebServlet("/_a/WriteFileServlet")
public class WriteFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InputStream is = new ArticleDAO().selectImage(Integer.parseInt(request.getParameter("a_id")));
		OutputStream os = response.getOutputStream();
		int len;
		byte[] buf = new byte[is.available()];
		while ((len = is.read(buf)) != -1) {
			os.write(buf, 0, len);
		}
	}
}
