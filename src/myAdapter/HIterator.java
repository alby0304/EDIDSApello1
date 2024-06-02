/* package myAdapter;

public interface HIterator {
    public boolean hasNext();
    public Object next();
    public void remove();
    
} */

package myAdapter;

public interface HIterator<T> {
    public boolean hasNext();
    public T next();
    public void remove();
}