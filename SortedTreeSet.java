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
		//To add we assume the first element is the best (its probably not)
		//But this is a first run. Can we get the tree to work.

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
			SortedTreeSet curr = null;
			curr = root;
			//System.out.println(curr.data);
			//System.out.println("CURR.DATA:  "+ curr.data);
			//System.out.println("CURR.ROOT:  "+ curr.root);
			
			//System.out.print("INSERTING: " + ambidextrous.data.toString());
			
			if(ambidextrous.data.compareTo(curr.data) < 0){
				//smaller than root
				//System.out.println(" -- smaller than root: "+root.data);

				if(curr.getLeft() == null){
					System.out.println(curr.data.getName()+"'s Left side open.Adding");
					curr.setLeft(ambidextrous);
				}else{
					System.out.println(curr.data.getName()+"'s Left side not open.Checking: " + curr.getLeft().data.getName());
		
					curr.getLeft().getLeft().add(p);
					
				}

			}

			if(ambidextrous.data.compareTo(curr.data) > 0){
				//larger than root
				//System.out.println(" --LARGER THAN ROOT: "+ root.data);
				if(curr.getRight() == null){
					System.out.println(curr.data.getName()+"'s Right Side Open. Adding");
					curr.setRight(ambidextrous);
				}else{
					System.out.println(curr.data.getName()+"'s Right side not open. Checking "+curr.getRight().data.getName());

					curr.getRight().getRight().add(p);
				}
			}

			if(ambidextrous.data.compareTo(curr.data) == 0)
			{
				//repeat
				System.out.println(" --REPEATED");
				return;

			}

			System.out.println();

			//while is a kind of recursion 

			/*if(ambidextrous.data.compareTo(curr.data) < 0 &&
				curr.getLeft() == null){//place in left

				curr.setLeft(ambidextrous);
				System.out.println("LEFT");
				System.out.println(curr.getLeft().data);


			}

			if(ambidextrous.data.compareTo(curr.data) > 0 &&
					curr.getRight() == null){ //place in right

				curr.setRight(ambidextrous);
				System.out.println("RIGHT");
				System.out.println(curr.getRight().data);


			}

			if(ambidextrous.data.compareTo(curr.data) < 0 &&
					curr.getLeft() != null){
				curr = curr.getLeft();
				System.out.println("LEFT NOT NULL");
				System.out.print(curr.data.toString());
				curr.root = curr;
				add(p);

			}

			if(ambidextrous.data.compareTo(curr.data) > 0 &&
					curr.getRight() != null){
				curr = curr.getRight();
				System.out.println("RIGHT NOT NULL");
				System.out.print(curr.data.toString());
				curr.root= curr;
				add(p);


			}

			if(ambidextrous.data.compareTo(curr.data) == 0){
				System.out.println("REPEAT");
			}*/




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
