package org.eng2.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CardapioDAO {
	
	protected boolean insert(Cardapio cardapio) {
		try {
			PreparedStatement ps = DataBase.getConnectionDB().
					prepareStatement("insert into cardapio(descricao) values(?)");
			
			ps.setString(1, cardapio.getDescricao());
			
			ps.execute();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	protected boolean update(Cardapio cardapio) {
		PreparedStatement ps;
		try {
			ps = DataBase.getConnectionDB().
					prepareStatement("update categoria set descricao=? where id=?");
			
			ps.setString(1, cardapio.getDescricao());
			ps.setInt(2, cardapio.getId());
		
			ps.execute();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	protected Cardapio getOne(int id) throws SQLException {
		PreparedStatement ps;
		Cardapio c = null;
		
		try {
			ps = DataBase.getConnectionDB().
					prepareStatement("select * from cardapio where id=?");
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				c = new Cardapio();
				
				c.setId(id);
				c.setDescricao(rs.getString("descricao"));
			}
		} catch (Exception e) {}
		
		return c;
	}

}
