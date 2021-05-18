package model.pastryshop;

import java.sql.Connection;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class OrdineDAO {
	static Connection currentCon = null;
	   static ResultSet rs = null;  
	   private static DataSource ds;
	   static {
			try {
				Context initCtx = new InitialContext();
				Context envCtx = (Context) initCtx.lookup("java:comp/env");

				ds = (DataSource) envCtx.lookup("jdbc/inventario");

			} catch (NamingException e) {
				System.out.println("Error:" + e.getMessage());
			}
		}
	   private static final String TABLE_NAME_ORDINI= "ordini";
	   static Date data = new Date();
	   public synchronized static void doSave2(Cart carrello) throws SQLException {
	         Connection connection = null;
	         PreparedStatement preparedStatement = null;
	         String insertSQL = "INSERT INTO " + OrdineDAO.TABLE_NAME_ORDINI
	                 + "(totale, data)"
	                 + " VALUES (?,?)";
	         try {
	        	 java.sql.Date DataOrdine = new java.sql.Date(data.getTime());
	             connection = ds.getConnection();
	             preparedStatement = connection.prepareStatement(insertSQL);
	             
	             preparedStatement.setInt(1, carrello.getTotal());
	             preparedStatement.setDate(2,DataOrdine);
	             preparedStatement.executeUpdate(); 
	            
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
	   public static Collection<OrdiniBean> doRetrieveAll2() throws SQLException {
			Connection connection = null;
			PreparedStatement preparedStatement = null;

			Collection<OrdiniBean> products = new LinkedList<OrdiniBean>();

			String selectSQL = "SELECT * FROM " + OrdineDAO.TABLE_NAME_ORDINI;


			try {
				connection = ds.getConnection();
				preparedStatement = connection.prepareStatement(selectSQL);

				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {
					OrdiniBean bean = new OrdiniBean();

					bean.setCode(rs.getInt("code"));
					bean.setTotale(rs.getInt("totale"));
					bean.setData_ordine(rs.getDate("data"));
					products.add(bean);
				}

			} finally {
				try {
					if (preparedStatement != null)
						preparedStatement.close();
				} finally {
					if (connection != null)
						connection.close();
				}
			}
			return products;
		}
	   
}
