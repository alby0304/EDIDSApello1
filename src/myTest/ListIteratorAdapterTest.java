package myTest;

import java.util.ListIterator;
import myAdapter.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

public class ListIteratorAdapterTest {

       ListAdapter list;
       ListIteratorAdapter it;

       @Before
       public void setup() {
              list = new ListAdapter();
              it = new ListIteratorAdapter(list);
       }

       

       /**
        * Creo il costruttore della classe ListIteratorAdapter. 
        * Verifica che l'iteratore venga inizializzato correttamente 
        * PRECONDITION: la lista contiene un elemento .
        * POSTCONDITION: l'iteratore e la lista iteratore sono nello stesso stato 
        */
       @Test
       public void constructor() {
              list.add(1);
              HListIterator iter = list.listIterator();
              assertEquals(it.next(), iter.next());
              assertEquals(false, iter.hasNext());
              assertEquals(it.hasNext(), iter.hasNext());
       }

       /**
        * SUMMARY: Test che verifica l'aggiunta di un elemento ad una lista tramite il metodo add().
        * 
        * TEST DESIGN: in seguito all'aggiunta di un elemento verifico che il mio iterator abbia il valore desiderato 
        * e poi verifico che l'elemento nella data posizione sia quello appena inserito.
        * 
        * TEST DESCRIPTION: aggiungo un elemento, controllo che il valore aspettato da next() sia giusto e 
        * controllo che add() abbia aggiunto l'elemento che volevo nella posizione desiderata.
        * 
        * PRECONDITION: esistenza di una lista.
        * POSTCONDITION: l'elenco contiene almeno un elemento.
         
        * EXPECTED RESULTS:  1 in entrambi i test
        */  
       @Test
       public void add() {
              it.add(1);
              assertEquals(1, it.next());   
              assertEquals(1, list.get(0));
       }
       

       /**
        * SUMMARY: Test che verifica la presenza di elementi quando attraversa un elenco. 
        * 
        * TEST DESIGN: se nel test non trova elementi ne aggiunge uno e verifica che la risposta sia true
        * 
        * TEST DESCRIPTION: Stabilisce se l'elenco sia vuoto, aggiunge un elemento e controlla la corretta riuscita dell'operazione 
        * 
        * PRECONDITION: esistenza di un elenco da attraversare 
        * POSTCONDITION: l'elenco contiene degli elementi 
        * 
        * EXPECTED RESULTS: prima false, poi in seguito all'aggiunta true 
        */
       @Test
       public void hasNext() {
              assertEquals(false, it.hasNext());
              it.add(1);
              assertEquals(true, it.hasNext());
       }

       /**
        * SUMMARY: Test che verifica la presenza di elementi quando attraversa un elenco nella direzione inversa. 
        * 
        * TEST DESIGN: se nel test non trova elementi ne aggiunge uno prima dell'elemento puntato dall'iteratore e verifica che la risposta sia true.
        * 
        * TEST DESCRIPTION: Stabilisce se l'elenco sia vuoto, aggiunge un elemento e controlla la corretta riuscita dell'operazione.
        * 
        * PRECONDITION: esistenza di un elenco da attraversare.
        * POSTCONDITION: l'elenco contiene degli elementi.
        * 
        * EXPECTED RESULTS: prima false, poi in seguito all'aggiunta true.
        */
       @Test
       public void hasPrev() {
              assertEquals(false, it.hasPrevious());
              it.add(1);
              it.next();
              assertEquals(true, it.hasPrevious());
       }

       /**
        * SUMMARY: Test che valuta se il metodo next() restituisce l'elemento desiderato dopo averlo aggiunto alla lista. 
        * 
        * TEST DESIGN: test che valuta se in seguito all'aggiunta di un elemento, il metodo next() restituisca quest'ultimo.
        * 
        * TEST DESCRIPTION: Aggiungo 1 e valuto se next restituisce quell'elemento.
        * 
        * PRECONDITION: esistenza di una lista. 
        * POSTCONDITION: presenza di almeno un elemento.
        * 
        * EXPECTED RESULTS: 1
        */
       @Test
       public void next() {
              it.add(1);
              assertEquals(1, it.next());
       }

