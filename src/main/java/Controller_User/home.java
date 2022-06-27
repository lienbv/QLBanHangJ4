package Controller_User;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Category_Dao;
import Dao.Product_Dao;
import entity.Category;
import entity.Product;
import entity.Promotion;

@MultipartConfig
@WebServlet({
	"/home","/product/edit",
})
public class home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Product_Dao productDao;
	private List<Product> listProduct;
	private Product product;
	    private Promotion promotion;
	    private Product_Dao product_Dao;
	    private List<Product> lstProduct;
	    private Category category;
	    private Category_Dao categoryDao;
	    private List<Category> listCategory;

	public home() {
		super();
		
		this.productDao = new Product_Dao();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI().toString();
		if(uri.contains("home")) {
			this.home(request, response);
		}else if (uri.contains("edit")) {
			this.edit(request, response);
		}

	}
	
	private void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.listProduct = this.productDao.getBestSaler();
		List<Product> lstNewDate = this.productDao.getdateNew();
		request.setAttribute("lstProduct", this.listProduct);
		request.setAttribute("listNewDate", lstNewDate);
		request.setAttribute("view", "/user/homeUser.jsp");
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
	
	}
	private void edit(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		this.product = this.productDao.findbyid(id);
		request.setAttribute("product", this.product);
		request.setAttribute("view", "/user/product_Detail.jsp");
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
