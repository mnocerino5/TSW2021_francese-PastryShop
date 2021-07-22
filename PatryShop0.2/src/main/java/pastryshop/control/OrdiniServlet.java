package pastryshop.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pastryshop.dao.OrdiniDao;
import pastryshop.dao.ProdottoDao;
import pastryshop.model.CarrelloBean;
import pastryshop.model.OrdiniBean;
import pastryshop.model.ProdottoBean;
import pastryshop.model.UtenteBean;

/**
 * Servlet implementation class OrdiniServlet
 */
@WebServlet("/OrdiniServlet")
public class OrdiniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static boolean isDataSource = true;
	
	static OrdiniDao model;
	static ProdottoDao model2;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	static {
		if (isDataSource) {
			model = new OrdiniDao();
			model2 = new ProdottoDao();
		}
	}
    public OrdiniServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CarrelloBean cart = (CarrelloBean)request.getSession().getAttribute("carrello");
		UtenteBean User = (UtenteBean)request.getSession().getAttribute("currentSessionUser");
		
		String action = request.getParameter("action");
		
		try {
			if (action.equalsIgnoreCase("acquista")) {
				if(cart.getTotal() == 0) {
				System.out.println("vuoto");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Homepage.jsp");
                dispatcher.forward(request, response);
				}
				else {
				model.doSave_ordini(cart, User);//salvo nel db
				int n = model.Get_Id_order();
				System.out.println("fatto la n");
				System.out.println(n);
				
				//id ordine preso
				
				//fare insert del carrello dentro a ordinedettaglio db e settare l'id_ordine con quello sopra " n "
				model.DoSave_details_order_from_id_order(cart, n);
				for(int i = 0; i<cart.getCarrello_prodotti().size(); i++) {
					ProdottoBean bean = cart.getCarrello_prodotti().get(i);
						model2.Update_prod_after_buy(bean);
					}
				}
				
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Homepage.jsp");
                dispatcher.forward(request, response);
				cart.removeall();
				}
			else if(action.equalsIgnoreCase("modificaordine")) {
				Date data = new Date();
				int id = Integer.parseInt(request.getParameter("id"));
				String txt = request.getParameter("stato");
				OrdiniBean ordine = model.doRetrieve_prodotto_ByID_prodotto(id);
				ordine.setStato_ordini(txt);
				model.Update_sigle_order(ordine);
				
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Homepage.jsp");
                dispatcher.forward(request, response);
			}
			else if(action.equalsIgnoreCase("leggi")) {
				int id = Integer.parseInt(request.getParameter("id"));
				request.removeAttribute("dettagliordini");
				request.setAttribute("dettagliordini", model.doRetrieve_ordine_by_id_ordini(id)); //metodo prendi retrieve all from id_ordine uguale.
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/DettagliOrdine.jsp");
                dispatcher.forward(request, response);
			}
			
			
			}catch (SQLException e) {
				System.out.println("Error:" + e.getMessage());
			}
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
