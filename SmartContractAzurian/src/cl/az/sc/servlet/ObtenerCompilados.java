package cl.az.sc.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.az.sc.api.RequestApiKaleido;
import cl.az.sc.utils.DatosKaleido;

/**
 * Servlet implementation class ObtenerCompilados
 */
@WebServlet("/ObtenerCompilados")
public class ObtenerCompilados extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DatosKaleido datosk = new DatosKaleido();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ObtenerCompilados() {
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
		String id_conjunto = request.getParameter("id-conjunto");
		String id_compilado = request.getParameter("id_compilado");
		
		
		
		RequestApiKaleido api = new RequestApiKaleido();
		HttpURLConnection con;
		if(id_compilado == null) {
			con = api.getConexionEndpoint(datosk.getUrl() + "/consortia/" + datosk.getConsortia() + "/contracts/"
					+ id_conjunto + "/compiled_contracts", "GET", 5000, 5000);
		}else {
			con = api.getConexionEndpoint(datosk.getUrl() + "/consortia/" + datosk.getConsortia() + "/contracts/"
					+ id_conjunto + "/compiled_contracts/" + id_compilado, "GET", 5000, 5000);
		}
		
		con = api.setHeadersRequest(con, "Authorization", datosk.getAuth_bearer());
		// con = api.setBody(con, json);
		InputStream stream = api.ejecutarRequest(con);

		BufferedReader in = new BufferedReader(new InputStreamReader(stream));
		String inputLine;
		StringBuffer content = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			content.append(inputLine);
		}
		in.close();

		response.getWriter().append(content.toString());
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
