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
		return new SortedTreeSet();
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
		return new SortedTreeSet();
	}

	/**------ADD----------------------------*/
	public void add(Person p){

	}



}//end class
