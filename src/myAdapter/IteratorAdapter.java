package myAdapter;

import java.lang.ClassCastException;
import java.util.NoSuchElementException;
import java.util.Vector;


public class IteratorAdapter implements HListIterator{

    private Vector<HCollection> v;
    private int position; 

    public IteratorAdapter() {
        v = new Vector<HCollection>();
        position = 0;
    }
    public IteratorAdapter(HCollection o) {
        this.v = o;
        position = 0;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        throw new NoSuchElementException();
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }

    @Override
    public Object previous() {
        throw new NoSuchElementException();
    }

    @Override
    public int nextIndex() {
        return iterator.nextIndex();
    }

    @Override
    public int previousIndex() {
        return iterator.previousIndex();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
        throw new IllegalStateException();
    }

    @Override
    public void set(Object o) {
        throw new UnsupportedOperationException();
        throw new ClassCastException();
        throw new IllegalArgumentException();
        throw new IllegalStateException();
    }

    @Override
    public void add(Object o) {
        throw new UnsupportedOperationException();
        throw new ClassCastException();
        throw new IllegalArgumentException();
    }
}


/*import java.util.NoSuchElementException;

public class MyIterator implements Iterator {

    private Object[] items;
    private int position;

    public MyIterator(Object[] items) {
        this.items = items;
        this.position = 0;
    }

    public boolean hasNext() {
        return position < items.length;
    }

    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements");
        }
        return items[position++];
    }

    public void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}*/