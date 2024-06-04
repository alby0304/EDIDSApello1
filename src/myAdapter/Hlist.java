package myAdapter;

/**
 * <h1>
 * Una Collection ordinata nota anche come sequenza 
 * </h1>
 * <p>
 * L'utilizzatore dell'interfaccia ha il pieno controllo di dove vengono inseriti gli elementi.
 * Presenta un iteratore che permette l'inserimento e la sostituzione degli elementi. 
 * L'accesso agli elementi avviene tramite indici di tipo integer. Questa interfaccia estende 
 * l'interfaccia {@link HCollection}.
 * </p>
 * */
public interface HList extends HCollection {    
    
    /**
     * <p>
     * Inserisce gli elementi specifici nella posizione specifica nella lista/sequenza
     * </p>
     * 
     * @param index parametro di tipo int
     * @param element parametro di tipo oggetto
     * @throws ClassCastException se il tipo dell'elemento specificato non è compatibile con questo elenco; 
     * @throws NullPointerException se l'elemento specificato è null e questo elenco non supporta elementi null
     * @throws UnsupportedOperationException se il metodo di rimozione non è supportato da questo elenco.
     */
    public void add(int index, Object element);
    
    /**
     * <p>
     * Aggiunge tutti gli elementi della specifica collection 
     * in una specifica posizione della lista,
     * </p>
     * 
     * @param index parametro di tipo int
     * @param c paramentro di tipo HCollection
     * @return true se è avvenuta una modifica alla lista
     * @throws UnsupportedOperationException se il metodo addAll non è supportato da questo elenco
     * @throws ClassCastException se la classe di un elemento nella raccolta specificata impedisce che venga aggiunto a questo elenco
     * @throws NullPointerException se la raccolta specificata contiene uno o più elementi null e questo elenco non supporta elementi null oppure se la raccolta specificata è null
     * @throws IllegalArgumentException se qualche aspetto di un elemento nella raccolta specificata impedisce che venga aggiunto a questo elenco
     */
    public boolean addAll(int index, HCollection c);

    /**
     * <p>
     * Restituisce l'elemento alla specifica posizione nella lista.
     * </p>
     * 
     * @param index parametro di tipo int
     * @return elemento di tipo Object alla data posizione
     * @throws IndexOutOfBoundsException se l'indice è fuori intervallo (indice < 0 || indice >= dimensione()).
     */
    public Object get(int index);

    /**
     * <p>
     * Restituisce l'indice nella lista della prima occorenza dell'elemento specificato o,
     * se non è presente nella lista, restituisce -1
     * </p>
     * 
     * @param o parametro di tipo Object
     * @return indice nella lista della prima occorrenza dell'elemento specificato, o -1 se la lista non contiene l'elemento
     * @throws NullPointerException se l'elemento specificato è nullo e non sono supportati elementi nulli
     * @throws ClassCastException se il tipo dell'elemento specificato è incompatibile con questo elenco
     * @throws IndexOutOfBandsException se l'indice è fuori dall'intervallo
     */
    public int indexOf(Object o);

    /**
     * <p>
     * Restituisce l'indice nella lista della ultima occorenza dell'elemento specificato o,
     * se non è presente nella lista, restituisce -1
     * More formally, returns the highest index i such that (o==null ? get(i)==null : o.equals(get(i))), or -1 if there is no such index.
     * </p>
     * 
     * @param o parametro di tipo Object
     * @return indice nella lista della ultima occorrenza dell'elemento specificato, o -1 se la lista non contiene l'elemento
     * @throws ClassCastException se il tipo dell'elemento specificato non è compatibile con questo elenco.
     * @throws NullPointerException - se l'elemento specificato è null e questo elenco non supporta elementi null.
     */
    public int lastIndexOf(Object o);

    /**
     * <p>
     *  Restituisce un iteratore di lista degli elementi in questa lista (nella sequenza corretta)
     * </p>
     * 
     * @return un iteratore della lista degli elementi in questa lista (nella sequenza corretta)
     */
    public HListIterator listIterator();

    /**
     * <p>
     * Restituisce un iteratore di lista degli elementi in questa lista (nella sequenza corretta),
     * </p>
     * 
     * @param index parametro di tipo int
     * @return Un iteratore della lista degli elementi in questa lista (nella sequenza corretta), a partire dalla posizione specificata in questa lista.
     * @throws IndexOutOfboundsException se l'indice è fuori dal range (indice < 0 || indice > size())
     */
    public HListIterator listIterator(int index);

    /**
     * <p>
     * Rimuove l'elemento nella posizione specificata in questa lista
     * Sposta gli elementi successivi a sinistra (sottrae uno dai loro indici). Restituisce l'elemento che è stato rimosso dalla lista
     * </p>
     * 
     * @param index parametro di tipo int
     * @return l'elemento precedentemente nella posizione specificata
     * @throws UnsupportedOperationException se il metodo remove non e' supportato dalla lista
     * @throws ArrayIndexOutOfBoundsException se l'indice e' fuori dal range (indice < 0 || indice > size())
     */
    public Object remove(int index);

    /**
     * <p>
     * Sostituisce l'elemento nella posizione specificata in questo elenco con l'elemento specificato
     * </p>
     * 
     * @param index parametro di tipo int, indice dell'elemento da rimpiazzare
     * @param element parametro di tipo int che indica l'elemento da memorizzare nella posizione specificata 
     * @return ritorna l'elemento presente precedentemente nella posizione specificata
     * @throws NullPointerException se l'elemento specificato è null e l'elenco non supporta elementi null
     * @throws ClassCastException se la classe dell'elemento specificato impedisce che venga aggiunta a questo elenco
     * @throws IndexOutOfBoundsException se l'indice è fuori dall'intervallo
     */
    public Object set(int index, Object element);

    /**
     * <p>
     * Restituisce una vista della parte di quest'elenco da fromIndex,incluso e toIndex escluso. Le modifiche non strutturali 
     * nell'elenco restituito si riflettono in questo elenco e viceversa. L'elenco restituito supporta tutte le operazioni
     * supportate da questo elenco
     * </p>
     * 
     * @param fromIndex parametro di tipo int che funge da indice minimo
     * @param toIndex parametro di tipo int che funge da indice massimo
     * @return ritorna una Hlist contenente l'intervallo specificato
     * @throws IndexOutOfBoundsException - per un valore di indice endpoint non valido (fromIndex < 0 || toIndex > size || fromIndex > toIndex).
     */
    public HList subList(int fromIndex, int toIndex);

}