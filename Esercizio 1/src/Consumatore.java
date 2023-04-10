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

/*
Il metodo run() legge continuamente le nuove quotazioni disponibili attraverso un ciclo while(true).

In particolare, a ogni iterazione del ciclo while, il thread chiama i metodi getAzienda() e getValore() dell'oggetto quotazioniBorsa per ottenere
il nome dell'azienda e rispettivamente il valore della sua quotazione.

Successivamente, il thread controlla se l'elenco delle aziende già raccolte non contiene il nome dell'azienda corrente.
Se il caso è vero, il nome dell'azienda e il valore della sua quotazione vengono aggiunti all'elenco delle aziende raccolte e viene stampato un messaggio
a schermo indicando il nome dell'azienda e il valore della sua quotazione.

Infine, il thread controlla se l'elenco delle aziende raccolte ha raggiunto una dimensione di 10.
Se il caso è vero, viene stampato un messaggio a schermo che indica che tutte le quotazioni sono state raccolte e il programma viene terminato
utilizzando il metodo System.exit(0).

Inoltre, il thread Consumatore attende per 100 millisecondi utilizzando il metodo Thread.sleep() prima di leggere la prossima quotazione, in modo da simulare
un intervallo di tempo tra una lettura e l'altra.
 */