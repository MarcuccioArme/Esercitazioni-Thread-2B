# Esercitazioni-Thread-2B
### Alcuni esercizi per capire i Thread

## Esercizio 1:
Scrivere un programma Java in cui:
- un thread produttore invia ripetutamente dei valori di “quotazioni di borsa” di almeno 10 aziende diverse (es.: “Fiat, 13 Euro”, “Generali, 21 Euro”, ecc.);
- tre thread consumatori raccolgono queste quotazioni;

Il programma dovrebbe funzionare “senza garanzia di ricezione” (con syncronized e non utilizzando cioè wait() e notify() vedi esempi) e termina quando uno dei thread è riuscito a raccogliere le quotazioni di tutte e 10 le aziende (nota: si potrebbe utilizzare un vettore a una o due dimensioni per caricare Aziende e Quotazioni, e poi…).

## Esercizio 2:
Scrivere un programma Java di tipo “produttore-consumatore” con garanzia di ricezione, nel quale:
- un cameriere presenta in cucina una sequenza di ordinazioni;
- il cuoco le riceve una dopo l’altra, nella stessa sequenza e senza perderne alcuna;

### Nota:
usare il meccanismo della “ricezione garantita con meccanismo inter-process communication”
