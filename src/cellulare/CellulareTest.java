package cellulare;
import java.util.Scanner;

public class CellulareTest {
    public static void main(String[] args) {
        Cellulare mioTelefono = new Cellulare();
        Scanner tastiera = new Scanner(System.in);
        int scelta = 0;

        while (scelta != 7) {
            System.out.println("\n-------------------------------------");
            System.out.println("----- MENU PRINCIPALE CELLULARE -----");
            System.out.println("-------------------------------------");
            System.out.println("Premi 1 per effettuare una ricarica");
            System.out.println("Premi 2 per gestire la tariffa");
            System.out.println("Premi 3 per effettuare una chiamata");
            System.out.println("Premi 4 per conoscere il credito disponibile");
            System.out.println("Premi 5 per sapere quante chiamate hai effettuato");
            System.out.println("Premi 6 per azzerare le chiamate effettuate");
            System.out.println("Premi 7 per spegnere il cellulare");
            System.out.print("Scegli un'opzione: ");
            
            scelta = tastiera.nextInt();

            switch (scelta) {
                case 1:
                    System.out.println("\n----- SERVIZIO RICARICA -----");
                    int tentativiRicarica = 3;
                    double importoScelto = 0;

                    while (tentativiRicarica > 0 && importoScelto == 0) {
                        System.out.println("Seleziona l'importo desiderato:");
                        System.out.println("Premi 1 per ricarica da 5€");
                        System.out.println("Premi 2 per ricarica da 10€");
                        System.out.println("Premi 3 per ricarica da 25€");
                        System.out.print("Scelta: ");
                        int sceltaRicarica = tastiera.nextInt();

                        if (sceltaRicarica == 1) {
                            importoScelto = 5.0;
                        } else if (sceltaRicarica == 2) {
                            importoScelto = 10.0;
                        } else if (sceltaRicarica == 3) {
                            importoScelto = 25.0;
                        } else {
                            tentativiRicarica--;
                            if (tentativiRicarica > 0) {
                                System.out.println("\n[Errore] Opzione non valida! Ti rimangono " + tentativiRicarica + " tentativi. Riprova.");
                            } else {
                                System.out.println("\n[Errore] Tentativi esauriti. Operazione di ricarica annullata.");
                            }
                        }
                    }
                    
                    if (importoScelto > 0) {
                        System.out.print("Inserisci il codice segreto di ricarica (usa '12345' per testare): ");
                        int codiceRicarica = tastiera.nextInt();
                        mioTelefono.ricarica(importoScelto, codiceRicarica);
                    }
                    break;
                    
                case 2:
                    System.out.println("\n----- GESTIONE PIANO TARIFFARIO -----");
                    int tentativiTariffa = 3;
                    boolean sceltaValida = false;

                    while (tentativiTariffa > 0 && !sceltaValida) {
                        System.out.println("C'e' una nuova offerta per te!");
                        System.out.println("Vuoi cambiare la tua tariffa attuale a 5 centesimi al minuto?");
                        System.out.println("Premi 1 per SI (Attiva offerta speciale a 5 cent/min)");
                        System.out.println("Premi 2 per NO (Mantieni la tariffa di base a 10 cent/min)");
                        System.out.print("Scelta: ");
                        int sceltaTariffa = tastiera.nextInt();
                        
                        if (sceltaTariffa == 1) {
                            mioTelefono.impostaTariffa(5);
                            sceltaValida = true;
                        } else if (sceltaTariffa == 2) {
                            mioTelefono.impostaTariffa(10);
                            sceltaValida = true;
                        } else {
                            tentativiTariffa--;
                            if (tentativiTariffa > 0) {
                                System.out.println("\n[Errore] Opzione non valida! Ti rimangono " + tentativiTariffa + " tentativi. Riprova.");
                            } else {
                                System.out.println("\n[Errore] Tentativi esauriti. Ritorno al menu principale.");
                            }
                        }
                    }
                    break;
                    
                case 3:
                    System.out.println("\n----- COMPOSIZIONE NUMERO -----");
                    
                    String numeroComposto = "";
                    int tentativiNumero = 3;
                    boolean numeroValido = false;

                    while (tentativiNumero > 0 && !numeroValido) {
                        System.out.print("Digita il numero di telefono da chiamare (max 10 cifre): ");
                        numeroComposto = tastiera.next();

                        if (numeroComposto.matches("[0-9]+") && numeroComposto.length() <= 10) {
                            numeroValido = true;
                        } else {
                            tentativiNumero--;
                            if (tentativiNumero > 0) {
                                System.out.println("\n[Errore] Numero non valido! Deve contenere solo cifre e massimo 10 caratteri.");
                                System.out.println("Ti rimangono " + tentativiNumero + " tentativi. Riprova a scrivere il numero.");
                            } else {
                                System.out.println("\n[Errore] Tentativi esauriti. Chiamata annullata. Ritorno al menu principale.");
                            }
                        }
                    }

                    if (numeroValido) {
                        int tentativiMinuti = 3;
                        boolean minutiValidi = false;
                        int minutiChiamata = 0;

                        while (tentativiMinuti > 0 && !minutiValidi) {
                            System.out.print("Digita i minuti di durata della chiamata (da 1 a 59): ");
                            String minutiString = tastiera.next();

                            if (minutiString.matches("[0-9]+")) {
                                minutiChiamata = Integer.parseInt(minutiString);
                                
                                if (minutiChiamata >= 1 && minutiChiamata <= 59) {
                                    minutiValidi = true;
                                } else {
                                    tentativiMinuti--;
                                    if (tentativiMinuti > 0) {
                                        System.out.println("\n[Errore] La durata deve essere compresa tra 1 e 59 minuti!");
                                        System.out.println("Ti rimangono " + tentativiMinuti + " tentativi. Riprova a scrivere i minuti.");
                                    } else {
                                        System.out.println("\n[Errore] Tentativi esauriti. Chiamata annullata. Ritorno al menu principale.");
                                    }
                                }
                            } else {
                                tentativiMinuti--;
                                if (tentativiMinuti > 0) {
                                    System.out.println("\n[Errore] Input errato! Non puoi inserire lettere, decimali o simboli.");
                                    System.out.println("Ti rimangono " + tentativiMinuti + " tentativi. Riprova a scrivere i minuti.");
                                } else {
                                    System.out.println("\n[Errore] Tentativi esauriti. Chiamata annullata. Ritorno al menu principale.");
                                }
                            }
                        }
                        
                        if (minutiValidi) {
                            mioTelefono.effettuaChiamata(numeroComposto, minutiChiamata);
                        }
                    }
                    break;
                    
                case 4:
                    System.out.println("\n----- VERIFICA CREDITO -----");
                    mioTelefono.visualizzaCredito();
                    break;
                    
                case 5:
                    System.out.println("\n----- REGISTRO CHIAMATE -----");
                    mioTelefono.visualizzaChiamateEffettuate();
                    break;
                    
                case 6:
                    System.out.println("\n----- REGISTRO CHIAMATE -----");
                    int tentativiAzzeramento = 3;
                    boolean azzeramentoRisposto = false;

                    while (tentativiAzzeramento > 0 && !azzeramentoRisposto) {
                        System.out.println("Sei sicuro di voler azzerare tutte le chiamate?");
                        System.out.println("Premi 1 per SI (Azzera contatore)");
                        System.out.println("Premi 2 per NO (Annulla operazione)");
                        System.out.print("Scelta: ");
                        int sceltaAzzera = tastiera.nextInt();

                        if (sceltaAzzera == 1) {
                            mioTelefono.azzeraChiamate();
                            azzeramentoRisposto = true;
                        } else if (sceltaAzzera == 2) {
                            System.out.println("SMS: Operazione di azzeramento annullata.");
                            azzeramentoRisposto = true;
                        } else {
                            tentativiAzzeramento--;
                            if (tentativiAzzeramento > 0) {
                                System.out.println("\n[Errore] Opzione non valida! Ti rimangono " + tentativiAzzeramento + " tentativi. Riprova.");
                            } else {
                                System.out.println("\n[Errore] Tentativi esauriti. Ritorno al menu principale.");
                            }
                        }
                    }
                    break;
                    
                case 7:
                    System.out.println("\nSpegnimento cellulare in corso... Arrivederci!");
                    break;
                    
                default:
                    System.out.println("\nTasto errato! Premi un numero da 1 a 7.");
                    break;
            }
        }
        
        tastiera.close();
    }
}