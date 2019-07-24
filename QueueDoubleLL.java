import java.util.*;

public class QueueDoubleLL<Item> implements Queue<Item> {

  //MEMBER VARIABLES
  Node first;
  Node last;
  int n;

  //CLASS DEFINITION OF NODE
  class Node {
    Item info;
    Node next;
    Node prev; //pointer to previous node


    //CONSTRUCTOR
    Node(Item info, Node next, Node prev){
      this.info = info;
      this.next = next;
      this.prev = prev;
    }
  }

  //CONSTRUCTOR: initialize values
  QueueDoubleLL() {
    this.first = null;
    this.last = null;
    this.n = 0;
  }

  //METHODS from queue interface

  //ENQUEUE: add something to end of queue
  public void enqueue (Item item){
    Node newlast = new Node(item, null, null); //create new node for incoming Item

    //if list is empty, first will point at the new Node
    if (last == null){
      first = newlast;
    }
    //if list is not empty, point the old last node pointer to the newlast and prev pointer of newlast to last
    else {
      last.next = newlast;
      newlast.prev = last;
    }

    //in all cases, last pointer points to the new node
    last = newlast;
    n++; //increase list size by 1

  }


  //DEQUEUE: remove front of queue
  public Item dequeue(){
    // If the queue is empty, just throw an exception.
    if (size() == 0) {
      throw new NoSuchElementException("Empty queue");
    }
    Item toReturn = first.info; //returning info in the front of the queue
    first = first.next; //move first pointer to second in queue

    // make sure previous is not pointing at something else, the first previous pointer should be null
    if (first != null) {
      first.prev = null;
    }
    //if there was no second node, last would be pointing at the node just deleted
    if (first == null) {
      last = null;
    }

    n--; //decrease list size by 1
    return toReturn; //return dequeue info
  }

  //SIZE: return queue size
  public int size(){
    return n;
  }

  //ISEMPTY: return boolean if queue is empty or not
  public boolean isEmpty(){
    return (n==0);
  }


  public static void main(String[] args) {

      Queue<String> myq = new QueueDoubleLL<String>();

      myq.enqueue("California");
      myq.enqueue("Connecticut");
      myq.enqueue("Nevada");

      System.out.println("The queue is length: " + myq.size());
      while (!myq.isEmpty()) {
        System.out.format("Dequeuing %s\n", myq.dequeue());
      }
      System.out.println("The queue is now length: " + myq.size());

  }



}
