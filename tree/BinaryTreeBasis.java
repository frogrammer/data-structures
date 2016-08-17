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
	 * Recursive helper method for traversal.
	 * @param rootNode
	 * @param order
	 */
	private void traverse(TreeNode<E> rootNode, String order) {
		if (rootNode != null) {
			switch (order) {
				case "preorder":
					System.out.print(rootNode.item + " ");
					traverse(rootNode.leftChild, order);
					traverse(rootNode.rightChild, order);
					break;
				case "inorder":
					traverse(rootNode.leftChild, order);
					System.out.print(rootNode.item + " ");
					traverse(rootNode.rightChild, order);
					break;
				case "postorder":
					traverse(rootNode.leftChild, order);
					traverse(rootNode.rightChild, order);
					System.out.print(rootNode.item + " ");
					break;
			}
		}
	}
	
	/**
	 * Traverse and print the binary tree in preorder.
	 */
	public void preorder() {
		traverse(root, "preorder");
	}
	
	/**
	 * Traverse and print the binary tree in inorder.
	 */
	public void inorder() {
		traverse(root, "inorder");
	}
	
	/**
	 * Traverse and print the binary tree in postorder.
	 */
	public void postorder() {
		traverse(root, "postorder");
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
	 * Set the item of the root node.
	 * @param newItem
	 */
	public abstract void setRootItem(E newItem);
}
