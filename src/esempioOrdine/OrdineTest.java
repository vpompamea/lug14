package esempioOrdine;

public class OrdineTest {

	public static void main(String[] args) {
		Ordine mioOrdine = new Ordine(); // dichiaro e creo un oggetto di tipo ordine
		Camicia camiciaUno = new Camicia(), camiciaDue = new Camicia(), camiciaTre = new Camicia(); // con la virgola perchè sono tutti oggetti delo stesso tipo
		double costoTotale = 0; // qui effettuo le somme
		//inizializzazione campi dei tre oggetti Camicia
		camiciaUno.prezzo = 23.90;
		camiciaDue.prezzo = 20.00;
		camiciaTre.prezzo = 52.99;
		camiciaUno.acquistate = 2;
		camiciaDue.acquistate = 5;
		camiciaTre.acquistate = 1;
		
		int camicieTotali = camiciaUno.acquistate + camiciaDue.acquistate + camiciaTre.acquistate; // somma delle quantità
		//							23.90*2					+		20.00*5 						+ 52.99*1
		costoTotale = mioOrdine.aggiungiCamicia(camiciaUno) + mioOrdine.aggiungiCamicia(camiciaDue) + mioOrdine.aggiungiCamicia(camiciaTre); //prodotto delle camicie per la quantità venduta
		System.out.println("Il costo totale della merce è di " + costoTotale + "euro, per " + camicieTotali + "articoli.");
		
		
	}

}
