package myTest;

import myAdapter.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;


public class ListAdapterTest {
        //N - E - G - R - I    <----- NON CANCELLARE
       
    @Test
    public void add(){
        final int add = 1;
        ListAdapter list = new ListAdapter();
        list.add(add);
        assertEquals(add, list.get(0));
    }

    @Test(expected = ClassCastException.class)
    public void addDifferentType(){
        final int add = 1;
        final boolean bool = true;
        ListAdapter list = new ListAdapter();
        list.add(add);
        list.add(bool);
    }

    @Test
    public void addDouble(){
        final int add = 1;
        ListAdapter list = new ListAdapter();
        list.add(add);
        list.add(add +1);
        assertEquals(2, list.get(1));
    }

    @Test
    public void addRemoveObj(){
        //uso double perchè con int confonde metodo
        final double add = 2.7;
        ListAdapter list = new ListAdapter();
        list.add(add);
        assertEquals(true,list.remove(add));
    }
    
    @Test
    public void addRemoveIndex(){
        final int add = 1;
        ListAdapter list = new ListAdapter();
        list.add(add);
        assertEquals(add,list.remove(0));
    }

    @Test
    public void addAll(){
        final int add = 1;
        final int[] giusto = {1,2,3};
        ListAdapter list = new ListAdapter();
        list.add(add);
        ListAdapter list2 = new ListAdapter();
        list2.add(2);
        list2.add(3);
        list.addAll(list2);
        assertEquals(giusto[0],list.get(0));
        assertEquals(giusto[1],list.get(1));
        assertEquals(giusto[2],list.get(2));
    }

    @Test
    public void addAllIndex(){
        final int add = 1;
        final int[] giusto = {1,2,3};
        ListAdapter list = new ListAdapter();
        list.add(add);
        list.add(add);
        ListAdapter list2 = new ListAdapter();
        list2.add(2);
        list2.add(3);
        list.addAll(1,list2);
        assertEquals(giusto[0],list.get(0));
        assertEquals(giusto[1],list.get(1));
        assertEquals(giusto[2],list.get(2));
        assertEquals(giusto[0],list.get(3));
        
    }

