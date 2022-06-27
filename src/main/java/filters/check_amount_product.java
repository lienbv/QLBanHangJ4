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


@WebFilter(urlPatterns = { "/admin/addProduct"}, filterName = "product_store")
public class check_amount_product extends HttpFilter implements Filter {

	public check_amount_product() {
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

		int amount = Integer.parseInt(request.getParameter("amount")) ;
		int gia = Integer.parseInt(request.getParameter("gia")) ;

		String uri = httpReq.getRequestURI().toString();

		if (amount <=0 && amount <=1000) {
			session.setAttribute("soluong", "Số lượng phải lớn hơn 0 và nhỏ hơn bằng 1000");
			httpResp.sendRedirect(httpReq.getContextPath() + "/admin/addProduct" + "?error1=5");
			return;
		}else if(gia <=1000 ) {
			session.setAttribute("gia", "Giá phải lớn hơn 1000 ");
			httpResp.sendRedirect(httpReq.getContextPath() + "/admin/addProduct" + "?error1=6");
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
