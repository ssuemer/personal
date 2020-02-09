package ds;

/* Tree Node that has recursive methods to be used in BST implementations.
 * Stores items that have a natural ordering defined.
 */

public class BinaryTreeNode<T extends Comparable<T>> {
	
	BinaryTreeNode<T> left,right,parent;
	T value;

	public BinaryTreeNode(T value) {
		this.value = value;
	}
	

	BinaryTreeNode<T> find(T value) {
		if (value.compareTo(this.value) == 0) { // if found,return reference to this node
			return this;
		} else if (value.compareTo(this.value) > 0) {
			if (right == null) { // if should be right child,return reference to this node
				return this;
			} else { // search in right subtree
				return right.find(value);
			}
		} else {
			if (left == null) { // if should be left child,return reference to this node
				return this;
			} else { // search in left subtree
				return left.find(value);
			}
		}
	}
	
	// prints out the values of the subtree with <code>this<code> as root in preorder
	String preOrder() {
		String out = value.toString() + " ";
		if (left != null) {
			out += left.preOrder() + " ";
		}
		if (right != null) {
			out += right.preOrder();
		}
		return out;
	}
	
	// prints out the values of the subtree with <code>this<code> as root in postorder
	String postOrder() {
		String out = "";
		if (left != null) {
			out += left.postOrder() + " ";
		}
		if (right != null) {
			out += right.postOrder() + " ";
		}
		out += value.toString();
		return out;
	}
	
	// prints out the values of the subtree with <code>this<code> as root in order (sorted order)
	String inOrder() {
		String out = "";
		if (left != null) {
			out += left.inOrder() + " ";
		}
		out += value.toString();
		if (right != null) {
			out += " " + right.inOrder();
		}
		return out;
	}
	
}
