

public class Queue {

	QueueNode front;
	QueueNode rear;

	public void enqueue(TreeNode node) {
		
		QueueNode new_node = new QueueNode(node);
		
		if (this.front == null) {
			this.front = new_node;
			this.rear = new_node;
		} else {
			this.rear.next = new_node;
			this.rear = new_node;
		}
	}

	public TreeNode dequeue() {
		
		if (this.front == null) {
			return null;
		}
		
		QueueNode temp = this.front;
		this.front = this.front.next;
		
		if (this.front == null) {
			this.rear = null;
		}
		return temp.node;
	}

	public boolean isEmpty() {
		if (this.front == null) {
			return true;
		}
		return false;
	}
}
