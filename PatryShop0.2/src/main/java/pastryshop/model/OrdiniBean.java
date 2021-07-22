package pastryshop.model;

import java.util.Date;

public class OrdiniBean {
	private int id_ordini;
	private int prezzo_ordini;
	private int quantit_ordini;
	private String stato_ordini;
	private Date data_eff_ordini;
	private Date data_conc_ordini;
	private int id_utente;
	public int getId_utente() {
		return id_utente;
	}
	public void setId_utente(int id_utente) {
		this.id_utente = id_utente;
	}
	public int getId_ordini() {
		return id_ordini;
	}
	public void setId_ordini(int id_ordini) {
		this.id_ordini = id_ordini;
	}
	public int getPrezzo_ordini() {
		return prezzo_ordini;
	}
	public void setPrezzo_ordini(int prezzo_ordini) {
		this.prezzo_ordini = prezzo_ordini;
	}
	public int getQuantit_ordini() {
		return quantit_ordini;
	}
	public void setQuantit_ordini(int quantit_ordini) {
		this.quantit_ordini = quantit_ordini;
	}
	public String getStato_ordini() {
		return stato_ordini;
	}
	public void setStato_ordini(String stato_ordini) {
		this.stato_ordini = stato_ordini;
	}
	public Date getData_eff_ordini() {
		return data_eff_ordini;
	}
	public void setData_eff_ordini(Date data_eff_ordini) {
		this.data_eff_ordini = data_eff_ordini;
	}
	public Date getData_conc_ordini() {
		return data_conc_ordini;
	}
	public void setData_conc_ordini(Date data_conc_ordini) {
		this.data_conc_ordini = data_conc_ordini;
	}
	@Override
	public String toString() {
		return "OrdiniBean [id_ordini=" + id_ordini + ", prezzo_ordini=" + prezzo_ordini + ", quantit_ordini="
				+ quantit_ordini + ", stato_ordini=" + stato_ordini + ", data_eff_ordini=" + data_eff_ordini
				+ ", data_conc_ordini=" + data_conc_ordini + ", id_utente=" + id_utente + "]";
	}


	
}
