package myAdapter;

/**
 * <h1>
 * An iterator for traversing a list bidirectionally.
 * </h1>
 * <p>
 * This interface extends the {@link HIterator} interface and provides additional methods
 * to add, remove, and modify elements in a list.
 * </p>
 * 
 * @see HIterator
 * @since Java Unit 4
 */
public interface HListIterator extends HIterator {
    
    /**
     * <p>
     * Inserisce l'elemento specificato nella lista
     * L'elemento viene inserito immediatamente prima del prossimo elemento 
     * che verrebbe restituito da next, se presente, e dopo il prossimo elemento che 
     * verrebbe restituito da previous, se presente. 
     * (Se la lista non contiene elementi, il nuovo elemento diventa l'unico elemento della lista.) 
     * Il nuovo elemento viene inserito prima del cursore implicito: una chiamata successiva a next non 
     * ne sarebbe influenzata, e una chiamata successiva a previous restituirebbe il nuovo elemento.
     * (Questa chiamata aumenta di uno il valore che verrebbe restituito da una chiamata a nextIndex o 
     * previousIndex.)
     * </p>
     * 
     * @param o parametro di tipo Object, 
     * @return l'elemento con cui sostituire l'ultimo elemento restituito da next o previous.
     * @throws NullPointerException 
     * @throws ClassCastException se la classe dell'elemento specificato impedisce che venga aggiunto a questo elenco 
     */
    public void add(Object o);
    
    /**
     * <p>
     * Restituisce true se questo iteratore della lista ha più elementi quando si attraversa la lista in direzione inversa
     * In altre parole, restituisce true se previous restituirebbe un elemento anziché lanciare un'eccezione
     * </p>
     * 
     * @return true se l'iteratore della lista ha un elemento precedente, false altrimenti
     */
    public boolean hasPrevious();
    
    /**
     * <p>
     * Restituisce l'indice dell'elemento che verrebbe restituito da una chiamata successiva a next
     * Restituisce la dimensione della lista se l'iteratore della lista è alla fine della lista
     * </p>
     * 
     * @return l'indice del prossimo elemento
     */
    public int nextIndex();
    
    /**
     * <p>
     * Restituisce l'elemento precedente nella lista. Questo metodo può essere chiamato ripetutamente per iterare attraverso la lista all'indietro, o alternato con chiamate a next per andare avanti e indietro. 
     * Nota che le chiamate alternate a next e previous restituiranno lo stesso elemento ripetutamente.
     * </p>
     * 
     * @return l'elemento precedente nell'elenco
     * @throws NoSuchElementException se l'iterazione non ha elementi precedenti
     */
    public Object previous();
    
    /**
     * <p>
     * Restituisce l'indice dell'elemento che verrebbe restituito da una chiamata successiva a previous. 
     * Restituisce -1 se l'iteratore della lista è all'inizio della lista.
     * </p>
     * 
     * @return l'indice dell'elemento che verrebbe restituito da una chiamata successiva a previous
     *  oppure -1 se l'iteratore della lista è all'inizio della lista.
     */
    public int previousIndex();
    
    /**
     * <p>
     * Sostituisce l'ultimo elemento restituito dalla chiamata più recente a {@link #next} 
     * o {@link #previous} con l'elemento specificato.
     * Questo metodo può essere chiamato solo dopo una chiamata a {@link #next}
     * o {@link #previous} è stato effettuato, ma non dopo una chiamata a {@link #remove} 
     * o {@link #add}.
     * </p>
     *
     * @param o parametro di tipo Object da impostare
     * @throws IllegalStateException se non sono stati chiamati né {@link #next} né {@link #previous},
     *  oppure {@link #remove} o {@link #add} sono stati chiamati dopo l'ultima chiamata a {@link #next} 
     * o {@ collegamento #precedente}
     * @throws NullPointerException
     * @throws ClassCastException se la classe dell'elemento specificato impedisce che venga aggiunto a questo elenco
     * @throws ArrayIndexOutOfBoundsException
     */
    public void set(Object o);
    
}
