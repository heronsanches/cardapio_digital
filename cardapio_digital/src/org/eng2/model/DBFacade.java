package org.eng2.model;

import java.sql.SQLException;

public class DBFacade {

	private static DBFacade facade;
	
	private CategoriaDAO categoriaDAO;
	private ItemDAO itemDAO;
	private ItemEstoqueDAO itemEstoqueDAO;
	private CardapioDAO cardapioDAO;
	
	private DBFacade() {
		categoriaDAO = new CategoriaDAO();
		itemDAO = new ItemDAO();
		itemEstoqueDAO = new ItemEstoqueDAO();
		
	}
	
	public static DBFacade getInstance() {
		if (facade == null) {
			facade = new DBFacade();
		}
		
		return facade;
	}
	
	//*********************interface para categoria*********************//
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
	
	
	//*********************interface para item*********************//
	public Item getOneItem(int id) {
		try {
			return itemDAO.getOne(id);
		} catch (SQLException e) {
			return null;
		}
	}

	public boolean insertItem(Item item) {
		return itemDAO.insert(item);
	}
	
	public boolean updateItem(Item item) {
		return itemDAO.update(item);
	}
	
	
	//*********************interface para item_estoque*********************//
	public ItemEstoque getOneItemEstoque(int id) {
		try {
			return itemEstoqueDAO.getOne(id);
		} catch (SQLException e) {
			return null;
		}
	}

	public boolean insertItemEstoque(ItemEstoque itemEstoque) {
		return itemEstoqueDAO.insert(itemEstoque);
	}
	
	public boolean updateItemEstoque(ItemEstoque itemEstoque) {
		return itemEstoqueDAO.update(itemEstoque);
	}
	
	
	//*********************interface para cardapio*********************//
	public Cardapio getOneCardapio(int id) {
		try {
			return cardapioDAO.getOne(id);
		} catch (SQLException e) {
			return null;
		}
	}

	public boolean insertCardapio(Cardapio cardapio) {
		return cardapioDAO.insert(cardapio);
	}
	
	public boolean updateCardapio(Cardapio cardapio) {
		return cardapioDAO.update(cardapio);
	}
	
	
}
