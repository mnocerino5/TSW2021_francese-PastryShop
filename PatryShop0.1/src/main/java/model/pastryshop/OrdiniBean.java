package model.pastryshop;

import java.util.Date;

public class OrdiniBean {
	int code;
	int totale;
	Date data_ordine;
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getTotale() {
		return totale;
	}

	public void setTotale(int totale) {
		this.totale = totale;
	}

	public Date getData_ordine() {
		return data_ordine;
	}

	public void setData_ordine(Date data_ordine) {
		this.data_ordine = data_ordine;
	}

	@Override
	public String toString() {
		return "OrdiniBean [code=" + code + ", totale=" + totale + ", data_ordine=" + data_ordine + "]";
	}

	
}
