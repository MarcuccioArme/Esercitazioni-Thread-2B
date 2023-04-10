import java.util.ArrayList;

class Produttore implements Runnable {

    private final ArrayList<String> ordinazioni;

    public Produttore(ArrayList<String> ordinazioni) {
        this.ordinazioni = ordinazioni;
    }

    @Override
    public void run() {
        // Inserisce le ordinazioni nell'arraylist
        synchronized (ordinazioni) {
            System.out.println("Ordinazioni :");

            ordinazioni.add("Pasta al pomodoro");
            System.out.println("Aggiunto: Pasta al pomodoro");

            ordinazioni.add("Pizza margherita");
            System.out.println("Aggiunto: Pizza margherita");

            ordinazioni.add("Insalata mista");
            System.out.println("Aggiunto: Insalata mista");

            ordinazioni.add("Tiramisu");
            System.out.println("Aggiunto: Tiramisu");

            ordinazioni.add("Caffè");
            System.out.println("Aggiunto: Caffè");

            // Segnala la fine delle ordinazioni inserendo un valore nullo nell'arraylist
            ordinazioni.add(null);
            ordinazioni.notifyAll();
        }
    }
}
