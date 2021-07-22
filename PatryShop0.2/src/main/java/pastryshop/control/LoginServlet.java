package pastryshop.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pastryshop.dao.LoginDao;
import pastryshop.model.UtenteBean;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			UtenteBean utente = new UtenteBean();
			utente.setUsername(request.getParameter("username"));
		    utente.setPassword(request.getParameter("password"));
		    utente = LoginDao.doRetrieve(utente);
		    
		    
		    if(utente.getRuolo().equalsIgnoreCase("utente")){
		    	 if (utente.isValido()){     
			          HttpSession session = request.getSession(true);	    
			          session.setAttribute("currentSessionUser",utente); 
			          response.sendRedirect("Homepage.jsp"); //logged-in page  
			          System.out.println("Sono Registrato");
		    	 }else {
			          response.sendRedirect("Login.jsp"); //error page 
				 } 
		   }
		     if(utente.getRuolo().equalsIgnoreCase("Admin")) {
		    	 if(utente.isValido()) {
		    	 HttpSession session = request.getSession(true);	    
		         session.setAttribute("currentSessionUser",utente); 
		         response.sendRedirect("Homepage.jsp"); //error page //fare reindirizzamento pagina amministratore
		         System.out.println("Sono Admin");
		    	 } else {
			          response.sendRedirect("Login.jsp"); //error page 

				 } 	
		     }
		}catch (Throwable theException){
		     System.out.println(theException); 
		     response.sendRedirect("Login.jsp");
			}
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
