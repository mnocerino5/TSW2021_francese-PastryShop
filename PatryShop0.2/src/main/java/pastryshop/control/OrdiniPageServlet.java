package pastryshop.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pastryshop.dao.OrdiniDao;
import pastryshop.dao.ProdottoDao;
import pastryshop.model.UtenteBean;

/**
 * Servlet implementation class OrdiniPageServlet
 */
@WebServlet("/OrdiniPageServlet")
public class OrdiniPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	static boolean isDataSource = true;
	
	static OrdiniDao model;
	
	static {
		if (isDataSource) {
			model = new OrdiniDao();
		}
	}
  
    public OrdiniPageServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UtenteBean User = (UtenteBean)request.getSession().getAttribute("currentSessionUser");
		int id = User.getId_utenti();
		
		System.out.println("sono qui ordine");
		try {
			if(User!= null) {
				if(User.getRuolo().equalsIgnoreCase("Admin")) {
					request.removeAttribute("ordini");
					request.setAttribute("ordini", model.doRetrieveAll());
				}
				else if(User.getRuolo().equalsIgnoreCase("utente")) {
					request.removeAttribute("ordini");
					request.setAttribute("ordini", model.doRetrieve_ordine_by_idUser(id));
				}
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListaOrdini.jsp");
			dispatcher.forward(request, response);
			}
		}catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}
	//azione quando clicco dettaglio attraverso l'id_ordine prendo tutti i singoli prodotti
	// da fare qui

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
