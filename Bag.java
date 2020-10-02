import java.util.*;

public class Bag<A> implements Iterable<A> {
  private LinkedQueue<A> items;

  public Bag() {
    items = new LinkedQueue<>();
  }

  public void add(A item) {
    items.enq(item);
  }

  public Iterator<A> iterator() {
    return items.iterator();
  }
}
