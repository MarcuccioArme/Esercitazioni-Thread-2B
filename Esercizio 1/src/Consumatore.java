import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Consumatore extends Thread {
    private QuotazioniBorsa quotazioniBorsa;

    public Consumatore(QuotazioniBorsa quotazioniBorsa) {
        this.quotazioniBorsa = quotazioniBorsa;
    }

    @Override
    public void run() {
        Set<String> aziendeRaccolte = new HashSet<>();
        while (true) {
            Map<String, Double> quotazioni = quotazioniBorsa.getQuotazioni();
            aziendeRaccolte.addAll(quotazioni.keySet());

            if (aziendeRaccolte.size() >= 10) {
                System.out.println(getName() + " ha raccolto le quotazioni di tutte le 10 aziende!");
                System.exit(0);
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}