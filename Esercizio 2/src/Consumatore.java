import java.util.concurrent.BlockingQueue;

class Consumatore implements Runnable {

    private final BlockingQueue<String> codaOrdinazioni;

    public Consumatore(BlockingQueue<String> codaOrdinazioni) {
        this.codaOrdinazioni = codaOrdinazioni;
    }

    @Override
    public void run() {
        try {

            while (true) {
                // Recupera l'ordinazione successiva dalla coda
                String ordine = codaOrdinazioni.take();

                // Se è stato inserito il valore speciale "FINE", termina il ciclo
                if (ordine.equals("FINE")) {
                    break;
                }

                // Elabora l'ordinazione
                System.out.println("\nPreparazione in corso: " + ordine);
                Thread.sleep(2000); // Simula il tempo di preparazione
                System.out.println("Ordinazione pronta: " + ordine);

            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}