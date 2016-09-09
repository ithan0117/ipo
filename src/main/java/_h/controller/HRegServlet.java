package _h.controller;
/*
 * 本程式讀取使用者輸入資料，進行必要的資料轉換，檢查使用者輸入資料，
 * 進行Business Logic運算，依照Business Logic運算結果來挑選適當的畫面
 * 
 */
import java.io.IOException;
import java.io.InputStream;
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

// 接收圖片所需的包裝
@MultipartConfig(
		location = "",
		fileSizeThreshold = 1024 * 1024,
		maxFileSize = 1024 * 1024 * 500,
		maxRequestSize = 1024* 1024 * 500 * 5)

@WebServlet("/_h/HRegServlet")
public class HRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		Map<String, String> msgOk = new HashMap<String, String>();
		Map<String, String> errorMsg = new HashMap<String, String>();
		request.setAttribute("msgOk", msgOk);
		request.setAttribute("errorMsg", errorMsg);
		
		request.setCharacterEncoding("UTF-8");
		
		String m_nickname = "";
		int m_id = 34;
		String a_block = "H";
		String h_area = request.getParameter("h_area");
		String h_pet_type = request.getParameter("h_pet_type");
		String h_age = request.getParameter("h_age");
		String h_pet_color = request.getParameter("h_pet_color");
		String h_name = request.getParameter("h_name");
		String h_time = "";
		h_time = request.getParameter("h_time");
		String h_desc = request.getParameter("h_desc");
		String h_lat = request.getParameter("h_lat");
		String h_lng = request.getParameter("h_lng");
		InputStream a_image = request.getPart("a_image").getInputStream();
		
		System.out.println(h_time);
//		2016-09-01T23:11--------datetime-local
		
		// String轉Timestamp((經過Date))
		Timestamp ts = null ;
		try {
			h_time = h_time.replace("T", " ");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			Date date = sdf.parse(h_time);
			ts = new Timestamp(date.getTime());
		} catch (Exception e) {
			errorMsg.put("errorH_time", "格式錯誤");
			
		}
		// String轉換double	
		double h_lat1 = 0;
		double h_lng1 = 0;
		try {
			h_lat1 = Double.parseDouble(h_lat);
			h_lng1 = Double.parseDouble(h_lng);
		} catch (Exception e) {
			errorMsg.put("errorH_latng", "格式錯誤");
		}
		
		// 設定欄位是否"必填"
		if (h_area == null || h_area.trim().length() == 0) {
			errorMsg.put("errorH_area", "必須輸入");
		}
		if (h_pet_type == null || h_pet_type.trim().length() == 0) {
			errorMsg.put("errorH_pet_type", "必須輸入");
		}
		if (h_age == null || h_age.trim().length() == 0) {
			errorMsg.put("errorH_age", "必須輸入");
		}
		if (h_pet_color == null || h_pet_color.trim().length() == 0) {
			errorMsg.put("errorH_pet_color", "必須輸入");
		}
		if (h_name == null || h_name.trim().length() == 0) {
			errorMsg.put("errorH_name", "必須輸入");
		}
		if (h_time == null || h_time.trim().length() == 0) {
			errorMsg.put("errorH_time", "必須輸入");
		}
		if (h_lat == null || h_lat.trim().length() == 0) {
			errorMsg.put("errorH_lat", "必須輸入");
		}
		if (h_lng == null || h_lng.trim().length() == 0) {
			errorMsg.put("errorH_lng", "必須輸入");
		}

		if (!errorMsg.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("hRegister.jsp");
			rd.forward(request, response);
			System.out.println("輸入有誤");
			return;
		}
		
		
//		String a_title = String.concat();
//		String a_title = Document.writeln();
		String a_title = m_nickname.concat(h_area).concat(h_pet_type).concat(h_age).concat(h_pet_color).concat(h_name);
		System.out.println(a_title);
		
		
		if (errorMsg.isEmpty()) {
//			ArticleBean abean = new ArticleBean(m_id, a_block, a_title, a_image);
//			ArticleDAO adao = new ArticleDAO();
//			int a_id = adao.insertArticle(abean);
			int a_id = new ArticleDAO().insertArticle(new ArticleBean(m_id, a_block, a_title, a_image));
			
			HomelessDAO hdao = new HomelessDAO();
//			HomelessBean hb = new HomelessBean(a_id, h_area, h_pet_type, h_age, h_pet_color, h_name, h_time, h_desc, h_lat1, h_lng1);
			HomelessBean hb = new HomelessBean();
			hb.setA_id(a_id);
			hb.setH_area(h_area);
			hb.setH_pet_type(h_pet_type);
			hb.setH_age(h_age);
			hb.setH_pet_color(h_pet_color);
			hb.setH_name(h_name);
			hb.setH_time(ts);
			hb.setH_desc(h_desc);
			hb.setH_lat(h_lat1);
			hb.setH_lng(h_lng1);
			hdao.insertHomeless(hb);
			request.setAttribute("Bean", hb);
			
			RequestDispatcher rd = request.getRequestDispatcher("hQueryDetail.jsp");
			rd.forward(request, response);
			System.out.println("浪浪登記成功");
			return;
		}else{
			HomelessBean hb = new HomelessBean();
			hb.setH_area(h_area);
			hb.setH_pet_type(h_pet_type);
			hb.setH_age(h_age);
			hb.setH_pet_color(h_pet_color);
			hb.setH_name(h_name);
			hb.setH_time(ts);
			hb.setH_desc(h_desc);
			hb.setH_lat(h_lat1);
			hb.setH_lng(h_lng1);
			request.setAttribute("Bean", hb);
			request.setAttribute("errorMsg", errorMsg);
			RequestDispatcher rd = request.getRequestDispatcher("hRegister.jsp");
			rd.forward(request, response);
			System.out.println("註冊失敗");
		}
				
	}
}
	