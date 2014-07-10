package org.eng2.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MesaDAO {

	protected boolean insert(Mesa m) {
		PreparedStatement ps;
		try {
			ps = DataBase.getConnectionDB().
					prepareStatement("insert into mesa(num) values(?)");			
			ps.setString(1, m.getNum());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	protected Mesa getOne(int id) {
		PreparedStatement ps;
		try {
			ps = DataBase.getConnectionDB().
					prepareStatement("select * from mesa where id=?");			
			ps.setInt(1, id);
			
			Mesa m = null;
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				m = new Mesa();
				
				m.setId(rs.getInt("id"));
				m.setNum(rs.getString("num"));
			}	
			return m;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	protected boolean update(Mesa m) {
		PreparedStatement ps;
		try {
			ps = DataBase.getConnectionDB().
					prepareStatement("update mesa set num=? where id=?");			
			ps.setString(1, m.getNum());
			ps.setInt(2, m.getId());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	protected boolean delete(int id) {
		PreparedStatement ps;
		try {
			ps = DataBase.getConnectionDB().
					prepareStatement("delete from mesa where id=?");			
			ps.setInt(1, id);
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	protected ArrayList<Mesa> getAll() {
		ArrayList<Mesa> list = new ArrayList<Mesa>();
		
		PreparedStatement ps;
		try {
			ps = DataBase.getConnectionDB().
					prepareStatement("select * from mesa");						
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Mesa m = new Mesa();
				
				m.setId(rs.getInt("id"));
				m.setNum(rs.getString("num"));
				
				list.add(m);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
}
