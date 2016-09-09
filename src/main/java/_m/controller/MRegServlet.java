	package _m.controller;
/*
 * 本程式讀取使用者輸入資料，進行必要的資料轉換，檢查使用者輸入資料，
 * 進行Business Logic運算，依照Business Logic運算結果來挑選適當的畫面
 * 
 */
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _m.model.GlobalService;
import _m.model.JavaMailUtil;
import _m.model.MemberBean;
import _m.model.MemberDAO;
import _m.model.VerifyUtils;

@WebServlet("/_m/MRegServlet")
public class MRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Map<String, String> errorMsg = new HashMap<String, String>();
		request.setAttribute("errorMsg", errorMsg);
		request.setCharacterEncoding("UTF-8");
		
		String m_account = request.getParameter("m_account");
		String m_password = request.getParameter("m_password");
		String passwordConfirm = request.getParameter("passwordConfirm");
		String m_nickname = request.getParameter("m_nickname");
		System.out.println(m_account);
		System.out.println(m_password);
		System.out.println(passwordConfirm);
		System.out.println(m_nickname);
		// 機器人
		String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
		System.out.println("gRecaptchaResponse=" + gRecaptchaResponse);
        boolean valid = VerifyUtils.verify(gRecaptchaResponse);
        System.out.println(valid);
		
		if(!valid){
			RequestDispatcher rd = request.getRequestDispatcher("mRegister.jsp");
			rd.forward(request, response);
			System.out.println("驗證失敗");
			return;
		}
	// 邏輯運算
		accountDuplicate(m_account , errorMsg);
		m_passwordCheck(m_password , passwordConfirm , errorMsg);

		MemberDAO dao = new MemberDAO();
		MemberBean mb;		
	//選擇畫面
		if(errorMsg.isEmpty()){	
			m_password = GlobalService.encryptString(m_password);
			mb = new MemberBean(m_account, m_password, m_nickname);
			dao.insertMemeber(mb);
			request.setAttribute("member", mb);
			RequestDispatcher rd = request.getRequestDispatcher("mSuccessMSG.jsp");
			rd.forward(request, response);
//			response.sendRedirect("_m/m_registerSuccess.jsp");
			System.out.println("註冊成功");
			sendMail(m_account);
			return;
		} else{
			mb = new MemberBean(m_account, null, m_nickname);
			request.setAttribute("member", mb);
			request.setAttribute("errorMsg", errorMsg);
//			response.sendRedirect("_m/m_register.jsp");	
			RequestDispatcher rd = request.getRequestDispatcher("mRegister.jsp");
			rd.forward(request, response);
			System.out.println("註冊失敗");
		}
	}
	
	// 判斷帳號是否重複的方法
	private void accountDuplicate(String m_account , Map<String,String> errorMsg){
		MemberDAO dao = new MemberDAO();
		List<MemberBean> list = dao.selectMembers();
		for(MemberBean temp : list){
			if(m_account.equals(temp.getM_account())){
				errorMsg.put("errorM_account", "帳號重複");
				break;
			}
		}
	}
	
	// 判斷密碼是否相同
	private void m_passwordCheck(String m_password,String m_password2,Map<String,String> errorMsg){
		if (!m_password.equals(m_password2)) {
			errorMsg.put("errorM_password", "請輸入相同密碼");
		}
	}
	
	// 成功畫面出現時，同時寄出"確認信"
	public void sendMail(String m_account) {
		String from = "ipolaung@gmail.com";
		List<String> to = Arrays.asList(new String[] { m_account });
		List<String> cc = Arrays.asList(new String[] {});
		List<String> bcc = Arrays.asList(new String[] {});
		String subject = "歡迎加入會員";
		String text = "<h1>謝謝您加入iPo會員</h1>" + "<h2>您可以按下列連結感受最新的體驗</h2>" + "<a href='http://tw.yahoo.com'>yahoo</a><br>"
				+ "<a href='http://www.google.com'>google</a><br>"
				+ "<br><br><font color='blue'> 再次感謝, </font><br>工作小組敬上";
		List<String> attachment = null;
		JavaMailUtil util = new JavaMailUtil(from, to, cc, bcc, subject, text, attachment);
		if (util.send()) {
			System.out.println("發信成功");
		} else {
			System.out.println("發信失敗");
		}
	}
}
