/**
 * @hide
 */
package myAdapter;

import java.util.NoSuchElementException;

public class ListIteratorAdapter implements HListIterator
{
    private int index = 0;
    private int min = 0;
    private ListAdapter l;

    // Costruttori
    public ListIteratorAdapter(){
        l = new ListAdapter();
        index = 0;
    }
    
    public ListIteratorAdapter(ListAdapter o){
        this.l = o;
        index = 0;
    }

    public ListIteratorAdapter(ListAdapter o, int index){
        this.l = o;
        this.index = index;
    }
    public ListIteratorAdapter(ListAdapter o, int index, int min){
        this.l = o;
        this.index = index;
        this.min = min;
    }

    
    /** 
     * @return boolean
     */
    /*
    **  Override HIterator
    */
    @Override
    public boolean hasNext(){
        return index<l.size()+min;
    }

    
    /** 
     * @return Object
     */
    @Override
    public Object next(){
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        return l.get(index++); //incremento viene fatto post
    }

    @Override
    public void remove(){
        if(index<=min)
            throw new IllegalStateException();
        index--;
        l.remove(index);
    }
    
    
    /** 
     * @param o
     */
    /*
    **  HListIterator
    */
   public void add(Object o){
        l.add(index,o);    
   }

   public boolean hasPrevious(){
        return (index>min);
   }

    public int nextIndex(){
        return (index +1);
    }
    
    public Object previous(){
        if(!hasPrevious()){
            throw new NoSuchElementException();
        }
        index--; //decremento devo farlo prima
        return l.get(index);
    }
    
    public int previousIndex()
    {
        return (index -1);
    }

    public void set(Object o){
        l.set(index,o);
    }
    
    
    
}

