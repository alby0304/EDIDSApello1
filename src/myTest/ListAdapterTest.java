package myTest;

import myAdapter.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.NoSuchElementException;

public class ListAdapterTest {

    ListAdapter list;

    @Before
    public void setup()
    {
        list=new ListAdapter();
    }


   /**
    * SUMMARY: Test che prova il funzionamento del metodo 'public boolean add(Object o)' di ListAdapter aggiungendo un valore di tipo intero.
    * 
    * TEST DESIGN: Test che valuta se in seguito alla creazione di una lista e all'invocazione di list.add(add) l'elemento è effettivamente stato inserito
    * 
    * TEST DESCRIPTION: creo variabile costante add di valore 1, creo una lista di tipo ListAdapter, passo il valore al metodo add()
    * e stabilisco se è avvenuta l'aggiunta.
    * 
    * PRECONDITION: esistenza di una list vuota.
    * 
    * POSTCONDITION: lista con un elemento aggiunto.
    * 
    * EXPECTED RESULTS: int add
    */
    @Test
    public void add() {
        final int add = 1;
        
        list.add(add);
        assertEquals(add, list.get(0));
    }


    /**
     * SUMMARY: Test che valuta se il metodo 'public boolean add(Object o)' lancia un' eccezione 
     * 
     * TEST DESIGN: Test che valuta se in seguito all'aggiunta di un valore null alla lista viene lanciata un'eccezione 
     * 
     * TEST DESCRIPTION: invoco il metodo add() passando come parametro un null e mi aspetto il lancio di un'eccezione
     * 
     * PRECONDITION: Esistenza di una lista 
     *  
     * POSTCONDITION: Lancio di un'eccezione 
     * 
     * EXPECTED RESULTS: NullPointerException     
     */
    @Test(expected = NullPointerException.class)
    public void addNullPointerException() {
        assertTrue(list.add(null));
    }

    
    /**
     * SUMMARY: Test che valuta il funzionamento del metodo 'public void add(int index, Object element)' 
     * 
     * TEST DESIGN: Test che valuta se in seguito all'inserimento di un elemento nella lista e all'invocazione di list.add(0,add) 
     * l'elemento è effettivamente stato inserito nella posizione indicata
     * 
     * 
     * TEST DESCRIPTION: creo variabile costante add di valore 1, creo una lista di tipo ListAdapter, passo il valore al metodo add()
     * e stabilisco se è avvenuta l'aggiunta.
     * 
     * PRECONDITION: esistenza di una list vuota.
     * 
     * POSTCONDITION: lista con un elemento aggiunto.
     * 
     * EXPECTED RESULTS: add
     */
    @Test
    public void addIndex() {
        final int add = 1;
        
        list.add(0, add);
        assertEquals(add, list.get(0));
    }
    
    
    /**
     * SUMMARY: Test che valuta il funzionamento del metodo 'public void add(int index, Object element)'
     * 
     * TEST DESIGN: Test che valuta se in seguito alla creazione di una lista e all'invocazione di list.add(1,null) viene lanciata un'eccezione
     * 
     * TEST DESCRIPTION: invoco il metodo add(1,null) e mi aspetto che venga lanciata un'eccezione 
     * 
     * PRECONDITION: esistenza di una list vuota.
     * 
     * POSTCONDITION: lancio di un'eccezione 
     * 
     * EXPECTED RESULTS: NullPointerException
     */
    @Test(expected = NullPointerException.class)
    public void addAtIndexNullPointerException() {
        list.add(1, null);
    }


   

    /**
    * SUMMARY: Test che valuta l'aggiunta di variabili di vario tipo all'interno della stessa lista. 
    * 
    * TEST DESIGN: test che valuta se in seguito alla creazione di una lista di tipo ListAdapter e all'aggiunta di un parametro int e uno boolean viene lanciata una eccezione. 
    * 
    * TEST DESCRIPTION: creo variabile costante add di valore 1 e variabile bool=true, creo una lista di tipo ListAdapter, passo la variabile add al metodo add() 
    * e successivamente passo bool. Infine stabilisco se ha lanciato l'eccezione ClassCastException.
    * 
    * PRECONDITION: esistenza di una list vuota.
    * 
    * POSTCONDITION: aggiunta di un valore e lancio di un'eccezione.
    * 
    * EXPECTED RESULTS: ClassCastException 
    */
    @Test(expected = ClassCastException.class)
    public void addDifferentType() {
        final int add = 1;
        final boolean bool = true;
        
        list.add(add);
        list.add(bool);
    }


    /**
    * SUMMARY: Test che valuta l'aggiunta consecutiva di due elementi.
    * 
    * TEST DESIGN: Test che valuta se in seguito alla creazione di una lista di tipo ListAdapter e all'aggiunta di due valori risulta inserito anche il secondo.
    * 
    * TEST DESCRIPTION: creo variabile costante add di valore 1, creo una lista di tipo ListAdapter, passo il valore al metodo add()
    * e successivamente gli passo add+1. Ci si aspetta che il secondo valore aggiunto sia pari a 2.
    * 
    * PRECONDITION: esistenza di una list vuota.
    * 
    * POSTCONDITION: presenza di 2 variabili di tipo int nella lista.
    * 
    * EXPECTED RESULTS: 2
    */
    @Test
    public void addDouble() {
        final int add = 1;
        
        list.add(add);
        list.add(add + 1);
        assertEquals(2, list.get(1));
    }


    /**
    * SUMMARY: Test che valuta il funzionamento del metodo 'public boolean remove(Object o)' su un elemento della lista in seguito alla sua aggiunta.
    * 
    * TEST DESIGN: Test che valuta se, in seguito alla creazione di una lista di tipo ListAdapter e all'inserimento di un elemento, la sua rimozione viene eseguita.
    * 
    * TEST DESCRIPTION: creo variabile costante add di valore 2.7, creo una lista di tipo ListAdapter, passo il valore al metodo add()
    * e stabilisco se è avvenuta la sua rimozione.
    * 
    * PRECONDITION: esistenza di una list vuota.
    * 
    * POSTCONDITION: lista vuota
    * 
    * EXPECTED RESULTS: true 
    */
    @Test
    public void addRemoveObj() {
        // uso double perchè con int confonde metodo
        final double add = 2.7;
        
        list.add(add);
        assertEquals(true, list.remove(add));
    }


