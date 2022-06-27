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

import Dao.Customer_Dao;
import Dao.Order_Infor_Dao;
import Dao.Product_Dao;
import Util.EncryptUtil;
import entity.Customer;
import entity.OrderInfor;
import entity.Product;

/**
 * Servlet implementation class QL_Staff
 */
@WebServlet({ "/admin/Staff/delete", "/admin/Staff/index","/admin/Staff/create","/admin/Staff/store" })
public class QL_Staff extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<OrderInfor> listOrder_Infor;
	private OrderInfor order;
	private Order_Infor_Dao orderDao;
	private Customer customer;
	private List<Customer> listCustomer;
	private Customer_Dao customer_Dao;
	private Product product;
	private Product_Dao productDao;

	public QL_Staff() {
		super();
		this.listOrder_Infor = new ArrayList<OrderInfor>();
		this.orderDao = new Order_Infor_Dao();
		this.order = new OrderInfor();
		this.customer = new Customer();
		this.listCustomer = new ArrayList<>();
		this.customer_Dao = new Customer_Dao();
		this.product = new Product();
		this.productDao = new Product_Dao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int index = this.orderDao.count();
		request.setAttribute("count", index);
		
		String uri = request.getRequestURI().toString();
		if (uri.contains("index")) {
			this.list_Staff(request, response);
			this.list_Customer(request, response);
			request.setAttribute("viewAdmin", "/Staff/Manager_Staff.jsp");
			request.getRequestDispatcher("/Staff/home_Admin.jsp").forward(request, response);
		}else if(uri.contains("delete")) {
			this.delete_Staff(request, response);
		}else if(uri.contains("create")) {
			request.setAttribute("viewAdmin", "/Staff/Create_Staff.jsp");
			request.getRequestDispatcher("/Staff/home_Admin.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI().toString();
		if(uri.contains("store")) {
			this.register(request, response);
		}
	}

	private void list_Staff(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.listCustomer = this.customer_Dao.finduser_Status("exist", "staff");
		request.setAttribute("list_Staff", this.listCustomer);
	}

	private void list_Customer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.listCustomer = this.customer_Dao.finduser_Status("exist", "customer");
		request.setAttribute("list_Customer", this.listCustomer);
	}
	private void delete_Staff(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id  = Integer.parseInt(request.getParameter("id"));
		this.customer.setId(id);
		this.customer.setStatus("delete");
		this.customer_Dao.updateToStatus(this.customer);
		response.sendRedirect(request.getContextPath() +"/admin/Staff/index" +"?success_Delete=1");
	}


	private void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();

		String fullname = request.getParameter("fullname");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String phoneNumber = request.getParameter("phoneNumber");
		String address = request.getParameter("address");

		Customer customer = new Customer();
		Customer customer_Check_Username = this.customer_Dao.checkUserName(username);
		Customer customer_Check_SDT = this.customer_Dao.checkPhoneNumber(phoneNumber);

		if (customer_Check_Username != null && customer_Check_SDT == null) {
			session.setAttribute("errorUsername", "Username bị trùng vui lòng đổi sang Username khác");
			response.sendRedirect(request.getContextPath() + "/admin/Staff/create" + "?error1=1");
			return;

		} else if (customer_Check_Username != null && customer_Check_SDT != null) {

			session.setAttribute("errorPhoneNumber", "Số điện thoại bị trùng vui lòng đổi sang số khác");
			session.setAttribute("errorUsername", "Username bị trùng vui lòng đổi sang Username khác");
			response.sendRedirect(request.getContextPath() + "/admin/Staff/create" + "?error2=1");
			return;

		} else if (customer_Check_Username == null && customer_Check_SDT != null) {

			session.setAttribute("errorPhoneNumber", "Số điện thoại bị trùng vui lòng đổi sang số khác");
			response.sendRedirect(request.getContextPath() + "/admin/Staff/create" + "?error3=1");
			return;

		} else if (customer_Check_Username == null && customer_Check_SDT == null) {

			String hashed = EncryptUtil.hashPassword(password);
			customer.setPassword(hashed);
			customer.setImg(null);
			customer.setFullname(fullname);
			customer.setUsername(username);
			customer.setEmail(email);
			customer.setPhoneNumber(phoneNumber);
			customer.setAddress(address);
			customer.setRole("staff");
			customer.setStatus("exist");
			try {

				this.customer_Dao.insert(customer);
				session.setAttribute("successRegister", "Đăng kí thành công");
				response.sendRedirect(request.getContextPath() + "/admin/Staff/index" + "?succes=1");

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

}
