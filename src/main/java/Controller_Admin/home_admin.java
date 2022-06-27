package Controller_Admin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Dao.Category_Dao;
import Dao.Order_Infor_Dao;
import Dao.Product_Dao;
import Dao.Promotion_Dao;
import entity.Category;
import entity.Customer;
import entity.Product;
import entity.Promotion;

@MultipartConfig
@WebServlet({ "/admin/home_admin", "/admin/updateProduct", "/admin/editProduct", "/admin/addProduct",
		"/admin/deleteProduct"

})
public class home_admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private List<Product> listProduct;
	private Product product;
	private Promotion promotion;
	private Product_Dao product_Dao;
	private Category category;
	private Category_Dao categoryDao;
	private List<Category> listCategory;
	private Promotion_Dao proDao;
	private List<Promotion> list_Promotion;
	private Customer customer;
	private Order_Infor_Dao orderDao;

	public home_admin() {
		super();
		this.product_Dao = new Product_Dao();
		this.listCategory = new ArrayList<Category>();
		this.list_Promotion = new ArrayList<Promotion>();
		this.listProduct = new ArrayList<Product>();
		this.product = new Product();
		this.categoryDao = new Category_Dao();
		this.promotion = new Promotion();
		this.category = new Category();
		this.proDao = new Promotion_Dao();
		this.orderDao = new Order_Infor_Dao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.listCategory = this.categoryDao.getAll();
		this.list_Promotion = this.proDao.getAll();
		int index = this.orderDao.count();
		
		request.setAttribute("listCC", this.listCategory);
		request.setAttribute("listPromotion", this.list_Promotion);
		request.setAttribute("count", index);

		String url = request.getRequestURI().toString();
		if (url.contains("home_admin")) {
			this.home_Admin(request, response);
		} else if (url.contains("addProduct")) {
			request.setAttribute("viewAdmin", "/Staff/addProduct.jsp");
			request.getRequestDispatcher("/Staff/home_Admin.jsp").forward(request, response);
		} else if (url.contains("editProduct")) {
			this.editProduct(request, response);
		} else if (url.contains("deleteProduct")) {
			this.deleteProduct(request, response);
		}

	}

	private void home_Admin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		this.listProduct = this.product_Dao.getAllSelling();
		

		request.setAttribute("lst_Product_Admin", this.listProduct);

		request.setAttribute("viewAdmin", "/Staff/Qlproduct_Admin.jsp");
		request.getRequestDispatcher("/Staff/home_Admin.jsp").forward(request, response);
	}

	private void editProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		this.product = this.product_Dao.findbyid(id);

		this.listCategory = this.categoryDao.getAll();
		this.list_Promotion = this.proDao.getAll();
		request.setAttribute("listCC", this.listCategory);
		request.setAttribute("listPromotion", this.list_Promotion);
		request.setAttribute("product", this.product);
		request.setAttribute("viewAdmin", "/Staff/UpdateProduct.jsp");
		request.getRequestDispatcher("/Staff/home_Admin.jsp").forward(request, response);
	}

	private void deleteProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		this.product.setId(id);
		this.product.setStatus("delete");
		this.product_Dao.update_status_Product(this.product);
		
		response.sendRedirect(request.getContextPath() +"/admin/home_admin" +"?success_Delete_product=1");
	}

	private void addProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.listCategory = this.categoryDao.getAll();
		this.list_Promotion = this.proDao.getAll();
		request.setAttribute("listCC", this.listCategory);
		request.setAttribute("listPromotion", this.list_Promotion);

		String realPath = request.getServletContext().getRealPath("./img");
		Path path = Paths.get(realPath);
		if (!Files.exists(path)) {
			Files.createDirectory(path);
		}
		Part part1 = request.getPart("img1");
		String filenameUpload1 = part1.getSubmittedFileName();
		
		if(!"".equals(filenameUpload1)) {
			String namefile1 = Path.of(filenameUpload1).getFileName().toString();
			part1.write(Paths.get(realPath.toString(), namefile1).toString());
			this.product.setImg1(namefile1);
			
		}

		Part part2 = request.getPart("img2");
		String filenameUpload2 = part2.getSubmittedFileName();
		if(!"".equals(filenameUpload2)) {
			String namefile2 = Path.of(filenameUpload2).getFileName().toString();
			part2.write(Paths.get(realPath.toString(), namefile2).toString());
			this.product.setImg2(namefile2);
			
		}

		String name = request.getParameter("name");
		String mota = request.getParameter("mota");
		double gia = Double.parseDouble(request.getParameter("gia"));
		int sl = Integer.parseInt(request.getParameter("amount"));
		int categories = Integer.parseInt(request.getParameter("category"));
		int promotions = Integer.parseInt(request.getParameter("promotion"));
		String size = request.getParameter("size");
		String color = request.getParameter("color");

		this.category = this.categoryDao.findbyid(categories);
		this.promotion = this.proDao.findbyid(promotions);

		this.product.setName(name);
		this.product.setDescription(mota);
		this.product.setPrice(gia);
		this.product.setAmount(sl);
		this.product.setCategory(this.category);
		this.product.setPromotion(this.promotion);
		this.product.setDate(new java.util.Date());
		this.product.setSize(size);
		this.product.setColor(color);
		this.product.setStatus("selling");
		try {
			this.product_Dao.insert(this.product);
			response.sendRedirect(request.getContextPath() + "/admin/home_admin" + "?success_Admin_Add_Product=1");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/admin/addProduct" + "?error_Admin_Add_Product=1");
		}

	}

	private void updateProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.listCategory = this.categoryDao.getAll();
		this.list_Promotion = this.proDao.getAll();
		request.setAttribute("listCC", this.listCategory);
		request.setAttribute("listPromotion", this.list_Promotion);

		String realPath = request.getServletContext().getRealPath("./img");
		Path path = Paths.get(realPath);
		if (!Files.exists(path)) {
			Files.createDirectory(path);
		}
		Part part1 = request.getPart("img1");
		String filenameUpload1 = part1.getSubmittedFileName();
		if (!"".equals(filenameUpload1)) {

			String namefile1 = Path.of(filenameUpload1).getFileName().toString();
			part1.write(Paths.get(realPath.toString(), namefile1).toString());
			this.product.setImg1(namefile1);
		}

		Part part2 = request.getPart("img2");
		String filenameUpload2 = part2.getSubmittedFileName();
		if (!"".equals(filenameUpload2)) {
			String namefile2 = Path.of(filenameUpload2).getFileName().toString();
			part2.write(Paths.get(realPath.toString(), namefile2).toString());
			this.product.setImg2(namefile2);

		}

		String name = request.getParameter("name");
		String mota = request.getParameter("mota");
		double gia = Double.parseDouble(request.getParameter("gia"));
		int sl = Integer.parseInt(request.getParameter("amount"));
		int categories = Integer.parseInt(request.getParameter("category"));
		int promotions = Integer.parseInt(request.getParameter("promotion"));
		String size = request.getParameter("size");
		String color = request.getParameter("color");

		this.category = this.categoryDao.findbyid(categories);
		this.promotion = this.proDao.findbyid(promotions);

		this.product.setName(name);
		this.product.setDescription(mota);
		this.product.setPrice(gia);
		this.product.setAmount(sl);
		this.product.setCategory(this.category);
		this.product.setPromotion(this.promotion);
		this.product.setDate(new java.util.Date());
		this.product.setSize(size);
		this.product.setColor(color);

		try {
			this.product_Dao.update(this.product);
			response.sendRedirect(request.getContextPath() + "/admin/home_admin" + "?success_Admin_Update_Product=1");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/admin/updateProduct" + "?error_Admin_Update_Product=1");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String url = request.getRequestURI().toString();
		if (url.contains("addProduct")) {
			this.addProduct(request, response);
		} else if (url.contains("updateProduct")) {
			this.updateProduct(request, response);
		}
	}

}
