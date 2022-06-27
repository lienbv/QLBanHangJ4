package Controller_User;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.map.HashedMap;

import Dao.Product_Dao;
import entity.Cart;
import entity.Customer;
import entity.Product;

//add_To_Cart
@WebServlet({ "/product_Detail/add_To_Cart", "/product_Detail/cart", "/product_Detail/update_To_Cart",
		"/product_Detail/delete_To_Cart"

})
public class cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Product_Dao productDao;
	private List<Product> listProduct;
	private Product product;
	private Cart carts;
	private List<Cart> lstCart;

	public cart() {
		super();
		this.productDao = new Product_Dao();
		this.lstCart = new ArrayList<>();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI().toString();
		if (uri.contains("cart")) {
			this.showCart(request, response);
		} else if (uri.contains("delete_To_Cart")) {
			this.deleteToCart(request, response);
			response.sendRedirect(request.getContextPath() + "/product_Detail/cart");
		}
		this.sumTT(request, response);

	}

	private void showCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("view", "/user/cart.jsp");

		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);

	}

	private void addCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.carts = new Cart();
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		this.product = this.productDao.findbyid(id);
		HashMap<Integer, Cart> cart = (HashMap<Integer, Cart>) session.getAttribute("listCart");
		if (cart == null) {
			cart = new HashMap<Integer, Cart>();
			this.carts = new Cart(1, this.product);
			cart.put(id, this.carts);

		} else {
			if (cart.containsKey(id)) {
				this.carts = cart.get(id);
				this.carts.amountAdd();
			} else {
				this.carts = new Cart(1, this.product);
				cart.put(id, this.carts);

			}
		}

		session.setAttribute("listCart", cart);
		for (Map.Entry<Integer, Cart> entry : cart.entrySet()) {
			Integer key = entry.getKey();
			Cart val = entry.getValue();
			System.out.println(val.getProduct().getName() + "product" + val.totalAll());
		}

		this.saveCartSession(request, response, cart);
		response.sendRedirect(request.getContextPath() + "/product_Detail/cart");

	}

	private void sumTT(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double sum = 0;
		HttpSession session = request.getSession();
		HashMap<Integer, Cart> cart = (HashMap<Integer, Cart>) session.getAttribute("listCart");
		for (Map.Entry<Integer, Cart> entry : cart.entrySet()) {
			System.out.println("sum èn");
			Integer key = entry.getKey();
			Cart val = entry.getValue();
			sum += val.getProduct().getPrice() * val.getAmount();
		}

		session.setAttribute("sum", sum);

	}

	private void saveCartSession(HttpServletRequest request, HttpServletResponse response, HashMap<Integer, Cart> cart)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.setAttribute("listCart", cart);
		Cookie arr[] = request.getCookies();
		String txt = "";
		System.out.println("============");
		for (Cookie o : arr) {
			System.out.println("cookie");
			if (o.getName().equals("id")) {
				txt = txt + o.getValue();
				response.addCookie(o);
				o.setMaxAge(600);
				System.out.println(o);
			}
		}
		Cookie c = new Cookie("id", txt);
		System.out.println(c);
		c.setMaxAge(600);

	}

	private void deleteToCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.carts = new Cart();
		System.out.println("delete nè");
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		this.carts = new Cart();
		this.product = this.productDao.findbyid(id);

		HashMap<Integer, Cart> cart = (HashMap<Integer, Cart>) session.getAttribute("listCart");
		if (cart.containsKey(id)) {
			cart.remove(id);
			this.carts = cart.get(id);

			session.setAttribute("message", "Delete thành công");
		}

		session.setAttribute("listCart", cart);
		this.saveCartSession(request, response, cart);

	}

	private void updateToCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.carts = new Cart();

		int amount = Integer.parseInt(request.getParameter("amount"));
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();

		this.carts = new Cart();
		this.product = this.productDao.findbyid(id);

		HashMap<Integer, Cart> cart = (HashMap<Integer, Cart>) session.getAttribute("listCart");
		if (cart == null) {
			cart = new HashMap<Integer, Cart>();
			this.carts = new Cart(amount, this.product);
			cart.put(id, this.carts);

		} else {
			if (cart.containsKey(id)) {
				if (amount == 0) {
					session.setAttribute("error", "Số lượng thêm vào giỏ hàng phải lớn hơn 0");
				} else if (amount >= this.product.getAmount()) {
					session.setAttribute("error",
							"Số lượng thêm vào giỏ hàng phải nhỏ hơn hoặc bằng" + this.product.getAmount());

				} else {
					this.carts = cart.get(id);
					this.carts.setAmount(amount);
					session.setAttribute("message", "Update số lượng thành công");
				}
			} else {
				this.carts = new Cart(amount, this.product);
				cart.put(id, this.carts);

			}
		}

		session.setAttribute("listCart", cart);
		for (Map.Entry<Integer, Cart> entry : cart.entrySet()) {
			Integer key = entry.getKey();
			Cart val = entry.getValue();
			System.out.println(val.getProduct().getName() + "product" + val.totalAll());
		}

//	    session.setAttribute("sum", this.carts.totalAll());
		this.saveCartSession(request, response, cart);
		response.sendRedirect(request.getContextPath() + "/product_Detail/cart");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI().toString();
		if (uri.contains("add_To_Cart")) {
			this.addCart(request, response);

		} else if (uri.contains("update_To_Cart")) {
			this.updateToCart(request, response);
		}
		this.sumTT(request, response);

	}

}
