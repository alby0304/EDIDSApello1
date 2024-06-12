package myTest;

import java.util.ListIterator;
import myAdapter.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

public class ListIteratorAdapterTest {
        
        ListAdapter list;
        ListIteratorAdapter it;

        @Before
        public  void setup(){
                list = new ListAdapter();
                it = new ListIteratorAdapter(list);
        }


        @Test
        public void constructor(){
                list.add(1);
                HListIterator iter = list.listIterator();
                assertEquals(it.next(),iter.next());
                assertEquals(false,iter.hasNext());
                assertEquals(it.hasNext(),iter.hasNext());
        }

        @Test
        public void add(){
               it.add(1);
               assertEquals(1,it.next());
               assertEquals(1,list.get(0));
        }

        @Test
        public void hasNext(){
               assertEquals(false,it.hasNext());
               it.add(1);
               assertEquals(true,it.hasNext());
        }

        @Test
        public void hasPrev(){
               assertEquals(false,it.hasPrevious());
               it.add(1);
               it.next();
               assertEquals(true,it.hasPrevious());
        }

        @Test
        public void next(){
               it.add(1);
               assertEquals(1,it.next());
        }

        @Test
        public void nextIndex(){
               it.add(1);
               assertEquals(1,it.nextIndex());
        }

        @Test
        public void prev(){
               it.add(1);
               assertEquals(1,it.next());
               assertEquals(1,it.previous());
        }

        @Test
        public void previousIndex(){
                assertEquals(-1,it.previousIndex());
        }

        @Test
        public void remove()
        {

        }

        @Test 
        public void set()
        {
                it.add(1);
                it.set(2);
                assertEquals(2,it.next());
                
        }



}
