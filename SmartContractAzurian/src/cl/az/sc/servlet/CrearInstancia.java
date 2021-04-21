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
 * Servlet implementation class CrearInstancia
 */
@WebServlet("/CrearInstancia")
public class CrearInstancia extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DatosKaleido datosk = new DatosKaleido();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearInstancia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idContrato = request.getParameter("id_contrato");
		String nombre_instancia = request.getParameter("nombre_instancia");
		String propiedad1 = request.getParameter("propiedad1");
		String endpoint = "contrato1";

		String url = "https://" + datosk.getEnviroment() + "-" + datosk.getNodo() + "-" + datosk.getZona() + ".kaleido.io/gateways/" + endpoint + "/?kld-from=" + datosk.getAccount() + "&kld-sync=true&kld-call=false&kld-register=" + nombre_instancia;
		System.out.println(url);
		String json = "{\"initVal\": \"" + propiedad1 + "\"}";

		RequestApiKaleido api = new RequestApiKaleido();
		HttpURLConnection con;
		con = api.getConexionEndpoint(url, "POST",
				15000, 15000);
		con = api.setHeadersRequest(con, "Authorization", datosk.getAuth_basic());
		con = api.setBody(con, json);
		//InputStream stream = api.ejecutarRequest(con);

		api.getCodigoEjecucion(con);
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		response.sendRedirect("Instancias.html?id_compilado=" + idContrato);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