       /**
        * SUMMARY: Test che valuta se il metodo nextIndex() restituisce l'indice dell'elemento che sarebbe restituito dal metodo next()
        * 
        * TEST DESIGN: test che valuta se in seguito all'aggiunta di un elemento, il metodo nextIndex() restuisce l'indice dell'elemento che restituirebbe next().
        * 
        * TEST DESCRIPTION: aggiungo 1 e valuto se nextIndex() restituisce l'indice dell'elemento successivo ovvero 1.
        * 
        * PRECONDITION: esistenza di una lista.
        * 
        * POSTCONDITION: nextIndex() restituisce un valore di tipo int.
        * 
        * EXPECTED RESULTS: 1
        */
       @Test
       public void nextIndex() {
              it.add(1);
              assertEquals(1, it.nextIndex());
       }
       
       /**
        * SUMMARY: Test che controlla il funzionamento del metodo previous()
        * e controlla che le chiamate alternate a previous() e next() restituiscano lo stesso oggetto
        * 
        * TEST DESIGN: test che valuta se in seguito all'aggiunta di un elemento,
        * il metodo previous() restituisca quest'ultimo.
        * 
        * TEST DESCRIPTION: aggiungo 1, valuto se il valore restituito da next() è 1 
        * e poi faccio previous() e valuto che mi dia ancora 1.
        * 
        * PRECONDITION: esistenza di una lista.
        * 
        * POSTCONDITION: presenza di almeno un elemento.
        * 
        * EXPECTED RESULTS: 1 in entrambi i test.
        * 
        */
       @Test
       public void prev() {
              it.add(1);
              assertEquals(1, it.next());
              assertEquals(1, it.previous());
       }
       
       /**
        * SUMMARY: Test che valuta se il metodo previousIndex() restituisce l'indice dell'elemento che sarebbe restituito dal metodo previous()
        * 
        * TEST DESIGN: test che valuta se il metodo previousIndex() restituisce l'indice dell'elemento che restituirebbe previous(). 
        * In questo caso -1 poichè iterator è all'inizio della lista
        * 
        * TEST DESCRIPTION: eseguo la chiamata a previousIndex() aspettamdomi -1 come valore restituito
        * 
        * PRECONDITION: esistenza di una lista 
        * 
        * POSTCONDITION: previousIndex() restituisce un valore di tipo int 
        * 
        * EXPECTED RESULTS: -1 
        */
       @Test
       public void previousIndex() {
              assertEquals(-1, it.previousIndex());
       }

       /**
        * 
        * SUMMARY: Test che valuta l'efficacia del metodo remove()
        * 
        * TEST DESIGN: Test che valuta se
        * 
        * TEST DESCRIPTION:
        * 
        * PRECONDITION:
        * 
        * POSTCONDITION
        * 
        * EXPECTED RESULTS: 
        * 
        */
       @Test
       public void remove() {

       }

       /** 
        * SUMMARY: Test che valuta l'efficacia del metodo set() che sostituisce 
        * l'ultimo elemento restituito dalla chiamata più recente a next o previous con l'elemento specificato
        * 
        * TEST DESIGN: Test che valuta se in seguito all'aggiunta di 1 e alla chiamata di it.set(2), il valore restituito da next() sia effettivamente 
        * quello stabilito da set() (in questo caso 2)
        * 
        * TEST DESCRIPTION: aggiungo 1, imposto a 2 il valore che deve restituire next() tramite il metodo set() e valuto se il valore restituito 
        * è quello desiderato
        * 
        * PRECONDITION: esistenza di una lista
        * 
        * POSTCONDITION: valore restituito da next() sostituito con quello passato in set()
        * 
        * EXPECTED RESULTS: 2 
        */
       @Test
       public void set() {
              it.add(1);
              it.set(2);
              assertEquals(2, it.next());

       }

}
