package org.eng2.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriaDAO {

	protected boolean insert(Categoria categoria) {
		try {
			PreparedStatement ps = DataBase.getConnectionDB().
					prepareStatement("insert into categoria(descricao) values(?)");
			
			ps.setString(1, categoria.getDescricao());
			
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
	
	protected boolean update(Categoria categoria) {
		PreparedStatement ps;
		try {
			ps = DataBase.getConnectionDB().
					prepareStatement("update categoria set descricao=? where id=?");
			
			ps.setString(1, categoria.getDescricao());
			ps.setInt(2, categoria.getId());
		
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
	
	protected Categoria getOne(int id) throws SQLException {
		PreparedStatement ps;
		Categoria c = null;
		
		try {
			ps = DataBase.getConnectionDB().
					prepareStatement("select * from categoria where id=?");
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				c = new Categoria();
				
				c.setId(id);
				c.setDescricao(rs.getString("descricao"));
			}
		} catch (Exception e) {}
		
		return c;
	}
	
	protected ArrayList<Categoria> getAll() throws SQLException {
		PreparedStatement ps;
		Categoria c = null;
		
		ArrayList<Categoria> categorias = null;
		
		try {
			ps = DataBase.getConnectionDB().
					prepareStatement("select * from categoria");
						
			ResultSet rs = ps.executeQuery();
			categorias = new ArrayList<Categoria>();
			
			while (rs.next()) {
				c = new Categoria();
				
				c.setId(rs.getInt(1));
				c.setDescricao(rs.getString(2));
				categorias.add(c);
			}
		} catch (Exception e) {}
		
		return categorias;
	}
	
	protected int delete(int id) {
		PreparedStatement ps;
		int count = 0;
		
		try {
			ps = DataBase.getConnectionDB().prepareStatement("delete from categoria where id=?");
			
			ps.setInt(1, id);
			count = ps.executeUpdate();
			
		} catch (Exception e) { }
		
		return count;
		
	}
	
}
