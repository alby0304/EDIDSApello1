# ListAdapterProject

## Descrizione

Questo progetto implementa un adapter per l'interfaccia `List` di Java 1.4.2 utilizzando la classe `Vector` di CLDC 1.1. Il progetto include anche una suite di test unitari sviluppata con metodologia Test Driven Development (TDD).

## Struttura del progetto

- `src/`: Codice sorgente del progetto.
    - `myAdapter/`: Implementazioni delle interfacce e delle classi dell'adapter.
    - `myTest/`: Test unitari per le classi dell'adapter.
- `lib/`: Librerie esterne (ad esempio, `junit.jar`).
- `doc/`: Documentazione generata.
    - `adapter/`: Documentazione Javadoc per le classi dell'adapter.
    - `tests/`: Documentazione dei test case.
- `README.md`: Documentazione del progetto.

## Creazione della documentazione Javadoc
```sh
javadoc -d doc -sourcepath src -subpackages myAdapter -classpath lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar
```

## Compilazione ed Esecuzione

### Prerequisiti

- JDK 1.4.2 (o compatibile con CLDC 1.1)
  - È possibile che nel caso in cui si utilizzi una versione successiva alcune operazioni risultino non sicure, verrà specificato a tempo di compilazione:
    - Note: src/myAdapter/ListAdapter.java uses unchecked or unsafe operations. 
    - Note: Recompile with -Xlint:unchecked for details.
- JUnit (incluso nella cartella `lib`)
- hamcrest-core-1.3.jar (incluso nella cartella lib)

### Compilare il progetto

Per compilare il progetto, eseguire il comando:

```sh
javac -cp lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar -d bin src/myAdapter/*.java src/myTest/*.java
```

### Eseguire il progetto

Per eseguire il progetto, eseguire il comando:

```sh
java -cp bin:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar myTest.TestRunner
```

Altrimenti tramite il file ```run_tests.sh```, Per rendere eseguibile lo script, esegui il seguente comando nella directory principale del progetto:
```sh
chmod +x run_tests.sh
```
E dopo aver eseguito tale programma si può eseguire il file direttamente dal terminale utilizzando il comando
```sh
./run_tests.sh
```