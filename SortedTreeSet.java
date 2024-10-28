/**
Programmer: Lucio Plancarte
Created:  24 OCT 2024
Description: Binary Tree Implementation to sort HR data.
*/

import java.util.Queue;
import java.util.LinkedList;

public class SortedTreeSet implements SortedTreeSetInterface{

	/**-------CLASS VARIABLES------------------*/
	private static SortedTreeSet root = new SortedTreeSet();
	private SortedTreeSet left;
	private SortedTreeSet right;
	private Person data;
	private static String header = String.format("%-6s %12s %9s\n","Name", "Height (cm)", "Weight (kg)");
	private static StringBuilder builder = new StringBuilder(header);

	/**-------CONSTRUCTOR---------------------*/
	public SortedTreeSet(){
		this.data = null;
		this.left = null;
		this.right = null;
	}

	/**-------GET---------------------------*/
	public Person getPerson(){
		return this.data;
	}
 

	/**------LEFT----------------------------*/
	public boolean hasLeft(){
		if(this.left == null)
			return false;
		return true;
	}

	public void setLeft(SortedTreeSet left){
		this.left = left;
	}

	public SortedTreeSet getLeft(){
		return this.left;
	}

	/**------RIGHT----------------------------*/
	public boolean hasRight(){
		if(this.right == null)
			return false;
		return true;
	}

	public void setRight(SortedTreeSet right){
		this.right = right;
	}

	public SortedTreeSet getRight(){
		return this.right;
	}

	/**------ADD----------------------------*/
		//Person should not be null
	public void add(Person p){
		
		//create new tree node and set in data
		SortedTreeSet ambidextrous = new SortedTreeSet();
		ambidextrous.data = p;

		//root does not exists
		if(root.data == null){
			root = ambidextrous;
			System.out.println("ROOT ADDED");
			return;
		}

			//root does exists
			//get local variable pointer to root
			SortedTreeSet localRoot = null;
			
			localRoot = root;
			
			//System.out.println(localRoot.data);
			//System.out.println("localRoot.DATA:  "+ localRoot.data);
			//System.out.println("localRoot.ROOT:  "+ localRoot.root);
			
			//System.out.print("INSERTING: " + ambidextrous.data.toString());
			while(localRoot != null){ //daloop
			
			if(ambidextrous.data.compareTo(localRoot.data) < 0){
				//smaller than root
				//System.out.println(" -- smaller than root: "+root.data);

				if(localRoot.getLeft() == null){
					System.out.println(localRoot.data.getName()+"'s Left side open.Adding");
					localRoot.setLeft(ambidextrous);
					return;
				}else{
					System.out.println(localRoot.data.getName()+"'s Left side not open.Checking: " + localRoot.getLeft().data.getName());
		
					//localRoot.getLeft().getLeft().add(p);
					localRoot = localRoot.getLeft();
					
				}

			}

			if(ambidextrous.data.compareTo(localRoot.data) > 0){
				//larger than root
				//System.out.println(" --LARGER THAN ROOT: "+ root.data);
				if(localRoot.getRight() == null){
					System.out.println(localRoot.data.getName()+"'s Right Side Open. Adding");
					localRoot.setRight(ambidextrous);
					return;
				}else{
					System.out.println(localRoot.data.getName()+"'s Right side not open. Checking "+localRoot.getRight().data.getName());

					//localRoot.getRight().getRight().add(p);
					localRoot = localRoot.getRight();
					
				}
			}

			if(ambidextrous.data.compareTo(localRoot.data) == 0)
			{
				//repeat
				System.out.println(" --REPEATED");
				return;

			}

			System.out.println();
			
		}//end while



		

	}//end add()


	@Override
	public String toString(){
		//return "TODO";
		//Reading online there is use of linkedlists and queue class
		//to print out binary tree using levelOrder. ei iterating through
		//each level before proceeding to the next. Starting at the root
		//and iterating through each level. Lets do this.
		
		//https://github.com/anandkumarkparmar/Data-Structures-Algorithms/blob/master/data-structures/binary-tree/TreeTraversalUtil.java
		//this source was used to quickly display if the tree was adding.
		//slowly but surely realizing that a different display algorithm is required. putting the median in the middle.
		//achieved through recursion, a static void function named inOrderTraversal() is used to test. test is sucessful.
		//https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/#level-order-traversal
		

		if(root == null)
			return "EMPTY TREE";
		
		//Inorder Traversal is what we need
		inOrderTraversal(root);
		return builder.toString();//inOrderTraversal(root);
	
	

	}//end toString()

	//shamelessly copied from geeksforgeeks. I'm just glad the tree is working.
	static private void inOrderTraversal(SortedTreeSet node){
		if(node == null)
			return;
				
		inOrderTraversal(node.getLeft());
		//System.out.println(node.getPerson());
		builder.append(node.getPerson()); //builder needs to be a class variable...static 
		inOrderTraversal(node.getRight());
	
	}

}//end class
