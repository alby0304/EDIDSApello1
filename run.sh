# Compilare i file Java
javac -cp lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar -d bin src/myAdapter/*.java src/myTest/*.java

# Verifica se la compilazione è stata completata con successo
if [ $? -eq 0 ]; then
    echo "Compilazione completata con successo."
    # Esecuzione dei test
    echo "Esecuzione dei test..."
    java -cp bin:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar myTest.TestRunner
else
    echo "Errore durante la compilazione del codice sorgente. Impossibile eseguire i test."
fi