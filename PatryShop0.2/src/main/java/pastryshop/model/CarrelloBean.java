package pastryshop.model;

import java.util.ArrayList;
import java.util.List;




public class CarrelloBean {
	private List<ProdottoBean> carrello_prodotti;
	private int quantita_carrello_prod_singoli;

	public CarrelloBean() {
		carrello_prodotti = new ArrayList<ProdottoBean>();
		
	}
	
	public void addProduct(ProdottoBean prodotto) {
		boolean ver = false;
		for(ProdottoBean prod : carrello_prodotti) {
			if(prod.getId_prodotto() == prodotto.getId_prodotto()) {
				ver = true;
				prod.setQq(prod.getQq()+1);	
				prod.setTot_price_qq(prod.getTot_price_qq()+prod.getPrezzo_prodotto());
			}		
		}
		if(!ver) {
			carrello_prodotti.add(prodotto);
			prodotto.setTot_price_qq(prodotto.getPrezzo_prodotto());
			prodotto.setQq(prodotto.getQq()+1);
		}
		quantita_carrello_prod_singoli++;
		
			
	}
	
	public void deleteProduct(ProdottoBean prodotto) {
		
		for(ProdottoBean prod : carrello_prodotti) {
			if(prod.getId_prodotto() == prodotto.getId_prodotto()) {
				if(prod.getQq() > 1) {
					prod.setQq(prod.getQq() - 1);
					prod.setTot_price_qq(prod.getTot_price_qq()-prod.getPrezzo_prodotto());
				}
				else if(prod.getQq() == 1){
					carrello_prodotti.remove(prod);
					break;
				}
			}
		}
 	}
	public int getTotal() {
		int somma = 0;
		for(ProdottoBean prod : carrello_prodotti) {
			somma += prod.getQq() * prod.getPrezzo_prodotto();
		}
		return somma;
	}
	
	public void removeall(){
		carrello_prodotti.removeAll(carrello_prodotti);
	}

	@Override
	public String toString() {
		return "CarrelloBean [carrello_prodotti=" + carrello_prodotti + "]";
	}

	public List<ProdottoBean> getCarrello_prodotti() {
		return carrello_prodotti;
	}

	public void setCarrello_prodotti(List<ProdottoBean> carrello_prodotti) {
		this.carrello_prodotti = carrello_prodotti;
	}

	public int getQuantita_carrello_prod_singoli() {
		return quantita_carrello_prod_singoli;
	}

	public void setQuantita_carrello_prod_singoli(int quantita_carrello_prod_singoli) {
		this.quantita_carrello_prod_singoli = quantita_carrello_prod_singoli;
	}
	
	
}
