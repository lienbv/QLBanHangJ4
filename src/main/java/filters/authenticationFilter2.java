package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Customer;
//"/product_Detail/*", "/admin/*"

@WebFilter(urlPatterns = {"/admin/*"}, filterName = "login_filter_admin"  )
public class authenticationFilter2 extends HttpFilter implements Filter {

	public authenticationFilter2() {
		super();

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// kiểm tr điều kiện trc khi servlet nhận kết quả
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpResp = (HttpServletResponse) response;
		
	    String uri = httpReq.getRequestURI().toString();
		HttpSession session = httpReq.getSession();

		Customer userstaff = (Customer) session.getAttribute("acountStaff");
		String error = "";
		if (userstaff == null) {
			session.setAttribute("sessionCart", "Vui lòng đăng nhập ");
			httpResp.sendRedirect(httpReq.getContextPath() + "/user/login" + "?error=1");
            return;
		}
		else {
			chain.doFilter(request, response);
		}

		// kiểm tr điều kiện sau khi servlet nhận kết quả
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
