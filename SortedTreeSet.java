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
		if(this.root.data == null){
			root = ambidextrous;
			System.out.println("ROOT ADDED");
		}else{
			//root does exists
			//get local variable pointer to root
			SortedTreeSet curr = this.root;
			//while is a kind of recursion 
			if(curr.data != null){
				if(ambidextrous.data.compareTo(curr.data) < 0 &&
					curr.getLeft() == null){//place in left
					curr.setLeft(ambidextrous);
					System.out.println("LEFT");
				

				}else if(ambidextrous.data.compareTo(curr.data) > 0 &&
							curr.getRight() == null){ //place in right
					curr.setRight(ambidextrous);
					System.out.println("RIGHT");


				}else if(ambidextrous.data.compareTo(curr.data) < 0 &&
						curr.getLeft() != null){
					curr = curr.getLeft();
					System.out.println("LEFT NOT NULL");
					curr.root = curr;
					add(curr.data);

				}else if(ambidextrous.data.compareTo(curr.data) > 0 &&
						curr.getRight() != null){
					curr = curr.getRight();
					System.out.println("RIGHT NOT NULL");
					curr.root= curr;
					add(curr.data);


				}else{
					System.out.println("REPEAT");
				}
				
		};//end if

		}// end else


	}//end add()


	@Override
	public String toString(){
		//return "TODO";
		//Reading online there is use of linkedlists and queue class
		//to print out binary tree using levelOrder. ei iterating through
		//each level before proceeding to the next. Starting at the root
		//and iterating through each level. Lets do this.
		String toConsole = "DEFAULT";
		String newLine;
		SortedTreeSet top = root;
		int count = 0;

		if(root == null)
			return "EMPTY TREE";

		LinkedList<SortedTreeSet> queue = new LinkedList<>();
		queue.add(top); //add the root to the queue

		while(!queue.isEmpty()){
			SortedTreeSet node = queue.remove(); //this is the root?
			System.out.print(node.data.toString() + " \n");

			if(node.left != null)
				queue.add(node.left);

			if(node.right != null)
				queue.add(node.right);

			//System.out.println(queue.data + " \n");
		//	newLine = queue.data.toString() + "\n";
		//	toConsole = toConsole.concat(newLine);

		}
		System.out.println("COUNT: " + count);

		return toConsole;




	}//end toString()


}//end class
