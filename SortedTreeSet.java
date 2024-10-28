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
			
			if(ambidextrous.data.compareTo(localRoot.data) < 0){
				//smaller than root
				//System.out.println(" -- smaller than root: "+root.data);

				if(localRoot.getLeft() == null){
					System.out.println(localRoot.data.getName()+"'s Left side open.Adding");
					localRoot.setLeft(ambidextrous);
				}else{
					System.out.println(localRoot.data.getName()+"'s Left side not open.Checking: " + localRoot.getLeft().data.getName());
		
					localRoot.getLeft().getLeft().add(p);
					
				}

			}

			if(ambidextrous.data.compareTo(localRoot.data) > 0){
				//larger than root
				//System.out.println(" --LARGER THAN ROOT: "+ root.data);
				if(localRoot.getRight() == null){
					System.out.println(localRoot.data.getName()+"'s Right Side Open. Adding");
					localRoot.setRight(ambidextrous);
				}else{
					System.out.println(localRoot.data.getName()+"'s Right side not open. Checking "+localRoot.getRight().data.getName());

					localRoot.getRight().getRight().add(p);
				}
			}

			if(ambidextrous.data.compareTo(localRoot.data) == 0)
			{
				//repeat
				System.out.println(" --REPEATED");
				return;

			}

			System.out.println();






	}//end add()


	@Override
	public String toString(){
		//return "TODO";
		//Reading online there is use of linkedlists and queue class
		//to print out binary tree using levelOrder. ei iterating through
		//each level before proceeding to the next. Starting at the root
		//and iterating through each level. Lets do this.
		String toConsole = "\nNAME     HEIGHT     WEIGHT\n";
		String newLine;
		SortedTreeSet top = root;
		int count = 0;

		if(root == null)
			return "EMPTY TREE";

		Queue<SortedTreeSet> queue = new LinkedList<>();
		queue.add(root); //add the root to the queue

		while(!queue.isEmpty()){
			SortedTreeSet node = queue.remove(); //this is the root?
			//System.out.print(node.data.toString() + " \n");

			if(node.hasLeft()){
				queue.add(node.getLeft());
			}

			if(node.hasRight()){
				queue.add(node.getRight());
			}

			//System.out.println(node.data.toString());
			newLine = node.data.toString() + "\n";
			toConsole = toConsole.concat(newLine);
			count++;

		}
		//System.out.println("COUNT: " + count);

		return toConsole;
	

	}//end toString()


}//end class