    /**
    * SUMMARY: Test che valuta il funzionamento del metodo 'Object remove(int index)' di ListAdapter che restituisce il valore dell'elemento che era appena stato inserito nella lista.
    * 
    * TEST DESIGN: Test che valuta se, in seguito alla creazione di una lista di tipo ListAdapter e all'inserimento di un elemento, passandogli la posizione di quest'ultimo la sua rimozione viene eseguita e l'elemento viene restituito.
    * 
    * TEST DESCRIPTION: creo variabile costante add di valore 1, creo una lista di tipo ListAdapter, passo il valore al metodo add()
    * e stabilisco se è avvenuta la rimozione dell'elemento tramite la chiamata al metodo Object remove(int index) (restituisce l'oggetto rimosso dalla lista).
    * 
    * PRECONDITION: esistenza di una list vuota.
    * 
    * POSTCONDITION: lista vuota.
    * 
    * EXPECTED RESULTS: add.
    */
    @Test
    public void addRemoveIndex() {
        final int add = 1;
        
        list.add(add);
        assertEquals(add, list.remove(0));
    }


/**
    * SUMMARY: Test che valuta il funzionamento del metodo 'public boolean addAll(HCollection c)' di ListAdapter che copia in una lista tutti gli elementi di quella passata come parametro.
    * 
    * TEST DESIGN: Test che confronta gli elementi della lista con quelli di un array in seguito alla chiamata del metodo addAll().
    * 
    * TEST DESCRIPTION: creo variabile costante add di valore 1 e array di 3 valori {1,2,3}, creo una lista di tipo ListAdapter, passo il valore al metodo add()
    * e in seguito creo una seconda lista e richiamo 2 volte il metodo add() sulla nuova lista passandogli 2 e 3. Richiamo il metodo addAll() sulla lista1 passandogli la lista2 
    * come parametro e valuto se la lista1 contiene tutti gli elementi aspettati confrontandola con quelli presenti nell'array creato inizialmente (uso il metodo get())
    * 
    * PRECONDITION: esistenza di una list vuota.
    * 
    * POSTCONDITION: lista contenente 3 elementi.
    * 
    * EXPECTED RESULTS: 1,2,3
    */
    @Test
    public void addAll() {
        final int add = 1;
        final int[] giusto = { 1, 2, 3 };
        
        list.add(add);
        HCollection list2 = new ListAdapter();
        list2.add(2);
        list2.add(3);
        list.addAll(list2);
        assertEquals(giusto[0], list.get(0));
        assertEquals(giusto[1], list.get(1));
        assertEquals(giusto[2], list.get(2));
    }

    /** 
     * SUMMARY: Test che valuta il funzionamento del metodo 'public boolean addAll(HCollection c)' che dovrebbe lanciare un'eccezione
     * 
     * TEST DESIGN: Test che in seguito alla creazione di una HCollection e all'invocazione del metodo addAll()
     * lancia una eccezione 
     * 
     * TEST DESCRIPTION: Creo una collezione che inizializzo a null e invoco addAll() che lancia un'eccezione  
     * 
     * PRECONDITION: esistenza di una collezione 
     * 
     * POSTCONDITION: lancio di un'eccezione 
     * 
     * EXPECTED RESULTS: NullPointerException
     */
    @Test(expected = NullPointerException.class)
    public void addAllNullPointerException() {
        HCollection collection = null;
        list.addAll(collection);
    }


    /**
    * SUMMARY: Test che valuta il funzionamento del metodo 'public boolean addAll(int index, HCollection c)' di ListAdapter che copia in una lista gli elementi di quella passata come parametro partendo dall'indice indicato.
    * 
    * TEST DESIGN: Test che confronta gli elementi della lista con quelli di un array in seguito alla chiamata del metodo addAll(int index, HCollection c).
    * 
    * TEST DESCRIPTION: creo variabile costante add di valore 1 e array di 3 valori {1,2,3}, creo una lista di tipo ListAdapter, passo 2 volte il valore al metodo add()
    * e in seguito creo una seconda lista e richiamo 2 volte il metodo add() sulla nuova lista passandogli 2 e 3. Richiamo il metodo addAll() sulla lista1 passandogli l'indice
    * di partenza e la lista2 come parametri e valuto se la lista1 contiene tutti gli elementi aspettati confrontandola con quelli presenti nell'array creato inizialmente (uso il metodo get()).
    * 
    * PRECONDITION: esistenza di una list vuota.
    * 
    * POSTCONDITION: lista contenente 4 elementi.
    * 
    * EXPECTED RESULTS: 1,2,3,1 
    */
    @Test
    public void addAllIndex() {
        final int add = 1;
        final int[] giusto = { 1, 2, 3 };
        
        list.add(add); 
        list.add(add);  
        ListAdapter list2 = new ListAdapter();
        list2.add(2);  
        list2.add(3); 
        list.addAll(1, list2);
        assertEquals(giusto[0], list.get(0));
        assertEquals(giusto[1], list.get(1));
        assertEquals(giusto[2], list.get(2));
        assertEquals(giusto[0], list.get(3));

    }

    
    /**
     * SUMMARY: Test che valuta il funzionamento del metodo 'public boolean addAll(int index, HCollection c)' che dovrebbe lanciare un'eccezione
     * 
     * TEST DESIGN: Test che in seguito all'invocazione del metodo addAll(0,null) lancia una eccezione 
     * 
     * TEST DESCRIPTION: Invoco il metodo addAll(0,null) con paramtri l'indice 0 e null al posto di una HCollection e mi aspetto
     * il lancio di un'eccezione
     * 
     * PRECONDITION: esistenza di una lista 
     * 
     * POSTCONDITION: lancio di un'eccezione 
     * 
     * EXPECTED RESULTS: NullPointerException
     */
    @Test(expected = NullPointerException.class)
    public void addAllAtIndexNullPointerException() {
        list.addAll(0, null);
    }

    //TODO: da visionare
    /**
     * SUMMARY: Test che valuta il funzionamento del metodo 'public boolean addAll(int index, HCollection c)' 
     * che dovrebbe lanciare un'eccezione
     * 
     * TEST DESIGN: Test che in seguito alla creazione di una HCollection e all'invocazione di due metodi add() e del metodo addAll(-1,c)
     * lancia una eccezione 
     * 
     * TEST DESCRIPTION: Creo una collezione che inizializzo 
     * 
     * PRECONDITION: esistenza di una collezione 
     * 
     * POSTCONDITION: lancio di un'eccezione 
     * 
     * EXPECTED RESULTS: IndexOutOfBoundsException
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllAtIndexIndexOutOfBoundsException() {
        HCollection c =  new ListAdapter();
        c.add(1);
        c.add(2);

        list.addAll(-1, c);
    }


    /**
    * SUMMARY: Test che valuta il funzionamento del metodo 'public void clear()' di ListAdapter.
    * 
    * TEST DESIGN: Test che valuta se in seguito all'aggiunta di un elemento la lista viene svuotata.
    * 
    * TEST DESCRIPTION: creo variabile costante add di valore 1, creo una lista di tipo ListAdapter, passo il valore al metodo add()
    * e richiamo il metodo clear() sulla lista. Infine controllo tramite metodo size() se la lista è vuota.
    * 
    * PRECONDITION: esistenza di una list vuota.
    * 
    * POSTCONDITION: lista vuota.
    * 
    * EXPECTED RESULTS: 0
    */
    @Test
    public void clear() {
        final int add = 1;
        
        list.add(add);
        list.clear();
        assertEquals(0, list.size());
    }


