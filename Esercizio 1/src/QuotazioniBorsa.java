public class QuotazioniBorsa {
    private String azienda;
    private double valore;

    public synchronized void aggiungiQuotazione(String azienda, double valore) {

        this.azienda = azienda;
        this.valore = valore;
        notifyAll();    //I thread consumatori vengono svegliati e possono leggere i nuovi valori delle variabili azienda e valore.

    }

    public synchronized String getAzienda() {

        //Deve aspettare che il produttore abbia aggiornato le variabili azienda e valore prima di restituire i valori ai consumatori.
        while (azienda == null) {

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        String aziendaSTR = azienda;
        azienda = null;
        return aziendaSTR;

    }

    public synchronized double getValore() {

        //Deve aspettare che il produttore abbia aggiornato le variabili azienda e valore prima di restituire i valori ai consumatori.
        while (azienda == null) {

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        double Valore = valore;
        valore = 0;
        return Valore;

    }
}