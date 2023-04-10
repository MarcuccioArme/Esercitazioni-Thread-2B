import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // Creazione della coda di ordinazioni
        BlockingQueue<String> codaOrdinazioni = new ArrayBlockingQueue<>(10);

        // Creazione e avvio del produttore (cameriere)
        Thread produttore = new Thread(new Produttore(codaOrdinazioni));
        produttore.start();

        // Creazione e avvio del consumatore (cuoco)
        Thread consumatore = new Thread(new Consumatore(codaOrdinazioni));
        consumatore.start();

        // Attende il completamento dei thread produttore e consumatore
        produttore.join();
        consumatore.join();
    }
}