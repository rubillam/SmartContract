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
 * Servlet implementation class PromoverContrato
 */
@WebServlet("/PromoverContrato")
public class PromoverContrato extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DatosKaleido datosk = new DatosKaleido();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PromoverContrato() {
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

		String nombre_endpoint = request.getParameter("endpoint");
		String id_contrato = request.getParameter("id_contrato");
		String compiled_contract_id = request.getParameter("id_compilado_contrato");

		String json = "{\"endpoint\": \"" + nombre_endpoint + "\", \"environment_id\": \"" + datosk.getEnviroment()
				+ "\"}";

		RequestApiKaleido api = new RequestApiKaleido();
		HttpURLConnection con;
		con = api.getConexionEndpoint(datosk.getUrl() + "/consortia/" + datosk.getConsortia() + "/contracts/"
				+ id_contrato + "/compiled_contracts/" + compiled_contract_id + "/promote", "POST", 5000, 5000);
		con = api.setHeadersRequest(con, "Authorization", datosk.getAuth_bearer());
		con = api.setBody(con, json);
		InputStream stream = api.ejecutarRequest(con);

		response.sendRedirect("Compilados.html?conjunto=" + id_contrato);

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

}
