package MultiThreading;
/**
 * Class: BST
 * 
 * @author Daniel Liang- modfied by C. Johnson
 * @version 1.0 Course : ITEC 3150, Spring, 2016 Modified: February 2016
 * 
 * 
 *          This class : Implementation of a generic binary search tree
 * 
 *          Purpose: This class is created for use in Spring, 2016 Homework 3
 *
 */

public class BST<E extends Comparable<E>>
{
    protected TreeNode<E> root;
    protected int size = 0;

    /*
     * Method: Constructors
     * 
     * Default Constructor
     * 
     */
    public BST()
    {
    }

 

    /*
     * Method: search
     * 
     * Returns true if the element is in the tree
     * 
     * @param E
     * @return boolean
     */
    public boolean search(E e)
    {
        TreeNode<E> current = root; // Start from the root

        while (current != null)
        {
            if (e.compareTo(current.element) < 0)
            {
                current = current.left;
            } else if (e.compareTo(current.element) > 0)
            {
                current = current.right;
            } else
                // element matches current.element
                return true; // Element is found
        }

        return false;
    }

  
    /*
     * Method: insert
     * 
     * Insert element o into the binary tree Return true if the element is
     * inserted successfully
     * 
     * @param E
     * @return boolean
     */
    public boolean insert(E e)
    {
        if (root == null)
            root = createNewNode(e); // Create a new root
        else
        {
            // Locate the parent node
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null)
                if (e.compareTo(current.element) < 0)
                {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0)
                {
                    parent = current;
                    current = current.right;
                } else
                    return false; // Duplicate node not inserted

            // Create the new node and attach it to the parent node
            if (e.compareTo(parent.element) < 0)
                parent.left = createNewNode(e);
            else
                parent.right = createNewNode(e);
        }

        size++;
        return true; // Element inserted successfully
    }

    /*
     * Method: removeSmallest
     * 
     * Removes smallest value in the tree
     * 
     * @return E
     * 
     */
    public E removeSmallest()
    {
    	// the smallest value in a BST is the left most node-> Go left until can't go left anymore
    	TreeNode<E> currentNode = root;
    	E returnValue = null;
    	
    	if (root == null)
    	{
    		return null;
    	}
    	else
    	{
    		while (currentNode.left != null)
    		{
    			currentNode = currentNode.left;
    		}
    		returnValue = currentNode.element;
    		delete(returnValue);
    		return returnValue;
    	}
    	
    }
    
    
    
    /*
     * Method: createNewNode
     * 
     * Creates new TreeNode
     * 
     * @param E
     * @return TreeNode<E>
     */
    protected TreeNode<E> createNewNode(E e)
    {
        return new TreeNode<E>(e);
    }

    /*
     * Method: inorder
     * 
     * Inorder traversal from the root
     * 
     */
    public void inorder()
    {
        inorder(root);
    }


    /*
     * Method: inorder
     * 
     * Inorder recursive helper method
     * 
     * @param TreeNode<E>
     */
    protected void inorder(TreeNode<E> root)
    {
        if (root == null)
            return;
        inorder(root.left);
        System.out.println(root.element);
        inorder(root.right);
    }

    /**
     * Class: TreeNode
     * 
     * @author Daniel Liang modified by C. Johnson
     * @version 1.0 Course : ITEC 3150, Spring, 2016 Written: February, 2016
     * 
     * 
     *          This class : Node of binary tree.This inner class is static,
     *          because it does not access any instance members defined in its
     *          outer class
     * 
     *          Purpose: This class is created for use in Spring, 2016 Homework
     *          3
     *
     */

    public static class TreeNode<E extends Comparable<E>>
    {
        protected E element;
        protected TreeNode<E> left;
        protected TreeNode<E> right;

        /**
         * Constructor for tree node
         * 
         * @param e
         */
        public TreeNode(E e)
        {
            element = e;
        }
    }

 
    /*
     * Method: delete
     * 
     * Delete an element from the binary tree. Return true if the element is
     * deleted successfully Return false if the element is not in the tree
     * 
     * @param E
     */
    public boolean delete(E e)
    {
        // Locate the node to be deleted and also locate its parent node
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while (current != null)
        {
            if (e.compareTo(current.element) < 0)
            {
                parent = current;
                current = current.left;
            } else if (e.compareTo(current.element) > 0)
            {
                parent = current;
                current = current.right;
            } else
                break; // Element is in the tree pointed at by current
        }

        if (current == null)
            return false; // Element is not in the tree

        // Case 1: current has no left child
        if (current.left == null)
        {
            // Connect the parent with the right child of the current node
            if (parent == null)
            {
                root = current.right;
            } else
            {
                if (e.compareTo(parent.element) < 0)
                    parent.left = current.right;
                else
                    parent.right = current.right;
            }
        } else
        {
            // Case 2: The current node has a left child
            // Locate the rightmost node in the left subtree of
            // the current node and also its parent
            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;

            while (rightMost.right != null)
            {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right; // Keep going to the right
            }

            // Replace the element in current by the element in rightMost
            current.element = rightMost.element;

            // Eliminate rightmost node
            if (parentOfRightMost.right == rightMost)
                parentOfRightMost.right = rightMost.left;
            else
                // Special case: parentOfRightMost == current
                parentOfRightMost.left = rightMost.left;
        }

        size--;
        return true; // Element deleted successfully
    }

    /*
     * Method: clear
     * 
     * Remove all nodes from the tree.
     */
    public void clear()
    {
        root = null;
        size = 0;
    }
}
