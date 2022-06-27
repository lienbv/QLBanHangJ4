package Controller_User;

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
import entity.Customer;
import entity.OrderInfor;

/**
 * Servlet implementation class waiting_Confirm_Cancel_Controller
 */
@WebServlet({ "/waiting_Confirm_Cancel_Controller", "/waiting_Confirm_Cancel_Controller/cancel"

})
public class waiting_Confirm_Cancel_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<OrderInfor> listOrder_Infor;
	private OrderInfor order;
	private Order_Infor_Dao orderDao;
    private Customer customer;
    private Customer_Dao  customer_dao;
     
	public waiting_Confirm_Cancel_Controller() {
		super();
		this.listOrder_Infor = new ArrayList<OrderInfor>();
		this.orderDao = new Order_Infor_Dao();
		this.order = new OrderInfor();
		this.customer = new Customer();
		this.customer_dao  = new Customer_Dao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = request.getRequestURI().toString();
		if (url.contains("/waiting_Confirm_Cancel_Controller")) {
			this.waiting(request, response);
			this.confirm(request, response);
			this.cancel(request, response);
			request.setAttribute("view", "/user/Order_Waiting_Confirm_Cancel.jsp");
			request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
		}
	}

	private void waiting(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		this.customer = (Customer) session.getAttribute("acountKH");
		int id = this.customer.getId();
		this.customer = this.customer_dao.findbyid(id);
		this.listOrder_Infor = this.orderDao.list_Product_Customer_Waiting(this.customer, "Waiting");
		System.out.println(this.listOrder_Infor);
		request.setAttribute("listOrder_Waiting", this.listOrder_Infor);


	}

	private void confirm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		this.customer = (Customer) session.getAttribute("acountKH");
		int id = this.customer.getId();
		this.customer = this.customer_dao.findbyid(id);
		this.listOrder_Infor = this.orderDao.list_Product_Customer_Waiting(this.customer,"Confirm");
		System.out.println(this.listOrder_Infor);
		request.setAttribute("listOrder_Confirm", this.listOrder_Infor);

	}
	private void cancel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		this.customer = (Customer) session.getAttribute("acountKH");
		int id = this.customer.getId();
		this.customer = this.customer_dao.findbyid(id);
		this.listOrder_Infor = this.orderDao.list_Product_Customer_Waiting(this.customer,"Cancel");
		System.out.println(this.listOrder_Infor);
		request.setAttribute("listOrder_Cancel", this.listOrder_Infor);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURI().toString();
		if (url.contains("cancel")) {
			this.waitingUpdatetoCancel(request, response);
		}
	}

	private void waitingUpdatetoCancel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hủy nè");
		int id = Integer.parseInt(request.getParameter("id"));
		this.order.setId(id);
		this.order.setStatus("Cancel");
		this.orderDao.updateToCancel(this.order);
		response.sendRedirect(request.getContextPath() + "/waiting_Confirm_Cancel_Controller");

	}

}
