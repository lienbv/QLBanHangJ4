package Controller_User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.Customer_Dao;
import Dao.Product_Dao;
import Sevice.Create_RandomString;
import Sevice.Email_Service;
import Util.EncryptUtil;
import entity.Customer;
import entity.Email;

@WebServlet({ "/user/login", "/user/register", "/user/Forgotpassword" })
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Customer_Dao customer_Dao;
	private Product_Controller product;
	private Product_Dao product_Dao;
	private Customer cus ;

	public login() {
		super();
		this.customer_Dao = new Customer_Dao();
		this.product_Dao = new Product_Dao();
		this.cus = new Customer();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		request.setAttribute("view", "/user/login_out.jsp");
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String url = request.getRequestURL().toString();
		if (url.contains("login")) {
			this.login(request, response);
		} else if (url.contains("register")) {
			this.register(request, response);
		} else if (url.contains("Forgotpassword")) {
			this.forGotPassWord(request, response);
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Customer customer_Check_Username = this.customer_Dao.LoginUserName(username);
		System.out.println(customer_Check_Username.getUsername()+"abc " + customer_Check_Username.getPassword() + "der ");
		boolean check = EncryptUtil.checkPass(password, customer_Check_Username.getPassword());
		
		if(check == true && customer_Check_Username!=null) {
			if(customer_Check_Username.getRole().equals("customer")) {
				this.saveSessionkh(request, customer_Check_Username, username, password);
				response.sendRedirect(request.getContextPath() + "/home" + "?successLogin=1");
				
			}else if(customer_Check_Username.getRole().equals("staff")){
				this.saveSessionStaff(request, this.cus, username, password);
				response.sendRedirect(request.getContextPath() + "/admin/home_admin" + "?successLogin=1");
			}
		}else {
			response.sendRedirect(request.getContextPath() + "/user/login" + "?errorLogin=1");
		}
		

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
			response.sendRedirect(request.getContextPath() + "/user/login" + "?error1=1");
			return;

		} else if (customer_Check_Username != null && customer_Check_SDT != null) {

			session.setAttribute("errorPhoneNumber", "Số điện thoại bị trùng vui lòng đổi sang số khác");
			session.setAttribute("errorUsername", "Username bị trùng vui lòng đổi sang Ueername khác");
			response.sendRedirect(request.getContextPath() + "/user/login" + "?error2=1");
			return;

		} else if (customer_Check_Username == null && customer_Check_SDT != null) {

			session.setAttribute("errorPhoneNumber", "Số điện thoại bị trùng vui lòng đổi sang số khác");
			response.sendRedirect(request.getContextPath() + "/user/login" + "?error3=1");
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
			customer.setRole("customer");
			customer.setStatus("exist");
			try {

				this.customer_Dao.insert(customer);
				session.setAttribute("successRegister", "Đăng kí thành công");
				response.sendRedirect(request.getContextPath() + "/user/login" + "?succes=1");

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	private void forGotPassWord(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		try {
			List<Customer> listCustomor = new ArrayList<Customer>();
			String emailAddress = request.getParameter("email");
			String username = request.getParameter("username");
			listCustomor = this.customer_Dao.findEmail(username, emailAddress);
			if (listCustomor != null) {
				Create_RandomString random = new Create_RandomString();
				String pass = random.generateRandomString();
				String hashPass = EncryptUtil.hashPassword(pass);
				Customer customer = listCustomor.get(0);
				customer.setPassword(hashPass);
				this.customer_Dao.update(customer);
				Email mail = new Email();
				mail.setFrom("lienptph16568@fpt.edu.vn");
				mail.setFrompassword("Lien2002");
				mail.setTo(emailAddress);
				mail.setSubject("Mail Forgot Password of " + username);

				StringBuilder sb = new StringBuilder();
				sb.append("Dear ").append(username).append(" ");
				sb.append("you are the forgot password and this is my password. ");
				sb.append("Your password is: ").append(pass);
				mail.setContent(sb.toString());
				Email_Service.send(mail);
				session.setAttribute("messageEmail", "Đã gửi email thành công");
				response.sendRedirect(request.getContextPath() + "/user/login" + "?successForgotpass=1");
			} else {
				session.setAttribute("erorrEmail", "Gửi email không thành công");
				response.sendRedirect(request.getContextPath() + "/user/Forgotpassword" + "?errorForgotpass=1");
			}
		} catch (Exception e) {

			e.printStackTrace();
			session.setAttribute("erorrEmail", "Gửi email không thành công");
			response.sendRedirect(request.getContextPath() + "/user/Forgotpassword" + "?errorForgotpass=1");

		}
	}

	private void saveSessionkh(HttpServletRequest request, Customer customer, String username, String password) {
		HttpSession session = request.getSession();
		session.setAttribute("acountKH", customer);

		Cookie cookieUserName = new Cookie("userNameCookie", username);
		Cookie cookiePassword = new Cookie("passwordCookie", password);

		cookiePassword.setMaxAge(600);
		cookieUserName.setMaxAge(600);

	}

	private void saveSessionStaff(HttpServletRequest request, Customer customer, String username, String password) {
		HttpSession session = request.getSession();
		session.setAttribute("acountStaff", customer);

		Cookie cookieUserName = new Cookie("userNameCookie", username);
		Cookie cookiePassword = new Cookie("passwordCookie", password);

		cookiePassword.setMaxAge(600);
		cookieUserName.setMaxAge(600);

	}

	protected void Check(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

	}
}
