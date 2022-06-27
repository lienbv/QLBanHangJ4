package Controller_User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.Cart_Dao;
import Dao.Customer_Dao;
import Dao.Order_Infor_Dao;
import entity.Cart;
import entity.Customer;
import entity.OrderInfor;
import entity.Product;

/**
 * Servlet implementation class bill
 */
@WebServlet({ "/order_Infor/show"

}

)
public class order_Infor_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Customer customer;
	private Customer_Dao customer_Dao;
	private List<Customer> lstCustomer;
	private Cart_Dao cartDao;
	private Product product;
	private Order_Infor_Dao order_Dao;
	private OrderInfor orderInfor;

	public order_Infor_Controller() {
		super();
		this.customer_Dao = new Customer_Dao();
		this.lstCustomer = new ArrayList<Customer>();
		this.customer = new Customer();
		//this.cart = new Cart();
		this.cartDao = new Cart_Dao();
		this.order_Dao = new Order_Infor_Dao();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           
			this.profile(request, response);
			this.sumTT(request, response);
			this.Tong(request, response);
			request.setAttribute("view", "/user/order_Infor.jsp");
			request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);

	}


	private void profile(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		this.customer = (Customer) session.getAttribute("acountKH");
		int id = this.customer.getId();
		this.customer = this.customer_Dao.findbyid(id);
		request.setAttribute("customer", this.customer);

	}

	private void sumTT(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double sum = 0;
		HttpSession session = request.getSession();
		HashMap<Integer, Cart> cart = (HashMap<Integer, Cart>) session.getAttribute("listCart");
		for (Map.Entry<Integer, Cart> entry : cart.entrySet()) {
			System.out.println("sum nè");
			Integer key = entry.getKey();
			Cart val = entry.getValue();
			sum += val.getProduct().getPrice() * val.getAmount();
		}
		session.setAttribute("sumTT", sum);

	}

	private void Tong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double sum = 0;
		HttpSession session = request.getSession();
		HashMap<Integer, Cart> cart = (HashMap<Integer, Cart>) session.getAttribute("listCart");
		for (Map.Entry<Integer, Cart> entry : cart.entrySet()) {

			Integer key = entry.getKey();
			Cart val = entry.getValue();
			sum += (val.getProduct().getPrice() * val.getAmount());

		}

		session.setAttribute("TongTT", sum + 40000);

	}

	private void insertCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		this.customer = (Customer) session.getAttribute("acountKH");
		int id = this.customer.getId();
		this.customer = this.customer_Dao.findbyid(id);
		
        Date date = new Date();
		HashMap<Integer, Cart> cart = (HashMap<Integer, Cart>) session.getAttribute("listCart");
        this.product = new Product();
		if(cart !=null) {
			for (Map.Entry<Integer, Cart> entry : cart.entrySet()) {
				System.out.println("insert cart nè");
				Integer key = entry.getKey();
				
				try {
					this.orderInfor=  new OrderInfor(date,null, "Waiting",entry.getValue().total(), entry.getValue().getAmount(),entry.getValue().getProduct(), this.customer);
					this.order_Dao.insert(this.orderInfor);
					session.setAttribute("listCart", null);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			response.sendRedirect(request.getContextPath() + "/waiting_Confirm_Cancel_Controller" + "?successCart=1");
			
		}else {
			response.sendRedirect(request.getContextPath() + "/home");
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			this.insertCart(request, response);
		
		
		
	}

}
