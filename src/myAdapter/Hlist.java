package myAdapter;

/**
 * Una Collection ordinata nota anche come sequenza 
 * 
 * L'utilizzatore dell'interfaccia ha il pieno controllo di dove vengono inseriti gli elementi.
 * Presenta un iteratore che permette l'inserimento e la sostituzione degli elementi. 
 * L'accesso agli elementi avviene tramite indici di tipo integer. Questa interfaccia estende 
 * l'interfaccia {@link HCollection}.
 * */
public interface HList extends HCollection {    
    
    /**
     * Inserisce gli elementi specifici nella posizione specifica nella lista/sequenza
     * 
     * @param index parametro di tipo int
     * @param element parametro di tipo oggetto
     */
    public void add(int index, Object element);
    
    /**
     * Aggiunge tutti gli elementi della specifica collection 
     * in una specifica posizione della lista, 
     * 
     * @param index parametro di tipo int
     * @param c paramentro di tipo HCollection
     * @return true se è avvenuta una modifica alla lista
     */
    public boolean addAll(int index, HCollection c);

    /**
     * Restituisce l'elemento alla specifica posizione nella lista.
     * 
     * @param index parametro di tipo int
     * @return elemento di tipo Object alla data posizione
     */
    public Object get(int index);

    /**
     * Restituisce l'indice nella lista della prima occorenza dell'elemento specificato o,
     * se non è presente nella lista, lancia eccezione
     * 
     * @param o parametro di tipo Object
     * @return indice nella lista della prima occorrenza dell'elemento specificato
     */
    public int indexOf(Object o);

    /**
     * 
     * @param o
     * @return
     */
    public int lastIndexOf(Object o);

    /**
     * 
     * @return
     */
    public HListIterator listIterator();

    /**
     * 
     * @param index
     * @return
     */
    public HListIterator listIterator(int index);

    /**
     * 
     * @param index
     * @return
     */
    public Object remove(int index);

    /**
     * 
     * @param index
     * @param element
     * @return
     */
    public Object set(int index, Object element);

    /**
     * 
     * @param fromIndex
     * @param toIndex
     * @return
     */
    public HList subList(int fromIndex, int toIndex);

}