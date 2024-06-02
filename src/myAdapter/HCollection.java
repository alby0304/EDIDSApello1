/* backup
package myAdapter;

public interface HCollection {
 
    public HIterator iterator();
    public boolean add(Object o);
    public boolean addAll(HCollection c);
    public void clear();
    public boolean contains(Object o);
    public boolean containsAll(HCollection c);
    public boolean equals(Object o);
    public int hashCode();
    public boolean isEmpty();
    public boolean remove(Object o);
    public boolean removeAll(HCollection c);
    public boolean retainAll(HCollection c);
    public int size();
    public Object[] toArray();
    public Object[] toArray(Object[] a);
    

    //public String toString();
    
} */

package myAdapter;

public interface HCollection<T> {
    public HIterator<T> iterator();
    public boolean add(T o);
    public boolean addAll(HCollection<? extends T> c);
    public void clear();
    public boolean contains(Object o);
    public boolean containsAll(HCollection<?> c);
    public boolean equals(Object o);
    public int hashCode();
    public boolean isEmpty();
    public boolean remove(Object o);
    public boolean removeAll(HCollection<?> c);
    public boolean retainAll(HCollection<?> c);
    public int size();
    public Object[] toArray();
    public Object[] toArray(Object[] a);
}


