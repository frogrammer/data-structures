package tree;

/**
 * Implementation of ADT binary tree
 * @author Tony Song
 *
 * @param <E>
 */
public class BinaryTree<E> extends BinaryTreeBasis<E> {
	
	public BinaryTree() {};
	
	public BinaryTree(E rootItem) {
		super(rootItem);
	}
	
	public BinaryTree(E rootItem, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
		super(rootItem);
		attachLeftSubtree(leftTree);
		attachRightSubtree(rightTree);
	}
	
	@Override
	public void setRootItem(E newItem) {
		if (!isEmpty()) {
			root.item = newItem;
		} else {
			root = new TreeNode<E>(newItem, null, null);
		}
	}
	
	/**
	 * Add an item to the left subtree if it is empty.
	 * @param newItem
	 */
	public void attachLeft(E newItem) {
		if (!isEmpty() && root.leftChild == null) {
			root.leftChild = new TreeNode<E>(newItem, null, null);
		}
	}
	
	/**
	 * Add an item to the right subtree if it is empty.
	 * @param newItem
	 */
	public void attachRight(E newItem) {
		if (!isEmpty() && root.rightChild == null) {
			root.rightChild = new TreeNode<E>(newItem, null, null);
		}
	}
	
	/**
	 * Attach a binary tree to the left subtree of the current binary tree.
	 * Throw TreeException if the binary tree is empty or the left subtree already exists.
	 * @param leftTree
	 * @throws TreeException
	 */
	public void attachLeftSubtree(BinaryTree<E> leftTree) throws TreeException {
		if (isEmpty()) {
			throw new TreeException("Empty tree");
		} else if (root.leftChild != null) {
			throw new TreeException("Cannot overwrite left subtree");
		} else {
			root.leftChild = leftTree.root;
			// the subtree is cleared after being attached
			leftTree.clear();
		}
	}
	
	/**
	 * Attach a binary tree to the right subtree of the current binary tree.
	 * Throw TreeException if the binary tree is empty or the right subtree already exists.
	 * @param rightTree
	 * @throws TreeException
	 */
	public void attachRightSubtree(BinaryTree<E> rightTree) throws TreeException {
		if (isEmpty()) {
			throw new TreeException("Empty tree");
		} else if (root.rightChild != null) {
			throw new TreeException("Cannot overwrite right subtree");
		} else {
			root.rightChild = rightTree.root;
			// the subtree is cleared after being attached
			rightTree.clear();
		}
	}
	
	protected BinaryTree(TreeNode<E> root) {
		this.root = root;
	}
	
	/**
	 * Detach the left subtree from the current binary tree, and 
	 * return the detached subtree. Throw TreeException if the binary tree is empty.
	 * @return the left subtree
	 * @throws TreeException
	 */
	public BinaryTree<E> detachLeftSubtree() throws TreeException {
		if (isEmpty()) {
			throw new TreeException("Empty tree");
		}
		
		BinaryTree<E> leftTree = new BinaryTree<E>(root.leftChild);
		root.leftChild = null;
		return leftTree;
	}
	
	/**
	 * Detach the right subtree from the current binary tree, and 
	 * return the detached subtree. Throw TreeException if the binary tree is empty.
	 * @return the right subtree
	 * @throws TreeException
	 */
	public BinaryTree<E> detachRightSubtree() throws TreeException {
		if (isEmpty()) {
			throw new TreeException("Empty tree");
		}
		
		BinaryTree<E> rightTree = new BinaryTree<E>(root.rightChild);
		root.rightChild = null;
		return rightTree;
	}
}