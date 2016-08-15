package tree;

/**
 * Node in a binary tree
 * @author Tony Song
 *
 * @param <E>
 */
class TreeNode<E> {
	E item;
	TreeNode<E> leftChild;
	TreeNode<E> rightChild;
	
	public TreeNode(E newItem) {
		item = newItem;
		leftChild = null;
		rightChild = null;
	}
	
	public TreeNode(E newItem, TreeNode<E> left, TreeNode<E> right) {
		item = newItem;
		leftChild = left;
		rightChild = right;
	}
}
