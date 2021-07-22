package pastryshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import pastryshop.model.CarrelloBean;
import pastryshop.model.OrdiniBean;
import pastryshop.model.OrdiniDettagliBean;
import pastryshop.model.ProdottoBean;
import pastryshop.model.UtenteBean;

public class OrdiniDao {
	private static DataSource ds;
	static {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/pastryshop_database");

		} catch (NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}
	private static final String TABLE_NAME_ORDINI= "ordini";
	private static final String TABLE_NAME_DETTAGLI_ORDINI= "dettagli_ordini";
	
	static Date data = new Date();
	

	static Date data2 = new GregorianCalendar(0,Calendar.JANUARY,1).getTime();
	
	public void doSave_ordini(CarrelloBean carrello,UtenteBean utente) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		String insertSQL = "INSERT INTO " + TABLE_NAME_ORDINI
				+ " (prezzo_ordini, quantita_ordini, stato_ordini, data_eff_ordini, data_conc_ordini, id_utenti) "
				+ " VALUES (?, ?, ?, ?, ?, ?)";
		
		try {
			java.sql.Date DataOrdine1 = new java.sql.Date(data.getTime());
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, carrello.getTotal());
			preparedStatement.setInt(2, carrello.getQuantita_carrello_prod_singoli());
			preparedStatement.setString(3, "In corso");
			preparedStatement.setDate(4, DataOrdine1);
			preparedStatement.setDate(5, null);
			preparedStatement.setInt(6, utente.getId_utenti());
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
	
	//metodi
	
	public static Collection<OrdiniBean> doRetrieveAll() throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<OrdiniBean> lista_ordini = new LinkedList<OrdiniBean>();
		
		String selectSQL = "SELECT * FROM " + TABLE_NAME_ORDINI;
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				OrdiniBean bean = new OrdiniBean();
				
				bean.setId_ordini(rs.getInt("id_ordini"));
				bean.setPrezzo_ordini(rs.getInt("prezzo_ordini"));
				bean.setQuantit_ordini(rs.getInt("quantita_ordini"));
				bean.setStato_ordini(rs.getString("stato_ordini"));
				bean.setData_eff_ordini(rs.getDate("data_eff_ordini"));
				bean.setData_conc_ordini(rs.getDate("data_conc_ordini"));
				bean.setId_utente(rs.getInt("id_utenti"));
				lista_ordini.add(bean);
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
		return lista_ordini;
	}
	
	//metodi
	public OrdiniBean doRetrieve_prodotto_ByID_prodotto(int code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		OrdiniBean ordine = new OrdiniBean();
		
		String selectSQL = "SELECT * FROM " + TABLE_NAME_ORDINI + " WHERE id_ordini = ?";
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, code);

			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				ordine.setId_ordini(rs.getInt("id_ordini"));
				ordine.setPrezzo_ordini(rs.getInt("prezzo_ordini"));
				ordine.setQuantit_ordini(rs.getInt("quantita_ordini"));
				ordine.setStato_ordini(rs.getString("stato_ordini"));
				ordine.setData_eff_ordini(rs.getDate("data_eff_ordini"));
				ordine.setData_conc_ordini(rs.getDate("data_conc_ordini"));
				ordine.setId_utente(rs.getInt("id_utenti"));
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
		return ordine;
	}
	
	public Collection<OrdiniBean> doRetrieve_ordine_by_idUser(int id_user) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		Collection<OrdiniBean> lista_ordini = new LinkedList<OrdiniBean>();
		
		String selectSQL = "SELECT * FROM " + TABLE_NAME_ORDINI + " WHERE id_utenti = ?";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id_user);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				OrdiniBean ordine = new OrdiniBean();
				ordine.setId_ordini(rs.getInt("id_ordini"));
				ordine.setPrezzo_ordini(rs.getInt("prezzo_ordini"));
				ordine.setQuantit_ordini(rs.getInt("quantita_ordini"));
				ordine.setStato_ordini(rs.getString("stato_ordini"));
				ordine.setData_eff_ordini(rs.getDate("data_eff_ordini"));
				ordine.setData_conc_ordini(rs.getDate("data_conc_ordini"));
				ordine.setId_utente(rs.getInt("id_utenti"));
				lista_ordini.add(ordine);
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
		return lista_ordini;
	}
	
	public void Update_sigle_order(OrdiniBean ordine)throws SQLException{
		Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql="UPDATE "+ TABLE_NAME_ORDINI + " SET stato_ordini = ?, data_conc_ordini = ? where id_ordini =?";
        try {
        	java.sql.Date DataOrdine1 = new java.sql.Date(data.getTime());
        	
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ordine.getStato_ordini());
            preparedStatement.setDate(2, DataOrdine1);
            preparedStatement.setInt(3, ordine.getId_ordini());
            preparedStatement.executeUpdate();
        }
        finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } finally {
                if (connection != null)
                    connection.close();
            }
        }
	}
	//prende ultimo id generato dalla tabella ordini
	public int Get_Id_order() throws SQLException{
		Connection connection = null;
        PreparedStatement preparedStatement = null;
        String selectSQL = "SELECT LAST_INSERT_ID() FROM " + TABLE_NAME_ORDINI;
        int n = 0;
        try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
        
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				n = rs.getInt(1);
			}
        }
        finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } finally {
                if (connection != null)
                    connection.close();
            }
        }
        return n;
	}
	//inserimento dettagli_ordini tramite id preso da sopra, e dagli attributi del carrello
	public void DoSave_details_order_from_id_order(CarrelloBean cart,int id_order)throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL = "INSERT INTO " + TABLE_NAME_DETTAGLI_ORDINI
				+ " (id_dettagli_ordini, nome_dett_ordini, descrizione_dett_ordini, quantit_dett_ordini, prezzo_tot_dett_ordini) "
				+ " VALUES (?, ?, ?, ?, ?)";
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			
			for(int i = 0; i<cart.getCarrello_prodotti().size(); i++) {
			preparedStatement.setInt(1, id_order);
			preparedStatement.setString(2, cart.getCarrello_prodotti().get(i).getNome_prodotto());
			preparedStatement.setString(3, cart.getCarrello_prodotti().get(i).getDescrizione_prodotto());
			preparedStatement.setInt(4, cart.getCarrello_prodotti().get(i).getQq());
			preparedStatement.setInt(5, cart.getCarrello_prodotti().get(i).getTot_price_qq());
			preparedStatement.executeUpdate();
			}
			
		}
		finally {
          	 try {
       		 if (preparedStatement != null)
       			 preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
				}
		}
	}
	//prendi tutti dettagli_ordini per id_ordini
	public Collection<OrdiniDettagliBean> doRetrieve_ordine_by_id_ordini(int id_ordine) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<OrdiniDettagliBean> lista_dett_ordini = new LinkedList<OrdiniDettagliBean>();
		
		String selectSQL = "SELECT * FROM " + TABLE_NAME_DETTAGLI_ORDINI + " WHERE id_dettagli_ordini = ?";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id_ordine);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				OrdiniDettagliBean bean = new OrdiniDettagliBean();
				
				bean.setId_ordini(rs.getInt("id_dettagli_ordini"));
				bean.setNome_dett_ordini(rs.getString("nome_dett_ordini"));
				bean.setDescri_dett_ordini(rs.getString("descrizione_dett_ordini"));
				bean.setQuantit_dett_ordini(rs.getInt("quantit_dett_ordini"));
				bean.setPrezzo_tot_dett_ordini(rs.getInt("prezzo_tot_dett_ordini"));
	
				lista_dett_ordini.add(bean);
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
	return lista_dett_ordini;
	}
}