    /**
    * SUMMARY: Test che verifica il funzionamento del metodo 'public void contains(Object o)' in seguito all'aggiunta di un elemento add.
    * 
    * TEST DESIGN: Test che valuta se dopo aver creato una lista e inserito un elemento quest'ultimo è effettivamente presente.
    * 
    * TEST DESCRIPTION: creo variabile costante add di valore 1, creo una lista di tipo ListAdapter, passo il valore al metodo add()
    * e richiamo il metodo contains() sulla lista passandogli 1 e controllo se è presente al suo interno.
    * 
    * PRECONDITION: esistenza di una list vuota.
    * 
    * POSTCONDITION: lista contenente 1 elemento
    * 
    * EXPECTED RESULTS: true
    */
    @Test
    public void contains() {
        final int add = 1;
        
        list.add(add);
        assertEquals(true, list.contains(1));
    }

    /**
     * SUMMARY: Test che valuta il funzionamento del metodo 'public boolean contains(Object o)'
     * 
     * TEST DESIGN: Test che valuta se invocando il metodo contains() con un parametro nullo viene lanciata un'eccezione 
     * 
     * TEST DESCRIPTION: Invoco il metodo contains() su una lista e passo come parametro un null 
     * aspettando che venga lanciata una eccezione 
     * 
     * PRECONDITION: Esistenza di una lista 
     * 
     * POSTCONDITION: Lancio di una eccezione 
     * 
     * EXPECTED RESULTS: NullPointerException
     */
    @Test(expected = NullPointerException.class)
    public void containsNullPointerException() {
        assertTrue(list.contains(null));
    }
    
    /**
    * SUMMARY: Test che valuta il funzionamento del metodo 'public boolean containsAll(HCollection c)' di ListAdapter.
    * 
    * TEST DESIGN: Test che valuta se dopo aver creato e iniziallizzato due liste la prima contiene tutti gli elementi della seconda
    * 
    * TEST DESCRIPTION: creo variabile costante add di valore 1, creo una lista di tipo ListAdapter, passo il valore al metodo add()
    * e richiamo add() altre 2 volte passandogli i valori 2 e 3. Creo poi una seconda lista di tipo ListAdapter e aggiungo 2 e 3 al suo interno. 
    * Infine passandogli list2 al metodo containsAll() valuto se list contiene tutti gli elementi di list2.
    * 
    * PRECONDITION: esistenza di una list vuota.
    * 
    * POSTCONDITION: list contenente 3 elementi e list2 contenente 2 elementi.
    * 
    * EXPECTED RESULTS: true
    */
    @Test
    public void containsAll() {
        final int add = 1;
        
        list.add(add);
        list.add(2);
        list.add(3);
        HCollection list2 = new ListAdapter();
        list2.add(2);
        list2.add(3);
        assertEquals(true, list.containsAll(list2));
    }
    
    /**
     * SUMMARY: Test che valuta il funzionamento del metodo 'public boolean containsAll(HCollection c)' di ListAdapter e verifica che questa non 
     * possa contenere elementi nulli.
     * 
     * TEST DESIGN: Test che dopo aver creato una collezione ed aggiunto tre elementi: due valori int e un null 
     * invocando il metodo containsAll() verifica che venga lanciata una eccezione.
     * 
     * TEST DESCRIPTION: Creo una collection di tipo HCollection, aggiungo 1, null e 2 e infine verifico che venga lanciata
     * un'eccezione NullPointerException.
     * 
     * PRECONDITION: Esistenza di una collezione.
     * 
     * POSTCONDITION: Lancio di un'eccezione.
     * 
     * EXPECTED RESULTS: NullPointerException
     */
    @Test(expected = NullPointerException.class)
    public void containsAllElementNullPointerException() {
        HCollection collection = new ListAdapter();
        collection.add(1);
        collection.add(null);
        collection.add(2);
        assertTrue(list.containsAll(collection));
    }

    /**
     * SUMMARY: Test che verifica il funzionamento del metodo 'public boolean containsAll(HCollection c)' di ListAdapter e in particolare che controlla che 
     * venga lanciata l'eccezione NullPointerException.
     * 
     * TEST DESIGN: Test che  dopo aver creato e iniziallizzato a null una collezione verifica che venga lanciata una eccezione.
     * 
     * TEST DESCRIPTION: Inizializzo la collection a null e verifico che mi venga lanciata l'eccezione 
     * NullPointerException.
     * 
     * PRECONDITION: Esistenza di una collezione 
     * 
     * POSTCONDITION: Lancio di una eccezione
     * 
     * EXPECTED RESULTS: NullPointerException   
     */
    @Test(expected = NullPointerException.class)
    public void containsAllCollectionNullPointerException() {
        HCollection collection = null;
        assertTrue(list.containsAll(collection));
    }
    
    /**
    * SUMMARY: Test che verifica il funzionamento del metodo ' public boolean equals(Object o)' di ListAdapter e confronta 2 liste.
    * 
    * TEST DESIGN: Test che valuta se dopo aver creato e inizializzato due liste la prima è uguale alla seconda.
    * 
    * TEST DESCRIPTION: Creo una lista di tipo ListAdapter e aggiungo i valori 1 e 2, poi creo una seconda lista list2 e aggiungo 
    * nuovamente 1 e 2. Infine controllo se list ha gli stessi elementi di list2 e viceversa.
    * 
    * PRECONDITION: esistenza di una list vuota.
    * 
    * POSTCONDITION: 2 liste con stessi elementi.
    * 
    * EXPECTED RESULTS: true, true.
    */
    @Test
    public void equals() {
        
        list.add(1);
        list.add(2);
        ListAdapter list2 = new ListAdapter();
        list2.add(1);
        list2.add(2);
        assertEquals(true, list.equals(list));
        assertEquals(true, list.equals(list2));
    }
    
    
    
