package pastryshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import pastryshop.model.UtenteBean;


public class LoginDao {
	private static DataSource ds;
	static Connection currentCon = null;
	static ResultSet rs = null;
	static {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/pastryshop_database");

		} catch (NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}
	private static final String TABLE_NAME_UTENTI= "utenti";
	
	public static UtenteBean doRetrieve(UtenteBean utente) {
		 Statement stmt = null;    
	      PreparedStatement preparedStatement = null;
		
	      String username = utente.getUsername();    
	      String password = utente.getPassword(); 
	      
	      String searchQuery =
		            "select * from utenti where username='"
		                     + username
		                     + "' AND password='"
		                     + password
		                     + "'";
	   // "System.out.println" prints in the console; Normally used to trace the process
		   System.out.println("Your user name is " + username);          
		   System.out.println("Your password is " + password);
		   
		   System.out.println("Query: "+searchQuery);
		   try 
		   {
		      //connect to DB 
		      currentCon = ds.getConnection();
		      preparedStatement=currentCon.prepareStatement(searchQuery);
		      rs = preparedStatement.executeQuery(searchQuery);	        
		      boolean more = rs.next();
			       
		      //se l'utente non esiste setta Valido a falso;
		      if (!more) 
		      {
		         System.out.println("Sorry, you are not a registered user! Please sign up first");
		         utente.setValido(false);
		      } 
			        
		      //se l'utente esiste setta Valido a true;
		      else if (more) 
		      {
		    	 int code = rs.getInt("id_utenti");
		         String nome = rs.getString("nome");
		         String cognome = rs.getString("cognome");
		         String email = rs.getString("email");
		         String ruolo = rs.getString("ruolo");
			     	
		         System.out.println("Welcome " + nome +" "+cognome);
		         utente.setId_utenti(code);
		         utente.setNome(nome);
		         utente.setCognome(cognome);
		         
		         utente.setEmail(email);
		         utente.setRuolo(ruolo);
		         utente.setValido(true);
		      }
		   } 

		   catch (Exception ex) 
		   {
		      System.out.println("Log In failed: An Exception has occurred! " + ex);
		   } 
		   finally 
		   {
		      if (rs != null)	{
		         try {
		            rs.close();
		         } catch (Exception e) {}
		            rs = null;
		         }
			
		      if (stmt != null) {
		         try {
		            stmt.close();
		         } catch (Exception e) {}
		            stmt = null;
		         }
			
		      if (currentCon != null) {
		         try {
		            currentCon.close();
		         } catch (Exception e) {
		         }

		         currentCon = null;
		      }
		   }

		return utente;
	}
}
