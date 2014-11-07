import java.util.LinkedList;

public class Queue {
	private LinkedList<Object> list;
	private int size;
	
	public Queue() {
		
		list = new LinkedList<Object>();
		size = 0;
	}
	public String elements() {
		
		StringBuilder builder = new StringBuilder();
		for (Object item : list){
			builder.append(" ");
			builder.append(item.toString());
			
		}
		return builder.toString();
	}

	public boolean isEmpty() {
		
		return (list.size() == 0);
	}

	public void enqueue(Object item) {

		list.add(item);
		size++;
	}

	public Object dequeue() {

		Object item = list.get(1);
		list.remove(1);
		size--;
		return item;
		
	}

	public Object peek() {

		return list.get(1);
	}
	
	public int size() {
		
		return size;
	}
}