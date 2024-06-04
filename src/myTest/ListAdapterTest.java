package myTest;
import myAdapter.*;


public class ListAdapterTest {
    public static void main(String[] args) {
        ListAdapter list = new ListAdapter();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println("Lista: " + list);
        ListIteratorAdapter listIterator = new ListIteratorAdapter(list);
        System.out.println("ListaIterator: " + listIterator);
        System.out.println("HasNext: " + listIterator.hasNext());
        System.out.println("NextIndex: " + listIterator.nextIndex());
        System.out.println("Next: " + listIterator.next());
        System.out.println("HasPrevious: " + listIterator.hasPrevious());
        System.out.println("PreviousIndex: " + listIterator.previousIndex());
        System.out.println("Previous: " + listIterator.previous());
        System.out.println("Previous2: " + listIterator.previous());
        System.out.println("Next: " + listIterator.next());
        listIterator.add(6);
        System.out.println("Lista: " + list);
        System.out.println("ListaIterator: " + listIterator);
        listIterator.set(7);
        System.out.println("Lista: " + list);
        System.out.println("ListaIterator: " + listIterator);
        
        for (Object element : list.toArray()) {
            System.out.println(element);
        }

    }
}


