package _h.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _a.model.ArticleDAO;

@WebServlet("/_h/HHomeImageServlet")
public class HHomeImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int a_id = Integer.parseInt(request.getParameter("a_id"));
		try (
			InputStream is =new ArticleDAO().selectImage(a_id);
			OutputStream os = response.getOutputStream();	
		){
			int len;
			byte[] buf = new byte[is.available()];
			while((len = is.read(buf)) != -1) {
				os.write(buf, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
