package org.eng2.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eng2.model.Cardapio;
import org.eng2.model.DBFacade;
import org.eng2.model.Item;

/**
 * Servlet implementation class Item
 */
@WebServlet({ "/novo_item", "/edita_item", "/criar_item", "/atualiza_item" })
public class ItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();

		if (action.equals("/novo_item")) {
			novoItem(request, response);
		} else if (action.equals("/edita_item")) {
			editaItem(request, response);
		}

	}
	
	private void novoItem(HttpServletRequest request,
			HttpServletResponse response) {
		
		RequestDispatcher rd = request.getRequestDispatcher("/novo_item.jsp");
		
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void editaItem(HttpServletRequest request,
			HttpServletResponse response) {
		
		Item item = DBFacade.getInstance().
			getOneItem(Integer.parseInt(request.getParameter("id")));
		
		RequestDispatcher rd = null;
		if (item != null) {
			rd = request.getRequestDispatcher("edita_item.jsp");
			request.setAttribute("item", item);
		} else {
			rd = request.getRequestDispatcher("mensagem.jsp");
		}
		
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();

		if (action.equals("/criar_item")) {
			criarItem(request, response);
		} else if (action.equals("/atualiza_item")) {
			atualizaItem(request, response);
		}
	}
	
	private void criarItem(HttpServletRequest request, HttpServletResponse response) {
		
		Item item = new Item();
		item.setTitulo(request.getParameter("titulo"));
		item.setDescricao(request.getParameter("descricao"));
		item.setCardapio_id(Integer.valueOf(request.getParameter("cardapio_id")));
		item.setImagem("imagem");
		item.setPreco(Float.valueOf("preco"));
		
		RequestDispatcher rd = request.getRequestDispatcher("mensagem.jsp");
		
		if (DBFacade.getInstance().insertItem(item)) {
			request.setAttribute("mensagem", "Item criado com sucesso!");
		} else {
			request.setAttribute("mensagem", "Erro ao criar item!");
		}
		
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void atualizaItem(HttpServletRequest request, HttpServletResponse response) {
		
		Item item = DBFacade.getInstance().
				getOneItem(Integer.parseInt(request.getParameter("id")));
		
		item.setTitulo(request.getParameter("titulo"));
		item.setDescricao(request.getParameter("descricao"));
		item.setCardapio_id(Integer.valueOf(request.getParameter("cardapio_id")));
		item.setImagem("imagem");
		item.setPreco(Float.valueOf("preco"));
		
		RequestDispatcher rd = request.getRequestDispatcher("mensagem.jsp");
		
		if (DBFacade.getInstance().updateItem(item)) {
			request.setAttribute("mensagem", "Item atualizado com sucesso!");
		} else {
			request.setAttribute("mensagem", "Erro ao atualizar item!");
		}
		
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
