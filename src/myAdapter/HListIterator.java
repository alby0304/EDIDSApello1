package myAdapter;

public interface HListIterator extends HIterator{
    
    public void add(Object o);
    public boolean hasPrevious();
    public int nextIndex();
    public Object previous();
    public int previousIndex();
    public void set(Object o);
    
}
