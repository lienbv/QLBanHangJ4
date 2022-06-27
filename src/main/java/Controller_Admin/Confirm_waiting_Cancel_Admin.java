package Controller_Admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Order_Infor_Dao;
import entity.OrderInfor;


@WebServlet({
	"/admin/waiting_Confirm_Cancel_Controller/index","/admin/waiting_Confirm_Cancel_Controller/cancel","/admin/waiting_Confirm_Cancel_Controller/confirm"
	
})
public class Confirm_waiting_Cancel_Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<OrderInfor> listOrder_Infor;
	private OrderInfor order;
	private Order_Infor_Dao orderDao;
 
    public Confirm_waiting_Cancel_Admin() {
        super();
        this.listOrder_Infor = new ArrayList<OrderInfor>();
		this.orderDao = new Order_Infor_Dao();
		this.order = new OrderInfor();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int index = this.orderDao.count();

		request.setAttribute("count", index);
		
		String url = request.getRequestURI().toString();
		if (url.contains("index")) {
			this.waiting(request, response);
			this.confirm(request, response);
			this.cancel(request, response);
			request.setAttribute("viewAdmin", "/Staff/waiting_cancel_confirm_Admin.jsp");
			request.getRequestDispatcher("/Staff/home_Admin.jsp").forward(request, response);
		}
	}
	private void waiting(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.listOrder_Infor = this.orderDao.showWaiting("Waiting");
		System.out.println(this.listOrder_Infor);
		request.setAttribute("listOrder_Waiting", this.listOrder_Infor);


	}

	private void confirm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.listOrder_Infor = this.orderDao.showWaiting("Confirm");
		System.out.println(this.listOrder_Infor);
		request.setAttribute("listOrder_Confirm", this.listOrder_Infor);

	}
	private void cancel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.listOrder_Infor = this.orderDao.showWaiting("Cancel");
		System.out.println(this.listOrder_Infor);
		request.setAttribute("listOrder_Cancel", this.listOrder_Infor);

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
