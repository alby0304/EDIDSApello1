/**
 * @hide
 */
package myAdapter;

import java.util.Vector;

public class ListAdapter implements HList {
    private Vector v;
    private ListIteratorAdapter it;

    // Costruttori
    public ListAdapter() {
        this.v = new Vector();
        it = new ListIteratorAdapter(this);
    }

    public ListAdapter(HCollection c) {
        this();
        addAll(c);
    }

    /*
     * Override HColletion
     */
    public boolean add(Object o) {
        excNullPtrCast(o);
        v.addElement(o);
        return true;
    }

    public boolean addAll(HCollection c) {
        if (c == null) {
            throw new NullPointerException();
        }
        boolean modified = false;
        Object[] items = c.toArray();
        for (int i = 0; i < items.length; i++) {
            boolean change = add(items[i]);
            if (change) {
                modified = true;
            }
        }
        return modified;
    }

    public void clear() {
        v.removeAllElements();
    }

    public boolean contains(Object o) {
        excNullPtrCast(o);
        return v.contains(o);
    }

    public boolean containsAll(HCollection c) {
        Object[] items = c.toArray();
        for (int i = 0; i < items.length; i++) {
            if (!contains(items[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof HCollection)) {
            return false;
        }
        HCollection c = (HCollection) o;
        if (c.size() != size()) {
            return false;
        }
        return containsAll(c);
    }

    public int hashCode() {
        int hashCode = 1;
        HIterator i = this.iterator();
        while (i.hasNext()) {
            Object obj = i.next();
            hashCode = 31 * hashCode + (obj == null ? 0 : obj.hashCode());
        }
        return hashCode;
    }

    public boolean isEmpty() {
        return v.isEmpty();
    }

    public HIterator iterator() {
        return it;
    }

    public boolean remove(Object o) {
        excNullPtrCast(o);
        return v.removeElement(o);
    }

    public boolean removeAll(HCollection c) {
        if (c == null) {
            throw new NullPointerException();
        }
        boolean modified = false;
        Object[] items = c.toArray();
        for (int i = 0; i < items.length; i++) {
            boolean change = remove(items[i]);
            if (change) {
                modified = true;
            }
        }
        return modified;
    }

    public boolean retainAll(HCollection c) {
        if (c == null) {
            throw new NullPointerException();
        }
        boolean modified = false;
        for (int i = 0; i < v.size(); i++) {
            if (!c.contains(this.get(i))) {
                remove(i);
                i--;
                modified = true;
            }
        }
        return modified;
    }

    public int size() {
        return v.size();
    }

    public Object[] toArray() {
        Object[] tmp = new Object[v.size()];
        for (int i = 0; i < v.size(); i++) {
            tmp[i] = v.elementAt(i);
        }
        return tmp;
    }

    public Object[] toArray(Object[] a) {
        if (a == null) {
            throw new NullPointerException();
        }
        if (a.length == v.size()) {
            a = toArray();
        } else if (a.length < v.size()) {
            Object[] newArray = new Object[v.size()];
            newArray = toArray();
            a = newArray;
        } else {
            for (int i = 0; i < a.length; i++) {
                if (i < v.size()) {
                    a[i] = v.elementAt(i);
                } else {
                    a[i] = null;
                }
            }
        }
        return a;
    }

    /*
     * Implement HList
     */
    public void add(int index, Object element) {
        excNullPtrCast(element);
        v.insertElementAt(element, index);// Lancia già ArrayIndexOutOfBoundsException
    }

    public boolean addAll(int index, HCollection c) {
        if (c == null) {
            throw new NullPointerException();
        }
        if (index < 0 || index > v.size()) {
            throw new IndexOutOfBoundsException();
        }
        Object[] items = c.toArray();
        for (int i = 0; i < items.length; i++) {
            add(index + i, items[i]);
        }
        return true;
    }

    public Object get(int index) {
        return v.elementAt(index);// Lancia già ArrayIndexOutOfBoundsException
    }

    public int indexOf(Object o) {
        excNullPtrCast(o);
        return v.indexOf(o); // Lancia già ArrayIndexOutOfBoundsException
    }

    public int lastIndexOf(Object o) {
        excNullPtrCast(o);
        return v.lastIndexOf(o);
    }

    public HListIterator listIterator() {
        return it;
    }

    public HListIterator listIterator(int index) {
        if (index < 0 || index > v.size()) {
            throw new IndexOutOfBoundsException();
        }
        return new ListIteratorAdapter(this, index);
    }

    public Object remove(int index) {
        Object o = get(index);
        v.removeElementAt(index);// Lancia già ArrayIndexOutOfBoundsException
        return o;
    }

    public Object set(int index, Object element) {
        excNullPtrCast(element);
        Object o = get(index);
        v.setElementAt(element, index); // Lancia già ArrayIndexOutOfBoundsException
        return o;
    }

    public HList subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > v.size() || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException();
        }
        SubList sub = new SubList(fromIndex, toIndex, this);
        return sub;
    }

