package pastryshop.model;

public class UtenteBean {
	private	int id_utenti;
	private String nome;
	private String cognome;
	private String username;
	private String password;
	private String email;
	private String ruolo;
	private boolean valido;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	public boolean isValido() {
		return valido;
	}
	public void setValido(boolean valido) {
		this.valido = valido;
	}
	public int getId_utenti() {
		return id_utenti;
	}
	public void setId_utenti(int id_utenti) {
		this.id_utenti = id_utenti;
	}
	
	
}
