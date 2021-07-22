package pastryshop.model;

public class OrdiniDettagliBean {
	private int id_ordini;
	private String nome_dett_ordini;
	private String descri_dett_ordini;
	private int quantit_dett_ordini;
	private int prezzo_tot_dett_ordini;
	public int getId_ordini() {
		return id_ordini;
	}
	public void setId_ordini(int id_ordini) {
		this.id_ordini = id_ordini;
	}
	public String getNome_dett_ordini() {
		return nome_dett_ordini;
	}
	public void setNome_dett_ordini(String nome_dett_ordini) {
		this.nome_dett_ordini = nome_dett_ordini;
	}
	public String getDescri_dett_ordini() {
		return descri_dett_ordini;
	}
	public void setDescri_dett_ordini(String descri_dett_ordini) {
		this.descri_dett_ordini = descri_dett_ordini;
	}
	public int getQuantit_dett_ordini() {
		return quantit_dett_ordini;
	}
	public void setQuantit_dett_ordini(int quantit_dett_ordini) {
		this.quantit_dett_ordini = quantit_dett_ordini;
	}
	public int getPrezzo_tot_dett_ordini() {
		return prezzo_tot_dett_ordini;
	}
	public void setPrezzo_tot_dett_ordini(int prezzo_tot_dett_ordini) {
		this.prezzo_tot_dett_ordini = prezzo_tot_dett_ordini;
	}
	@Override
	public String toString() {
		return "OrdiniDettagliBean [id_ordini=" + id_ordini + ", nome_dett_ordini=" + nome_dett_ordini
				+ ", descri_dett_ordini=" + descri_dett_ordini + ", quantit_dett_ordini=" + quantit_dett_ordini
				+ ", prezzo_tot_dett_ordini=" + prezzo_tot_dett_ordini + "]";
	}
	
}