    /**
    * SUMMARY: Test che controlla il funzionamento del metodo 'public Object get(int index)' di ListAdapter.
    * 
    * TEST DESIGN: Test che valuta se dopo aver creato e inizializzato una lista, l'elemento aggiunto si trova in posizione 0.
    * 
    * TEST DESCRIPTION: creo variabile costante add di valore 1, creo una lista di tipo ListAdapter, passo il valore al metodo add()
    * e controllo che in posizione 0 sia presente il valore add tramite metodo get().
    * 
    * PRECONDITION: esistenza di una list vuota.
    * 
    * POSTCONDITION: lista con 1 elemento.
    * 
    * EXPECTED RESULTS: add
    */
    @Test
    public void get() {
        final int add = 1;
        
        list.add(add);
        assertEquals(add, list.get(0));
    }

    
    /**
     * SUMMARY: Test che verifica il funzionamento del metodo ' public Object get(int index)' di ListAdapter che dovrebbe lanciare
     * IndexOutOfBoundsException
     * 
     * TEST DESIGN: Test che valuta se in seguito all'invocazione del metodo get() passandogli un indice negativo in una lista vuota viene lanciata un'eccezione
     * 
     * TEST DESCRIPTION: Creo una lista vuota, richiamo il metodo get e passo l'indice -1. Verifico quindi che venga lanciata un'eccezione IndexOutOfBoundsException.
     * 
     * PRECONDITION: esistenza di una lista vuota.
     * 
     * POSTCONDITION: lancio di un'eccezione.
     * 
     * EXPECTED RESULTS: IndexOutOfBoundsException.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void getIndexOutOfBoundsException() {
        list.get(-1);
    }


    
    /**
     * SUMMARY: Test che verifica il funzionamento del metodo 'public boolean remove(Object o)' di ListAdapter
     * 
     * TEST DESIGN: Test che valuta se in seguito all'aggiunta e alla rimoazione di un elemento da una lista inizialmente vuota 
     * questa torna ad esserlo 
     * 
     * TEST DESCRIPTION: Aggiungo un elemento alla lista e verifico che l'elemento mi venga rimosso tramite metodo remove() e che venga restituito true 
     * se prima della rimozione la lista conteneva l'elemento. Infine verifico che la lista sia vuota dopo la rimozione.
     * 
     * PRECONDITION: esistenza di una lista vuota
     * 
     * POSTCONDITION: esistenza di una lista vuota
     * 
     * EXPECTED RESULTS: 0
     */
    @Test
    public void remove() {
        list.add("elemento");
        assertTrue(list.remove("elemento"));
        assertEquals(0, list.size());
    }

    
    /**
     * SUMMARY: Test che verifica il funzionamento del metodo ' public boolean remove(Object o)' di ListAdapter
     * 
     * TEST DESIGN: Test che valuta che il metodo remove() a cui è passato come parametro un null lanci un'eccezione 
     * 
     * TEST DESCRIPTION: Verifico che richiamando il metodo remove() e passandogli null, venga lanciata l'eccezione
     * NullPointerException.
     * 
     * PRECONDITION: esistenza di una lista vuota
     * 
     * POSTCONDITION: lancio di un'eccezione
     * 
     * EXPECTED RESULTS: IndexOutOfBoundsException
     */
    @Test(expected = NullPointerException.class)
    public void removeNullPointerException() {
        assertTrue(list.remove(null));
    }

    
    /**
    * SUMMARY: Test che verifica il funzionamento del metodo 'public int hashCode()' di ListAdapter.
    * 
    * TEST DESIGN: Test che dopo aver creato una lista e aggiunto un elemento restituisce l'hashCode. 
    * 
    * TEST DESCRIPTION: creo variabile costante add di valore 1, creo una lista di tipo ListAdapter, passo il valore al metodo add(). 
    * Poi creo una variabile int n=32 e stabilisco se il valore restituito dal metodo hashCode() applicato alla lista è ugaule a 32.
    * 
    * PRECONDITION: esistenza di una list vuota.
    * 
    * POSTCONDITION: lista con 1 elemento.
    * 
    * EXPECTED RESULTS: n
    */
    @Test
    public void testHashCode() {
        final int add = 1;
        
        list.add(add);
        int n = 32;
        assertEquals(n, list.hashCode());

    }

    
    /**
    * SUMMARY: Test che verifica il funzionamento del metodo ' public int indexOf(Object o)' di ListAdapter.
    * 
    * TEST DESIGN: Test che dopo aver creato una lista e aggiunto un elemento restituisce l'indice della sua prima occorrenza
    * 
    * TEST DESCRIPTION: creo variabile costante add di valore 1, creo una lista di tipo ListAdapter, passo il valore al metodo add()
    * e controllo che add sia in posizione 0 tramite metodo indexOf(add).
    * 
    * PRECONDITION: esistenza di una list vuota.
    * 
    * POSTCONDITION: lista con 1 elemento.
    * 
    * EXPECTED RESULTS: 0
    */
    @Test
    public void indexOF() {
        final int add = 1;
        
        list.add(add);
        assertEquals(0, list.indexOf(add));
    }

    
    /**
     * SUMMARY: Test che verifica il funzionamento del metodo 'public int indexOf(Object o)' di ListAdapter 
     * che dovrebbe lanciare un'eccezione.
     * 
     * TEST DESIGN: Test che verifica se in seguito all'invocazione del metodo indexOf() a cui e passato un null 
     * viene lanciata l'eccezione NullPointerException.
     * 
     * TEST DESCRIPTION: Verifico che passando un oggetto null a indexOf() venga lanciata l'eccezione NullPointerException.
     * 
     * PRECONDITION: esistenza di una lista vuota.
     * 
     * POSTCONDITION: lancio di un'eccezione.
     * 
     * EXPECTED RESULTS: NullPointerException
     */
    @Test(expected = NullPointerException.class)
    public void indexOfNullPointerException() {
        assertEquals(0, list.indexOf(null));
    }

    
    /**
    * SUMMARY: Test che verifica il funzionamento del metodo ' public boolean isEmpty()' di ListAdapter.
    * 
    * TEST DESIGN: Test che dopo aver creato una lista e aggiunto un elemento controlla che non sia vuota.
    * 
    * TEST DESCRIPTION: creo variabile costante add di valore 1, creo una lista di tipo ListAdapter, passo il valore al metodo add()
    * e controllo che la lista non sia vuota tramite il metodo isEmpty() (deve restituire false).
    * 
    * PRECONDITION: esistenza di una list vuota.
    * 
    * POSTCONDITION: lista con 1 elemento
    * 
    * EXPECTED RESULTS: false
    */
    @Test
    public void isEmpty() {
        final int add = 1;
        
        list.add(add);
        assertEquals(false, list.isEmpty());
    }

    
    /**
    * SUMMARY: Test che verifica il funzionamento del metodo 'public HIterator iterator()' di ListAdapter.
    * 
    * TEST DESIGN: 
    * 
    * TEST DESCRIPTION: 
    * 
    * PRECONDITION: esistenza di una list vuota.
    * 
    * POSTCONDITION:
    * 
    * EXPECTED RESULTS: it
    */
    @Test
    public void iterator() {
        final int add = 1;
        
        HIterator it = list.iterator();
        assertEquals(it, list.iterator());
    }

    
    /**
    * SUMMARY: Test che verifica il funzionamento del metodo ' public int lastIndexOf(Object o)' di ListAdapter.
    * 
    * TEST DESIGN: Test che crea una lista e dopo aver aggiunto due volte lo stesso elemento restituisce la sua ultima occorrenza nella lista
    * 
    * TEST DESCRIPTION: creo variabile costante add di valore 1, creo una lista di tipo ListAdapter, passo il valore al metodo add() 2 volte
    * e controllo che l'occorrenza dell'ultimo elemento inserito sia 1 tramite metodo lastIndexOf(add).
    * 
    * PRECONDITION: esistenza di una list vuota.
    * 
    * POSTCONDITION: lista con 2 elementi
    * 
    * EXPECTED RESULTS: 1
    */
    @Test
    public void lastIndexOf() {
        final int add = 1;
        
        list.add(add);
        list.add(add);
        assertEquals(1, list.lastIndexOf(add));
    }

    
    /**
     * SUMMARY: Test che verifica il funzionamento del metodo 'public int lastIndexOf(Object o)' di ListAdapter 
     * che dovrebbe lanciare un'eccezione 
     * 
     * TEST DESIGN: Test che verifica se in seguito all'invocazione di lastIndexOf() a cui è passato come parametro un null
     * viene lanciata l'eccezione NullPointerException
     * 
     * TEST DESCRIPTION: Verifico che passando un oggetto null a lastIndexOf() venga lanciata l'eccezione NullPointerException.
     * 
     * PRECONDITION: esistenza di una lista vuota
     * 
     * POSTCONDITION: lancio di un'eccezione
     * 
     * EXPECTED RESULTS: NullPointerException
     */
    @Test(expected = NullPointerException.class)
    public void lastIndexOfNull() {
        assertEquals(0, list.lastIndexOf(null));
    }

    
    /**
    * SUMMARY: 
    * 
    * TEST DESIGN: 
    * 
    * TEST DESCRIPTION:
    * 
    * PRECONDITION: esistenza di una list vuota.
    * 
    * POSTCONDITION
    * 
    * EXPECTED RESULTS: it
    */
    @Test
    public void ListIterator() {
        final int add = 1;
        
        HListIterator it = list.listIterator();
        assertEquals(it, list.iterator());
    }

    
    /**
    * SUMMARY: Test che verifica 
    * 
    * TEST DESIGN: 
    * 
    * TEST DESCRIPTION:
    * 
    * PRECONDITION: esistenza di una list vuota.
    * 
    * POSTCONDITION
    * 
    * EXPECTED RESULTS: add
    */
    @Test
    public void ListIteratorIndex() {
        final int add = 1;
        
        list.add(add);
        assertEquals(add, list.listIterator(0).next());
    }

    
    /**
    * SUMMARY: Test che verifica il corretto funzionamento del metodo ' public boolean removeAll(HCollection c)' di ListAdapter.
    * 
    * TEST DESIGN: Test che crea e inizializza due liste e verifica: 
    * 1) che vengano cancellati gli elementi della seconda lista contenuti anche nella prima  
    * 2) il primo elemento dell'array creato
    * 3) la lunghezza dell'array
    * 
    * TEST DESCRIPTION: creo una lista di tipo ListAdapter e aggiungo 1, 2, 3. 
    * Creo una seconda lista e aggiungo 2 e 3. Utilizzo il metodo removeAll(list2) per rimuovere tutti gli elementi della list2 da list
    * e verifico che sia andata a buon fine l'operazione.
    * Creo un array contenente tutti gli elementi di list e controllo che il primo elemento sia 1 e inoltre che quest'ultimo sia l'unico presente nell'array
    * verificando che sia di lunghezza unitaria.
    * 
    * PRECONDITION: esistenza di una list vuota.
    * 
    * POSTCONDITION: lista e array con 1 elemento.
    * 
    * EXPECTED RESULTS:  true, 1, 1
    */
    @Test
    public void removeAll() {
        
        list.add(1);
        list.add(2);
        list.add(3);
        ListAdapter list2 = new ListAdapter();
        list2.add(2);
        list2.add(3);
        assertEquals(true, list.removeAll(list2));
        Object[] vett = list.toArray();
        assertEquals(1, vett[0]);
        assertEquals(1, vett.length);
    }
    
    
    /**
     * SUMMARY: Test che valuta il funzionamento del metodo 'public boolean removeAll(HCollection c)' di ListAAdapter
     * che dovrebbe lanciare un'eccezione
     * 
     * TEST DESIGN: Test chee crea e inizializza una collezione a null e verifica che invocando removeAll() venga lanciata l'eccezione
     * NullPointerException 
     * 
     * TEST DESCRIPTION: inizializzo una collection c a null e richiamo il metodo removeAll().
     * Verifico che venga lanciata un'eccezione NullPointerException.ovou
     *       
     * PRECONDITION: esistenza di una lista vuota.
     * 
     * POSTCONDITION: Lancio di un'eccezione.
     * 
     * EXPECTED RESULTS: NullPointerException
     * 
     */
    @Test(expected = NullPointerException.class)
    public void removeAllNullPointerException() {
        HCollection c = null;
        list.removeAll(c);
    }

    
    /**
    * SUMMARY: Test che verifica il corretto funzionamento del metodo 'public boolean retainAll(HCollection c)' di ListAdapter.
    * 
    * TEST DESIGN: Test che crea e inizializza due liste e verifica : 
    * 1) che vengano cancellati gli elementi della seconda lista  contenuti anche nella prima  
    * 2) il primo e il secondo elemento dell'array creato
    * 3) la lunghezza dell'array
    * 
    * TEST DESCRIPTION: creo una lista di tipo ListAdapter e aggiungo 1, 2, 3. 
    * Creo una seconda lista e aggiungo 2 e 3. Utilizzo il metodo retainAll(list2) per mantenere tutti gli elementi della list2 in list
    * e verifico che sia andata a buon fine l'operazione.
    * Creo un array contenente tutti gli elementi di list e controllo che siano presenti gli elementi rimasti in list (in questo caso 2 e 3)
    * e inoltre che questi siano gli unici elementi dell'array verificando che abbia la lunghezza prestabilità (in questo caso 2).
    * 
    * PRECONDITION: esistenza di una list vuota.
    * 
    * POSTCONDITION: list e array con 2 elementi
    * 
    * EXPECTED RESULTS: true 2,3,2
    */
    @Test
    public void retainAll() {
        
        list.add(1);
        list.add(2);
        list.add(3);
        ListAdapter list2 = new ListAdapter();
        list2.add(2);
        list2.add(3);
        assertEquals(true, list.retainAll(list2));
        Object[] vett = list.toArray();
        assertEquals(2, vett[0]);
        assertEquals(3, vett[1]);
        assertEquals(2, vett.length);
    }

    
    /**
     * SUMMARY: Test che verifica il funzionamento del metodo 'public boolean retainAll(HCollection c)' di ListAdapter 
     * che dovrebbe lanciare un'eccezione
     * 
     * TEST DESIGN: Test che dopo aver creato e inizializzato una collezione con null verifica che retainAll() 
     * lanci l'eccezione NullPointerException
     * 
     * TEST DESCRIPTION: inizializzo una collection c a null e richiamo il metodo retainAll().
     * Verifico che venga lanciata un'eccezione NullPointerException.
     * 
     * PRECONDITION: esistenza di una lista vuota.
     * 
     * POSTCONDITION: lancio di un'eccezione.
     * 
     * EXPECTED RESULTS: NullPointerException
     */
    @Test(expected = NullPointerException.class)
    public void retainAllNullPointerException() {
        HCollection c = null;
        list.retainAll(c);
    }

    
    /**
    * SUMMARY: Test che verifica il corretto funzionamento del metodo 'public Object set(int index, Object element)' di ListAdapter.
    * 
    * TEST DESIGN: Test che controlla che avvenga la corretta sostituzione di un elemento nella lista con l'elemento passato per parametro a set().
    * 
    * TEST DESCRIPTION: creo una lista di tipo ListAdapter e aggiungo 3 elementi 1, 2, 3. 
    * Richiamo il metodo set() e sostituisco l'elemento in posizione 2 (3) con l'elemento passato come parametro (4). 
    * L'elemento di tipo object restituito lo chiamo remove e valuto che valga esattamente quanto l'elemento precedentemente presente nella list. 
    * Infine controllo sia avvenuta la corretta sostituzione dell'elemento tramite metodo get(2).
    * 
    * PRECONDITION: esistenza di una list vuota.
    * 
    * POSTCONDITION: list con 3 elementi (1, 2, 4).
    *
    * EXPECTED RESULTS: 3,4
    */
    @Test
    public void set() {
        
        list.add(1);
        list.add(2);
        list.add(3);
        Object remove = list.set(2, 4);
        assertEquals(3, remove);
        assertEquals(4, list.get(2));
    }

    
    /**
     * SUMMARY: Test che verifica il funzionamento del metodo 'public Object set(int index, Object element)' di ListAdapter 
     * che dovrebbe lanciare un'eccezione
     * 
     * TEST DESIGN: Test che aggiunge un elemento ad una lista e dopo aver invocato set() verifica che venga lanciata un'eccezione
     * 
     * TEST DESCRIPTION: Aggiungo 1 alla lista e richiamo il metodo set() passandogli null come elemento da inserire nella lista alla posizione 0.
     * Verifico che venga lanciata un'eccezione NullPointerException.
     * 
     * PRECONDITION: esistenza di una list vuota.
     * 
     * POSTCONDITION: list vuota 
     *
     * EXPECTED RESULTS: NullPointerException
     */
    @Test(expected = NullPointerException.class)
    public void setNullPointerException() {
        list.add(1);
        list.set(0, null);
    }


