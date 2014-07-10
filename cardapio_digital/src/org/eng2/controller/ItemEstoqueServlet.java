package org.eng2.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eng2.model.DBFacade;
import org.eng2.model.ItemEstoque;

/**
 * Servlet implementation class ItemEstoqueServlet
 */
@WebServlet({ "/novo_itemEstoque", "/edita_itemEstoque", "/criar_itemEstoque", "/atualiza_itemEstoque" })
public class ItemEstoqueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemEstoqueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();

		if (action.equals("/novo_itemEstoque")) {
			novoItemEstoque(request, response);
		} else if (action.equals("/edita_itemEstoque")) {
			editaItemEstoque(request, response);
		}

	}
	
	private void novoItemEstoque(HttpServletRequest request,
			HttpServletResponse response) {
		
		RequestDispatcher rd = request.getRequestDispatcher("/novo_itemEstoque.jsp");
		
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
	
	private void editaItemEstoque(HttpServletRequest request,
			HttpServletResponse response) {
		
		ItemEstoque itemEstoque = DBFacade.getInstance().
			getOneItemEstoque(Integer.parseInt(request.getParameter("id")));
		
		RequestDispatcher rd = null;
		if (itemEstoque != null) {
			rd = request.getRequestDispatcher("edita_itemEstoque.jsp");
			request.setAttribute("itemEstoque", itemEstoque);
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

		if (action.equals("/criar_itemEstoque")) {
			criarItemEstoque(request, response);
		} else if (action.equals("/atualiza_itemEstoque")) {
			atualizaItemEstoque(request, response);
		}
	}
	
	private void criarItemEstoque(HttpServletRequest request, HttpServletResponse response) {
		
		ItemEstoque itemEstoque = new ItemEstoque();
		itemEstoque.setId(Integer.valueOf(request.getParameter("id")));
		itemEstoque.setItem_id(Integer.valueOf(request.getParameter("item_id")));
		
		RequestDispatcher rd = request.getRequestDispatcher("mensagem.jsp");
		
		if (DBFacade.getInstance().insertItemEstoque(itemEstoque)) {
			request.setAttribute("mensagem", "Item adicionado com sucesso no estoque!");
		} else {
			request.setAttribute("mensagem", "Erro ao adicionar item no estoque!");
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
	
	private void atualizaItemEstoque(HttpServletRequest request, HttpServletResponse response) {
		
		ItemEstoque itemEstoque = DBFacade.getInstance().
				getOneItemEstoque(Integer.parseInt(request.getParameter("id")));
		
		itemEstoque.setId(Integer.valueOf(request.getParameter("id")));
		itemEstoque.setItem_id(Integer.valueOf(request.getParameter("item_id")));
		
		RequestDispatcher rd = request.getRequestDispatcher("mensagem.jsp");
		
		if (DBFacade.getInstance().updateItemEstoque(itemEstoque)) {
			request.setAttribute("mensagem", "Item do estoque atualizado ncom sucesso!");
		} else {
			request.setAttribute("mensagem", "Erro ao atualizar item do estoque!");
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
