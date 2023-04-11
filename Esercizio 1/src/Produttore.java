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

/*
Il metodo run() genera continuamente nuove quotazioni per aziende attraverso un ciclo while(true) utilizzando un array di nomi di aziende
predefinito e un oggetto Random per generare un valore casuale per ogni quotazione.

A ogni iterazione del ciclo while, viene selezionato casualmente un nome di azienda dall'array aziende utilizzando il metodo nextInt() dell'oggetto Random.
Successivamente, viene generato un valore casuale tra 10 e 110 utilizzando il metodo nextDouble() dell'oggetto Random.
Infine, il metodo aggiungiQuotazione() dell'oggetto quotazioniBorsa viene chiamato per inserire la nuova quotazione nella lista delle quotazioni disponibili.

In conclusione, il thread Produttore attende per 100 millisecondi utilizzando il metodo Thread.sleep() prima di generare una nuova quotazione,
in modo da simulare un intervallo di tempo tra una quotazione e l'altra.
*/