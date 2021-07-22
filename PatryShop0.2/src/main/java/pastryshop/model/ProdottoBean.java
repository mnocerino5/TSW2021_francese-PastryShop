package pastryshop.model;

import java.io.File;

import javax.servlet.http.Part;

public class ProdottoBean {
	private int id_prodotto;
	private String nome_prodotto;
	private String descrizione_prodotto;
	private int quantita_disponibile_prodotto;
	private int prezzo_prodotto;
	private String categoria;
	private Part foto;
	private int qq; //quantità singolo prodotto
	private int tot_price_qq; //quantità prezzo totale singolo prodotto
	
	public int getId_prodotto() {
		return id_prodotto;
	}
	public void setId_prodotto(int id_prodotto) {
		this.id_prodotto = id_prodotto;
	}
	public String getNome_prodotto() {
		return nome_prodotto;
	}
	public void setNome_prodotto(String nome_prodotto) {
		this.nome_prodotto = nome_prodotto;
	}
	public String getDescrizione_prodotto() {
		return descrizione_prodotto;
	}
	public void setDescrizione_prodotto(String descrizione_prodotto) {
		this.descrizione_prodotto = descrizione_prodotto;
	}
	public int getQuantita_disponibile_prodotto() {
		return quantita_disponibile_prodotto;
	}
	public void setQuantita_disponibile_prodotto(int quantita_disponibile_prodotto) {
		this.quantita_disponibile_prodotto = quantita_disponibile_prodotto;
	}
	public int getPrezzo_prodotto() {
		return prezzo_prodotto;
	}
	public void setPrezzo_prodotto(int prezzo_prodotto) {
		this.prezzo_prodotto = prezzo_prodotto;
	}
	
	
	public int getQq() {
		return qq;
	}
	public void setQq(int qq) {
		this.qq = qq;
	}
	public int getTot_price_qq() {
		return tot_price_qq;
	}
	public void setTot_price_qq(int tot_price_qq) {
		this.tot_price_qq = tot_price_qq;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public Part getFoto() {
		return foto;
	}
	public void setFoto(Part foto) {
		this.foto = foto;
	}
	@Override
	public String toString() {
		return "ProdottoBean [id_prodotto=" + id_prodotto + ", nome_prodotto=" + nome_prodotto
				+ ", descrizione_prodotto=" + descrizione_prodotto + ", quantita_disponibile_prodotto="
				+ quantita_disponibile_prodotto + ", prezzo_prodotto=" + prezzo_prodotto + ", categoria=" + categoria
				+ ", qq=" + qq + ", tot_price_qq=" + tot_price_qq + "]";
	}
	


	
	
}
