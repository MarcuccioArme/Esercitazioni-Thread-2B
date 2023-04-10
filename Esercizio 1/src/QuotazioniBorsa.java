public class QuotazioniBorsa {
    private String azienda;
    private double valore;

    public synchronized void aggiungiQuotazione(String azienda, double valore) {

        this.azienda = azienda;
        this.valore = valore;
        notifyAll();

    }

    public synchronized String getAzienda() {

        while (azienda == null) {

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        String result = azienda;
        azienda = null;
        return result;

    }

    public synchronized double getValore() {

        while (azienda == null) {

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        double result = valore;
        valore = 0;
        return result;

    }
}