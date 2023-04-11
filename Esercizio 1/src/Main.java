public class Main {
    public static void main(String[] args) {
        QuotazioniBorsa quotazioniBorsa = new QuotazioniBorsa();

        Thread produttore = new Produttore(quotazioniBorsa);
        Thread consumatore1 = new Consumatore(quotazioniBorsa);
        Thread consumatore2 = new Consumatore(quotazioniBorsa);
        Thread consumatore3 = new Consumatore(quotazioniBorsa);

        produttore.start();
        consumatore1.start();
        consumatore2.start();
        consumatore3.start();
    }
}

/*
Questo codice crea un'applicazione multithread che utilizza un'istanza della classe "QuotazioniBorsa" come oggetto
condiviso tra i thread produttore e consumatori.

Il thread produttore genera quotazioni casuali della borsa e le inserisce nell'oggetto "QuotazioniBorsa".
I thread consumatori recuperano e stampano le quotazioni dalla "QuotazioniBorsa".

L'avvio dei thread viene gestito tramite il metodo "start()", che avvia l'esecuzione del codice all'interno di ogni thread in modo asincrono.
In questo modo, tutti i thread possono lavorare contemporaneamente e accedere all'oggetto condiviso in modo sincronizzato.
*/