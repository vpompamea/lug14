package esempioOrdine;

public class Camicia { // corrispondente al 1° rigo del diagramma UML
	//public: file visibile esternamente al package
	// class: dischiarazione di classe Java

	//2° rigo del diagramma UMl ovvero ATTRIBUTI( o anche chiamati variabili globali/ campi / istanze)
	
	public int camiciaID; // int tipo numerico intero
	public String descrizione = "-descrizione macante-"; // String testo con in questo caso un valore iniziale
	public char codiceColore = 'U'; //colori disponibili: R= red, G = green, B= blue, W=white, U= unset;
	//char deve essere un carattere singolo
	public double prezzo; // double: tipo numerico decimale
	public int acquistate; // int numero intero
	
	// 3° rigo del diagramma UML : metodi della classe
	// modifier, tipo di ritorno e il modo del metodo
	public void display() { // void: il metodo non deve fornire valori di ritorno ma solo stampare e quindi non restituisce nulla
		System.out.println("ID della camicia: " + camiciaID); // metodo di stampa per la console gi esistente in Java / il + è un operatore polimorfo: effettua somme o concatenazioni string
		System.out.println("descrizione: " + descrizione);
		System.out.println("colore: " + codiceColore);
		System.out.println("prezzo: " + prezzo + " euro");
		System.out.println("quantità acquistate: " + acquistate);
		System.out.println(); //rigo vuoto
		
	}
	//4° rigo del diagramma UML : in questo caso camicia NON crea oggetti a sua volta
}

