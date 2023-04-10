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

        String result = azienda;
        azienda = null;
        return result;

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

        double result = valore;
        valore = 0;
        return result;

    }
}

/*
Senza l'utilizzo del wait() e del notify(), i thread consumatori potrebbero leggere i valori delle variabili azienda e valore prima che il thread
produttore abbia finito di aggiornarle, causando situazioni d'inconsistenza dei dati.
*/