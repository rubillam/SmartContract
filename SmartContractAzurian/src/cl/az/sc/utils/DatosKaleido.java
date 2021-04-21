package cl.az.sc.utils;

public class DatosKaleido {

	private String url = "https://console.kaleido.io/api/v1";
	private String consortia = "u0anpopx37";
	private String menbership = "u0r1q8wt9s";
	private String auth_bearer = "Bearer u0hrrbjez2-4Vl9uxWREK7TAFl091vdARWLMmlg0XfXIeoFCMki4wQ=";
	private String auth_basic = "Basic dTBqd2w5cHFkZzo2VWg2V2dSWTkzTW9kR3ROWTQ0N01mYUVHMDhCdlFRd0pid3NwUlFZQzlj";
	private String enviroment = "u0i0lez3sb";
	private String nodo = "u0rrr5fw0i";
	private String zona = "connect.us0-aws";
	private String account = "0x63b4c8a83d73bb26d23d00ed2f8d1082c845db67";
	
	public String getAuth_basic() {
		return auth_basic;
	}

	public void setAuth_basic(String auth_basic) {
		this.auth_basic = auth_basic;
	}

	

	public String getEnviroment() {
		return enviroment;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getNodo() {
		return nodo;
	}

	public void setNodo(String nodo) {
		this.nodo = nodo;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public void setEnviroment(String enviroment) {
		this.enviroment = enviroment;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getConsortia() {
		return consortia;
	}

	public void setConsortia(String consortia) {
		this.consortia = consortia;
	}

	public String getMenbership() {
		return menbership;
	}

	public void setMenbership(String menbership) {
		this.menbership = menbership;
	}

	public String getAuth_bearer() {
		return auth_bearer;
	}

	public void setAuth_bearer(String auth_bearer) {
		this.auth_bearer = auth_bearer;
	}

}
