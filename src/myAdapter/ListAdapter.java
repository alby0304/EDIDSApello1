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
package myAdapter;

import java.util.Vector;

public class ListAdapter<T> extends CollectionAdapter<T> implements HList<T> {

    private CollectionAdapter<T> c;
    private ListIteratorAdapter<T> it;

    public ListAdapter() {
        this.c = new CollectionAdapter<>();
        it = new ListIteratorAdapter<>(this);
    }
    public ListAdapter(HCollection<? extends T> c) {
        this.c = new CollectionAdapter<>(c);
        it = new ListIteratorAdapter<>(this);
    }
    
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

    public boolean addAll(HCollection<? extends T> c){
        boolean modified = false;
        for (T item : c.toArray()) {
            modified |= add(item);
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

    //private T[] vet;
    public T[] toArray() {
        T[] tmp = (T[]) new Object[v.size()];
        for(int i =0 ; i< v.size();i++)
        {
            tmp[i] = v.elementAt(i);
        }

        return tmp;
        //v.copyInto(vet);
        //return vet;
    }

    public <E> E[] toArray(E[] a) {
        a = (E[]) toArray();
        return a;
    }

}
/*
public T[] toArray() {
        // Supponiamo che il tipo di array restituito sia Object[]
        T[] array = (T[]) new Object[v.size()];  // Creazione dell'array di tipo generico
        for (int i = 0; i < v.size(); i++) {
            array[i] = v.get(i);  // Copia degli elementi dalla Vector all'array
        }
        return array;
    }

    public <E> E[] toArray(E[] a) {
        if (a.length < v.size()) {
            // Creiamo un nuovo array del tipo di runtime di a, con la stessa dimensione di v
            a = (E[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), v.size());
        }
        for (int i = 0; i < v.size(); i++) {
            a[i] = (E) v.get(i);  // Copia degli elementi dalla Vector all'array
        }
        if (a.length > v.size()) {
            a[v.size()] = null;  // Se l'array è più grande, imposta l'elemento successivo a null
        }
        return a;
    }

    @Override
    public void remove() {
        try {
            it = new IteratorAdapter<>(this);
        } catch (Exception e) {
            // Handle exception as needed
        }
    }

    @Override
    public void set(T o) {
        throw new ClassCastException();
    }

*/

/*
import java.util.Vector;

public class MyClass<T> {
    private Vector<T> v = new Vector<>();

    // Metodo per aggiungere elementi al Vector
    public void add(T element) {
        v.add(element);
    }

    // Metodo toArray che utilizza un array prototipo
    @SuppressWarnings("unchecked")
    public T[] toArray(T[] a) {
        if (a.length < v.size()) {
            // Creiamo un nuovo array del tipo corretto se quello passato è troppo piccolo
            a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), v.size());
        }
        for (int i = 0; i < v.size(); i++) {
            a[i] = v.elementAt(i);
        }
        if (a.length > v.size()) {
            a[v.size()] = null; // Imposta il primo elemento non utilizzato a null
        }
        return a;
    }

    public static void main(String[] args) {
        MyClass<String> myClass = new MyClass<>();
        myClass.add("one");
        myClass.add("two");
        myClass.add("three");

        // Creiamo un array di String da passare al metodo toArray
        String[] array = myClass.toArray(new String[0]);
        for (String s : array) {
            System.out.println(s);
        }
    }
}

*/