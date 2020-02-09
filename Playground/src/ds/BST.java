package ds;

/* Unbalanced Binary Search Tree that supports traversals,insertion,deletion,getmax and getmin ops.
 * Works with every class that has a natural ordering defined.  */

public class BST<T extends Comparable<T>> {

	private BinaryTreeNode<T> root;
	
	// inserts the given value at the correct position in the tree
	public void insert(T value) {
		BinaryTreeNode<T> toInsert = new BinaryTreeNode<T>(value);
		if (root == null) {
			root = toInsert;
		} else {
			BinaryTreeNode<T> found = root.find(value);
			if (found.value.compareTo(value) == 0) {
				return;
			} else if (found.value.compareTo(value) > 0) {
				found.left = toInsert;
			} else {
				found.right = toInsert;
			}
			toInsert.parent = found;
		}
	}
	
	// deletes the given value from the tree
	public void delete(T value) {
		if (root != null) {
			BinaryTreeNode<T> node = root.find(value);
			if (node.value.compareTo(value) == 0) {
				delete(node);
			}
		}
	}
	
	public void clear() {
		root = null;
	}
	
	// helper method that deletes the node at the given reference
	private void delete(BinaryTreeNode<T> toDelete) {
		if (toDelete == root) {
			if (toDelete.left == null && toDelete.right == null) {
				root = null;
			} else if (toDelete.left == null && toDelete.right != null) {
				root = toDelete.right;
				root.parent = null;
			} else if (toDelete.left != null && toDelete.right == null) {
				root = toDelete.left;
				root.parent = null;
			} else {
				BinaryTreeNode<T> symSucc = getSymSucc(toDelete);
				toDelete.value = symSucc.value;
				delete(symSucc);
			}
		} else {
			if (toDelete.parent.left == toDelete) {
				if (toDelete.right == null && toDelete.left == null) {
					toDelete.parent.left = null;
				} else if (toDelete.right == null && toDelete.left != null) {
					toDelete.left.parent = toDelete.parent;
					toDelete.parent.left = toDelete.left;
				} else if (toDelete.right != null && toDelete.left == null) {
					toDelete.right.parent = toDelete.parent;
					toDelete.parent.left = toDelete.right;
				} else {
					BinaryTreeNode<T> symSucc = getSymSucc(toDelete);
					toDelete.value = symSucc.value;
					delete(symSucc);
				}
			} else {
				if (toDelete.right == null && toDelete.left == null) {
					toDelete.parent.right = null;
				} else if (toDelete.right == null && toDelete.left != null) {
					toDelete.left.parent = toDelete.parent;
					toDelete.parent.right = toDelete.left;
				} else if (toDelete.right != null && toDelete.left == null) {
					toDelete.right.parent = toDelete.parent;
					toDelete.parent.right = toDelete.right;
				} else {
					BinaryTreeNode<T> symSucc = getSymSucc(toDelete);
					toDelete.value = symSucc.value;
					delete(symSucc);
				}
			}
		}
		
	}

	private BinaryTreeNode<T> getSymSucc(BinaryTreeNode<T> node) {
		if (node.right == null) {
			return null;
		} else {
			BinaryTreeNode<T> cur = node.right;
			while (cur.left != null) {
				cur = cur.left;
			}
			return cur;
		}
	}

	@SuppressWarnings("unused")
	private BinaryTreeNode<T> getSymPred(BinaryTreeNode<T> node) {
		if (node.left == null) {
			return null;
		} else {
			BinaryTreeNode<T> cur = node.left;
			while (cur.right != null) {
				cur = cur.right;
			}
			return cur;
		}
	}
	
	public T getMax() {
		if (root == null) {
			return null;
		} else {
			BinaryTreeNode<T> cur = root;
			while (cur.right != null) {
				cur = cur.right;
			}
			return cur.value;
		}
	}
	
	public T getMin() {
		if (root == null) {
			return null;
		} else {
			BinaryTreeNode<T> cur = root;
			while (cur.left != null) {
				cur = cur.left;
			}
			return cur.value;
		}
	}
	
	public String preOrder() {
		return (root != null) ? root.preOrder() : "";
	}
	
	public String postOrder() {
		return (root != null) ? root.postOrder() : "";
	}
	
	public String inOrder() {
		return (root != null) ? root.inOrder() : "";
	}

}
