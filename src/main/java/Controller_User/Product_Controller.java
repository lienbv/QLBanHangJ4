package Controller_User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Category_Dao;
import Dao.Product_Dao;
import entity.Category;
import entity.Product;
import entity.Promotion;

@WebServlet({
	"/product/index","/product/price_Max","/product/category","/product/price_Min","/product/bestSaler"
	
})
public class Product_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Product product;
    private Promotion promotion;
    private Product_Dao product_Dao;
    private List<Product> lstProduct;
    private Category category;
    private Category_Dao categoryDao;
    private List<Category> listCategory;
    public Product_Controller() {
        this.product_Dao = new Product_Dao();
        this.category = new Category();
        this.categoryDao = new Category_Dao();
        this.listCategory = new ArrayList<Category>();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String uri = request.getRequestURI().toString();
		if(uri.contains("index")) {
			this.product(request, response);
		}
		else if(uri.contains("category")) {
			this.productLoadCategory(request, response);
		}else if(uri.contains("price_Min")) {
			this.productPrice_Min(request, response);
		}else if(uri.contains("price_Max")) {
			this.productPrice_Max(request, response);
		}else if(uri.contains("bestSaler")) {
			this.productBest_Saler(request, response);
		}
		
		this.listCategory = this.categoryDao.getAll();
		request.setAttribute("lstCategory", this.listCategory);
		
		request.setAttribute("view", "/user/product.jsp");
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
	}

	private void productPrice_Max(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		this.lstProduct = this.product_Dao.getPriceMax();
		request.setAttribute("lst_Product", this.lstProduct);

	}
	private void productBest_Saler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		this.lstProduct = this.product_Dao.getBestSaler();
		request.setAttribute("lst_Product", this.lstProduct);

	}
	private void productPrice_Min(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		this.lstProduct = this.product_Dao.getPriceMin();
		request.setAttribute("lst_Product", this.lstProduct);

	}
	
	private void product(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		this.lstProduct = this.product_Dao.getAll();
		request.setAttribute("lst_Product", this.lstProduct);

	}
	private void productLoadCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		System.out.println("Load category");
		int id = Integer.parseInt(request.getParameter("id"));
		this.category = this.categoryDao.findbyid(id);
		this.lstProduct = this.product_Dao.getCategory(this.category);

	    request.setAttribute("id", id);
		request.setAttribute("lst_Product", this.lstProduct);
		this.listCategory = this.categoryDao.getAll();
		request.setAttribute("lstCategory", this.listCategory);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
