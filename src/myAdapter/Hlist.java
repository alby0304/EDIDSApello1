/* Backup
package myAdapter;

public interface HList extends HCollection{
    public void add(int index, Object element);
    public boolean addAll(int index, HCollection c);
    public Object get(int index);
    public int indexOf(Object o);
    public int lastIndexOf(Object o);
    public HListIterator listIterator();
    public HListIterator listIterator(int index);
    public Object remove(int index);
    public Object set(int index, Object element);
    public HList subList(int fromIndex, int toIndex);
}
*/
package myAdapter;

public interface HList<T> extends HCollection<T> {
    public void add(int index, T element);
    public boolean addAll(int index, HCollection<? extends T> c);
    public T get(int index);
    public int indexOf(Object o);
    public int lastIndexOf(Object o);
    public HListIterator<T> listIterator();
    public HListIterator<T> listIterator(int index);
    public T remove(int index);
    public T set(int index, T element);
    public HList<T> subList(int fromIndex, int toIndex);
}