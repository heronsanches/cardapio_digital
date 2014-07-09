package org.eng2.model;

import java.sql.SQLException;

public class DBFacade {

	private static DBFacade facade;
	private CategoriaDAO categoriaDAO;
	
	
	private DBFacade() {
		categoriaDAO = new CategoriaDAO();
	}
	
	public static DBFacade getInstance() {
		if (facade == null) {
			facade = new DBFacade();
		}
		
		return facade;
	}
	
	public Categoria getOneCategoria(int id) {
		try {
			return categoriaDAO.getOne(id);
		} catch (SQLException e) {
			return null;
		}
	}

	public boolean insertCategoria(Categoria categoria) {
		return categoriaDAO.insert(categoria);
	}
	
	public boolean updateCategoria(Categoria categoria) {
		return categoriaDAO.update(categoria);
	}
	
}