    /**
     * SUMMARY: Test che verifica il funzionamento del metodo 'public Object set(int index, Object element)' di ListAdapter 
     * che dovrebbe lanciare un'eccezione
     * 
     * TEST DESIGN: Test che aggiunge un elemento ad una lista e dopo aver invocato set() verifica che venga lanciata 
     * 
     * TEST DESCRIPTION: Aggiungo 1 alla lista e richiamo il metodo set() passandogli 2 come elemento da inserire nella lista alla posizione -1.
     * Verifico che venga lanciata un'eccezione ArrayIndexOutOfBoundsException.
     * 
     * PRECONDITION: esistenza di una list vuota.
     * 
     * POSTCONDITION: lancio di un'eccezione
     *
     * EXPECTED RESULTS: ArrayIndexOutOfBoundsException
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void setArrayIndexOutOfBoundsException() {
        list.add("1");
        list.set(-1, "2");
    }

    
    /**
    * SUMMARY: Test che verifica il corretto funzionamento del metodo 'public int size()' di ListAdapter.
    * 
    * TEST DESIGN: Test che crea una lista, aggiunge due elementi e verifica che siano effettivamente presenti al suo interno
    * 
    * TEST DESCRIPTION: creo variabile costante add di valore 1, creo una lista di tipo ListAdapter, passo il valore al metodo add() 2 volte
    * e controllo che il numero di elementi inseriti sia 2
    * 
    * PRECONDITION: esistenza di una list vuota.
    * 
    * POSTCONDITION: list con 2 elementi uguali
    * 
    * EXPECTED RESULTS: 2
    */
    @Test
    public void size() {
        final int add = 1;
        
        list.add(add);
        list.add(add);
        assertEquals(2, list.size());
    }


    
    
