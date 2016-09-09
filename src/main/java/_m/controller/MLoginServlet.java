package _m.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _m.model.GlobalService;
import _m.model.MemberBean;
import _m.model.MemberDAO;

@WebServlet("/_m/MLoginServlet")
public class MLoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
				
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		
		String m_account = request.getParameter("m_account");
		String m_password = request.getParameter("m_password");
		
		if(checkAccountPassword(m_account, m_password, session)){
			session.removeAttribute("errorMsg");
			session.setAttribute("m_account", m_account);
			session.setAttribute("m_password", m_password);
			String servletPath = (String) session.getAttribute("target");
			
			if( servletPath == null ) {
				response.sendRedirect(request.getContextPath() + "/homePage.jsp");
			} else {
				response.sendRedirect(request.getContextPath() + servletPath);
			}
			System.out.println("登入成功");
			return;
		} else{
			session.setAttribute("errorMsg", "帳號或密碼錯誤");
			session.setAttribute("m_account", m_account);
			// 將畫面留在登入畫面
//			RequestDispatcher rd = request.getRequestDispatcher("m_login.jsp");
//			rd.forward(request, response);
			
			response.sendRedirect("mLogin.jsp");
			System.out.println("登入失敗");
			return;
		}
	}
	
	// 檢查帳號密碼
	public boolean checkAccountPassword(String m_account,String m_password, HttpSession session) {
		boolean check = false;

		MemberBean mb = new MemberBean();
		mb.setM_account(m_account);
		m_password = GlobalService.encryptString(m_password);
		
		MemberDAO dao = new MemberDAO();
		MemberBean userBean = dao.selectMember(mb);
		if(userBean != null){
			if(m_password.equals(userBean.getM_password())){
				session.setAttribute("LoginOK", userBean);
				check = true;
			} else {
				System.out.println("密碼不相同");
			}
		}
		return check;
	}
}
