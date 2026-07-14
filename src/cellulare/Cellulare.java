package cellulare;

public class Cellulare {
    private double creditoDisponibile;
    private int chiamateEffettuate;
    private int tariffa = 10; 

    public void impostaTariffa(int nuovaTariffa) {
        tariffa = nuovaTariffa;
        System.out.println("SMS: Piano tariffario aggiornato! Nuova tariffa: " + tariffa + " cent/min.");
    }

    public void ricarica(double importo, int codiceInserito) {
        if (codiceInserito == 12345) {
            creditoDisponibile = creditoDisponibile + importo;
            System.out.println("SMS: Ricarica di " + importo + "€ effettuata con successo! Credito disponibile: " + creditoDisponibile + "€.");
        } else {
            System.out.println("SMS: Errore! Il codice di ricarica inserito non e' valido.");
        }
    }

    public void effettuaChiamata(String numero, int minuti) {
        if (numero.length() > 10) {
            System.out.println("SMS: Impossibile chiamare. Il numero inserito e' troppo lungo (max 10 cifre).");
            return;
        }

        if (creditoDisponibile <= 0) {
            System.out.println("SMS: Impossibile chiamare. Credito insufficiente.");
            return; 
        }

        double costoChiamata = (minuti * tariffa) / 100.0;

        if (creditoDisponibile >= costoChiamata) {
            creditoDisponibile = creditoDisponibile - costoChiamata;
            chiamateEffettuate = chiamateEffettuate + 1;
            System.out.println("SMS: Chiamata verso il numero " + numero + " di " + minuti + " minuti completata. Costo: " + costoChiamata + "€.");
        } else {
            int minutiEffettivi = (int) ((creditoDisponibile * 100) / tariffa);
            creditoDisponibile = 0.0;
            chiamateEffettuate = chiamateEffettuate + 1;
            
            System.out.println("SMS: Chiamata interrotta per credito esaurito!");
            System.out.println("SMS: Sei riuscito a parlare solo per " + minutiEffettivi + " minuti verso il numero " + numero + ". Il tuo credito e' ora di 0.0€.");
        }
    }

    public void visualizzaCredito() {
        System.out.println("SMS: Il tuo credito disponibile e' di " + creditoDisponibile + "€.");
    }

    public void visualizzaChiamateEffettuate() {
        System.out.println("SMS: Hai effettuato " + chiamateEffettuate + " chiamate in totale.");
    }

    public void azzeraChiamate() {
        chiamateEffettuate = 0;
        System.out.println("SMS: Il contatore delle chiamate e' stato azzerato con successo.");
    }
}