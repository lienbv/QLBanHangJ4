package Controller_Admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.Cart_Dao;
import Dao.Customer_Dao;
import Dao.Order_Infor_Dao;
import entity.Customer;
import entity.OrderInfor;
import entity.Product;

/**
 * Servlet implementation class profile_admin
 */
@WebServlet({ "/admin/profile_Infor/index", "/admin/profile_Infor/update", "/admin/profile_Infor/changePassword"})
public class profile_admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Customer customer;
	private Customer_Dao customer_Dao;
	private List<Customer> lstCustomer;
	private Cart_Dao cartDao;
	private Product product;
	private Order_Infor_Dao order_Dao;
	private OrderInfor orderInfor;
    public profile_admin() {
        super();
        this.customer_Dao = new Customer_Dao();
		this.lstCustomer = new ArrayList<Customer>();
		this.customer = new Customer();
		this.cartDao = new Cart_Dao();
		this.order_Dao = new Order_Infor_Dao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI().toString();
		if (uri.contains("index")) {
			this.profile(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String uri = request.getRequestURI().toString();
		if (uri.contains("update")) {
			this.profileUpdate(request, response);
		} else if (uri.contains("changePassword")) {
            this.profileChangePass(request, response);
		}
	}
	private void profileUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("update nè");

		HttpSession session = request.getSession();

		int id = Integer.parseInt(request.getParameter("id"));
		String phoneNumber = request.getParameter("phone");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String fullname = request.getParameter("fullname");

		this.customer.setId(id);
		this.customer.setAddress(address);
		this.customer.setEmail(email);
		this.customer.setFullname(fullname);
		this.customer.setPhoneNumber(phoneNumber);
		
		try {
			if(checkinput(this.customer, this.customer.getPhoneNumber())) {
				this.customer_Dao.updateProfile(this.customer);
				
				response.sendRedirect(request.getContextPath() + "/admin/profile_Infor/index" + "?success=1");
				session.setAttribute("successUpdateProfile", "Cập nhật thành công");
				
			}else {
				session.setAttribute("errorPhone", "Số điện thoại đã được 1 tài khoản khác sử dụng vui lòng cập nhật sđt khác");
				response.sendRedirect(request.getContextPath() + "/admin/profile_Infor/index" + "?error=1");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/admin/profile_Infor/index" + "?error=1");
		}
		
		

	}
	private boolean checkinput(Customer k, String sdt) {
		List<Customer> lst = this.customer_Dao.finduserbysdt(k, sdt);

		if (lst.size() == 0) {
			System.out.println(lst.size());
			return true;
		} else {
			System.out.println(lst.size());
			return false;
		}

	}

	private void profileChangePass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("id"));
		String oldpass = request.getParameter("pass_old");
		String newpass = request.getParameter("pass_new");

		request.setAttribute("customer", id);
		this.customer.setId(id);
		this.customer.setPassword(newpass);
		if(this.checkPassword(oldpass, this.customer) || oldpass.equals(this.customer.getPassword().trim())) {
			this.customer_Dao.ChangePass(this.customer);
			response.sendRedirect(request.getContextPath() + "/admin/profile_Infor/index" + "?success=1");
		}else {
			response.sendRedirect(request.getContextPath() + "/admin/profile_Infor/index" + "?error=1");
		}

	}


	private void profile(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		this.customer = (Customer) session.getAttribute("acountStaff");
		int id = this.customer.getId();
		this.customer = this.customer_Dao.findbyid(id);
		request.setAttribute("customer", this.customer);
		request.setAttribute("view", "/Staff/personal_information.jsp");
		request.getRequestDispatcher("/Staff/home_Admin.jsp").forward(request, response);

	}
	private boolean checkPassword(String oldPass, Customer user) {
		return Util.EncryptUtil.checkPass(oldPass, user.getPassword());

	}

}
