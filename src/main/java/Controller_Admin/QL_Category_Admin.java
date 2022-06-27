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

import Dao.Category_Dao;
import Dao.Customer_Dao;
import Dao.Order_Infor_Dao;
import Dao.Product_Dao;
import entity.Category;
import entity.Customer;
import entity.OrderInfor;
import entity.Product;

@WebServlet({ "/admin/category/index", "/admin/category/create", "/admin/category/update", "/admin/category/delete",
		"/admin/category/edit" })
public class QL_Category_Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<OrderInfor> listOrder_Infor;
	private OrderInfor order;
	private Order_Infor_Dao orderDao;
	private List<Category> listCategory;
	private Customer_Dao customer_Dao;
	private Product product;
	private Product_Dao productDao;
	private Category_Dao category_Dao;
	private Category category;

	public QL_Category_Admin() {
		super();
		this.listOrder_Infor = new ArrayList<OrderInfor>();
		this.orderDao = new Order_Infor_Dao();
		this.order = new OrderInfor();
		this.listCategory = new ArrayList<>();
		this.customer_Dao = new Customer_Dao();
		this.product = new Product();
		this.productDao = new Product_Dao();
		this.category_Dao = new Category_Dao();
		this.category = new Category();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		int index = this.orderDao.count();
		request.setAttribute("count", index);

		String uri = request.getRequestURI().toString();
		if (uri.contains("index")) {
			this.category_index(request, response);
		} else if (uri.contains("edit")) {
			this.category_eidt(request, response);
		} else if (uri.contains("delete")) {
			this.category_delete(request, response);
		}
	}

	private void category_index(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.listCategory = this.category_Dao.getAll_status();
		request.setAttribute("list_category", response);
		request.setAttribute("viewAdmin", "/Staff/Manager_Category.jsp");
		request.getRequestDispatcher("/Staff/home_Admin.jsp").forward(request, response);

	}

	private void category_create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		this.category.setName(name);
		this.category.setStatus("selling");
		if (name.length() <= 0) {
			session.setAttribute("name_category", "Tên thể loại không để trống");
			response.sendRedirect(request.getContextPath() + "/admin/category/create");
		} else {
			try {
				this.category_Dao.insert(this.category);
				session.setAttribute("success_category", "Thêm loại sản phẩm thành công");
				response.sendRedirect(request.getContextPath() + "/admin/category/index");
			} catch (Exception e) {
				response.sendRedirect(request.getContextPath() + "/admin/category/create");
			}

		}
		//

	}

	private void category_eidt(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		this.category = this.category_Dao.findbyid(id);
		request.setAttribute("category", this.category);
	}

	private void category_update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		this.category.setId(id);
		this.category.setName(name);
		this.category.setStatus("selling");
		if (name.length() <= 0) {
			session.setAttribute("name_category_update", "Tên thể loại không để trống");
			response.sendRedirect(request.getContextPath() + "/admin/category/create");
		} else {
			try {
				this.category_Dao.update(this.category);
				session.setAttribute("success_category", "Thêm loại sản phẩm thành công");
				response.sendRedirect(request.getContextPath() + "/admin/category/index");
			} catch (Exception e) {
				response.sendRedirect(request.getContextPath() + "/admin/category/create");
			}

		}

	}

	private void category_delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           int id = Integer.parseInt(request.getParameter("id"));
           this.category.setId(id);
           this.category_Dao.updateToStatus(this.category);
           response.sendRedirect(request.getContextPath() + "/admin/category/index");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String uri = request.getRequestURI().toString();
		if (uri.contains("store")) {
			this.category_index(request, response);
		} else if (uri.contains("update")) {
             this.category_update(request, response);
		}

	}

}
