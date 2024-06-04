/**
 * @hide
 */
package myAdapter;

import java.util.NoSuchElementException;

public class ListIteratorAdapter implements HListIterator
{
    private int index = 0;
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

    /*
    **  Override HIterator
    */
    @Override
    public boolean hasNext(){
        return index<l.size();
    }

    @Override
    public Object next(){
        if(!hasNext()){
            throw  new NoSuchElementException();
        }
        return l.get(index++);
    }

    @Override
    public void remove(){
        l.get(index);
    }
    
    /*
    **  HListIterator
    */
   public void add(Object o){
        l.add(o);       
   }

   public boolean hasPrevious(){
        return (index>=0);
   }

    public int nextIndex(){
        return (index +1);
    }
    
    public Object previous(){
        if(!hasPrevious()){
            throw new NoSuchElementException();
        }
        return l.get(index--);
    }
    
    public int previousIndex()
    {
        return (index -1);
    }

    public void set(Object o){
        l.set(l.size()-1,o);
    }
    
    
    
}

