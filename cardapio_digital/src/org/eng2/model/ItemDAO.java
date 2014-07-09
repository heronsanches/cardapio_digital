package org.eng2.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemDAO {
	
	protected boolean insert(Item item) {
		try {
			PreparedStatement ps = DataBase.getConnectionDB().
				prepareStatement("insert into item(titulo, descricao, preco, imagem, cardapio_id)"
						+ " values(?, ?, ?, ?, ?)");
			
			ps.setString(1, item.getTitulo());
			ps.setString(2, item.getDescricao());
			ps.setFloat(3, item.getPreco());
			ps.setString(4, item.getImagem());
			ps.setInt(5, item.getCardapio_id());
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
				prepareStatement("update item set titulo=?, descricao=?, preco=?, imagem=?, cardapio_id=?"
					+ " where id=?");
			
			ps.setString(1, item.getTitulo());
			ps.setString(2, item.getDescricao());
			ps.setFloat(3, item.getPreco());
			ps.setString(4, item.getImagem());
			ps.setInt(5, item.getCardapio_id());
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
				i.setCardapio_id(rs.getInt("cardapio_id"));
			}
		} catch (Exception e) {}
		
		return i;
	}

}
