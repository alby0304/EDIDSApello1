
# Compilare i file Java
javac -cp "junit/junit-4.12.jar;lib/hamcrest-core-1.3.jar" src/myAdapter/*.java src/myTest/*.java


# Verifica se la compilazione è stata completata con successo
if [ $? -eq 0 ]; then
    echo "Compilazione completata con successo."
    # Esecuzione dei test
    echo "Esecuzione dei test..."
    java -cp .:"junit/junit-4.12.jar;lib/hamcrest-core-1.3.jar" myTest.TestRunner
else
    echo "Errore durante la compilazione del codice sorgente. Impossibile eseguire i test."
fi