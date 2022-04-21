# Capitolo 1

## Analisi 

### 1.1 Requisiti 

Il software costruito mira all'emulazione del *retro game* Pang.
Con retro game si intende un gioco di una precedente generazione i quali necessitano l'utilizzo di specifici emulatori in quanto non sono reperibili in forma fisica.

#### Requisiti funzionali
Il gioco e' composto da 3 scenari principali: menu di inizio, sequenza di gioco, fine gioco.

 - Nel menu di inizio e' possibile scegliere il proprio nickname, visualizzare la leaderboard locale ed avviare il menu di gioco.

 - Durante la fase di gioco il giocatore impersona un personaggio il quale dovra' far scoppiare delle sfere ( ognuna sdoppiabile per 3 volte ) tramite l'utilizzo di un arpione.
 Una volta finite le sfere, il giocatore passa al prossimo stage dove le sfere aumentano.
 Durante lo stage viene generato anche un uccello il quale, planando verso un punto specifico, potrebbe colpire il personaggio.
 Vengono inoltre generati dei frutti che, se raccolti dal personaggio, assegnano determinati punteggi al giocatore.
 Ogni volta che il personaggio viene colpito, viene decurtata una vita e viene riavviato lo stage.

- Alla perdita delle 3 vite, si passa alla fine del gioco dove il punteggio viene salvato nella leaderboard ( se sufficentemente alto ) e viene chiuso il gioco.

#### Requisiti non funzionali
In quanto retro game, il gioco deve poter funzionare anche su architetture con basse prestazioni.


### 1.2 Analisi e modello del dominio

Il software dovra' essere in grado di generare degli stage di difficolta' sequenziale.
La difficolta' e' determinata dal numero di sfere presenti all'avvio dello stage.
Ogni sfera ha la possibilita' di duplicarsi nel caso venga colpita dall'arpione.
Con duplicarsi si intende il passaggio da uno stato *padre* ad uno stato *figlio*, eseguibile per un massimo di 2 volte, quindi 3 stati in totale.
L'arpione viene lanciato dal personaggio principale e a seconda del *powerup* attivo puo' assumere 3 utilizzi diversi:

 - Arpione classico: il personaggio puo' sparare un solo arpione per volta verso l'alto e nel momento in cui il proiettile raggiunge l'altezza massima consentita, viene riacquisito.

 - Arpione Appiccicoso: il personaggio spara verso l'alto un arpione per volta il quale, nel momento in cui ragguinge l'altezza massima consentita, si appiccica per un determinato intervallo di tempo.

 - Doppio Arpione: il personaggio puo' sparare due arpioni classici per volta senza il bisogno di aspettare che uno dei due raggiunga la massima altezza consentita.

Il personaggio principale ha a disposizione delle vite, 




