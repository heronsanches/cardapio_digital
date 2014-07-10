package org.eng2.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TokenDAO {

	protected boolean insert(Token token) {
		PreparedStatement ps = null;
		
		try {
			ps = DataBase.getConnectionDB().
					prepareStatement("insert into token(cod, mesa_id) values(?, ?)");
			
			ps.setString(1, token.getCod());
			ps.setInt(2, token.getMesaId());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	protected boolean delete(String cod) {	
		PreparedStatement ps = null;
		
		try {
			ps = DataBase.getConnectionDB().
					prepareStatement("delete from token where cod=?");
			
			ps.setString(1, cod);
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
