package org.eng2.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemEstoqueDAO {

	protected boolean insert(ItemEstoque itemEstoque) {
		try {
			PreparedStatement ps = DataBase.getConnectionDB().
					prepareStatement("insert into item_estoque(id, item_id) values(?, ?)");
			
			ps.setInt(1, itemEstoque.getId());
			ps.setInt(2, itemEstoque.getItem_id());
			
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
	
	protected boolean update(ItemEstoque itemEstoque) {
		PreparedStatement ps;
		try {
			ps = DataBase.getConnectionDB().
					prepareStatement("update item_estoque set id=?, item_id=? where id=?");
			
			ps.setInt(1, itemEstoque.getId());
			ps.setInt(2, itemEstoque.getItem_id());
			ps.setInt(3, itemEstoque.getId());
		
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
	
	protected ItemEstoque getOne(int id) throws SQLException {
		PreparedStatement ps;
		ItemEstoque ie = null;
		
		try {
			ps = DataBase.getConnectionDB().
					prepareStatement("select * from item_estoque where id=?");
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				ie = new ItemEstoque();
				
				ie.setId(id);
				ie.setItem_id(rs.getInt("item_id"));
			}
		} catch (Exception e) {}
		
		return ie;
	}
}
