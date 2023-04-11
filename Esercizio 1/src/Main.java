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