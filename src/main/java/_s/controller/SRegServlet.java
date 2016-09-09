package _s.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.xml.bind.JAXBElement.GlobalScope;

import _a.model.ArticleBean;
import _a.model.ArticleDAO;
import _m.model.MemberBean;
import _s.model.SearchBean;
import _s.model.SearchDAO;

@MultipartConfig(location = "", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 500, maxRequestSize = 1024
		* 1024 * 500 * 5)
@WebServlet("/_s/sRegServlet")
public class SRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("成功進來RegServlet");
		request.setCharacterEncoding("UTF-8");
		Map<String, String> errorMsg = new HashMap<String, String>();
		Map<String, String> msgOK = new HashMap<String, String>();
		HttpSession session = request.getSession();
		request.setAttribute("MsgMap", errorMsg); // 顯示錯誤訊息
		session.setAttribute("MsgOK", msgOK); // 顯示正常訊息

		final String a_block = "S";
		String a_title = "";
		InputStream s_image = null;

		String s_type = "";
		String s_type1 = "";
		String s_name = "";
		String s_conn = "";
		Timestamp s_time = null;
		String s_location = "";
		String s_desc = "";
		Double s_lat = null;
		Double s_lng = null;
		String s_pet_type = "";
		String s_pet_type2 = "";
		int experience = 0;
		long sizeInBytes = 0;

		Collection<Part> parts = request.getParts();
		// GlobalService.exploreParts(parts, request);
		if (parts != null) { // 如果這是一個上傳資料的表單
			for (Part p : parts) {
				String fldName = p.getName();
				String value = request.getParameter(fldName);
				// 1. 讀取使用者輸入資料
				if (p.getContentType() == null) {
					if (fldName.equals("s_pet_type")) {
						s_pet_type = value;
					} else if (fldName.equals("s_name")) {
						s_name = value;
					} else if (fldName.equalsIgnoreCase("s_conn")) {
						s_conn = value;
					} else if (fldName.equalsIgnoreCase("s_time")) {
						// s_time = new Timestamp(value);
						
						s_time = new Timestamp(System.currentTimeMillis());
					} else if (fldName.equalsIgnoreCase("s_location")) {
						s_location = value;
					} else if (fldName.equalsIgnoreCase("s_desc")) {
						s_desc = value;
					} else if (fldName.equalsIgnoreCase("s_lat")) {
						s_lat = Double.valueOf(value);
					} else if (fldName.equalsIgnoreCase("s_lng")) {
						s_lng = Double.valueOf(value);
					}
				} else {
					fldName = getFileName(p);
					if (fldName != null && fldName.trim().length() > 0) {
						sizeInBytes = p.getSize();
						s_image = p.getInputStream();
					} else {
						errorMsg.put("errPicture", "必須挑選圖片檔");
					}

				}
			}

			// 2. 進行必要的資料轉換
			Cookie[] allCookies = request.getCookies();
			if (allCookies != null) {
				for (int i = 0; i < allCookies.length; i++) {
					if (allCookies[i].getName().equals("bottomSelect")) {
						s_type = allCookies[i].getValue();
					}
				}
			}

			if (s_type.equals("lost")) {
				s_type = "找寵物";
				s_type1 = "l";
				
			} else if (s_type.equals("found")) {
				s_type = "找主人";
				s_type1 = "f";
				
			}

			if (s_pet_type.equals("d")) {
				s_pet_type2 = "狗狗";
			} else if (s_pet_type.equals("c")) {
				s_pet_type2 = "貓貓";
			} else if (s_pet_type.equals("o")) {
				s_pet_type2 = "其他";
			}
			a_title = "[" + s_type + "][" + s_pet_type2 + "]";
			System.out.println(a_title);

			// 3. 檢查使用者輸入資料
			if (s_name == null || s_name.trim().length() == 0) {
				errorMsg.put("errorName", "姓名欄必須輸入");
			}
			if (s_conn == null || s_conn.trim().length() == 0) {
				errorMsg.put("errorConnEmpty", "電話欄必須輸入");
			}
			if (s_time == null) {
				errorMsg.put("errorTimeEmpty", "時間欄必須輸入");
			}
			if (s_location == null || s_location.trim().length() == 0) {
				errorMsg.put("errorLocation", "地點欄必須輸入");
			}
			if (s_desc == null || s_desc.trim().length() == 0) {
				errorMsg.put("errorDesc", "地址欄必須輸入");
			}
		} else {
			errorMsg.put("errTitle", "此表單不是上傳檔案的表單");
		}

		if (!errorMsg.isEmpty()) {
			// 導向原來輸入資料的畫面，這次會顯示錯誤訊息
			System.out.println(errorMsg);
			RequestDispatcher rd = request.getRequestDispatcher("sLostReg.jsp");
			rd.forward(request, response);
			return;
		}
		try {
			// 4. 進行Business Logic運算
			// RegisterServiceFile類別的功能：
			// 1.檢查帳號是否已經存在
			// 2.儲存會員的資料
			ArticleDAO aDao = new ArticleDAO();
			MemberBean mBean = (MemberBean)request.getSession().getAttribute("LoginOK");
//			int m_id = mBean.getM_id();m_id!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			ArticleBean ab = new ArticleBean(25, a_block, a_title, new Timestamp(System.currentTimeMillis()), s_image);

			
			int n1 = aDao.insertArticle(ab);
			SearchDAO sDao = new SearchDAO();
			SearchBean sb = new SearchBean(n1, s_type1, s_name, s_conn, s_time, s_location, s_desc, s_lat,
					s_lng, s_pet_type);
			
			int n2 = sDao.insertSearch(sb);

			if (n1 > 0  && n2 == 1) {
				msgOK.put("InsertOK", "<Font color='red'>新增成功，請開始使用本系統</Font>");
				if (s_type1.equals("f")) {
					request.setAttribute("s_path", s_type1);//--------------------
				} else if (s_type1.equals("l")){
					request.setAttribute("s_path", s_type1);//--------------------
				}
				RequestDispatcher rd = request.getRequestDispatcher("sSuccessMSG.jsp");
				rd.forward(request, response);
				return;
			} else {
				errorMsg.put("errorIDDup", "新增此筆資料有誤(RegisterServlet)");
			}

			// // 5.依照 Business Logic 運算結果來挑選適當的畫面
			if (!errorMsg.isEmpty()) {
				// 導向原來輸入資料的畫面，這次會顯示錯誤訊息
				RequestDispatcher rd = request.getRequestDispatcher(request.getRequestURI());
				rd.forward(request, response);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
			errorMsg.put("errorIDDup", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher(request.getRequestURI());
			rd.forward(request, response);
		}

	}

	public static String getFileName(final Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim()
						.replace("\"", "");
			}
		}
		return null;
	}
}
