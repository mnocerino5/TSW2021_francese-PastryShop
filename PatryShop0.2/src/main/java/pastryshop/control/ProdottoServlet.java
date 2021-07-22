package pastryshop.control;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import pastryshop.dao.ProdottoDao;
import pastryshop.model.CarrelloBean;
import pastryshop.model.ProdottoBean;

/**
 * Servlet implementation class ProdottoServlet
 */
@WebServlet("/ProdottoServlet")
@MultipartConfig(maxFileSize = 16177215 )
public class ProdottoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static boolean isDataSource = true;
	
	static ProdottoDao model;
	
	static {
		if (isDataSource) {
			model = new ProdottoDao();
		}
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdottoServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CarrelloBean cart = (CarrelloBean)request.getSession().getAttribute("carrello");
		
		if(cart == null) {
			cart = new CarrelloBean();
			request.getSession().setAttribute("carrello", cart);
		}
		
		String action = request.getParameter("action");
		try {
			if (action != null) {
				if (action.equalsIgnoreCase("aggiungiProdottoCarrello")) {
					int id = Integer.parseInt(request.getParameter("id"));
					cart.addProduct(model.doRetrieve_prodotto_ByKey(id));
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Prodotti.jsp");
					dispatcher.forward(request, response);
					System.out.println(cart);
					} 
				else if (action.equalsIgnoreCase("cancellaProdottoCarrello")) {
					int id = Integer.parseInt(request.getParameter("id"));
					cart.deleteProduct(model.doRetrieve_prodotto_ByKey(id));
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Carrello.jsp");
					dispatcher.forward(request, response);
				} 
				else if (action.equalsIgnoreCase("leggi")) {
					int id = Integer.parseInt(request.getParameter("id"));
					request.removeAttribute("prodotto");
					request.setAttribute("prodotto", model.doRetrieve_prodotto_ByKey(id));
					
					
					//messi qui
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/SingoloProdotto.jsp");
					dispatcher.forward(request, response);
				} else if (action.equalsIgnoreCase("cancella")) {
					int id = Integer.parseInt(request.getParameter("id"));
					model.doDelete_prodotto(id);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Prodotti.jsp");
					dispatcher.forward(request, response);
				} else if (action.equalsIgnoreCase("inserire")) {
					String nome = request.getParameter("nome");
					String descrizione = request.getParameter("descrizione");
					int quantita = Integer.parseInt(request.getParameter("quantita"));
					int prezzo = Integer.parseInt(request.getParameter("prezzo"));
					String categoria = request.getParameter("categoria");
					
					Part foto = request.getPart("foto");

					ProdottoBean prodotto = new ProdottoBean();
					prodotto.setNome_prodotto(nome);
					prodotto.setDescrizione_prodotto(descrizione);
					prodotto.setQuantita_disponibile_prodotto(quantita);
					prodotto.setPrezzo_prodotto(prezzo);
					prodotto.setCategoria(categoria);
					prodotto.setFoto(foto);
					
					model.doSave_prodotto(prodotto);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Prodotti.jsp");
					dispatcher.forward(request, response);
				}
				else if(action.equalsIgnoreCase("modificaprod")) {
					
					int id = Integer.parseInt(request.getParameter("id"));

					int quantità = Integer.parseInt(request.getParameter("quantita"));
					int prezzo =Integer.parseInt(request.getParameter("prezzo"));
					ProdottoBean prodotto = model.doRetrieve_prodotto_ByKey(id);
					prodotto.setQuantita_disponibile_prodotto(quantità);
					prodotto.setPrezzo_prodotto(prezzo);
					model.Update_sigle_prod(prodotto);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Prodotti.jsp");
					dispatcher.forward(request, response);
				}
			}
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}
		
		String sort = request.getParameter("sort");

		try {
			request.removeAttribute("prodotti");
			request.setAttribute("prodotti", model.doRetrieveAll(sort));
		    
			request.setAttribute("prodotti_lievitati",model.doRetrieveCategory("lievitati"));
			request.setAttribute("prodotti_torte",model.doRetrieveCategory("torte"));
			request.setAttribute("prodotti_colazione",model.doRetrieveCategory("colazione"));
			request.setAttribute("prodotti_mignon",model.doRetrieveCategory("mignon"));
			
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}
		
		if (action == null) {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Prodotti.jsp");
		dispatcher.forward(request, response);
		}
	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
