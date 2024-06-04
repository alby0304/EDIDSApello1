/**
 * @hide
 */
package myAdapter;

/**
 * <p>
 * L'interfaccia Collection viene utilizzata per rappresentare 
 * un gruppo di oggetti noti come i suoi elementi.
 * Viene in genere utilizzata per passare le collezioni 
 * e manipolarle dove si desidera la massima generalità.
 * </p>
 */
public interface HCollection {
 
    /**
     * <p>
     * Restituisce un iteratore sugli elementi di questa raccolta.
     * </p>
     * 
     * @return restituisce un iteratore relativo agli elementi della raccolta 
     */
    public HIterator iterator();
    
    
    /**
     * <p>
     * Assicura che la raccolta contenga l'elemento specificato
     * </p>
     * 
     * @param o paramatro di tipo oggetto 
     * @return  restituisce true se questa raccolta è stata modificata a seguito della chiamata,
     *          false se la raccolta non consente duplicati e contiene già l'elemento 
     */
    public boolean add(Object o);

    /**
     * <p>
     * Aggiunge tutti gli elementi del tipo specificato alla raccolta
     * </p> 
     * 
     * @param c parametro di tipo HCollection 
     * @return ritorna true se la collezione è cambiata in seguito alla chiamata 
     * @throws NullPointerException se l'insieme specificato contiene uno o più elementi nulli o è nullo
     */
    public boolean addAll(HCollection c);

    /**
     * <p>
     * Rimuove tutti gli elementi da questa raccolta. La raccolta sarà vuota dopo il ritorno di questo metodo
     * a meno che non lanci un'eccezione 
     * </p>
     */
    public void clear();

    /**
     * <p>
     * Restituisce vero se questa raccolta contiene l'elemento specificato
     * </p>
     * 
     * @param o elemento di tipo Object la cui presenza nella collezione deve essere testata 
     * @return ritorna true se la collezione contiene l'elemento specificato
     * @throws NullPointerException se l'elemento specificato è nullo e questa raccolta non supporta elementi nulli
     * @throws ClassCastException se il tipo  dell'elemento specificato è incompatibile con la raccolta 
     */
    public boolean contains(Object o);

    /**
     * <p>
     * Restituisce vero se questa raccolta contiene tutti gli elementi nella raccolta specificata.
     * </p>
     * 
     * @param c parametro di tipo Hcollection da controllare per il contenimento in questa collezione 
     * @return restituisce true se questa raccolta contiene tutti gli elementi dell'insieme specificato
     */
    public boolean containsAll(HCollection c);

    /**
     * <p>
     * Confronta l'oggetto specificato con questa raccolta 
     * </p>
     * 
     * @param o parametro di tipo Object inserito nella raccolta 
     * @return true se l'oggetto specificato è uguale a quelli inseriti nella raccolta 
     */
    public boolean equals(Object o);

    /**
     * <p>
     * Restituisce il valore del codice hash per questa raccolta.
     * </p>
     * 
     * @return restituisce il valore del codice hash per questa raccolta
     */
    public int hashCode();
    
    /**
     * <p>
     * Restituisce vero se questa raccolta non contiene elementi.
     * </p>
     * 
     * @return ritorna true se la collezione non contiene elementi  
     */
    public boolean isEmpty();

    /**
     * <p>
     * Rimuove una singola istanza dell'elemento specificato da questa raccolta se presente
     * </p>
     * @param o parametro di tipo Object da rimuovere se presente 
     * @return restituisce true se questa raccolta conteneva l'elemento specificato
     * @throws NullPointerException se l'elemento specificato è nullo e la raccolta non supporta elementi nulli
     * @throws ClassCastException se il tipo dell'elemento specificato è incompatibile con questa raccolta 
     */
    public boolean remove(Object o);

    /**
     * <p>
     * Rimuove tutti gli elementi di questa raccolta che sono contenuti anche nella raccolta specificata 
     * </p>
     * 
     * @param c parametri di tipo HCollection da rimuovere 
     * @return ritorna true se la collezione è cambiata in seguito alla chiamata
     * @throws NullPointerException se questa raccolta contiene uno o più elementi nulli
     */
    public boolean removeAll(HCollection c);

    /**
     * <p>
     * Mantiene solo gli elementi di questa raccolta contenuti nella raccolta specificata
     * </p> 
     * 
     * @param c parametro di tipo HCollection da conservare 
     * @return ritorna true se la collezione cambia in seguito alla chiamata 
     * @throws NullPointerException se la collezione specificata è nulla 
     */
    public boolean retainAll(HCollection c);

    /** 
     * <p>
     * Restituisce il numero di elementi in questa raccolta. Se questa raccolta contiene più 
     * di elementi Integer.MAX_VALUE, restituisce Integer.MAX_VALUE
     * </p>
     * 
     * @return ritorna il numero di elementi nella collezione 
     */
    public int size();

    /**
     * <p>
     * Restituisce un array contenente tutti gli elementi di questa raccolta; 
     * il tipo di runtime dell'array restituito è quello dell'array specificato. 
     * Se la raccolta rientra nell'array specificato, viene restituita al suo interno. 
     * In caso contrario, viene allocato un nuovo array con il tipo di runtime dell'array specificato e la dimensione di questa raccolta
     * </p>
     * 
     * @return restituisce un array contenente tutti gli elementi di questa raccolta e fornisce garanzie sull'ordine 
     *         in cui i suoi elementi vengono restituiti dall'iteratore 
     */
    public Object[] toArray();

    /** 
     * <p>
     * Il tipo restituito è lo stessodi quello specificato. Se la raccolta rientra nell'array specificato viene restituita in essa. 
     * In caso contrario viene allocato un nuovo array con il tipo dell'array specificato e le dimensioni di questa raccolta. 
     * Questa raccolta fornisce anche garanzie sull'ordine in cui i suoi elementi vengono restituiti.
     * </p>
     * 
     * @param a array in cui gli elementi di questa raccolta devono essere retituiti 
     * @return restituisce un array contenente tutti gli elementi di questa raccolta.
     */
    public Object[] toArray(Object[] a);
    
}

