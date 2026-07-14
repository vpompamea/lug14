package tavPitagorica;

public class TavolaPitagorica {
    public static void main(String[] args) {
        //ciclo per le righe
        for (int i = 1; i <= 10; i++) {
        	// ciclo per le colonne
            for (int j = 1; j <= 10; j++) {
                int prodotto = i * j; // variabile locale
                
                if (prodotto < 10) {
                    System.out.print("   " + prodotto);
                } else if (prodotto < 100) {
                    System.out.print("  " + prodotto); 
                } else {
                    System.out.print(" " + prodotto); 
                }
            }
            System.out.println(); 
        }
        
    }
}
