package bag;

import java.util.Iterator;
import java.util.NoSuchElementException;
public class bag <Item> implements Iterable <Item> {
    private Node<Item> node;
    private int size;

    public bag(){
        this.node = null;
        this.size = 0;
    }

    public void add(Item Item) {
        Node<Item> oldNode = node;
        node = new Node<>(Item);
        node.next = oldNode;
        size++;
    }

    public int getSize(){return this.size;}

    public boolean IsEmpty() {return size == 0;}


    @Override
    public Iterator<Item> iterator(){
        return new bagIterator();
    }

    private class bagIterator implements Iterator<Item> {
        private Node<Item> current = node;


        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item data = current.data;
            current = current.next;
            return data;
        }
    }
}
