package org.eng2.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eng2.model.DBFacade;
import org.eng2.model.Token;
import org.eng2.model.Mesa;


/**
 * Servlet implementation class TokenServlet
 */
@WebServlet({ "/gerar_token", "/deletar_token", "/criar_token" })
public class TokenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TokenServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

		if (action.equals("/gerar_token")) {
			gerarToken(request, response);
		} else if (action.equals("/deletar_token")) {
			deletartoken(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

		if (action.equals("/criar_token")) {
			criarToken(request, response);
		}
	}

	private void deletartoken(HttpServletRequest request,
			HttpServletResponse response) {
		RequestDispatcher rd = request
				.getRequestDispatcher("mensagem.jsp");
		if (DBFacade.getInstance().deleteToken(request.getParameter("cod"))) {
			request.setAttribute("mensagem", "Token deletado com sucesso" );
		} else {
			request.setAttribute("mensagem", "Erro ao deletar token!");
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

	private void gerarToken(HttpServletRequest request,
			HttpServletResponse response) {
		request.setAttribute("lista_mesa", DBFacade.getInstance().getAllMesa());
		RequestDispatcher rd = request.getRequestDispatcher("gera_token.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void criarToken(HttpServletRequest request,
			HttpServletResponse response) {
		String uuid = UUID.randomUUID().toString().split("-")[0];
		
		Token token = new Token();
		token.setCod(uuid.substring(0, 6));
		token.setMesaId(Integer.parseInt(request.getParameter("mesa_id")));
		
		RequestDispatcher rd = request
				.getRequestDispatcher("mensagem.jsp");
		if (DBFacade.getInstance().insertToken(token)) {
			request.setAttribute("mensagem", "Token criado: " + uuid);
		} else {
			request.setAttribute("mensagem", "Erro ao criar token!");
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
