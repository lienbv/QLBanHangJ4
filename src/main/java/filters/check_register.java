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


@WebFilter(urlPatterns = { "/user/register"}, filterName = "check_register")
public class check_register extends HttpFilter implements Filter {

	public check_register() {
		super();
		// TODO Auto-generated constructor stub
	}


	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpResp = (HttpServletResponse) response;
		HttpSession session = httpReq.getSession();

		String fullname = request.getParameter("fullname");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirm = request.getParameter("confirm");
		String phoneNumber = request.getParameter("phoneNumber");
		String address = request.getParameter("address");
		String phone_Matches = "/^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$/";
		String email_Matches = "/^[a-z][a-z0-9_.]{5,32}@[a-z0-9]{2,}(.[a-z0-9]{2,4}){1,2}$/";
		String fullname_Matches = " /^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\W|_]+$/";

		String uri = httpReq.getRequestURI().toString();

		if (fullname.length() <= 0 ) {
			session.setAttribute("fullname_null", "Họ tên không được để trống");
			httpResp.sendRedirect(httpReq.getContextPath() + "/user/login" + "?error1=5");
			return;
		} else if (username.length() <= 0) {
			session.setAttribute("user_null", "username không được để trống");
			httpResp.sendRedirect(httpReq.getContextPath() + "/user/login" + "?error1=5");
			return;
		} else if (email.length() <= 0) {
			session.setAttribute("email_null", "Email không được để trống");
			httpResp.sendRedirect(httpReq.getContextPath() + "/user/login" + "?error1=5");
			return;
		} else if (password.length() <= 0) {
			session.setAttribute("pass_null", "PassWord không được để trống");
			httpResp.sendRedirect(httpReq.getContextPath() + "/user/login" + "?error1=5");
			return;
		} else if (confirm.length() <= 0) {
			session.setAttribute("repass_null", "Confirm password không được để trống");
			httpResp.sendRedirect(httpReq.getContextPath() + "/user/login" + "?error1=5");
			return;
		} else if (phoneNumber.length() <= 0) {
			session.setAttribute("phone_null", "phone không được để trống");
			httpResp.sendRedirect(httpReq.getContextPath() + "/user/login" + "?error1=5");
			return;
		} else if (address.length() <= 0) {
			session.setAttribute("address_null", "Address không được để trống");
			httpResp.sendRedirect(httpReq.getContextPath() + "/user/login" + "?error1=5");
			return;
		}

		else {
			chain.doFilter(request, response);

		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
