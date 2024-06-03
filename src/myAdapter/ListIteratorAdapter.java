package myAdapter;

import java.util.NoSuchElementException;

/* 
import java.util.NoSuchElementException;

public class ListIteratorAdapter<T> extends IteratorAdapter<T> implements HListIterator<T> {

    private ListAdapter<T> v;
    private int position;

    // Costruttori
    public ListIteratorAdapter() {
        super(); // Explicitly invoke the constructor of the IteratorAdapter class.
        v = new ListAdapter<>();
        position = 0;
    }

    //TODO: da sistemare
    public ListIteratorAdapter(ListAdapter<T> o) {
        super(o); // Explicitly invoke the constructor of the IteratorAdapter class.
        this.v = o;
        position = 0;
    }

    public ListIteratorAdapter(ListAdapter<T> o, int index) {
        super(o, index); // Explicitly invoke the constructor of the IteratorAdapter class.
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

    private CollectionAdapter<T> v;
    private int position;
    public IteratorAdapter() {
        this.v = new CollectionAdapter<>();
        this.position = 0;
    }

    public IteratorAdapter(CollectionAdapter<T> v) {
        this.v = v;
        this.position = 0;
    }

    public IteratorAdapter(CollectionAdapter<T> v, int index) {
        this.v = v;
        this.position = index;
    }

    // HIterator
    public boolean hasNext() {
        return position < v.size();
    }

    public T next() {
        throw new UnsupportedOperationException();
    }

    public void remove() {
        if (position <= 0) {
            throw new IllegalStateException();
        }
        v.remove(position - 1);
        position--;
    }
}

class UnsupportedOperationException extends RuntimeException {
    // Costruttore senza argomenti
    public UnsupportedOperationException() {
        super();
    }

    // Costruttore che accetta un messaggio di errore
    public UnsupportedOperationException(String message) {
        super(message);
    }

    // Costruttore che accetta un messaggio di errore e una causa
    public UnsupportedOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    // Costruttore che accetta una causa
    public UnsupportedOperationException(Throwable cause) {
        super(cause);
    }
}
*/

public class ListIteratorAdapter implements HListIterator
{
    private int index = 0;
    private ListAdapter l;

    // Costruttori
    public ListIteratorAdapter(){
        l = new ListAdapter();
        index = 0;
    }

    //TODO: da sistemare
    public ListIteratorAdapter(ListAdapter o){
        this.l = o;
        index = 0;
    }

    public ListIteratorAdapter(ListAdapter o, int index){
        this.l = o;
        this.index = index;
    }

    /*
    **  Override HIterator
    */
    @Override
    public boolean hasNext(){
        return index<l.size();
    }

    @Override
    public Object next(){
        if(!hasNext()){
            throw  new NoSuchElementException();
        }
        return l.get(index++);
    }

    @Override
    public void remove(){
        l.get(index);
    }
    
    /*
    **  HListIterator
    */
   public void add(Object o){
        l.add(o);       
   }

   public boolean hasPrevious(){
        return (index<1);
   }

    public int nextIndex(){
        return (index +1);
    }
    
    public Object previous(){
        if(!hasPrevious()){
            throw new NoSuchElementException();
        }
        return l.get(index--);
    }
    
    public int previousIndex()
    {
        return (index -1);
    }

    public void set(Object o){
        l.set(l.size()-1,o);
    }
    
    
    
}

