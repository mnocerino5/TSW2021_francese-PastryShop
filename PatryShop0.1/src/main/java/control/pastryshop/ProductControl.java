package control.pastryshop;

import java.io.IOException; 
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.pastryshop.Cart;
import model.pastryshop.OrdineDAO;
import model.pastryshop.OrdiniBean;
import model.pastryshop.ProductBean;
import model.pastryshop.ProductModel;
import model.pastryshop.ProductModelDS;

/**
 * Servlet implementation class ProductControl
 */
public class ProductControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// ProductModelDS usa il DataSource
	// ProductModelDM usa il DriverManager	
	static boolean isDataSource = true;
	
	static ProductModel model;
	static OrdineDAO model2;
	
	static {
		if (isDataSource) {
			model = new ProductModelDS();
			model2 = new OrdineDAO();
		}
	}
	
	public ProductControl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cart cart = (Cart)request.getSession().getAttribute("cart");
		if(cart == null) {
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		
		
		String action = request.getParameter("action");

		try {
			if (action != null) {
				if (action.equalsIgnoreCase("addC")) {
					int id = Integer.parseInt(request.getParameter("id"));
					cart.addProduct(model.doRetrieveByKey(id));
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ProductView.jsp");
					dispatcher.forward(request, response);
					System.out.println(cart);
				} else if (action.equalsIgnoreCase("deleteC")) {
					int id = Integer.parseInt(request.getParameter("id"));
					cart.deleteProduct(model.doRetrieveByKey(id));
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/CartView.jsp");
					dispatcher.forward(request, response);
				} else if (action.equalsIgnoreCase("read")) {
					int id = Integer.parseInt(request.getParameter("id"));
					request.removeAttribute("product");
					request.setAttribute("product", model.doRetrieveByKey(id));
					
					
					//messi qui
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/SingleProduct.jsp");
					dispatcher.forward(request, response);
				} else if (action.equalsIgnoreCase("delete")) {
					int id = Integer.parseInt(request.getParameter("id"));
					model.doDelete(id);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ProductView.jsp");
					dispatcher.forward(request, response);
				} else if (action.equalsIgnoreCase("insert")) {
					String name = request.getParameter("name");
					String description = request.getParameter("description");
					int price = Integer.parseInt(request.getParameter("price"));
					int quantity = Integer.parseInt(request.getParameter("quantity"));

					ProductBean bean = new ProductBean();
					bean.setName(name);
					bean.setDescription(description);
					bean.setPrice(price);
					bean.setQuantity(quantity);
					model.doSave(bean);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ProductView.jsp");
					dispatcher.forward(request, response);
				}
				else if(action.equalsIgnoreCase("checkout")) {
					if(cart.getTotal() == 0) {
						System.out.println("vuoto");
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Checkout.jsp");
	                    dispatcher.forward(request, response);
					}
					else {
						model2.doSave2(cart);
						request.setAttribute("ordini",model2.doRetrieveAll2());
						for(int i = 0; i<cart.getProducts().size(); i++) {
							ProductBean bean = cart.getProducts().get(i);
							model.Update_prod(bean);
						}
						cart.removeall();
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/OrdiniView.jsp");
	                    dispatcher.forward(request, response);
					}
					
				}
			}
			
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}

		request.getSession().setAttribute("cart", cart);
		request.setAttribute("cart", cart);
		
		
		String sort = request.getParameter("sort");

		try {
			request.removeAttribute("products");
			request.setAttribute("products", model.doRetrieveAll(sort));
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}
		
		if (action == null) {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ProductView.jsp");
		dispatcher.forward(request, response);
		}
//		else if (action != null) {
//			if(action.equalsIgnoreCase("read")) {
//				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/SingleProduct.jsp");
//				dispatcher.forward(request, response);
//			}
//		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
