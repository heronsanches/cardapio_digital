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

/**
 * Servlet implementation class CardapioServlet
 */
@WebServlet({ "/novo_cardapio", "/edita_cardapio", "/criar_cardapio", "/atualiza_cardapio" })
public class CardapioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CardapioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();

		if (action.equals("/novo_cardapio")) {
			novoCardapio(request, response);
		} else if (action.equals("/edita_cardapio")) {
			editaCardapio(request, response);
		}

	}
	
	private void novoCardapio(HttpServletRequest request,
			HttpServletResponse response) {
		
		RequestDispatcher rd = request.getRequestDispatcher("/novo_cardapio.jsp");
		
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
	
	private void editaCardapio(HttpServletRequest request,
			HttpServletResponse response) {
		
		Cardapio car = DBFacade.getInstance().
			getOneCardapio(Integer.parseInt(request.getParameter("id")));
		
		RequestDispatcher rd = null;
		if (car != null) {
			rd = request.getRequestDispatcher("edita_cardapio.jsp");
			request.setAttribute("cardapio", car);
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

		if (action.equals("/criar_cardapio")) {
			criarCardapio(request, response);
		} else if (action.equals("/atualiza_cardapio")) {
			atualizaCardapio(request, response);
		}
	}
	
	private void criarCardapio(HttpServletRequest request, HttpServletResponse response) {
		
		Cardapio cardapio = new Cardapio();
		cardapio.setDescricao(request.getParameter("descricao"));
		
		RequestDispatcher rd = request.getRequestDispatcher("mensagem.jsp");
		
		if (DBFacade.getInstance().insertCardapio(cardapio)) {
			request.setAttribute("mensagem", "Cardápio criado com sucesso!");
		} else {
			request.setAttribute("mensagem", "Erro ao criar cardápio!");
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
	
	private void atualizaCardapio(HttpServletRequest request, HttpServletResponse response) {
		Cardapio cardapio = DBFacade.getInstance().
				getOneCardapio(Integer.parseInt(request.getParameter("id")));
		
		cardapio.setDescricao(request.getParameter("descricao"));
		
		RequestDispatcher rd = request.getRequestDispatcher("mensagem.jsp");
		
		if (DBFacade.getInstance().updateCardapio(cardapio)) {
			request.setAttribute("mensagem", "Cardápio atualizado com sucesso!");
		} else {
			request.setAttribute("mensagem", "Erro ao atualizar cardápio!");
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