    @Test
    public void clear(){
        final int add = 1;
        ListAdapter list = new ListAdapter();
        list.add(add);
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void contains(){
        final int add = 1;
        ListAdapter list = new ListAdapter();
        list.add(add);
        assertEquals(true,list.contains(1));
    }

    @Test
    public void containsAll(){
        final int add = 1;
        ListAdapter list = new ListAdapter();
        list.add(add);
        list.add(2);
        list.add(3);
        ListAdapter list2 = new ListAdapter();
        list2.add(2);
        list2.add(3);
        assertEquals(true,list.containsAll(list2));
    }

    @Test
    public void equals(){
        ListAdapter list = new ListAdapter();
        list.add(1);
        list.add(2);
        ListAdapter list2 = new ListAdapter();
        list2.add(1);
        list2.add(2);
        assertEquals(true,list.equals(list));
        assertEquals(true,list.equals(list2));
    }

    @Test
    public void get(){
        final int add = 1;
        ListAdapter list = new ListAdapter();
        list.add(add);
        assertEquals(add,list.get(0));
    }

    @Test
    public void testHashCode(){
        final int add = 1;
        ListAdapter list = new ListAdapter();
        list.add(add);
        int n = 32;
        assertEquals(n,list.hashCode());
        
    }

    @Test
    public void indexOF(){
        final int add = 1;
        ListAdapter list = new ListAdapter();
        list.add(add);
        assertEquals(0,list.indexOf(add));
    }

    @Test
    public void isEmpty(){
        final int add = 1;
        ListAdapter list = new ListAdapter();
        list.add(add);
        assertEquals(false,list.isEmpty());
    }

    @Test
    public void iterator(){
        final int add = 1;
        ListAdapter list = new ListAdapter();
        HIterator it = list.iterator();
        assertEquals(it,list.iterator());
    }

    @Test
    public void lastIndexOf(){
        final int add = 1;
        ListAdapter list = new ListAdapter();
        list.add(add);
        list.add(add);
        assertEquals(1,list.lastIndexOf(add));
    }

    @Test
    public void ListIterator(){
        final int add = 1;
        ListAdapter list = new ListAdapter();
        HListIterator it = list.listIterator();
        assertEquals(it,list.iterator());
    }

    @Test
    public void ListIteratorIndex(){
        final int add = 1;
        ListAdapter list = new ListAdapter();
        list.add(add);
        assertEquals(add,list.listIterator(0).next());
    }

    @Test
    public void removeAll(){
        ListAdapter list = new ListAdapter();
        list.add(1);
        list.add(2);
        list.add(3);
        ListAdapter list2 = new ListAdapter();
        list2.add(2);
        list2.add(3);
        assertEquals(true,list.removeAll(list2));
        Object[] vett = list.toArray();
        assertEquals(1,vett[0]);
        assertEquals(1,vett.length);
    }

    @Test
    public void retainAll(){
        ListAdapter list = new ListAdapter();
        list.add(1);
        list.add(2);
        list.add(3);
        ListAdapter list2 = new ListAdapter();
        list2.add(2);
        list2.add(3);
        assertEquals(true,list.retainAll(list2));
        Object[] vett = list.toArray();
        assertEquals(2,vett[0]);
        assertEquals(3,vett[1]);
        assertEquals(2,vett.length);
    }

    @Test
    public void set()
    {
        ListAdapter list = new ListAdapter();
        list.add(1);
        list.add(2);
        list.add(3);
        Object remove = list.set(2, 4);
        assertEquals(3,remove);
        assertEquals(4,list.get(2));
    }

    @Test
    public void size(){
        final int add = 1;
        ListAdapter list = new ListAdapter();
        list.add(add);
        list.add(add);
        assertEquals(2,list.size());
    }

    @Test
    public void SubList()
    {
        ListAdapter list = new ListAdapter();
        list.add(1);
        list.add(2);
        list.add(3);
        HList sub = list.subList(0, 1);
        sub.add(4);
        sub.add(1,5);
        assertEquals(5,sub.get(1));
        assertEquals(5,list.get(1));
        assertEquals(4,list.get(2));
        assertEquals(2,list.get(3));
    }

    @Test
    public void toArray(){
        ListAdapter list = new ListAdapter();
        list.add(1);
        list.add(2);
        list.add(3);
        Object[] fine  = list.toArray();
        assertEquals(list.get(0),fine[0]);
        assertEquals(list.get(1),fine[1]);
        assertEquals(list.get(2),fine[2]);
    }

    @Test
    public void toArrayObjectArray(){
        ListAdapter list = new ListAdapter();
        list.add("1");
        list.add("2");
        list.add("3");
        String[] vet = new String[2];
        Object[] fine  = list.toArray(vet); //viene ridimensionato 
        assertEquals(list.get(0),fine[0]);
        assertEquals(list.get(1),fine[1]);
        assertEquals(list.get(2),fine[2]);
    }

}

/*
 * public static void main(String[] args) {
 * ListAdapter list = new ListAdapter();
 * list.add(1);
 * list.add(2);
 * list.add(3);
 * list.add(4);
 * list.add(5);
 * System.out.println("Lista: " + list);
 * ListIteratorAdapter listIterator = new ListIteratorAdapter(list);
 * System.out.println("ListaIterator: " + listIterator);
 * System.out.println("HasNext: " + listIterator.hasNext());
 * System.out.println("NextIndex: " + listIterator.nextIndex());
 * System.out.println("Next: " + listIterator.next());
 * System.out.println("HasPrevious: " + listIterator.hasPrevious());
 * System.out.println("PreviousIndex: " + listIterator.previousIndex());
 * System.out.println("Previous: " + listIterator.previous());
 * System.out.println("Previous2: " + listIterator.previous());
 * System.out.println("Next: " + listIterator.next());
 * listIterator.add(6);
 * System.out.println("Lista: " + list);
 * System.out.println("ListaIterator: " + listIterator);
 * listIterator.set(7);
 * System.out.println("Lista: " + list);
 * System.out.println("ListaIterator: " + listIterator);
 * 
 * for (Object element : list.toArray()) {
 * System.out.println(element);
 * }
 * 
 * }
 */
