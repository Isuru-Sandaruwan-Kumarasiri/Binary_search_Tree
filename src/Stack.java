

public class Stack {

	StackNode top;

	public void push(TreeNode data) {
		StackNode new_node = new StackNode(data);
		new_node.next = top;
		this.top = new_node;
	}

	public TreeNode pop() {
		
		if (this.top != null) {
			StackNode temp = this.top;
			this.top = top.next;
			return temp.node;
		}
		return null;
	}

	public boolean isEmpty() {
		if (this.top == null) {
			return true;
		}
		return false;
	}
}
