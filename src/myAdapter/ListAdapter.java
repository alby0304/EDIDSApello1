package myAdapter;
import java.util.Vector;

public class ListAdapter extends CollectionAdapter implements HList{

    CollectionAdapter c;

    ListAdapter(){
        c = new CollectionAdapter();
    }
    ListAdapter(CollectionAdapter o){
        this.c = o;
    }

}

class CollectionAdapter implements HCollection{
    private Vector v;
    private HIterator it;

    CollectionAdapter(){
        v = new Vector();
    }
    CollectionAdapter(HCollection o){
        this.v = o;
    }

    //HCollection
    public HIterator iterator()
    {
        return it;
    }

    public boolean add(Object o)
    {
        if (o == null)
        {
            throw new NullPointerException();
        }
        Object firstElement = v.firstElement();
        if (!(firstElement.getClass().isInstance(o)))
        {
            throw new ClassCastException();
        }

        v.add(o);
        return true;
        
    }

    @Override
    public void remove() {
        try {
            it = new IteratorAdapter();
        } catch (Exception e) {
            super.remove();
        }
        // Add your additional code here
    }

    @Override
    public void set(Object o) {
        super.set(o);
        throw new ClassCastException(); 
        throw new IllegalArgumentException();
        
        throw new IllegalStateException();
    }
}

/*
 * package myAdapter;

import java.util.Vector;

public class ListAdapter<T> extends CollectionAdapter<T> implements HList<T> {

    CollectionAdapter<T> c;

    public ListAdapter() {
        c = new CollectionAdapter<>();
    }

    public ListAdapter(CollectionAdapter<T> o) {
        this.c = o;
    }

    // Implement HList methods here if needed
}

class CollectionAdapter<T> implements HCollection<T> {
    private Vector<T> v;
    private HIterator<T> it;

    public CollectionAdapter() {
        v = new Vector<>();
    }

    public CollectionAdapter(HCollection<? extends T> o) {
        this();
        addAll(o);
    }

    // HCollection
    public HIterator<T> iterator() {
        return it;
    }

    public boolean add(T o) {
        if (o == null) {
            throw new NullPointerException();
        }
        if (!v.isEmpty() && !v.firstElement().getClass().isInstance(o)) {
            throw new ClassCastException();
        }

        v.add(o);
        return true;
    }

    public void clear() {
        v.clear();
    }

    public boolean contains(Object o) {
        return v.contains(o);
    }

    public boolean containsAll(HCollection<?> c) {
        for (Object item : c.toArray()) {
            if (!v.contains(item)) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        return v.isEmpty();
    }

    public boolean remove(Object o) {
        return v.remove(o);
    }

    public boolean removeAll(HCollection<?> c) {
        boolean modified = false;
        for (Object item : c.toArray()) {
            modified |= v.remove(item);
        }
        return modified;
    }

    public boolean retainAll(HCollection<?> c) {
        boolean modified = false;
        for (int i = 0; i < v.size(); i++) {
            if (!c.contains(v.get(i))) {
                v.remove(i);
                i--;
                modified = true;
            }
        }
        return modified;
    }

    public int size() {
        return v.size();
    }

    public T[] toArray() {
        return (T[]) v.toArray();
    }

    public <E> E[] toArray(E[] a) {
        return v.toArray(a);
    }

    @Override
    public void remove() {
        try {
            it = new IteratorAdapter<>();
        } catch (Exception e) {
            // Handle exception as needed
        }
        // Add your additional code here
    }

    @Override
    public void set(T o) {
        throw new ClassCastException();
        // throw new IllegalArgumentException(); // This will never be reached due to the previous throw
        // throw new IllegalStateException(); // This will never be reached due to the previous throw
    }
}

class IteratorAdapter<T> implements HIterator<T> {
    private int currentIndex;
    private Vector<T> vector;

    public IteratorAdapter(Vector<T> vector) {
        this.vector = vector;
        this.currentIndex = 0;
    }

    public boolean hasNext() {
        return currentIndex < vector.size();
    }

    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return vector.get(currentIndex++);
    }

    public void remove() {
        if (currentIndex == 0) {
            throw new IllegalStateException();
        }
        vector.remove(--currentIndex);
    }
}

 */