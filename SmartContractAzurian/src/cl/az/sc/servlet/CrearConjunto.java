package cl.az.sc.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.az.sc.api.RequestApiKaleido;
import cl.az.sc.utils.DatosKaleido;

/**
 * Servlet implementation class CrearConjunto
 */
@WebServlet("/CrearConjunto")
public class CrearConjunto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DatosKaleido datosk = new DatosKaleido();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CrearConjunto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombre_conjunto = request.getParameter("nombre-conjunto");
		String descripcion_conjunto = request.getParameter("descripcion-conjunto");
		String tipo_conjunto = request.getParameter("tipo-conjunto");

		String json = "{\"name\": \"" + nombre_conjunto + "\", \"description\": \"" + descripcion_conjunto
				+ "\", \"membership_id\": \""+datosk.getMenbership()+"\", \"type\": \"" + tipo_conjunto + "\"}";

		RequestApiKaleido api = new RequestApiKaleido();
		HttpURLConnection con;
		con = api.getConexionEndpoint(datosk.getUrl() + "/consortia/" + datosk.getConsortia() + "/contracts", "POST",
				5000, 5000);
		con = api.setHeadersRequest(con, "Authorization", datosk.getAuth_bearer());
		con = api.setBody(con, json);
		InputStream stream = api.ejecutarRequest(con);

		// response.getWriter().append("Served at: ").append(request.getContextPath());
		response.sendRedirect("Plantillas.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.print(request.getParameter("nombre-conjunto"));
		doGet(request, response);
	}

}
