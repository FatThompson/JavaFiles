// Stuart Reges / Marty Stepp
// 2/22/06, updated Nov 2010
//
// Simple class that includes methods to construct a random tree of ints, to
// print the structure, and to print the data using a preorder, inorder or
// postorder traversal.
/**
 * For midterm
 * @author Matthew Thompson
 *
 */
public class IntTree
{



	/// Make countLeaves method here work- you may add additional methods and change the existing code
	// if needed

	public int countLeaves()
	{
		//check if root is null
		if(getRoot()!=null) 
		{
			//send to the recursive counter
			return countLeaves(getRoot());
		}
		else 
			return 0;
	}

	public int countLeaves(IntTreeNode node)
	{
		//If the node is null, return nothing
		if( node == null )
		{
			return 0;
		}
		//if both are null, we hit the end of the branch, so add one
		else if( node.left == null && node.right == null ) 
		{
			return 1;
		}
		//continue down the branch
		else 
		{
			return countLeaves(node.left) + countLeaves(node.right);
		}
	}






	// DON"T CHANGE ANYTHING BELOW HERE


	private IntTreeNode overallRoot;


	public IntTree()
	{
		overallRoot = null;
	}

	// pre : height >= 0
	// post: constructs a perfect binary tree of given height with random
	// data values between 0 and 99 inclusive
	public IntTree(int height)
	{
		if (height < 0)
		{
			throw new IllegalArgumentException();
		}
		overallRoot = randomTree(height);
	}

	private IntTreeNode randomTree(int h)
	{
		return randomTree(h, true);
	}

	// pre : height >= 0
	// post: constructs and returns a reference to a perfect binary tree
	// of height h with random data values between 0 and 99 inclusive
	private IntTreeNode randomTree(int h, boolean perfect)
	{
		if (h == 0)
		{
			return null;
		} else
		{
			int n = (int) (Math.random() * 100);
			IntTreeNode node = new IntTreeNode(n);
			if (perfect || Math.random() >= 0.75)
			{
				node.left = randomTree(h - 1);
			}
			if (perfect || Math.random() >= 0.75)
			{
				node.right = randomTree(h - 1);
			}
			return node;
		}
	}

	public IntTree(String s)
	{
		overallRoot = fromString(new StringBuilder(s.toLowerCase().trim()));
	}

	public boolean equals(Object o)
	{
		IntTreeNode.clearCycleData();
		if (o instanceof IntTree)
		{
			IntTree other = (IntTree) o;
			return this.overallRoot == other.overallRoot
					|| equals(this.overallRoot, other.overallRoot);
		} else
		{
			return false;
		}
	}

	private boolean equals(IntTreeNode root1, IntTreeNode root2) {
		if (root1 == null || root2 == null) {
			return root1 == root2;
		} else {
			return root1.data == root2.data
					&& (root1.left == root2.left || equals(root1.__gotoLeft(),  root2.__gotoLeft()))
					&& (root1.right == root2.right || equals(root1.__gotoRight(), root2.__gotoRight()));
		}
	}

	// post: prints the data fields of the tree using a preorder traversal
	public void printPreOrder()
	{
		IntTreeNode.clearCycleData();
		System.out.print("preorder:");
		printPreOrder(overallRoot);
		System.out.println();
	}

	// post: prints in preorder the data fields of the tree with given root
	private void printPreOrder(IntTreeNode root)
	{
		if (root != null)
		{
			System.out.print(" " + root.data);
			printPreOrder(root.__gotoLeft());
			printPreOrder(root.__gotoRight());
		}
	}

	// post: prints the data fields of the tree using an inorder traversal
	public void printInOrder()
	{
		IntTreeNode.clearCycleData();
		System.out.print("inorder:");
		printInOrder(overallRoot);
		System.out.println();
	}

	// post: prints in inorder the data fields of the tree with given root
	private void printInOrder(IntTreeNode root)
	{
		if (root != null)
		{
			printInOrder(root.__gotoLeft());
			System.out.print(" " + root.data);
			printInOrder(root.__gotoRight());
		}
	}

	// post: prints the data fields of the tree using a postorder traversal
	public void printPostOrder()
	{
		IntTreeNode.clearCycleData();
		System.out.print("postorder:");
		printPostOrder(overallRoot);
		System.out.println();
	}

	// post: prints in postorder the data fields of the tree with given root
	private void printPostOrder(IntTreeNode root)
	{
		if (root != null)
		{
			printPostOrder(root.__gotoLeft());
			printPostOrder(root.__gotoRight());
			System.out.print(" " + root.data);
		}
	}

	// post: prints the data fields of the tree, one per line, following
	// an inorder traversal and using indentation to indicate node depth;
	// prints right to left so that it looks correct when the output is
	// rotated.
	public void printStructure()
	{
		IntTreeNode.clearCycleData();
		printStructure(overallRoot, 0);
	}

	// post: prints in preorder the data fields of the given tree indenting
	// each line to the given level
	private void printStructure(IntTreeNode root, int level)
	{
		if (root != null)
		{
			printStructure(root.__gotoRight(), level + 1);
			for (int i = 0; i < level; i++)
			{
				System.out.print("    ");
			}
			System.out.println(root.data);
			printStructure(root.__gotoLeft(), level + 1);
		}
	}

