package org.eng2.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	protected ArrayList<Token> getAll() {
		ArrayList<Token> tokens = new ArrayList<Token>();
		
		PreparedStatement ps = null;
		
		try {
			ps = DataBase.getConnectionDB().
					prepareStatement("select * from token");
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Token token = new Token();
				
				token.setCod(rs.getString("cod"));
				token.setMesaId(rs.getInt("mesa_id"));
				token.setAtivadoEm(rs.getDate("ativado_em"));
				
				tokens.add(token);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return tokens;
	}
	
}
