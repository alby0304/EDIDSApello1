/**
 * @hide
 */
package myAdapter;

/**
 * <p>
 * Gli iteratori nelle collezioni prendono il posto delle enumerazioni da cui differiscono in due modi:
 * consentono al chiamante di rimuovere elementi dalla raccolta sottostante durante l'iterazione
 * i nomi dei metodi vengono migliorati
 * </p>
 */
public interface HIterator {

    /**
     * <p>
     * Restituisce true se l'iterazione ha più elementi.
     * </p>
     * 
     * @return ritorna true se l'iterazione ha più elementi
     */
    public boolean hasNext();

    /**
     * <p>
     * Restituisce l'elemento successivo nell'iterazione.
     * </p>
     * 
     * @return ritorna l'elemto successivo nell'iterazione 
     * @throws NoSuchElementException se non ci sono più elementi
     */
    public Object next();

    /**
     * <p>
     * Rimuove dall'insieme l'ultimo elemento restituito dall'iteratore. Il comportamento dell'iteratore
     * non è specificato se l'insieme sottostante viene modificato mentre è in corso l'iterazione 
     * </p> 
     * 
     * @throws UnsupportedOperationException: se l'operazione di rimozione non è supportata da questo iteratore dell'elenco
     * @throws IllegalStateException: non sono stati chiamati né il successivo né il precedente, oppure la rimozione o l'aggiunta sono state chiamate dopo l'ultima chiamata a * successivo o precedente.
     */
    public void remove();
    
}