    /**
     * SUMMARY: Test che valuta il funzionamento del metodo toArray() di ListAdapter.
     * 
     * TEST DESIGN: aggiungendo elementi alla lista verifico che tramite il metodo toArray() (applicato alla lista) venga creato un array che contiene gli stessi elementi
     * 
     * TEST DESCRIPTION: aggiungo 3 elementi alla list (1,2,3), richiamo il metodo toArray() sulla lista 
     * e creo un array di tipo Object. Verifico infine che l'array contenga gli stessi elementi della lista nelle medesime posizioni
     * 
     * PRECONDITION: esistenza di una list vuota.
     * 
     * POSTCONDITION: list e array con 3 elementi (1,2,3)
     * 
     * EXPECTED RESULTS: 
     */
    @Test
    public void toArray() {
        
        list.add(1);
        list.add(2);
        list.add(3);
        Object[] fine = list.toArray();
        assertEquals(list.get(0), fine[0]);
        assertEquals(list.get(1), fine[1]);
        assertEquals(list.get(2), fine[2]);
    }

    
    /**
     * SUMMARY: Test che verifica che passando al metodo toArray(Object[] a) di ListAdapter una stringa, l'array creato viene ridimensionato e prende tutti gli elementi della lista.
     * 
     * TEST DESIGN: Test che passa una stringa di dimensione 2 al metodo toArray() (applicato alla list con 3 elementi). 
     * Viene verificato che l'array creato abbia stessa dimensione di list e che contenga gli stessi elementi della list alle medesime posizioni.
     * 
     * TEST DESCRIPTION: Aggiungo 3 elementi alla list, creo una stringa di dimensione 2 e la passo al metodo toArray() che crea un array (viene ridimensionato in base alle dimensioni della lista).
     * Infine verifico che list e array abbiano stessi elementi nello stesso ordine.
     * 
     * PRECONDITION: esistenza di una list vuota.
     * 
     * POSTCONDITION: list e array con 3 elementi nello stesso ordine.
     * 
     * EXPECTED RESULTS: 1,2,3
    */
    @Test
    public void toArrayObjectArray() {
        
        list.add("1");
        list.add("2");
        list.add("3");
        String[] vet = new String[2];
        Object[] fine = list.toArray(vet); // viene ridimensionato
        assertEquals(list.get(0), fine[0]);
        assertEquals(list.get(1), fine[1]);
        assertEquals(list.get(2), fine[2]);
    }


    /**
     * SUMMARY: Test che verifica il funzionamento del metodo subList() di ListAdapter che crea una sottolista di una list principale precedentemente creata. 
     * 
     * TEST DESIGN: Test che dopo aver aggiunto 3 elementi ad una list, verifica il funzionamento
     * del metodo subList() che crea una sottolista di capacità minore ma che possiede nelle relative posizioni gli stessi elementi 
     * della lista principale. Verifico quindi che aggiungendo elementi alla subList, la modifica avvenga pure all'interno della list principale.
     * 
     * TEST DESCRIPTION: Creo una list di tipo ListAdapter, aggiungo 3 elementi 1, 2, 3.
     * Richiamo il metodo subList(0,1) che restituisce un oggetto di tipo HList che chiamo sub e
     * aggiungo 4. Aggiungo poi il valore 5 in posizione 1. Verifico quindi che in posizione 1 di sub ci sia 
     * il valore 5, inoltre verifico che anche in list in posizione 1 ci sia 5, in posizione 2 ci sia 4 e in posizione 3 ci sia 2.
     * 
     * PRECONDITION: esistenza di una list vuota.
     * 
     * POSTCONDITION: list con 5 elementi(1,5,4,2,3) e subList con 3 elementi (1,5,4)
     * 
     * EXPECTED RESULTS: 5,5,4,2
     */
    @Test
    public void SubList() {
        
        list.add(1);
        list.add(2);
        list.add(3);
        HList sub = list.subList(0, 1);
        sub.add(4);
        sub.add(1, 5);
        assertEquals(5, sub.get(1));
        assertEquals(5, list.get(1));
        assertEquals(4, list.get(2));
        assertEquals(2, list.get(3));
    }

