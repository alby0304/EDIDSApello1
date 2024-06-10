package myTest;
import myAdapter.*;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestRunner {

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
    public void size(){
        final int add = 1;
        ListAdapter list = new ListAdapter();
        list.add(add);
        list.add(add);
        assertEquals(2,list.size());
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
