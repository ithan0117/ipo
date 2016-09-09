package _m.filter;
/*
 * 過濾器(Filter)是當使用者"要求"它所監控的資源時，才會執行
 * 當使用者提出請求，我們可以將回應的訊息"過濾"或進行某些"處理"
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _m.model.MemberBean;

// 監控的對象, "/*" 表示系統內的所有資源
@WebFilter(urlPatterns = { "/*" }, initParams = { 
				@WebInitParam(name = "filter_edit", value = "/_m/mEdit.jsp"), 
				@WebInitParam(name = "filter_selectpost", value = "/_m/mMemberselect.jsp"),
				@WebInitParam(name = "filter_selectpost", value = "/_m/mAccount.jsp")
				})

public class LoginFilter implements Filter {
	// 定義一個"包裝url"的實例變數
	Collection<String> url = new ArrayList<String>();
    public LoginFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response
			, FilterChain chain) throws IOException, ServletException {
		if(request instanceof HttpServletRequest 
				&& response instanceof HttpServletResponse){
			HttpServletRequest req = (HttpServletRequest) request;
//			HttpServletResponse resp = (HttpServletResponse) response;
			String servletPath = req.getServletPath();
			System.out.println("111--->" + servletPath);
			if(mustLogin(servletPath)){
				//如果已經登入
				if(checkLogin(req)){	
					System.out.println("222--->需要Login，已經Login");
					chain.doFilter(request, response);
				//如果尚未登入
				} else {	
					HttpSession session = req.getSession();
					session.setAttribute("target", req.getServletPath());
					System.out.println("333--->需要Login，尚未Login , ServletPath="
							+ req.getServletPath());
					RequestDispatcher rd = request.getRequestDispatcher("/_m/mLogin.jsp");
					rd.forward(request, response);
					return;
				}
			// 不需要登入
			} else {
				System.out.println("444--->不需要Login");
				chain.doFilter(request, response);
			}
		} else {
			throw new ServletException("Request / Response Type Error(型態錯誤)");
		}
	}

	// 讀入起始參數，並放置於url內
	public void init(FilterConfig fConfig) throws ServletException {
		Enumeration<String> e = fConfig.getInitParameterNames();
		while(e.hasMoreElements()){
			String name = e.nextElement();
			url.add(fConfig.getInitParameter(name));
		}
	}
	
	private boolean mustLogin(String servletPath){
		boolean login = false;
		System.out.println(servletPath);
		for(String sURL : url){
			System.out.println(sURL);
			if(sURL.endsWith("*")){
				sURL = sURL.substring(0, sURL.length() - 1);
				if(servletPath.startsWith(sURL)){
					login = true;
					break;
				}
			} else {
				if(servletPath.equals(sURL)){
					login = true;
					break;
				}
			}
		}
		return login;
	}
	
	private boolean checkLogin(HttpServletRequest request){
		HttpSession session = request.getSession();
		MemberBean loginToken = (MemberBean)session.getAttribute("LoginOK");
		if(loginToken == null){
			return false;
		} else {
			return true;
		}
	}
}
