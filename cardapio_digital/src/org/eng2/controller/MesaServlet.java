package org.eng2.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eng2.model.DBFacade;
import org.eng2.model.Mesa;

/**
 * Servlet implementation class MesaServlet
 */
@WebServlet({ "/nova_mesa", "/cria_mesa", "/edita_mesa", "/atualiza_mesa", "/remove_mesa" })
public class MesaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MesaServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

		if (action.equals("/nova_mesa")) {
			novaMesa(request, response);
		} else if (action.equals("/edita_mesa")) {
			editaMesa(request, response);
		} else if (action.equals("/remove_mesa")) {
			removeMesa(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

		if (action.equals("/cria_mesa")) {
			criaMesa(request, response);
		} else if (action.equals("/atualiza_mesa")) {
			atualizaMesa(request, response);
		}
	}

	private void editaMesa(HttpServletRequest request,
			HttpServletResponse response) {
		Mesa m = DBFacade.getInstance().
				getOneMesa(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("mesa", m);
		RequestDispatcher rd = request
				.getRequestDispatcher("edita_mesa.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void novaMesa(HttpServletRequest request,
			HttpServletResponse response) {
		RequestDispatcher rd = request
				.getRequestDispatcher("nova_mesa.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void removeMesa(HttpServletRequest request,
			HttpServletResponse response) {
		int r = DBFacade.getInstance().
				deleteMesa(Integer.parseInt(request.getParameter("id")));
		
		RequestDispatcher rd = request
				.getRequestDispatcher("mensagem.jsp");
		if (r > 0) {
			request.setAttribute("mensagem", "Mesa removida com sucesso!");
		} else {
			request.setAttribute("mensagem", "Erro ao romver mesa!");
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
	
	private void criaMesa(HttpServletRequest request,
			HttpServletResponse response) {
		Mesa mesa = new Mesa();
		mesa.setNum(request.getParameter("num"));
		
		RequestDispatcher rd = request
				.getRequestDispatcher("mensagem.jsp");
		if (DBFacade.getInstance().insertMesa(mesa)) {
			request.setAttribute("mensagem", "Mesa criada com sucesso!");
		} else {
			request.setAttribute("mensagem", "Erro ao criar mesa!");
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

	private void atualizaMesa(HttpServletRequest request,
			HttpServletResponse response) {
		Mesa mesa = new Mesa();
		mesa.setNum(request.getParameter("num"));
		mesa.setId(Integer.parseInt(request.getParameter("id")));
		
		RequestDispatcher rd = request
				.getRequestDispatcher("mensagem.jsp");
		if (DBFacade.getInstance().updateMesa(mesa)) {
			request.setAttribute("mensagem", "Mesa atualizada com sucesso!");
		} else {
			request.setAttribute("mensagem", "Erro ao atualizar mesa!");
		}
		
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
