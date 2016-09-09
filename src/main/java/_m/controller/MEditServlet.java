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

@WebServlet("/_m/MEditServlet")
public class MEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("errorMsg");
		request.setCharacterEncoding("UTF-8");
		
		String m_account = (String)session.getAttribute("m_account");
		System.out.println(m_account);
		String m_password = request.getParameter("m_password");
		String m_newpassword = request.getParameter("m_newPassword");
		String passwordConfirm= request.getParameter("passwordConfirm");
		System.out.println(m_newpassword);
		String m_nickname = request.getParameter("m_nickname");

		MemberBean mb = new MemberBean();
		MemberDAO dao = new MemberDAO();
		
		if(checkPassword( m_account , m_password , m_newpassword , passwordConfirm)) {
			session.setAttribute("m_newpassword", m_newpassword);
			m_newpassword = GlobalService.encryptString(m_newpassword);
			System.out.println(m_newpassword);
			mb.setM_password(m_newpassword);
			mb.setM_nickname(m_nickname);
			mb.setM_pass(true);
			mb.setM_account(m_account);
			dao.updateMember(mb);
			System.out.println("密碼/暱稱，更新成功");
			
			RequestDispatcher rd = request.getRequestDispatcher("mSuccessMSG.jsp");
			rd.forward(request, response);
			return;
		} else{
//			request.setAttribute("errorMsg", "輸入資料有誤!!");
//			request.setAttribute("m_nickname", m_nickname);
			session.setAttribute("errorMsg", "輸入資料有誤!!");
			session.setAttribute("m_nickname", m_nickname);
			System.out.println("密碼/暱稱，更新失敗");
//			RequestDispatcher rd = request.getRequestDispatcher("/_m/m_edit.jsp");
//			rd.forward(request, response);
			response.sendRedirect("mEdit.jsp");
			return;
		}
	}
	
	public boolean checkPassword(String m_account , String m_password , String m_newpassword , String passwordConfirm){
		boolean check = false;
		MemberBean mb = new MemberBean();
		mb.setM_account(m_account);
		m_password = GlobalService.encryptString(m_password);
		
		MemberDAO dao = new MemberDAO();
		MemberBean userBean = dao.selectMember(mb);
		// 如果從資料庫中有找到對應的使用者資料，並非null
		if(userBean != null){
			System.out.println(m_password);
			System.out.println(userBean.getM_password());
			// 將使用者輸入的"舊密碼"與"資料庫中的密碼"比對
			if(m_password.equals(userBean.getM_password())){
								// 比對"新密碼"是否一致
				if(m_newpassword.equals(passwordConfirm)){
					// 兩者相等時傳回true，進行下一步
					check = true;
				} else {
					// 在console印出
					System.out.println("密碼不相同");
				}
			}
		}
		return check;
	}
}	

