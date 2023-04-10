import java.util.Random;

public class Produttore extends Thread {
    private QuotazioniBorsa quotazioniBorsa;

    public Produttore(QuotazioniBorsa quotazioniBorsa) {
        this.quotazioniBorsa = quotazioniBorsa;
    }

    @Override
    public void run() {
        String[] aziende = {"Fiat", "Generali", "Eni", "Intesa", "Unicredit", "Luxottica", "Mediaset", "Ferrari", "Telecom", "Pirelli"};
        Random random = new Random();

        while (true) {
            int indiceAzienda = random.nextInt(aziende.length);
            double valore = 10 + random.nextDouble() * 100;
            quotazioniBorsa.aggiungiQuotazione(aziende[indiceAzienda], valore);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}