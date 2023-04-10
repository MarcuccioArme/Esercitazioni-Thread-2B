import java.util.concurrent.BlockingQueue;

class Produttore implements Runnable {

    private final BlockingQueue<String> codaOrdinazioni;

    public Produttore(BlockingQueue<String> codaOrdinazioni) {
        this.codaOrdinazioni = codaOrdinazioni;
    }

    @Override
    public void run() {
        try {
            System.out.println("Ordinazioni:");

            // Inserisce le ordinazioni nella coda
            codaOrdinazioni.put("Pasta al pomodoro");
            System.out.println("Inserita: Pasta al pomodoro");

            codaOrdinazioni.put("Pizza margherita");
            System.out.println("Inserita: Pizza margherita");

            codaOrdinazioni.put("Insalata mista");
            System.out.println("Inserita: Insalata mista");

            codaOrdinazioni.put("Tiramisu");
            System.out.println("Inserito: Tiramisu");

            codaOrdinazioni.put("Caffè");
            System.out.println("Inserito: Caffè");

            // Inserisce un valore speciale per segnalare la fine delle ordinazioni
            codaOrdinazioni.put("FINE");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}