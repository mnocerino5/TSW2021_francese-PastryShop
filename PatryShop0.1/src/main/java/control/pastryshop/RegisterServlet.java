package control.pastryshop;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.pastryshop.UserDAO;

import model.pastryshop.UserBean;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	static boolean isDataSource = true;

	static UserDAO model2;

	static {
		if (isDataSource) {
			model2 = new UserDAO();
		}
	}

	public RegisterServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String name = request.getParameter("firstname");
			String description = request.getParameter("lastname");
			String price = request.getParameter("username");
			String quantity = request.getParameter("password");

			UserBean bean = new UserBean();
			bean.setFirstName(name);
			bean.setLastName(description);
			bean.setUserName(price);
			bean.setPassword(quantity);
		
			model2.doSave(bean);
			System.out.println(bean);
			HttpSession session = request.getSession(true);
			if(bean.isValid()) {
				session.setAttribute("currentSessionUser", bean);
				response.sendRedirect("LoginPage.jsp"); // logged-in page
			}else {
				response.sendRedirect("./Register.jsp");
			}
			
			

		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
