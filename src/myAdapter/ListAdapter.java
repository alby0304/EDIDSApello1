package myAdapter;
import java.util.Vector;

public class ListAdapter implements HList, HListIterator {
    private Vector<HCollection> v;

    ListAdapter(){
        v = new Vector<HCollection>();
    }
    ListAdapter(HCollection o){
        this.v = v;
    }




}
