package com.uniovi.sdi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletCarrito
 */
@WebServlet("/ServletCarrito")
public class ServletCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCarrito() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		//Opcion A 
		//Usar ConcurrentHashMap o SyncronizedMap
		//ConcurrentHashMap <String,Integer> carrito = (ConcurrentHashMap<String, Integer>) request.getSession().getAttribute("carrito");
		HashMap<String, Integer> carrito = (HashMap<String, Integer>) request.getSession().getAttribute("carrito");

		// No hay carrito, creamos uno y lo insertamos en sesi�n
		if (carrito == null) {
			carrito = new HashMap<String, Integer>();
			request.getSession().setAttribute("carrito", carrito);
		}

		String producto = request.getParameter("producto");
		if (producto != null) {
			//Opcion B
			synchronized (session) {
				insertarEnCarrito(carrito, producto);
			}
			//insertarEnCarrito(carrito, producto);
		}

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD><TITLE>Tienda SDI: carrito</TITLE></HEAD>");
		out.println("<BODY>");
		out.println(carritoEnHTML(carrito) + "<br>");
		out.println("<a href=\"tienda.html\">Volver</a></BODY></HTML>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void insertarEnCarrito(Map<String, Integer> carrito, String claveProducto) {
		if (carrito.get(claveProducto) == null)
			carrito.put(claveProducto, new Integer(1));
		else {
			int numeroArticulos = (Integer) carrito.get(claveProducto).intValue();
			carrito.put(claveProducto, new Integer(numeroArticulos + 1));
		}
	}

	private String carritoEnHTML(Map<String, Integer> carrito) {
		String carritoEnHTML = "";
		for (String key : carrito.keySet())
			carritoEnHTML += "<p>[" + key + "], " + carrito.get(key) + " unidades</p>";
		return carritoEnHTML;
	}

}
