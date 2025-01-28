package a2023_08_10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class First implements Iterator<Integer> {

    Collection<Integer> collection;
    Iterator<Integer> iterator;
    Integer next = null;

    public First(Collection<Integer> collection) {
        this.collection = collection;
        iterator = collection.iterator();
    }

    public boolean hasNext() {
        while (next == null && iterator.hasNext()) {
            Integer value = iterator.next();
            if (value % 2 == 0) {
                next = value;
            }
        }
        return next != null;
    }

    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Integer value = Integer.valueOf(next);
        next = null;
        return value;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>() {{
            add(1);
            add(4);
            add(5);
            add(17);
            add(18);

        }};
        First first = new First(list);
        while (first.hasNext()) {
            System.out.println(first.next());
        }
    }
}
