import java.util.HashMap;
import java.util.Map;

public class QuotazioniBorsa {
    private Map<String, Double> quotazioni;

    public QuotazioniBorsa() {
        quotazioni = new HashMap<>();
    }

    public synchronized void aggiungiQuotazione(String azienda, double valore) {
        quotazioni.put(azienda, valore);
    }

    public synchronized Map<String, Double> getQuotazioni() {
        return new HashMap<>(quotazioni);
    }
}