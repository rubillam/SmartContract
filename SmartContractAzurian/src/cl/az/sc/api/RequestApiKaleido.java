package cl.az.sc.api;
//nnuevo comentario 
//nuevo cambio

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class RequestApiKaleido {
	
	public HttpURLConnection getConexionEndpoint(String endpoint, String metodo, int conecttimeout, int readtimeout) throws IOException {
		URL url = new URL(endpoint);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod(metodo);
		con.setConnectTimeout(conecttimeout);
		con.setReadTimeout(readtimeout);
		return con;
	}
	
	public HttpURLConnection setHeadersRequest(HttpURLConnection con, String key, String value) {
		con.setRequestProperty(key, value);
		return con;
	}
	
	public InputStream ejecutarRequest(HttpURLConnection con) throws IOException {
		InputStream stream = con.getInputStream();
		//con.disconnect();
		return stream;
	}	
	
	public HttpURLConnection setBody(HttpURLConnection con, String json) throws IOException {		
		byte[] outputInBytes = json.getBytes("UTF-8");
		con.setRequestProperty("Content-Type","application/json"); 
		con.setDoOutput(true);
		OutputStream os = con.getOutputStream();		
		os.write(outputInBytes);
		os.close();
		con.connect();
		return con;
	}
	/*
	public void createRequest() throws IOException {
		URL url = new URL("https://console.kaleido.io/api/v1/consortia");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Authorization", "Bearer u0wa11zpqc-4eYOgpcwADI6V9j/7kLC9VG+/+P5MzuG9UL8K+qkO2U=");
		con.setConnectTimeout(5000);
		con.setReadTimeout(5000);
		
		//int status = con.getResponseCode();
		//System.out.print(status);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer content = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
		    content.append(inputLine);
		}
		in.close();
		con.disconnect();
		ReadJSON json = new ReadJSON();
		json.readJson(content.toString());
		//System.out.println(content.toString());
	}*/

}
