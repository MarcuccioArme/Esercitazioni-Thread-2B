import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

class Consumatore extends Thread {
    private QuotazioniBorsa quotazioniBorsa;

    public Consumatore(QuotazioniBorsa quotazioniBorsa) {
        this.quotazioniBorsa = quotazioniBorsa;
    }

    @Override
    public void run() {

        List<String> aziendeRaccolte = new ArrayList<>();
        DecimalFormat df = new DecimalFormat("#.##");

        while (true) {

            String azienda = quotazioniBorsa.getAzienda();
            double valore = quotazioniBorsa.getValore();

            if (!aziendeRaccolte.contains(azienda)) {
                aziendeRaccolte.add(azienda);
                System.out.println(getName() + " ha raccolto la quotazione di " + azienda + " con valore " + df.format(valore));
            }

            if (aziendeRaccolte.size() >= 10) {
                System.out.println("\n--> " +getName() + " ha raccolto le quotazioni di tutte le 10 aziende! <--");
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