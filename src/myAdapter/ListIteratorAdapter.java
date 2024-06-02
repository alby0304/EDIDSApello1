/* package myAdapter;

import java.lang.ClassCastException;
import java.util.NoSuchElementException;

public class ListIteratorAdapter implements HListIterator {

    private CollectionAdapter v; // ????
    private int position;

    // Costruttori
    public ListIteratorAdapter() {
        v = new CollectionAdapter(); // Giusto o ListAdapter???
        position = 0;
    }

    public ListIteratorAdapter(CollectionAdapter o) {
        this.v = o;
        position = 0;
    }

    public ListIteratorAdapter(CollectionAdapter o, int index) { // TODO: Posizione argomenti
        this.v = o;
        position = index;
    }

    
    //HListIterator
    public void add(Object o){
 

        return position > 0; 
 

    public int nextIndex() {
        return position + 1;
    }
    public Object previous() {

 
    }
    public int previousIndex() {
        return position - 1;
    }
    public void set(Object o) {
        throw new UnsupportedOperationException();
    }
}


class IteratorAdapter implements HIterator{

    //Hiterator
    public boolean hasNext() {
        if(position < v.size())
            return true;
        return false;
    }
    public Object next() {
        try {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }
            return v.get(position++); //TODO: get(index) da implementare in ListAdapter
        } catch (Exception e) {
            System.out.println("Eccezione: " + e); //Errorre
            throw new NoSuchElementException();
        }
    }
    public void remove() { //TODO: da implementare remove(index) in ListAdapter
        throw new UnsupportedOperationException();//TODO: NON presente in CDLC 1.1
        //throw new IllegalStateException();
    }
} */

package myAdapter;

import java.util.NoSuchElementException;

public class ListIteratorAdapter<T> implements HListIterator<T> {

    private ListAdapter<T> v;
    private int position;

    // Costruttori
    public ListIteratorAdapter() {
        v = new ListAdapter<>();
        position = 0;
    }

    public ListIteratorAdapter(ListAdapter<T> o) {
        this.v = o;
        position = 0;
    }

    public ListIteratorAdapter(ListAdapter<T> o, int index) {
        this.v = o;
        position = index;
    }

    // HListIterator
    public void add(T o) {
        v.add(position, o);
        position++;
    }

    public boolean hasPrevious() {
        return position > 0;
    }

    public int nextIndex() {
        return position;
    }

    public T previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        return v.get(--position);
    }

    public int previousIndex() {
        return position - 1;
    }

    public void set(T o) {
        if (position <= 0 || position > v.size()) {
            throw new IllegalStateException();
        }
        v.set(position - 1, o);
    }

    public boolean hasNext() {
        return position < v.size();
    }

    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements");
        }
        return v.get(position++);
    }

    public void remove() {
        if (position <= 0) {
            throw new IllegalStateException();
        }
        v.remove(position - 1);
        position--;
    }
}

class IteratorAdapter<T> implements HIterator<T> {

    private ListAdapter<T> v;
    private int position;

    public IteratorAdapter(ListAdapter<T> v) {
        this.v = v;
        this.position = 0;
    }

    // HIterator
    public boolean hasNext() {
        return position < v.size();
    }

    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements");
        }
        return v.get(position++);
    }

    public void remove() {
        if (position <= 0) {
            throw new IllegalStateException();
        }
        v.remove(position - 1);
        position--;
    }
}

