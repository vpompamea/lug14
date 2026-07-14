package scannerArray;

import java.util.ArrayList;
import java.util.Scanner;

public class ListaNomi {

    ArrayList<String> listaNomi = new ArrayList<String>();

    public void inserisciNomi() {
        Scanner tastiera = new Scanner(System.in);

        System.out.println("\nInserisci un nome per volta e premi INVIO (scrivi 'stop'quando hai finito): " + "\n"); // \n carattere speciale di nuova riga 
 
        while (true) {
            System.out.print("Inserisci un nome: ");
            String nomeInserito = tastiera.next();
            
            switch (nomeInserito.toLowerCase()) {
                case "stop":
                    break;  
                default:
                    listaNomi.add(nomeInserito);
                    break;
            }
            
            if (nomeInserito.equalsIgnoreCase("stop")) { //Il metodo equalsIgnoreCase() confronta due stringhe determinando se sono uguali, ignorando le differenze tra maiuscole e minuscole
                break;
            }
        }
        
        tastiera.close();
    }

    public void stampaNomi() {
        System.out.println("\nEcco i nomi che hai inserito!"); 
        
        for (int i = 0; i < listaNomi.size(); i++) {
            String nome = listaNomi.get(i);
            System.out.println(nome);
        }
    }
}