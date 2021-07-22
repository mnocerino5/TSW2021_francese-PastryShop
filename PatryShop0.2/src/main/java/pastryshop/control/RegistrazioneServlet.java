package pastryshop.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pastryshop.dao.RegistrazioneDao;
import pastryshop.model.UtenteBean;

/**
 * Servlet implementation class RegistrazioneServlet
 */
@WebServlet("/RegistrazioneServlet")
public class RegistrazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	static boolean isDataSource = true;

	static RegistrazioneDao model;

	static {
		if (isDataSource) {
			model = new RegistrazioneDao();
		}
	}
    public RegistrazioneServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {	
			String nome = request.getParameter("nome");
			String cognome = request.getParameter("cognome");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			
			UtenteBean user = new UtenteBean();
			
			user.setNome(nome);
			user.setCognome(cognome);
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);
			model.Save_Utenti(user); // salva nel db utenti
		
			
			HttpSession session = request.getSession(true);
			if(user.isValido()) {
				session.setAttribute("sessioneutenteattuale", user);
				response.sendRedirect("./Homepage.jsp"); // logged-in page
			}else {
				response.sendRedirect("./Registrazione.jsp");
			}
			
			

		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
			response.sendRedirect("./ErroreRegistrazione.jsp");
		}
	}
		


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
