package org.eng2.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eng2.model.DBFacade;
import org.eng2.model.Item;

/**
 * Servlet implementation class Item
 */
@WebServlet({ "/novo_item", "/edita_exclui_item", "/criar_item", "/atualiza_item", "/escolhe_edita_exclui_item" })
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
		} else if (action.equals("/escolhe_edita_exclui_item")) {
			escolheEditaExcluiItem(request, response);
		}

	}
	
	private void novoItem(HttpServletRequest request,
			HttpServletResponse response) {
		
		RequestDispatcher rd = request.getRequestDispatcher("/novo_item.jsp");
		request.setAttribute("categorias", DBFacade.getInstance().getAllCategoria());
		
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
	
	private void escolheEditaExcluiItem(HttpServletRequest request,
			HttpServletResponse response) {
		
		request.setAttribute("items", DBFacade.getInstance().getAllItem());
		RequestDispatcher rd = request.getRequestDispatcher("/escolhe_edita_exclui_item.jsp");
		try {
			rd.forward(request, response);
			
		} catch (ServletException e) {
			
		} catch (IOException e) { }
		
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
		}else if(action.equals("/edita_exclui_item")){
			editaExcluiItem(request, response);
		}
	}
	

	private void editaExcluiItem(HttpServletRequest request,
			HttpServletResponse response) {
		
		Item item = DBFacade.getInstance().
			getOneItem(Integer.parseInt(request.getParameter("item").split("-")[1].trim()));
		
		RequestDispatcher rd = null;
		if (item != null){
			
			if(request.getParameter("button").equals("Editar")){
				
				rd = request.getRequestDispatcher("edita_item.jsp");
				request.setAttribute("item", item);
				request.setAttribute("categorias", DBFacade.getInstance().getAllCategoria());
				request.setAttribute("cat_selecionada", DBFacade.getInstance()
					.getOneCategoria(item.getCategoria_id()));
				
			}else{ //excluir
				
				rd = request.getRequestDispatcher("mensagem.jsp");

				if(DBFacade.getInstance().deleteItem(item.getId()) > 0){
					request.setAttribute("mensagem", "Item excluído com sucesso!");
				}else{
					request.setAttribute("mensagem", "Item não excluído!");
				}
				
			}
			
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

	
	private void criarItem(HttpServletRequest request, HttpServletResponse response) {
		
		Item item = new Item();
		item.setTitulo(request.getParameter("titulo"));
		item.setDescricao(request.getParameter("descricao"));
		
		item.setCategoria_id((int)Integer.valueOf(request.getParameter("categoria").split("-")[1].trim()));
		item.setImagem("imagem");
		System.out.println(Float.valueOf(request.getParameter("preco"))
				.floatValue());
		item.setPreco(Float.valueOf(request.getParameter("preco"))
				.floatValue());		
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
		
		System.out.println(request.getParameter("id"));
		Item item = DBFacade.getInstance().
				getOneItem(Integer.parseInt(request.getParameter("id")));
		
		item.setTitulo(request.getParameter("titulo"));
		item.setDescricao(request.getParameter("descricao"));
		item.setCategoria_id(Integer.valueOf(request.getParameter("categoria")
			.split("-")[1].trim()));
		item.setImagem("imagem");
		item.setPreco(Float.valueOf(request.getParameter("preco")).floatValue());
		
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
