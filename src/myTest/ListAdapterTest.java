package myTest;

import myAdapter.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class ListAdapterTest {


   /**
    * Summary: Test che prova il funzionamento del metodo add() aggiungendo un valore di tipo intero.
    * 
    * Test design: Test che valuta se in seguito alla creazione di una lista e all'invocazione di list.add(add) l'elemento è effettivamente stato inserito
    * 
    * Test description: creo variabile costante add di valore 1, creo una lista di tipo ListAdapter, passo il valore al metodo add()
    * e stabilisco se è avvenuta l'aggiunta.
    * 
    * Precondition: //TODO
    * 
    * Postcondition: lista con un elemento aggiunto.
    * 
    * Expected results: int add
    */
    @Test
    public void add() {
        final int add = 1;
        ListAdapter list = new ListAdapter();
        list.add(add);
        assertEquals(add, list.get(0));
    }


    /**
    * Summary: Test che valuta l'aggiunta di variabili di vario tipo all'interno della stessa lista. 
    * 
    * Test design: test che valuta se in seguito alla creazione di una lista di tipo ListAdapter e all'aggiunta di un parametro int e uno boolean viene lanciata una eccezione. 
    * 
    * Test description: creo variabile costante add di valore 1 e variabile bool=true, creo una lista di tipo ListAdapter, passo la variabile add al metodo add() 
    * e successivamente passo bool. Infine stabilisco se ha lanciato l'eccezione ClassCastException.
    * 
    * Precondition:
    * 
    * Postcondition: aggiunta di un valore e lancio di un'eccezione.
    * 
    * Expected results: ClassCastException 
    */
    @Test(expected = ClassCastException.class)
    public void addDifferentType() {
        final int add = 1;
        final boolean bool = true;
        ListAdapter list = new ListAdapter();
        list.add(add);
        list.add(bool);
    }


    /**
    * Summary: Test che valuta l'aggiunta consecutiva di due elementi.
    * 
    * Test design: Test che valuta se in seguito alla creazione di una lista di tipo ListAdapter e all'aggiunta di due valori risulta inserito anche il secondo.
    * 
    * Test description: creo variabile costante add di valore 1, creo una lista di tipo ListAdapter, passo il valore al metodo add()
    * e successivamente gli passo add+1. Ci si aspetta che il secondo valore aggiunto sia pari a 2.
    * 
    * Precondition:
    * 
    * Postcondition: presenza di 2 variabili di tipo int nella lista.
    * 
    * Expected results: 2
    */
    @Test
    public void addDouble() {
        final int add = 1;
        ListAdapter list = new ListAdapter();
        list.add(add);
        list.add(add + 1);
        assertEquals(2, list.get(1));
    }


    /**
    * Summary: Test che valuta il funzionamento del metodo remove su un elemento della lista in seguito alla sua aggiunta 
    * 
    * Test design: Test che valuta se, in seguito alla creazione di una lista di tipo ListAdapter e all'inserimento di un elemento, la sua rimozione viene eseguita.
    * 
    * Test description: creo variabile costante add di valore 2.7, creo una lista di tipo ListAdapter, passo il valore al metodo add()
    * e stabilisco se è avvenuta la sua rimozione.
    * 
    * Precondition:
    * 
    * Postcondition: lista vuota
    * 
    * Expected results: true 
    */
    @Test
    public void addRemoveObj() {
        // uso double perchè con int confonde metodo
        final double add = 2.7;
        ListAdapter list = new ListAdapter();
        list.add(add);
        assertEquals(true, list.remove(add));
    }


    /**
    * Summary: Test che valuta il funzionamento del metodo 'Object remove(int index)' che restituisce il valore dell'elemento che era appena stato inserito nella lista.
    * 
    * Test design: Test che valuta se, in seguito alla creazione di una lista di tipo ListAdapter e all'inserimento di un elemento, passandogli la posizione di quest'ultimo la sua rimozione viene eseguita e l'elemento viene restituito.
    * 
    * Test description: creo variabile costante add di valore 1, creo una lista di tipo ListAdapter, passo il valore al metodo add()
    * e stabilisco se è avvenuta la rimozione dell'elemento tramite la chiamata al metodo Object remove(int index) (restituisce l'oggetto rimosso dalla lista).
    * 
    * Precondition:
    * 
    * Postcondition: lista vuota.
    * 
    * Expected results: add.
    */
    @Test
    public void addRemoveIndex() {
        final int add = 1;
        ListAdapter list = new ListAdapter();
        list.add(add);
        assertEquals(add, list.remove(0));
    }


/**
    * Summary: Test che valuta il funzionamento del metodo 'public boolean addAll(HCollection c)' che copia in una lista tutti gli elementi di quella passata come parametro.
    * 
    * Test design: Test che confronta gli elementi della lista con quelli di un array in seguito alla chiamata del metodo addAll().
    * 
    * Test description: creo variabile costante add di valore 1 e array di 3 valori {1,2,3}, creo una lista di tipo ListAdapter, passo il valore al metodo add()
    * e in seguito creo una seconda lista e richiamo 2 volte il metodo add() sulla nuova lista passandogli 2 e 3. Richiamo il metodo addAll() sulla lista1 passandogli la lista2 
    * come parametro e valuto se la lista1 contiene tutti gli elementi aspettati confrontandola con quelli presenti nell'array creato inizialmente (uso il metodo get())
    * 
    * Precondition:
    * 
    * Postcondition: lista contenente 3 elementi.
    * 
    * Expected results: 1,2,3
    */
    @Test
    public void addAll() {
        final int add = 1;
        final int[] giusto = { 1, 2, 3 };
        ListAdapter list = new ListAdapter();
        list.add(add);
        ListAdapter list2 = new ListAdapter();
        list2.add(2);
        list2.add(3);
        list.addAll(list2);
        assertEquals(giusto[0], list.get(0));
        assertEquals(giusto[1], list.get(1));
        assertEquals(giusto[2], list.get(2));
    }


    /**
    * Summary: Test che valuta il funzionamento del metodo 'public boolean addAll(int index, HCollection c)' che copia in una lista gli elementi di quella passata come parametro partendo dall'indice indicato
    * 
    * Test design: Test che confronta gli elementi della lista con quelli di un array in seguito alla chiamata del metodo addAll(int index, HCollection c).
    * 
    * Test description: creo variabile costante add di valore 1 e array di 3 valori {1,2,3}, creo una lista di tipo ListAdapter, passo 2 volte il valore al metodo add()
    * e in seguito creo una seconda lista e richiamo 2 volte il metodo add() sulla nuova lista passandogli 2 e 3. Richiamo il metodo addAll() sulla lista1 passandogli l'indice
    * di partenza e la lista2 come parametri e valuto se la lista1 contiene tutti gli elementi aspettati confrontandola con quelli presenti nell'array creato inizialmente (uso il metodo get()).
    * 
    * Precondition:
    * 
    * Postcondition: lista contenente 4 elementi.
    * 
    * Expected results: 1,2,3,1 
    */
    @Test
    public void addAllIndex() {
        final int add = 1;
        final int[] giusto = { 1, 2, 3 };
        ListAdapter list = new ListAdapter();
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
    * Summary: Test che valuta il funzionamento del metodo 'public void clear()'.
    * 
    * Test design: Test che valuta se in seguito all'aggiunta di un elemento la lista viene svuotata.
    * 
    * Test description: creo variabile costante add di valore 1, creo una lista di tipo ListAdapter, passo il valore al metodo add()
    * e richiamo il metodo clear() sulla lista. Infine controllo tramite metodo {@link int myAdapter.ListAdapter.size()} se la lista è vuota.
    * 
    * Precondition:
    * 
    * Postcondition: lista vuota.
    * 
    * Expected results: 0
    */
    @Test
    public void clear() {
        final int add = 1;
        ListAdapter list = new ListAdapter();
        list.add(add);
        list.clear();
        assertEquals(0, list.size());
    }

    
    /**
    * Summary: Test che verifica il funzionamento del metodo 'public void contains(Object o)' in seguito all'aggiunta di un elemento add.
    * 
    * Test design: Test che valuta se dopo aver creato una lista e inserito un elemento quest'ultimo è effettivamente presente.
    * 
    * Test description: creo variabile costante add di valore 1, creo una lista di tipo ListAdapter, passo il valore al metodo add()
    * e richiamo il metodo contains() sulla lista passandogli 1 e controllo se è presente al suo interno.
    * 
    * Precondition:
    * 
    * Postcondition: lista contenente 1 elemento
    * 
    * Expected results: true
    */
    @Test
    public void contains() {
        final int add = 1;
        ListAdapter list = new ListAdapter();
        list.add(add);
        assertEquals(true, list.contains(1));
    }

    
    /**
    * Summary: Test che valuta il funzionamento del metodo 'public boolean containsAll(HCollection c) '
    * 
    * Test design: Test che valuta se dopo aver creato e iniziallizzato due liste la prima contiene tutti gli elementi della seconda
    * 
    * Test description: creo variabile costante add di valore 1, creo una lista di tipo ListAdapter, passo il valore al metodo add()
    * e richiamo add() altre 2 volte passandogli i valori 2 e 3. Creo poi una seconda lista di tipo ListAdapter e aggiungo 2 e 3 al suo interno. 
    * Infine passandogli list2 al metodo containsAll() valuto se list contiene tutti gli elementi di list2.
    * 
    * Precondition:
    * 
    * Postcondition: list contenente 3 elementi e list2 contenente 2 elementi.
    * 
    * Expected results: true
    */
    @Test
    public void containsAll() {
        final int add = 1;
        ListAdapter list = new ListAdapter();
        list.add(add);
        list.add(2);
        list.add(3);
        ListAdapter list2 = new ListAdapter();
        list2.add(2);
        list2.add(3);
        assertEquals(true, list.containsAll(list2));
    }

    
    /**
    * Summary: Test che verifica il funzionamento del metodo ' public boolean equals(Object o)'.
    * 
    * Test design: Test che valuta se dopo aver creato e inizializzato due liste la prima è uguale alla seconda.
    * 
    * Test description: Creo una lista di tipo ListAdapter e aggiungo i valori 1 e 2, poi creo una seconda lista list2 e aggiungo 
    * nuovamente 1 e 2. Infine controllo se list ha gli stessi elementi di list2 e viceversa.
    * 
    * Precondition:
    * 
    * Postcondition: 2 liste con stessi elementi.
    * 
    * Expected results: true, true.
    */
    @Test
    public void equals() {
        ListAdapter list = new ListAdapter();
        list.add(1);
        list.add(2);
        ListAdapter list2 = new ListAdapter();
        list2.add(1);
        list2.add(2);
        assertEquals(true, list.equals(list));
        assertEquals(true, list.equals(list2));
    }

    
    /**
    * Summary: Test che controlla il funzionamento del metodo 'public Object get(int index)'
    * 
    * Test design: Test che valuta se dopo aver creato e inizializzato una lista, l'elemento aggiunto si trova in posizione 0.
    * 
    * Test description: creo variabile costante add di valore 1, creo una lista di tipo ListAdapter, passo il valore al metodo add()
    * e controllo che in posizione 0 sia presente il valore add tramite metodo get().
    * 
    * Precondition:
    * 
    * Postcondition: lista con 1 elemento.
    * 
    * Expected results: add
    */
    @Test
    public void get() {
        final int add = 1;
        ListAdapter list = new ListAdapter();
        list.add(add);
        assertEquals(add, list.get(0));
    }

    
    /**
    * Summary: Test che verifica il funzionamento del metodo 'public int hashCode()'.
    * 
    * Test design: Test che dopo aver creato una lista e aggiunto un elemento restituisce l'hashCode. 
    * 
    * Test description: creo variabile costante add di valore 1, creo una lista di tipo ListAdapter, passo il valore al metodo add(). 
    * Poi creo una variabile int n=32 e stabilisco se il valore restituito dal metodo hashCode() applicato alla lista è ugaule a 32.
    * 
    * Precondition:
    * 
    * Postcondition: lista con 1 elemento.
    * 
    * Expected results: n
    */
    @Test
    public void testHashCode() {
        final int add = 1;
        ListAdapter list = new ListAdapter();
        list.add(add);
        int n = 32;
        assertEquals(n, list.hashCode());

    }

    
    /**
    * Summary: Test che verifica il funzionamento del metodo ' public int indexOf(Object o)'
    * 
    * Test design: Test che dopo aver creato una lista e aggiunto un elemento restituisce l'indice della sua prima occorrenza
    * 
    * Test description: creo variabile costante add di valore 1, creo una lista di tipo ListAdapter, passo il valore al metodo add()
    * e controllo che add sia in posizione 0 tramite metodo indexOf(add).
    * 
    * Precondition:
    * 
    * Postcondition: lista con 1 elemento.
    * 
    * Expected results: 0
    */
    @Test
    public void indexOF() {
        final int add = 1;
        ListAdapter list = new ListAdapter();
        list.add(add);
        assertEquals(0, list.indexOf(add));
    }

    
    /**
    * Summary: Test che verifica il funzionamento del metodo ' public boolean isEmpty()'
    * 
    * Test design: Test che dopo aver creato una lista e aggiunto un elemento controlla che non sia vuota.
    * 
    * Test description: creo variabile costante add di valore 1, creo una lista di tipo ListAdapter, passo il valore al metodo add()
    * e controllo che la lista non sia vuota tramite il metodo isEmpty() (deve restituire false).
    * 
    * Precondition:
    * 
    * Postcondition: lista con 1 elemento
    * 
    * Expected results: false
    */
    @Test
    public void isEmpty() {
        final int add = 1;
        ListAdapter list = new ListAdapter();
        list.add(add);
        assertEquals(false, list.isEmpty());
    }

    
    /**
    * Summary: Test che verifica il funzionamento del metodo 'public HIterator iterator()'
    * 
    * Test design: 
    * 
    * Test description: 
    * 
    * Precondition:
    * 
    * Postcondition:
    * 
    * Expected results: it
    */
    @Test
    public void iterator() {
        final int add = 1;
        ListAdapter list = new ListAdapter();
        HIterator it = list.iterator();
        assertEquals(it, list.iterator());
    }

    
    /**
    * Summary: Test che verifica il funzionamento del metodo ' public int lastIndexOf(Object o)'
    * 
    * Test design: Test che crea una lista e dopo aver aggiunto due volte lo stesso elemento restituisce la sua ultima occorrenza nella lista
    * 
    * Test description: creo variabile costante add di valore 1, creo una lista di tipo ListAdapter, passo il valore al metodo add() 2 volte
    * e controllo che l'occorrenza dell'ultimo elemento inserito sia 1 tramite metodo lastIndexOf(add).
    * 
    * Precondition:
    * 
    * Postcondition: lista con 2 elementi
    * 
    * Expected results: 1
    */
    @Test
    public void lastIndexOf() {
        final int add = 1;
        ListAdapter list = new ListAdapter();
        list.add(add);
        list.add(add);
        assertEquals(1, list.lastIndexOf(add));
    }

    
    /**
    * Summary: 
    * 
    * Test design: 
    * 
    * Test description:
    * 
    * Precondition:
    * 
    * Postcondition
    * 
    * Expected results: it
    */
    @Test
    public void ListIterator() {
        final int add = 1;
        ListAdapter list = new ListAdapter();
        HListIterator it = list.listIterator();
        assertEquals(it, list.iterator());
    }

    
    /**
    * Summary: Test che verifica 
    * 
    * Test design: 
    * 
    * Test description:
    * 
    * Precondition:
    * 
    * Postcondition
    * 
    * Expected results: add
    */
    @Test
    public void ListIteratorIndex() {
        final int add = 1;
        ListAdapter list = new ListAdapter();
        list.add(add);
        assertEquals(add, list.listIterator(0).next());
    }

    
    /**
    * Summary: Test che verifica il corretto funzionamento del metodo ' public boolean removeAll(HCollection c)'
    * 
    * Test design: Test che crea e inizializza due liste e verifica: 
    * 1) che vengano cancellati gli elementi della seconda lista contenuti anche nella prima  
    * 2) il primo elemento dell'array creato
    * 3) la lunghezza dell'array
    * 
    * Test description: creo una lista di tipo ListAdapter e aggiungo 1, 2, 3. 
    * Creo una seconda lista e aggiungo 2 e 3. Utilizzo il metodo removeAll(list2) per rimuovere tutti gli elementi della list2 da list
    * e verifico che sia andata a buon fine l'operazione.
    * Creo un array contenente tutti gli elementi di list e controllo che il primo elemento sia 1 e inoltre che quest'ultimo sia l'unico presente nell'array
    * verificando che sia di lunghezza unitaria.
    * 
    * Precondition:
    * 
    * Postcondition: lista e array con 1 elemento.
    * 
    * Expected results:  true, 1, 1
    */
    @Test
    public void removeAll() {
        ListAdapter list = new ListAdapter();
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
    * Summary: Test che verifica il corretto funzionamento del metodo 'public boolean retainAll(HCollection c)'
    * 
    * Test design: Test che crea e inizializza due liste e verifica : 
    * 1) che vengano cancellati gli elementi della seconda lista  contenuti anche nella prima  
    * 2) il primo e il secondo elemento dell'array creato
    * 3) la lunghezza dell'array
    * 
    * Test description: creo una lista di tipo ListAdapter e aggiungo 1, 2, 3. 
    * Creo una seconda lista e aggiungo 2 e 3. Utilizzo il metodo retainAll(list2) per mantenere tutti gli elementi della list2 in list
    * e verifico che sia andata a buon fine l'operazione.
    * Creo un array contenente tutti gli elementi di list e controllo che siano presenti gli elementi rimasti in list (in questo caso 2 e 3)
    * e inoltre che questi siano gli unici elementi dell'array verificando che abbia la lunghezza prestabilità (in questo caso 2).
    * 
    * Precondition:
    * 
    * Postcondition: list e array con 2 elementi
    * 
    * Expected results: true 2,3,2
    */
    @Test
    public void retainAll() {
        ListAdapter list = new ListAdapter();
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
    * Summary: Test che verifica il corretto funzionamento del metodo 'public Object set(int index, Object element)'
    * 
    * Test design: Test che controlla che avvenga la corretta sostituzione di un elemento nella lista con l'elemento passato per parametro a set().
    * 
    * Test description: creo una lista di tipo ListAdapter e aggiungo 3 elementi 1, 2, 3. 
    * Richiamo il metodo set() e sostituisco l'elemento in posizione 2 (3) con l'elemento passato come parametro (4). 
    * L'elemento di tipo object restituito lo chiamo remove e valuto che valga esattamente quanto l'elemento precedentemente presente nella list. 
    * Infine controllo sia avvenuta la corretta sostituzione dell'elemento tramite metodo get(2).
    * 
    * Precondition:
    * 
    * Postcondition: list con 3 elementi (1, 2, 4).
    *
    * Expected results: 3,4
    */
    @Test
    public void set() {
        ListAdapter list = new ListAdapter();
        list.add(1);
        list.add(2);
        list.add(3);
        Object remove = list.set(2, 4);
        assertEquals(3, remove);
        assertEquals(4, list.get(2));
    }

    
    /**
    * Summary: Test che verifica il corretto funzionamento del metodo 'public int size()'
    * 
    * Test design: Test che crea una lista, aggiunge due elementi e verifica che siano effettivamente presenti al suo interno
    * 
    * Test description: creo variabile costante add di valore 1, creo una lista di tipo ListAdapter, passo il valore al metodo add() 2 volte
    * e controllo che il numero di elementi inseriti sia 2
    * 
    * Precondition:
    * 
    * Postcondition: list con 2 elementi uguali
    * 
    * Expected results: 2
    */
    @Test
    public void size() {
        final int add = 1;
        ListAdapter list = new ListAdapter();
        list.add(add);
        list.add(add);
        assertEquals(2, list.size());
    }

    
    /**
    * Summary: 
    * 
    * Test design: 
    * 
    * Test description:
    * 
    * Precondition:
    * 
    * Postcondition
    * 
    * Expected results: 5,5,4,2
    */
    @Test
    public void SubList() {
        ListAdapter list = new ListAdapter();
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

    
    /**
    * Summary: 
    * 
    * Test design: 
    * 
    * Test description:
    * 
    * Precondition:
    * 
    * Postcondition
    * 
    * Expected results: 
    */
    @Test
    public void toArray() {
        ListAdapter list = new ListAdapter();
        list.add(1);
        list.add(2);
        list.add(3);
        Object[] fine = list.toArray();
        assertEquals(list.get(0), fine[0]);
        assertEquals(list.get(1), fine[1]);
        assertEquals(list.get(2), fine[2]);
    }

    
    /**
    * Summary: 
    * 
    * Test design: 
    * 
    * Test description:
    * 
    * Precondition:
    * 
    * Postcondition
    * 
    * Expected results: 
    */
    @Test
    public void toArrayObjectArray() {
        ListAdapter list = new ListAdapter();
        list.add("1");
        list.add("2");
        list.add("3");
        String[] vet = new String[2];
        Object[] fine = list.toArray(vet); // viene ridimensionato
        assertEquals(list.get(0), fine[0]);
        assertEquals(list.get(1), fine[1]);
        assertEquals(list.get(2), fine[2]);
    }

}

/*
 * public static void main(String[] args) {
 * ListAdapter list = new ListAdapter();
 * list.add(1);
 * list.add(2);
 * list.add(3);
 * list.add(4);
 * list.add(5);
 * System.out.println("Lista: " + list);
 * ListIteratorAdapter listIterator = new ListIteratorAdapter(list);
 * System.out.println("ListaIterator: " + listIterator);
 * System.out.println("HasNext: " + listIterator.hasNext());
 * System.out.println("NextIndex: " + listIterator.nextIndex());
 * System.out.println("Next: " + listIterator.next());
 * System.out.println("HasPrevious: " + listIterator.hasPrevious());
 * System.out.println("PreviousIndex: " + listIterator.previousIndex());
 * System.out.println("Previous: " + listIterator.previous());
 * System.out.println("Previous2: " + listIterator.previous());
 * System.out.println("Next: " + listIterator.next());
 * listIterator.add(6);
 * System.out.println("Lista: " + list);
 * System.out.println("ListaIterator: " + listIterator);
 * listIterator.set(7);
 * System.out.println("Lista: " + list);
 * System.out.println("ListaIterator: " + listIterator);
 * 
 * for (Object element : list.toArray()) {
 * System.out.println(element);
 * }
 * 
 * }
 */
