package org.eng2.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAO {
	
	protected boolean insert(Item item) {
		try {
			PreparedStatement ps = DataBase.getConnectionDB().
				prepareStatement("insert into item(titulo, descricao, preco, imagem, categoria_id)"
						+ " values(?, ?, ?, ?, ?)");
			
			ps.setString(1, item.getTitulo());
			ps.setString(2, item.getDescricao());
			ps.setFloat(3, item.getPreco());
			ps.setString(4, item.getImagem());
			ps.setInt(5, item.getCategoria_id());
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
	
	protected boolean update(Item item) {
		PreparedStatement ps;
		try {
			ps = DataBase.getConnectionDB().
				prepareStatement("update item set titulo=?, descricao=?, preco=?, imagem=?, categoria_id=?"
					+ " where id=?");
			
			ps.setString(1, item.getTitulo());
			ps.setString(2, item.getDescricao());
			ps.setFloat(3, item.getPreco());
			ps.setString(4, item.getImagem());
			ps.setInt(5, item.getCategoria_id());
			ps.setInt(6, item.getId());
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
	
	protected Item getOne(int id) throws SQLException {
		PreparedStatement ps;
		Item i = null;
		
		try {
			ps = DataBase.getConnectionDB().
					prepareStatement("select * from item where id=?");
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				i = new Item();
				
				i.setId(id);
				i.setTitulo(rs.getString("titulo"));
				i.setDescricao(rs.getString("descricao"));
				i.setPreco(rs.getFloat("preco"));
				i.setImagem(rs.getString("imagem"));
				i.setCategoria_id(rs.getInt("categoria_id"));
			}
		} catch (Exception e) {}
		
		return i;
	}
	
	protected ArrayList<Item> getAll() throws SQLException {
		PreparedStatement ps;
		Item i = null;
		ArrayList<Item> items = null;
		
		try {
			ps = DataBase.getConnectionDB().
					prepareStatement("select * from item");
						
			ResultSet rs = ps.executeQuery();
			items = new ArrayList<Item>();
			
			while (rs.next()) {
				i = new Item();
				
				i.setId(rs.getInt(1));
				i.setTitulo(rs.getString(2));
				i.setDescricao(rs.getString(3));
				i.setPreco(rs.getFloat(4));
				i.setImagem(rs.getString(5));
				i.setCategoria_id(rs.getInt(6));
				items.add(i);
			}
		} catch (Exception e) {}
		
		return items;
	}
	
	protected int delete(int id) {
		PreparedStatement ps;
		int count = 0;
		
		try {
			ps = DataBase.getConnectionDB().prepareStatement("delete from item where id=?");
			
			ps.setInt(1, id);
			count = ps.executeUpdate();
			
		} catch (Exception e) { }
		
		return count;
		
	}

}
