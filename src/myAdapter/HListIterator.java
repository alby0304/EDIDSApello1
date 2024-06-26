package myAdapter;

/**
 * An iterator for traversing a list bidirectionally.
 * 
 * <p>
 * This interface extends the {@link HIterator} interface and provides additional methods
 * to add, remove, and modify elements in a list.
 * </p>
 * 
 * @param <T> the type of elements in the list
 * @see HIterator
 * @since Java Unit 4
 */
public interface HListIterator extends HIterator {
    
    /**
     * Inserts the specified element into the list.
     * 
     * @param o the element to be added
     */
    public void add(Object o);
    
    /**
     * Returns true if this list iterator has a previous element.
     * 
     * @return true if the list iterator has a previous element, false otherwise
     */
    public boolean hasPrevious();
    
    /**
     * Returns the index of the next element.
     * 
     * @return the index of the next element
     */
    public int nextIndex();
    
    /**
     * Returns the previous element in the list.
     * 
     * @return the previous element in the list
     */
    public Object previous();
    
    /**
     * Returns the index of the previous element.
     * 
     * @return the index of the previous element
     */
    public int previousIndex();
    
    /**
     * Replaces the last element returned by the most recent call to {@link #next} or {@link #previous} with the specified element.
     * This method can be called only after a call to {@link #next} or {@link #previous} has been made, but not after a call to {@link #remove} or {@link #add}.
     *
     * @param o the element to be set
     * @throws IllegalStateException if neither {@link #next} nor {@link #previous} have been called, or {@link #remove} or {@link #add} have been called after the last call to {@link #next} or {@link #previous}
     */
    public void set(Object o);
    
}
