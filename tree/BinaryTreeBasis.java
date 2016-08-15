package tree;

/**
 * Abstract class for the ADT binary tree
 * @author Tony Song
 *
 * @param <E>
 */
public abstract class BinaryTreeBasis<E> {
	// the root should only be accessed by subclasses
	protected TreeNode<E> root;
	
	public BinaryTreeBasis() {
		root = null;
	}
	
	public BinaryTreeBasis(E rootItem) {
		root = new TreeNode<E>(rootItem, null, null);
	}
	
	/**
	 * Return true if the tree is empty.
	 * @return a boolean
	 */
	public boolean isEmpty() {
		return root == null;
	}
	
	/**
	 * Remove all nodes from the tree.
	 */
	public void clear() {
		root = null;
	}
	
	/**
	 * Return the item in the tree's root. Throw TreeException 
	 * if the tree is empty.
	 * @return the item of the root node
	 * @throws TreeException
	 */
	public E getRootItem() throws TreeException {
		if (isEmpty()) {
			throw new TreeException("The tree is empty");
		}
		return root.item;
	}
	
	/**
	 * Set the item of the root node
	 * @param newItem
	 */
	public abstract void setRootItem(E newItem);
}
