package pastryshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import pastryshop.model.UtenteBean;

public class RegistrazioneDao {
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
	
	
	public synchronized static void Save_Utenti(UtenteBean user1) throws SQLException {
		Connection connection = null;
        PreparedStatement preparedStatement = null;
        String InsertSql = "INSERT INTO " + TABLE_NAME_UTENTI 
        		+	"(nome, cognome, username, password, email, ruolo)"
        		+   " VALUES (?,?,?,?,?,?)";
        try {
        	connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(InsertSql);
            preparedStatement.setString(1, user1.getNome());
            preparedStatement.setString(2, user1.getCognome());
            preparedStatement.setString(3, user1.getUsername());
            preparedStatement.setString(4, user1.getPassword());
            preparedStatement.setString(5, user1.getEmail());
            preparedStatement.setString(6, "utente");
            
            int m=preparedStatement.executeUpdate();
            
            if(m==0) {
           	 System.out.println("Utente gi√  registrato.");
           	 user1.setValido(false);	 
           	 }
            else {
           	 user1.setValido(true);
           	 }
            
        }finally {
       	 try {
    		 if (preparedStatement != null)
    			 preparedStatement.close();
		} finally {
			if (connection != null)
				connection.close();
			}
     }
	}
}