    //TODO: da visionare
    /**
     * SUMMARY: Test che verifica il funzionamento del metodo subList() di ListAdapter che crea una sottolista di una list principale precedentemente creata. 
     * 
     * TEST DESIGN: Test che dopo aver aggiunto 3 elementi ad una list, verifica il funzionamento
     * del metodo subList() che crea una sottolista di capacità minore ma che possiede nelle relative posizioni gli stessi elementi 
     * della lista principale. Verifico quindi che aggiungendo elementi alla subList, la modifica avvenga pure all'interno della list principale.
     * 
     * TEST DESCRIPTION: Creo una list di tipo ListAdapter, aggiungo 3 elementi 1, 2, 3.
     * Richiamo il metodo subList(0,1) che restituisce un oggetto di tipo HList che chiamo sub e
     * aggiungo 4. Aggiungo poi il valore 5 in posizione 1. Verifico quindi che in posizione 1 di sub ci sia 
     * il valore 5, inoltre verifico che anche in list in posizione 1 ci sia 5, in posizione 2 ci sia 4 e in posizione 3 ci sia 2.
     * 
     * PRECONDITION: esistenza di una list vuota.
     * 
     * POSTCONDITION: list con 5 elementi(1,5,4,2,3) e subList con 3 elementi (1,5,4)
     * 
     * EXPECTED RESULTS: 5,5,4,2
     */
    @Test
    public void SubListAdd() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        HList subList = list.subList(2, list.size());

