package pastryshop.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import pastryshop.model.ProdottoBean;

public class ProdottoDao {
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
	private static final String TABLE_NAME_PRODOTTI= "prodotti";
	
	// salva il prodotto nel db (input il prodotto) 
	public void doSave_prodotto(ProdottoBean prodotto) throws SQLException, IOException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		InputStream fis = null;
		
		String insertSQL = "INSERT INTO " + TABLE_NAME_PRODOTTI
				+ " (nome_prodotto, descrizione_prodotto, quantita_disponibile_prodotto, prezzo_prodotto, categoria,foto) "
				+ " VALUES (?, ?, ?, ?, ?, ?)"; 
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, prodotto.getNome_prodotto());
			preparedStatement.setString(2, prodotto.getDescrizione_prodotto());
			preparedStatement.setInt(3, prodotto.getQuantita_disponibile_prodotto());
			preparedStatement.setInt(4, prodotto.getPrezzo_prodotto());
			preparedStatement.setString(5, prodotto.getCategoria());
			fis = prodotto.getFoto().getInputStream();
			preparedStatement.setBlob(6, fis);
			preparedStatement.executeUpdate();

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
	}
	//cancella prodotto per codice
	public boolean doDelete_prodotto(int code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		int result = 0;
		
		String deleteSQL = "DELETE FROM " + TABLE_NAME_PRODOTTI + " WHERE ID_PRODOTTI = ?";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, code);

			result = preparedStatement.executeUpdate();

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return (result != 0);
	}
	//prendi prodotto per il codice
	public ProdottoBean doRetrieve_prodotto_ByKey(int code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		ProdottoBean prodotto = new ProdottoBean();
		
		String selectSQL = "SELECT * FROM " + TABLE_NAME_PRODOTTI + " WHERE id_prodotti = ?";
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, code);

			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				prodotto.setId_prodotto(rs.getInt("id_prodotti"));
				prodotto.setNome_prodotto(rs.getString("nome_prodotto"));
				prodotto.setDescrizione_prodotto(rs.getString("descrizione_prodotto"));
				prodotto.setQuantita_disponibile_prodotto(rs.getInt("quantita_disponibile_prodotto"));
				prodotto.setPrezzo_prodotto(rs.getInt("prezzo_prodotto"));
				
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
		return prodotto;
	}
	
	//prendi tutti i prodotti con un ordine
	public Collection<ProdottoBean> doRetrieveAll(String order) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		Collection<ProdottoBean> prodotti = new LinkedList<ProdottoBean>();
		String selectSQL = "SELECT * FROM " + TABLE_NAME_PRODOTTI;
		
		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				ProdottoBean prodotto = new ProdottoBean();

				prodotto.setId_prodotto(rs.getInt("id_prodotti"));
				prodotto.setNome_prodotto(rs.getString("nome_prodotto"));
				prodotto.setDescrizione_prodotto(rs.getString("descrizione_prodotto"));
				prodotto.setQuantita_disponibile_prodotto(rs.getInt("quantita_disponibile_prodotto"));
				prodotto.setPrezzo_prodotto(rs.getInt("prezzo_prodotto"));
				prodotto.setCategoria(rs.getString("categoria"));
				prodotti.add(prodotto);
				
			
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
		return prodotti;
	}
	//aggiorna singolo prodotto per id
	public void Update_sigle_prod(ProdottoBean prod)throws SQLException{
		Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql="UPDATE "+ TABLE_NAME_PRODOTTI + " SET quantita_disponibile_prodotto = ?, prezzo_prodotto = ? where id_prodotti =?";
        try {

            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, prod.getQuantita_disponibile_prodotto());
            preparedStatement.setInt(2, prod.getPrezzo_prodotto());
            preparedStatement.setInt(3, prod.getId_prodotto());
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
	//prendi prodotti per categoria
	public  Collection<ProdottoBean> doRetrieveCategory(String category)throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		Collection<ProdottoBean> prodotti = new LinkedList<ProdottoBean>();
		String selectSQL = "SELECT * FROM " + TABLE_NAME_PRODOTTI + " where categoria = ?";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			
			preparedStatement.setString(1, category);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				ProdottoBean prodotto = new ProdottoBean();

				prodotto.setId_prodotto(rs.getInt("id_prodotti"));
				prodotto.setNome_prodotto(rs.getString("nome_prodotto"));
				prodotto.setDescrizione_prodotto(rs.getString("descrizione_prodotto"));
				prodotto.setQuantita_disponibile_prodotto(rs.getInt("quantita_disponibile_prodotto"));
				prodotto.setPrezzo_prodotto(rs.getInt("prezzo_prodotto"));
				prodotto.setCategoria(rs.getString("categoria"));
				
				prodotti.add(prodotto);
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
		return prodotti;
	}
	//scala quantità prodotto dopo l'acquisto
	public void Update_prod_after_buy(ProdottoBean prodotto) throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql= "UPDATE " + TABLE_NAME_PRODOTTI + " SET quantita_disponibile_prodotto = quantita_disponibile_prodotto - ? WHERE id_prodotti=?";

            try {

                connection = ds.getConnection();
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, prodotto.getQq());
                preparedStatement.setInt(2, prodotto.getId_prodotto());
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
}
