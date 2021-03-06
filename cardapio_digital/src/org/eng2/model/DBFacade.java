package org.eng2.model;

import java.sql.SQLException;
import java.util.ArrayList;

public class DBFacade {

	private static DBFacade facade;
	
	private CategoriaDAO categoriaDAO;
	private ItemDAO itemDAO;
	private ItemEstoqueDAO itemEstoqueDAO;
	private MesaDAO mesaDAO;
	private TokenDAO tokenDAO;
	
	private DBFacade() {
		categoriaDAO = new CategoriaDAO();
		itemDAO = new ItemDAO();
		itemEstoqueDAO = new ItemEstoqueDAO();
		mesaDAO = new MesaDAO();
		tokenDAO = new TokenDAO();
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
	
	public ArrayList<Categoria> getAllCategoria(){
		try {
			return categoriaDAO.getAll();
		} catch (SQLException e) {
			return null;
		}
	}
	
	public int deleteCategoria(int id){
		return categoriaDAO.delete(id);
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
	
	public ArrayList<Item> getAllItem(){
		try {
			return itemDAO.getAll();
		} catch (SQLException e) {
			return null;
		}
	}
	
	public int deleteItem(int id){
		return itemDAO.delete(id);
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
	
	// *********************interface para mesa*********************//
	public Mesa getOneMesa(int id) {
		return mesaDAO.getOne(id);		
	}

	public boolean insertMesa(Mesa mesa) {
		return mesaDAO.insert(mesa);
	}

	public boolean updateMesa(Mesa mesa) {
		return mesaDAO.update(mesa);
	}
	
	public int deleteMesa(int id) {
		return mesaDAO.delete(id);
	}
	
	public ArrayList<Mesa> getAllMesa() {
		return mesaDAO.getAll();
	}
	
	// *********************interface para token*********************//
	public boolean insertToken(Token token) {
		return tokenDAO.insert(token);
	}
	
	public boolean deleteToken(String cod) {
		return tokenDAO.delete(cod);
	}
	
	public ArrayList<Token> getAllToken() {
		return tokenDAO.getAll();
	}
	
	
}
