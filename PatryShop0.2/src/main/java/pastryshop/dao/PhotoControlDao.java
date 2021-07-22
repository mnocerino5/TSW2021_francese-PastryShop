package pastryshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class PhotoControlDao {
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
	
	public synchronized static byte[] load (String id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		byte[] bt = null;
		
		String selectSQL = "SELECT foto FROM " + TABLE_NAME_PRODOTTI + " where id_prodotti= ?";
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, id);
			rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				bt = rs.getBytes("foto");
			}
			
		}catch (SQLException sqlException) {
			sqlException.printStackTrace();
			
		}finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return bt;
	}
}
