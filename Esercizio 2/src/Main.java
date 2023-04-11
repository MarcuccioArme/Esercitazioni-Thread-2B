import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // Creazione dell'arraylist di ordinazioni
        ArrayList<String> ordinazioni = new ArrayList<>();

        // Creazione e avvio del produttore (cameriere)
        Thread produttore = new Thread(new Produttore(ordinazioni));
        produttore.start();

        // Creazione e avvio del consumatore (cuoco)
        Thread consumatore = new Thread(new Consumatore(ordinazioni));
        consumatore.start();

        // Attende il completamento dei thread produttore e consumatore
        produttore.join();
        consumatore.join();

    }
}