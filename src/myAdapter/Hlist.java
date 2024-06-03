package myAdapter;

/**
 * Una Collection ordinata nota anche come sequenza 
 * 
 * */
public interface HList extends HCollection {    
    
    /**
     * 
     * @param index
     * @param element
     */
    public void add(int index, Object element);
    
    /**
     * 
     * @param index
     * @param c
     * @return
     */
    public boolean addAll(int index, HCollection c);

    /**
     * 
     * @param index
     * @return
     */
    public Object get(int index);

    /**
     * 
     * @param o
     * @return
     */
    public int indexOf(Object o);

    /**
     * 
     * @param o
     * @return
     */
    public int lastIndexOf(Object o);

    /**
     * 
     * @return
     */
    public HListIterator listIterator();

    /**
     * 
     * @param index
     * @return
     */
    public HListIterator listIterator(int index);

    /**
     * 
     * @param index
     * @return
     */
    public Object remove(int index);

    /**
     * 
     * @param index
     * @param element
     * @return
     */
    public Object set(int index, Object element);

    /**
     * 
     * @param fromIndex
     * @param toIndex
     * @return
     */
    public HList subList(int fromIndex, int toIndex);

}