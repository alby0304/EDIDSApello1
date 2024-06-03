/*package myAdapter;
import java.util.Vector;

public class ListAdapter<T> extends CollectionAdapter implements HList{

    CollectionAdapter c;

    ListAdapter(){
        c = new CollectionAdapter();
    }
    ListAdapter(CollectionAdapter o){
        this.c = o;
    }

}

class CollectionAdapter<T> implements HCollection{
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

*/
/* 
package myAdapter;

import java.util.Enumeration;
import java.util.Vector;

import myAdapter.ListAdapter.CollectionAdapter;

public class ListAdapter<T> extends CollectionAdapter<T> implements HList<T> 

    private CollectionAdapter<T> c;
    private ListIteratorAdapter<T> it;

    // Costruttori
    public ListAdapter() {
        this.c = new CollectionAdapter<>();
        it = new ListIteratorAdapter<>(this);
    }

    public ListAdapter(HCollection<? extends T> c) {
        this.c = new CollectionAdapter<>(c);
        it = new ListIteratorAdapter<>(this);
    }

    // HList
    public void add(int index, T element) {
        if (index < 0 || index > c.size()) {
            throw new IndexOutOfBoundsException();
        }
        CollectionAdapter<T> tmp = new CollectionAdapter<>();
        for (int i = 0; i < c.size(); i++) {
            if (i == index) {
                tmp.add(element);
            }
            tmp.add(c.get(i));        
        }
        c = tmp;
    }
    
    @Override
    public boolean add(T o) {
        return c.add(o);
    }

    @Override
    public boolean addAll(HCollection<? extends T> c) {
        return this.c.addAll(c);
    }
    
    public boolean addAll(int index, CollectionAdapter<? extends T> c) {
        if (index < 0 || index > this.c.size()) {
            throw new IndexOutOfBoundsException();
        }
        CollectionAdapter<T> tmp = new CollectionAdapter<>();
        for (int i = 0; i < this.c.size(); i++) {
            if (i == index) {
                for (int j = 0; j < c.size(); j++) {
                    tmp.add(c.get(j));
                }
            }
            tmp.add(this.c.get(i));
        }
        this.c = tmp;
        return true;
    }

    @Override
    public void clear() {
        c.clear();
    }

    @Override
    public boolean contains(Object o) {
        return c.contains(o);
    }

    @Override
    public boolean containsAll(HCollection<?> c) {
        return this.c.containsAll(c);
    }

    @Override
    public boolean equals(Object o) {
        return c.equals(o);
    }

    @Override
    public int hashCode() {
        return c.hashCode();
    }


    public T get(int index) {
        return c.get(index);
    }

    



class CollectionAdapter<T> implements HCollection<T> {
    private Vector<T> v;
    private HIterator<T> it;

    public CollectionAdapter() {
        v = new Vector<>();
    }

    public CollectionAdapter(HCollection<? extends T> c) {
        this();
        addAll(c);
    }

    // HCollection
    public HIterator<T> iterator() {
        return it;
    }

    public boolean add(T c) {
        if (c == null) {
            throw new NullPointerException();
        }
        if (!v.isEmpty() && !v.firstElement().getClass().isInstance(c)) {
            throw new ClassCastException();
        }
        v.addElement(c);
        return true;
    }

    public boolean addAll(HCollection<? extends T> c) {
        boolean modified = false;
        for (Object item : c.toArray()) {
            modified |= add((T) item);
        }
        return modified;
    }

    public void clear() {
        v.removeAllElements();
    }

    public boolean contains(Object o) {
        return v.contains(o);
    }

    public boolean containsAll(HCollection<?> c) {
        for (Object item : c.toArray()) {
            if (!contains(item)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof HCollection)) {
            return false;
        }
        HCollection<?> c = (HCollection<?>) o;
        if (c.size() != size()) {
            return false;
        }
        return containsAll(c);
    }

    public int hashCode() {
        /*int hashCode = 1;
        Enumeration<T> e = this.iterator();
        while (e.hasMoreElements()) {
            T obj = e.nextElement();
            hashCode = 31 * hashCode + (obj == null ? 0 : obj.hashCode());
        }
        return hashCode;
        //TODO: implementare hashCode
    }
    */
    /* 
    

    public boolean isEmpty() {
        return v.isEmpty();
    }

    public boolean remove(Object o) {
        return v.removeElement(o);
    }

    public boolean removeAll(HCollection<?> c) {
        boolean modified = false;
        for (Object item : c.toArray()) {
            modified |= remove(item);
        }
        return modified;
    }

    public boolean retainAll(HCollection<?> c) {
        boolean modified = false;
        for (int i = 0; i < v.size(); i++) {
            if (!c.contains(v.elementAt(i))) {
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

    public Object[] toArray() {
        Object[] tmp = new Object[v.size()];
        for (int i = 0; i < v.size(); i++) {
            tmp[i] = v.elementAt(i);
        }
        return tmp;
    }

    public Object[] toArray(Object[] a) {
        if (a[0] == null) {
            throw new NullPointerException();
        }
        if (a.length == v.size()) {
            a = toArray();
        } else if (a.length < v.size()) {
            Object[] newArray = new Object[v.size()];
            newArray = v.toArray();
            return newArray;
        } else {
            int i;
            for (i = 0; i < v.size(); i++) {
                a[i] = v.elementAt(i);
            }
            while (i < a.length) {
                a[i] = null;
            }
        }
        return a;
    }

    protected T get(int index) {
        return v.elementAt(index);
    }

}
*/
package myAdapter;
public class ListAdapter<T> implements HList<T>{
    

}