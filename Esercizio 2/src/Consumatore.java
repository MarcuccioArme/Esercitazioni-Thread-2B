import java.util.ArrayList;

class Consumatore implements Runnable {

    private final ArrayList<String> ordinazioni;

    public Consumatore(ArrayList<String> ordinazioni) {
        this.ordinazioni = ordinazioni;
    }

    @Override
    public void run() {

        synchronized (ordinazioni) {
            try {

                while (true) {
                    // Attende finché ci sono ordinazioni nell'arraylist
                    while (ordinazioni.isEmpty()) {
                        ordinazioni.wait();
                    }
                    // Recupera l'ordinazione successiva dall'arraylist
                    String ordine = ordinazioni.get(0);
                    ordinazioni.remove(0);

                    // Se è stato inserito un valore nullo, termina il ciclo
                    if (ordine == null) {
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

}