    /*
     * public HList subList(int fromIndex, int toIndex) {
     * if (fromIndex < 0 || toIndex > v.size() || fromIndex > toIndex) {
     * throw new IndexOutOfBoundsException();
     * }
     * ListAdapter sub = new ListAdapter();
     * for (int i = fromIndex; i < toIndex; i++) {
     * sub.add(get(i));
     * }
     * if(fromIndex == toIndex){
     * return sub;
     * }
     * return sub;
     * }
     */

    /*
     * Helper methods
     */
    private void excNullPtrCast(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }
        if (!v.isEmpty() && !v.firstElement().getClass().isInstance(o)) {
            throw new ClassCastException();
        }
    }

    private class SubList extends ListAdapter {
        private int max;
        private int min;
        ListAdapter list;
        ListIteratorAdapter it;

        private SubList(int fromIndex, int toIndex, ListAdapter list) {
            max = toIndex;
            min = fromIndex;
            it = new ListIteratorAdapter(this, min,min);
            this.list = list;
        }

        // metodi ListAdapter
        /*
         * Override HColletion
         * 
         */

        private boolean check(int index) {
            if (index >= min && index < max) {
                return true;
            }
            return false;
        }

        /*
         * Override HColletion
         */
        @Override
        public boolean add(Object o) { // TODO Done
            list.add(max, o);
            max++;
            return true;
        }

        // @Override
        // public boolean addAll(HCollection c) { //TODO done
        // if (c == null) {
        // throw new NullPointerException();
        // }
        // boolean modified = false;
        // Object[] items = c.toArray();
        // for (int i = 0; i < items.length; i++) {
        // boolean change = add(items[i]);
        // if (change) {
        // modified = true;
        // }
        // }
        // return modified;
        // }

        @Override
        public void clear() { // TODO done
            for (int i = max - 1; i >= min; i--) {
                list.remove(i);
            }
        }

        @Override
        public boolean contains(Object o) { // TODO done
            excNullPtrCast(o);
            for (int i = min; i < max; i++) {
                if (get(i).equals(o)) {
                    return true;
                }
            }
            return false;
        }

        // Override non necessario
        // public boolean containsAll(HCollection c) {
        // Object[] items = c.toArray();
        // for (int i = 0; i < items.length; i++) {
        // if (!contains(items[i])) {
        // return false;
        // }
        // }
        // return true;
        // }

        // public boolean equals(Object o) {
        // if (o == this) {
        // return true;
        // }
        // if (!(o instanceof HCollection)) {
        // return false;
        // }
        // HCollection c = (HCollection) o;
        // if (c.size() != size()) {
        // return false;
        // }
        // return containsAll(c);
        // }

        // public int hashCode() {
        // int hashCode = 1;
        // HIterator i = this.iterator();
        // while (i.hasNext()) {
        // Object obj = i.next();
        // hashCode = 31 * hashCode + (obj == null ? 0 : obj.hashCode());
        // }
        // return hashCode;
        // }
        @Override
        public boolean isEmpty() {
            return min == max;
        }

        @Override
        public HIterator iterator() {
            return it;
        }

        @Override
        public boolean remove(Object o) {
            excNullPtrCast(o);
            try {
                return remove(indexOf(o)) != null;
            } catch (Exception e) {
                return false;
            }
        }

        @Override
        public boolean removeAll(HCollection c) {
            if (c == null) {
                throw new NullPointerException();
            }
            boolean modified = false;
            Object[] items = c.toArray();
            for (int i = min; i < max; i++) {
                boolean change = remove(items[i]);
                if (change) {
                    modified = true;
                }
            }
            return modified;
        }

        @Override
        public boolean retainAll(HCollection c) {
            if (c == null) {
                throw new NullPointerException();
            }
            boolean modified = false;
            for (int i = min; i < max; i++) {
                if (!c.contains(this.get(i))) {
                    remove(i);
                    i--;
                    modified = true;
                }
            }
            return modified;
        }

        @Override
        public int size() {
            return max - min;
        }

        @Override
        public Object[] toArray() {
            Object[] tmp = new Object[size()];
            for (int i = 0; i < size(); i++) {
                tmp[i] = get(i);
            }
            return tmp;
        }

        @Override
        public Object[] toArray(Object[] a) {
            if (a == null) {
                throw new NullPointerException();
            }
            if (a.length == size()) {
                a = toArray();
            } else if (a.length < size()) {
                Object[] newArray = new Object[size()];
                newArray = toArray();
                a = newArray;
            } else {
                for (int i = 0; i < a.length; i++) {
                    if (i < size()) {
                        a[i] = get(i);
                    } else {
                        a[i] = null;
                    }
                }
            }
            return a;
        }

        /*
         * Implement HList
         */
        @Override
        public void add(int index, Object element) { // TODO done
            if (check(index)) {
                list.add(min + index, element);
                max++;
            }
        }

        @Override
        public boolean addAll(int index, HCollection c) { // TODO done
            check(index);
            if (c == null) {
                throw new NullPointerException();
            }
            Object[] items = c.toArray();
            for (int i = 0; i < items.length; i++) {
                add(index + i, items[i]);
            }
            return true;
        }

        @Override
        public Object get(int index) { // TODO done
            if (!(check(index))) {
                throw new IndexOutOfBoundsException();
            }
            return list.get(min + index);
        }

        @Override
        public int indexOf(Object o) {
            excNullPtrCast(o);
            int index = -1;
            Object[] items = toArray();
            for (int i = min; i < max; i++) {
                if (items[i].equals(o)) {
                    return i;
                }
            }
            return index;
        }

        @Override
        public int lastIndexOf(Object o) { // TODO done
            excNullPtrCast(o);
            int index = -1;
            Object[] items = toArray();
            for (int i = min; i < max; i++) {
                if (items[i].equals(o)) {
                    index = i;
                }
            }
            return index;
        }

        @Override
        public HListIterator listIterator() { // TODO done
            return it;
        }

        @Override
        public HListIterator listIterator(int index) { // TODO done
            if (check(index)) {
                throw new IndexOutOfBoundsException();
            }
            return new ListIteratorAdapter(this, index);
        }

        @Override
        public Object remove(int index) { // TODO done
            Object o = get(index);
            list.remove(min + index);
            return o;
        }

        @Override
        public Object set(int index, Object element) {// TODO done
            excNullPtrCast(element);
            Object o = get(index);
            list.set(min + index, element);
            return o;
        }

        public HList subList(int fromIndex, int toIndex) {
            if (fromIndex < 0 || toIndex > size() || fromIndex > toIndex) {
                throw new IndexOutOfBoundsException();
            }
            SubList sub = new SubList(min + fromIndex, min + toIndex, this);
            return sub;
        }

    }
}
