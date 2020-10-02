import java.util.*;

public class LinkedQueue<A> implements Iterable<A> {
  private class Node {
    private A value;
    private Node next;
  }

  // Queue = FIFO
  // keep pointers to both ends of the
  // list so we can add/remove items to/from
  // each end
  private Node first;
  private Node last;


  private class QueueIterator implements Iterator<A> {
    private Node current = first;

    public boolean hasNext() {
      return current != null;
    }

    public A next(){
      A tmp = current.value;
      current = current.next;
      return tmp;
    }
  }

  public Iterator<A> iterator() {
    return new QueueIterator();
  }

  public LinkedQueue() {
    first = null;
    last = null;
  }

  public boolean isEmpty() {
    return first == null;
  }

  // add to the end
  public void enq(A item) {
    Node n = new Node();
    n.value = item;
    if (first == null) {
      first = n;
      last = first;
    } else {
      Node tmp = last;
      tmp.next = n;
      last = n;
    }
  }

  // remove from the begining
  public A deq() {
    A val = first.value;
    first = first.next;
    return val;
  }

  public static void main(String[] args) {
    LinkedQueue<Integer> q = new LinkedQueue<>();
    q.enq(1);
    q.enq(2);
    System.out.println(q.deq());
  }
}
