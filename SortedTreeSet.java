/**
Programmer: Lucio Plancarte
Created:  24 OCT 2024
Description: Binary Tree Implementation to sort HR data.
*/

class SortedTreeSet implements SortedTreeListInterface, PersonList{

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
		}else{
			//root does exists
			//get local variable pointer to root
			SortedTreeSet curr = root;
			//while is a kind of recursion 
			while(curr.data != null){
				if(ambidextrous.data < curr.data &&
					curr.getLeft() == null){//place in left
					this.setLeft(ambidextrous);
				}else if(ambidextrous.data > curr.data &&
							curr.getRight() == null){ //place in right
					this.setRight(ambidextrous);
				}else if(ambidextrous.data < curr.data){
					curr = curr.getLeft();
				}else if(ambidextrous.data > curr.data){
					curr = curr.getRight();
				}

			}//end while

		}// end else


	}//end add()




}//end class
