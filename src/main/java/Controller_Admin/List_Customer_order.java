package Controller_Admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Cart_Dao;
import Dao.Customer_Dao;
import Dao.Order_Infor_Dao;
import Dao.Product_Dao;
import entity.Customer;
import entity.OrderInfor;
import entity.Product;

@WebServlet({ "/admin/List_Customer_Order/index", "/admin/List_Customer_Order/edit", "/admin/List_Customer_Order/update"

})
public class List_Customer_order extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Customer customer;
	private Customer_Dao customer_Dao;
	private List<Customer> lstCustomer;
	private Cart_Dao cartDao;
	private Product product;
	private Order_Infor_Dao order_Dao;
	private Product_Dao product_Dao;
	private OrderInfor orderInfor;
	private List<OrderInfor> lstOrder;

	public List_Customer_order() {
		super();
		this.customer_Dao = new Customer_Dao();
		this.lstCustomer = new ArrayList<Customer>();
		this.customer = new Customer();
		// this.cart = new Cart();
		this.cartDao = new Cart_Dao();
		this.order_Dao = new Order_Infor_Dao();
		this.product_Dao = new Product_Dao();
		this.lstOrder = new ArrayList<OrderInfor>();
		this.product = new Product();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int index = this.order_Dao.count();

		request.setAttribute("count", index);

		String uri = request.getRequestURI().toString();
		if (uri.contains("index")) {
			this.list_Customer_order(request, response);
		} else if (uri.contains("edit")) {
			this.list_Customer_order_edit(request, response);
		}

	}

	private void list_Customer_order(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Object[]> lstObj = new ArrayList<Object[]>();
		lstObj = this.order_Dao.list_Customer_Waiting();
		request.setAttribute("listOrder_Waiting_Customer", lstObj);
		request.setAttribute("viewAdmin", "/Staff/List_Customer_Order.jsp");
		request.getRequestDispatcher("/Staff/home_Admin.jsp").forward(request, response);

	}

	private void list_Customer_order_edit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		this.customer = this.customer_Dao.findbyid(id);
		this.lstOrder = this.order_Dao.list_Product_Customer_Waiting(this.customer, "Waiting");
		request.setAttribute("listOrder_Waiting", this.lstOrder);
		request.setAttribute("viewAdmin", "/Staff/waiting_cancel_confirm_Admin.jsp");
		request.getRequestDispatcher("/Staff/home_Admin.jsp").forward(request, response);

	}

	private void list_Customer_order_update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		OrderInfor or = new OrderInfor();
		Product pro = new Product();

		int id = Integer.parseInt(request.getParameter("id"));
		int id_product = Integer.parseInt(request.getParameter("id_product"));

		this.orderInfor = this.order_Dao.findbyid(id);
		this.orderInfor.setStatus("Confirm");
		this.orderInfor.setId(id);

		this.product.setId(id_product);
		this.product = this.product_Dao.findbyid(id_product);
		int quantity = this.product.getAmount() - this.orderInfor.getAmount();
        System.out.println(this.product.getAmount()+"amount product");
        System.out.println(this.orderInfor.getAmount()+"amount product");
		this.product.setAmount(quantity);

		or = this.order_Dao.updateToCancel(this.orderInfor);
		pro = this.product_Dao.updateASmount(this.product);

		request.setAttribute("listOrder_Waiting", this.lstOrder);
		response.sendRedirect(request.getContextPath() + "/admin/List_Customer_Order/index" + "?susscessUpdate=1");

	}

	private void list_Customer_order_delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		OrderInfor or = new OrderInfor();
		Product pro = new Product();

		int id = Integer.parseInt(request.getParameter("id"));
		int id_product = Integer.parseInt(request.getParameter("id_product"));

		this.orderInfor = this.order_Dao.findbyid(id);
		this.orderInfor.setStatus("Confirm");
		this.orderInfor.setId(id);
		this.product.setId(id_product);

		or = this.order_Dao.updateToCancel(this.orderInfor);
		pro = this.product_Dao.update_Amount_Product(this.product);

		request.setAttribute("listOrder_Waiting", this.lstOrder);
		response.sendRedirect(request.getContextPath() + "/admin/List_Customer_Order/index" + "?susscessUpdate=1");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI().toString();
		if (uri.contains("update")) {
			this.list_Customer_order_update(request, response);
		}
	}

}
