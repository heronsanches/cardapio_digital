package org.eng2.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eng2.model.Categoria;
import org.eng2.model.DBFacade;

/**
 * Servlet implementation class CategoriaServlet
 */
@WebServlet({ "/nova_categoria", "/edita_exclui_categoria", "/criar_categoria", "/atualiza_categoria",
	"/escolhe_edita_exclui_categoria"})
public class CategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategoriaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();

		if (action.equals("/nova_categoria")) {
			novaCategoria(request, response);
		} else if (action.equals("/escolhe_edita_exclui_categoria")) {
			escolheEditaExcluiCategoria(request, response);
		}

	}
	
	private void novaCategoria(HttpServletRequest request, HttpServletResponse response) {
		
		RequestDispatcher rd = request.getRequestDispatcher("nova_categoria.jsp");
		
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
	
	private void escolheEditaExcluiCategoria(HttpServletRequest request,
			HttpServletResponse response) {
		
		request.setAttribute("categorias", DBFacade.getInstance().getAllCategoria());
		RequestDispatcher rd = request.getRequestDispatcher("/escolhe_edita_exclui_categoria.jsp");
		try {
			rd.forward(request, response);
			
		} catch (ServletException e) {
			
		} catch (IOException e) { }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

		if (action.equals("/criar_categoria")) {
			criarCetegoria(request, response);
		} else if (action.equals("/edita_exclui_categoria")) {
			editaExcluiCategoria(request, response);
		} else if(action.equals("/atualiza_categoria")){
			atualizaCategoria(request, response);
		}
	}
	
	private void editaExcluiCategoria(HttpServletRequest request,
			HttpServletResponse response) {
		
		Categoria categoria = DBFacade.getInstance().
			getOneCategoria(Integer.parseInt(request.getParameter("categoria").split("-")[1].trim()));
		
		RequestDispatcher rd = null;
		if (categoria != null){
			
			if(request.getParameter("button").equals("Editar")){
				
				rd = request.getRequestDispatcher("edita_categoria.jsp");
				request.setAttribute("categoria", categoria);
				
			}else{ //excluir
				
				rd = request.getRequestDispatcher("mensagem.jsp");

				if(DBFacade.getInstance().deleteCategoria(categoria.getId()) > 0){
					request.setAttribute("mensagem", "Categoria excluída com sucesso!");
				}else{
					request.setAttribute("mensagem", "Categoria não excluída!");
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

	private void criarCetegoria(HttpServletRequest request,
			HttpServletResponse response) {
		Categoria categoria = new Categoria();
		categoria.setDescricao(request.getParameter("description"));
		
		RequestDispatcher rd = request
				.getRequestDispatcher("mensagem.jsp");
		if (DBFacade.getInstance().insertCategoria(categoria)) {
			request.setAttribute("mensagem", "Categoria criada com sucesso!");
		} else {
			request.setAttribute("mensagem", "Erro ao criar categoria!");
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


	
	private void atualizaCategoria(HttpServletRequest request,
			HttpServletResponse response) {
		
		Categoria cat = new Categoria();
		cat.setId(Integer.parseInt(request.getParameter("id")));
		cat.setDescricao(request.getParameter("descricao"));
		
		RequestDispatcher rd = request
				.getRequestDispatcher("mensagem.jsp");
		if (DBFacade.getInstance().updateCategoria(cat)) {
			request.setAttribute("mensagem", "Categoria atualizada com sucesso!");
		} else {
			request.setAttribute("mensagem", "Erro ao atualizar categoria!");
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
