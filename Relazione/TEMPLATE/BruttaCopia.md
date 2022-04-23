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

Nello scenario e' inoltre presente un uccello il quale attraversa lo stage orrizontalmente e durante la attraversata, puo' planare verso una determinata posizione per poi continuare il suo percorso. Anche l'uccello puo' essere colpito dall'arpione.

Il giocatore ha a disposizione un certo numero di vite, le quali vengono decurtate in caso di coliisione con una palla o con l'uccello. Nel momento in cui si finiscono le vite, il gioco termina e si registra il punteggio nella leaderboard ( Nel caso sia abbastanza alto da superare quelli gia presenti).

Lo *score* viene aumentato dall'acquisizione di frutti che vengono generati durante la partita, ad ogni frutto viene assegnato un punteggio diverso.

Oltre ai due powerup che influenzano l'arma, ne sono presenti altri due in grado di influire sullo stage, ovvero:

- *Time Freeze:* Ferma tutte le sfere attive e le riattiva dopo un certo periodo di tempo.
- *Bomba:* Fa esplodere tutte le sfere a patto che non siano gia al terzo stadio ( piu piccolo ), in quel caso vengono ignorate.

A differenza dei *powerups* rivolti all'arma, gli ultimi due citati possono allo stesso tempo semplificare o peggiorare il *gameplay* al giocatore, in quanto il loro vantaggio/svantaggio varia in base al momento in cui vengono raccolti.


# Capitolo 2


## 2.1


## 2.2 Design Dettagliato 


## Portabilita' del personaggio principale e della sua arma su un nuovo motore grafico.

**Problema** IL personaggio principale ha bisogno di muoversi all interno di uno spazio il quale e' determinato dal motore grafico che puo' essere cambiata a seconda delle esigenze.

**Soluzione** Il Personaggio principale ed il suo arpione sono divisi in *Hero*, *HeroComponent* ed *Arpion*, *ArpionComponent*.
Sia *Hero* che *Arpion* mantengono le loro posizioni assolute a prescindere da qualsiasi motore grafico si stia usando.
Nel momento in cui c'e' bisogno di mettere in relazione le due entita' si usa un convertitore *StepsConverter* che converte i passi fatti dal personaggio principale in una coordinata cartesiana.
Stessa cosa vale per l'arpione, il quale esegue per salire verso l'alto, esegue un certo numero di passi verso l'alto.

### KeyBindings

**Problema** Associare determinati tasti a semplici comandi per il personaggio principale.

**Soluzione** In vista di rendere il personaggio principale il meno possibile dalla interfaccia usata abbiamo deciso di creare un sistema il quale, collegando i tasti al pannello di gioco, questi richiamano semplici azioni che avranno direttamente effetto sulle caratteristiche del personaggio principale, al quale non si delegano azioni che richiedono computazione.
(e.g. Nell'esecuzione di LeftAction, viene prima estratta la posizione dell'eroe da *Hero* tramite *StepsApplier*, in seguito viene fatto un controllo sulla prossima posizione e, se il controllo passa, si aggiorna il *Component*.




