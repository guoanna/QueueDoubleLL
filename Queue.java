public interface Queue<Item> {
  void enqueue (Item item);
  Item dequeue();
  int size();
  boolean isEmpty();
}