	public IntTreeNode getRoot()
	{
		return overallRoot;
	}

	public void setRoot(IntTreeNode root)
	{
		overallRoot = root;
	}











	// for testing
	public static void main(String[] args)
	{
		// has 3 leaves
		IntTree tree = new IntTree(
				"[19 [47 [23] [-2 [55]]] [63 null [94 null [28]]]]");
		System.out.println("The number of leaves is : " + tree.countLeaves());
		System.out.println("Correct answer is 3");
		System.out.println();

		// has 1 leave
		tree = new IntTree("[12]");
		System.out.println(tree);
		System.out.println("The number of leaves is : " + tree.countLeaves());
		System.out.println("Correct answer is 1");
	}

	// "[19 [47 [23] [-2 [55]]] [63 null [94 null [28]]]]"
	private IntTreeNode fromString(StringBuilder s)
	{
		String next = nextToken(s);
		if (next.length() == 0 || next.equals("null"))
		{
			return null;
		} else
		{
			next = next.substring(1, next.length() - 1).trim(); // remove []
			// from ends
			StringBuilder nextBuilder = new StringBuilder(next);
			String rootStr = nextToken(nextBuilder);
			int data = Integer.parseInt(rootStr);
			String leftStr = nextToken(nextBuilder);
			String rightStr = nextToken(nextBuilder);
			return new IntTreeNode(data,
					fromString(new StringBuilder(leftStr)),
					fromString(new StringBuilder(rightStr)));
		}
	}

	// returns string representation of next complete node or data value from
	// given text
	// (e.g. if you pass "[42 null [23]] [25]" it will return "[42 null [23]]")
	// (e.g. if you pass "null [23]" it will return "null")
	private String nextToken(StringBuilder s)
	{
		// trim leading whitespace
		while (s.indexOf(" ") == 0)
		{
			s.deleteCharAt(0);
		}
		if (s.length() == 0)
		{
			return "";
		}

		int i = 0;
		if (s.charAt(0) == '[')
		{
			// scan ahead looking for matching ] bracket (respects nesting)
			int lbracketCount = 0;
			do
			{
				if (s.charAt(i) == '[')
				{
					lbracketCount++;
				} else if (s.charAt(i) == ']')
				{
					lbracketCount--;
				}
				i++;
			} while (i < s.length() && lbracketCount > 0);
			if (lbracketCount > 0)
			{
				throw new IllegalArgumentException("no ] bracket seen for [");
			}
		} else
		{
			// scan ahead looking for space or end of string
			while (i < s.length() && s.charAt(i) != ' ')
			{
				i++;
			}
		}

		String result = s.substring(0, i).trim();
		s.delete(0, i); // consume characters from buffer
		while (s.indexOf(" ") == 0)
		{
			s.deleteCharAt(0);
		}

		return result;
	}

	// IntTreeNode is a class for storing a single node of a binary tree of
	// ints.
	// It has just data fields and constructors.
	public static class IntTreeNode
	{
		private static final java.util.List<IntTreeNode> ALL_NODES = new java.util.ArrayList<IntTreeNode>();

		public static void clearCycleData()
		{
			clearCycleData(5);
		}

		public static void clearCycleData(int visitsAllowed)
		{
			for (IntTreeNode node : ALL_NODES)
			{
				node.visitsLeft = visitsAllowed;
			}
		}

		public int data; // data stored at this node
		public IntTreeNode left; // reference to left subtree
		public IntTreeNode right; // reference to right subtree
		public int visitsLeft;

		// Constructs a leaf node with given data.
		public IntTreeNode(int data)
		{
			this(data, null, null);
		}

		// Constructs a IntTreeNode with the given data and links.
		public IntTreeNode(int data, IntTreeNode left, IntTreeNode right)
		{
			ALL_NODES.add(this);
			this.data = data;
			this.left = left;
			this.right = right;
			this.visitsLeft = 5;
		}

		public IntTreeNode __gotoLeft()
		{
			return __gotoLeft(true);
		}

		public IntTreeNode __gotoLeft(boolean checkForCycle)
		{
			if (checkForCycle)
			{
				if (left != null)
				{
					if (left.visitsLeft > 0)
					{
						left.visitsLeft--;
					}
					if (left.cycle())
					{
						// throw new
						// IllegalStateException("cycle detected in tree");
					}
				}
			}
			return left;
		}

		public IntTreeNode __gotoRight()
		{
			return __gotoRight(true);
		}

		public IntTreeNode __gotoRight(boolean checkForCycle)
		{
			if (checkForCycle)
			{
				if (right != null)
				{
					if (right.visitsLeft > 0)
					{
						right.visitsLeft--;
					}
					if (right.cycle())
					{
						// throw new
						// IllegalStateException("cycle detected in tree");
					}
				}
			}
			return right;
		}

		public String toString()
		{
			if (this.cycle())
			{
				return "(cycle!)";
			} else
			{
				return String.format("[%d]", data);
			}
		}

		private boolean cycle()
		{
			return visitsLeft == 0;
		}
	}

	// YOUR CODE GOES HERE

}