        subList.add(5);
        assertEquals(5, subList.get(subList.size() - 1));
        assertEquals(5, list.get(list.size()-1));
    }
    
    //TODO: da visionare
    /**
     * SUMMARY: Test che verifica il funzionamento del metodo subList() di ListAdapter che crea una sottolista di una list principale precedentemente creata. 
     * 
     * TEST DESIGN: Test che dopo aver aggiunto 3 elementi ad una list, verifica il funzionamento
     * del metodo subList() che crea una sottolista di capacità minore ma che possiede nelle relative posizioni gli stessi elementi 
     * della lista principale. Verifico quindi che aggiungendo elementi alla subList, la modifica avvenga pure all'interno della list principale.
     * 
     * TEST DESCRIPTION: Creo una list di tipo ListAdapter, aggiungo 3 elementi 1, 2, 3.
     * Richiamo il metodo subList(0,1) che restituisce un oggetto di tipo HList che chiamo sub e
     * aggiungo 4. Aggiungo poi il valore 5 in posizione 1. Verifico quindi che in posizione 1 di sub ci sia 
     * il valore 5, inoltre verifico che anche in list in posizione 1 ci sia 5, in posizione 2 ci sia 4 e in posizione 3 ci sia 2.
     * 
     * PRECONDITION: esistenza di una list vuota.
     * 
     * POSTCONDITION: list con 5 elementi(1,5,4,2,3) e subList con 3 elementi (1,5,4)
     * 
     * EXPECTED RESULTS: 5,5,4,2
     */
    @Test
    public void SubListAddAtIndex() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);


        HList subList = list.subList(2, list.size());

        subList.add(1, 5);
        assertEquals(5, subList.get(1));
    }

    //TODO: da visionare
    /**
     * SUMMARY: Test che verifica il funzionamento del metodo subList() di ListAdapter che crea una sottolista di una list principale precedentemente creata. 
     * 
     * TEST DESIGN: Test che dopo aver aggiunto 3 elementi ad una list, verifica il funzionamento
     * del metodo subList() che crea una sottolista di capacità minore ma che possiede nelle relative posizioni gli stessi elementi 
     * della lista principale. Verifico quindi che aggiungendo elementi alla subList, la modifica avvenga pure all'interno della list principale.
     * 
     * TEST DESCRIPTION: Creo una list di tipo ListAdapter, aggiungo 3 elementi 1, 2, 3.
     * Richiamo il metodo subList(0,1) che restituisce un oggetto di tipo HList che chiamo sub e
     * aggiungo 4. Aggiungo poi il valore 5 in posizione 1. Verifico quindi che in posizione 1 di sub ci sia 
     * il valore 5, inoltre verifico che anche in list in posizione 1 ci sia 5, in posizione 2 ci sia 4 e in posizione 3 ci sia 2.
     * 
     * PRECONDITION: esistenza di una list vuota.
     * 
     * POSTCONDITION: list con 5 elementi(1,5,4,2,3) e subList con 3 elementi (1,5,4)
     * 
     * EXPECTED RESULTS: 5,5,4,2
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void SubListAddAtIndexIndexOutOfBoundsException() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        HList subList = list.subList(2, list.size());

        subList.add(-1, 0);
    }


    //TODO: da visionare
    /**
     * SUMMARY: Test che verifica il funzionamento del metodo subList() di ListAdapter che crea una sottolista di una list principale precedentemente creata. 
     * 
     * TEST DESIGN: Test che dopo aver aggiunto 3 elementi ad una list, verifica il funzionamento
     * del metodo subList() che crea una sottolista di capacità minore ma che possiede nelle relative posizioni gli stessi elementi 
     * della lista principale. Verifico quindi che aggiungendo elementi alla subList, la modifica avvenga pure all'interno della list principale.
     * 
     * TEST DESCRIPTION: Creo una list di tipo ListAdapter, aggiungo 3 elementi 1, 2, 3.
     * Richiamo il metodo subList(0,1) che restituisce un oggetto di tipo HList che chiamo sub e
     * aggiungo 4. Aggiungo poi il valore 5 in posizione 1. Verifico quindi che in posizione 1 di sub ci sia 
     * il valore 5, inoltre verifico che anche in list in posizione 1 ci sia 5, in posizione 2 ci sia 4 e in posizione 3 ci sia 2.
     * 
     * PRECONDITION: esistenza di una list vuota.
     * 
     * POSTCONDITION: list con 5 elementi(1,5,4,2,3) e subList con 3 elementi (1,5,4)
     * 
     * EXPECTED RESULTS: 5,5,4,2
     */
    @Test
    public void SubListAddAll() {
        list.add(1);
        list.add(2);
        list.add(3);

        HCollection c = new ListAdapter();
        c.add(4);
        c.add(5);
        c.add(6);

        HList subList = list.subList(1, 2);

        assertTrue(subList.addAll(c));
        assertEquals(6, subList.get(subList.size()-1));
        assertEquals(3, list.get(list.size()-1));
        assertEquals(4, list.get(2));
    }
    
    //TODO: da visionare
    /**
     * SUMMARY: Test che verifica il funzionamento del metodo addAll() sub . 
     * 
     * TEST DESIGN: verficiare il metodo addAll() di sub, creo una collection e la  carico in sub .
     * 
     * TEST DESCRIPTION: Creo una lista, riempio,creo un collection, riempio,creo sub list, eseguo addAll 
     * 
     * PRECONDITION: esistenza di una list vuota.
     * 
     * POSTCONDITION: list con 7 elementi(1,2,5,6,7,3,4) sub (2,5,6,7,3)
     * 
     * EXPECTED RESULTS: sopra
     */
    @Test
    public void SubListAddAllAtIndex() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        HCollection c = new ListAdapter();
        c.add(5);
        c.add(6);
        c.add(7);

        HList subList = list.subList(1, list.size()-1);
        assertTrue(subList.addAll(1, c));
        assertEquals(3, subList.get(subList.size()-1));
        assertEquals(4, list.get(list.size()-1));
    }

    //TODO: da visionare- Tess visto 
    /**
     * SUMMARY: Test che verifica il funzionamento del metodo addAll() sub . 
     * 
     * TEST DESIGN: verficiare il metodo addAll() di sub, creo una collection e la  carico in sub mi aspetto errore.
     * 
     * TEST DESCRIPTION: Creo una lista, riempio,creo un collection, riempio,creo sub list, eseguo addAll verifico errore 
     * 
     * PRECONDITION: esistenza di una list vuota.
     * 
     * POSTCONDITION: errore, lista invariata 
     * 
     * EXPECTED RESULTS: sopra
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void SubListAddAllAtIndexIndexOutOfBoundsException() {
        list.add(1);
        list.add(2);
        list.add(3);

        HCollection c = new ListAdapter();
        c.add(4);
        c.add(5);
        c.add(6);

        HList subList = list.subList(0, 1);
        assertTrue(subList.addAll(-1, c));
    }
    
    //TODO: da visionare-Tess visto
    /**
     * SUMMARY: Test che verifica il funzionamento del metodo clear() sub . 
     * 
     * TEST DESIGN: verficiare il metodo clear() di sub.
     * 
     * TEST DESCRIPTION: Creo lista ,riempio, creo sub,verifico che la sub sia vuota e che la dim della lista sia diminuita 
     * 
     * PRECONDITION: esistenza di una list vuota.
     * 
     * POSTCONDITION: lista esistente 
     * 
     * EXPECTED RESULTS: dim list = 2, d
otos m
     */
    @Test
    public void SubListClear() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        HList subList = list.subList(0, 2);

        subList.clear();
        assertEquals(0, subList.size());
        assertEquals(2, list.size());
    }

    //TODO: da visionare  - Tess visto
    /**
     * SUMMARY: Test che verifica il funzionamento del metodo subList() di ListAdapter che crea una sottolista di una list principale precedentemente creata. 
     * 
     * TEST DESIGN: Test che dopo aver aggiunto 4 elementi ad una list, verifica il funzionamento
     * del metodo subList() che crea una sottolista di capacità minore ma che possiede nelle relative posizioni gli stessi elementi 
     * della lista principale. Verifico quindi che aggiungendo elementi alla subList, la modifica avvenga pure all'interno della list principale.
     * 
     * TEST DESCRIPTION: Creo una list di tipo ListAdapter, aggiungo 4 elementi 1, 2, 3,4.
     * Richiamo il metodo subList(0,2) che restituisce un oggetto di tipo HList che chiamo subList.
     * Eseguo il clear, verifico dimensione sub == 0  e dimensione lista = dimensione lista originale - dim sub tolta 
     * 
     * PRECONDITION: esistenza di una list vuota.
     * 
     * POSTCONDITION: list con 5 elementi(1,5,4,2,3) e subList con 3 elementi (1,5,4)
     * 
     * EXPECTED RESULTS: 5,5,4,2
     */
    @Test
    public void SubListContains() {
        list.add(1);
        list.add(2);
        list.add(3);
        HList subList = list.subList(0, 1);
        assertTrue(subList.contains(1));
    }


    //TODO: da visionare
    /**
     * SUMMARY: Test che verifica il funzionamento del metodo subList() di ListAdapter che crea una sottolista di una list principale precedentemente creata. 
     * 
     * TEST DESIGN: Test che dopo aver aggiunto 4 elementi ad una list, verifica il funzionamento
     * del metodo subList() che crea una sottolista di capacità minore ma che possiede nelle relative posizioni gli stessi elementi 
     * della lista principale. Verifico quindi che aggiungendo elementi alla subList, la modifica avvenga pure all'interno della list principale.
     * 
     * TEST DESCRIPTION: Creo una list di tipo ListAdapter, aggiungo 4 elementi 1, 2, 3,4.
     * Richiamo il metodo subList(0,2) che restituisce un oggetto di tipo HList che chiamo subList.
     * Eseguo il clear, verifico dimensione sub == 0  e dimensione lista = dimensione lista originale - dim sub tolta 
     * 
     * PRECONDITION: esistenza di una list vuota.
     * 
     * POSTCONDITION: list con 5 elementi(1,5,4,2,3) e subList con 3 elementi (1,5,4)
     * 
     * EXPECTED RESULTS: 5,5,4,2
     */
    @Test
    public void SubListContainsAll() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        HCollection c = new ListAdapter();
        c.add(1);
        c.add(2);
        c.add(3);

        HList subList = list.subList(0, 3);
        assertTrue(subList.containsAll(c));
        c.add(4);
        assertFalse(subList.containsAll(c));
    }
    
    //TODO: da visionare
    /**
     * SUMMARY: Test che verifica il funzionamento del metodo subList() di ListAdapter che crea una sottolista di una list principale precedentemente creata. 
     * 
     * TEST DESIGN: Test che dopo aver aggiunto 4 elementi ad una list, verifica il funzionamento
     * del metodo subList() che crea una sottolista di capacità minore ma che possiede nelle relative posizioni gli stessi elementi 
     * della lista principale. Verifico quindi che aggiungendo elementi alla subList, la modifica avvenga pure all'interno della list principale.
     * 
     * TEST DESCRIPTION: Creo una list di tipo ListAdapter, aggiungo 4 elementi 1, 2, 3,4.
     * Richiamo il metodo subList(0,2) che restituisce un oggetto di tipo HList che chiamo subList.
     * Eseguo il clear, verifico dimensione sub == 0  e dimensione lista = dimensione lista originale - dim sub tolta 
     * 
     * PRECONDITION: esistenza di una list vuota.
     * 
     * POSTCONDITION: list con 5 elementi(1,5,4,2,3) e subList con 3 elementi (1,5,4)
     * 
     * EXPECTED RESULTS: 5,5,4,2
     */
    @Test(expected = NullPointerException.class)
    public void SubListContainsAllCollectionNullPointerException() {
        list.add(1);
        list.add(2);
        HList subList = list.subList(0, list.size());

        HCollection c = null;

        assertTrue(subList.containsAll(c));
    }

    @Test(expected = NullPointerException.class)
    public void SubListContainsAllElementNullPointerException() {
        list.add(1);
        HList subList = list.subList(0, list.size());

        HCollection c = new ListAdapter();
        c.add(1);
        c.add(null);
        c.add(3);
        assertTrue(subList.containsAll(c));
    }


    @Test
    public void SubListGet() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        HList subList = list.subList(1, 3);

        assertEquals(3, subList.get(subList.size() - 1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void SubListGetIndexOutOfBoundsException() {
        list.add(1);
        HList subList = list.subList(0, list.size());
        assertEquals(1, subList.get(subList.size()));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void SubListGetIndexOutOfBoundsExceptionSubList() {
        list.add(1);
        HList subList = list.subList(0, list.size());

        assertEquals(1, subList.get(subList.size()));
    }


    @Test
    public void testSetSubList() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        HList subList = list.subList(1, 3);

        subList.set(0, 6);
        assertEquals(6, subList.get(0));
        assertEquals(6, list.get(1));
    }
}

