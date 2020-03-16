/*Author: Nash Smith
*/

class BSTlex {

	public LeafNode _root;
	private String _toString;
	
	/*Constructor without setting root*/
	public BSTlex(){
	
		_root = new LeafNode("");
		_toString = "";
	}
	
	/*Base insert method*/
	public void insert(String word){
	
		//resets the path string
		_toString = "";
	
		//convert the word to lower case
		word = word.toLowerCase();
		
		//if the word is in the tree
		if(find(word)){
			//delete the word
			delete(word);
			
		//else if the tree is empty
		}else if(_root._value.equals("")){
			//set the root to the word
			_root._value = word;
			//print the path
			_toString += _root._value + " INSERTED\n";
			System.out.print(_toString);
		//else insert the word recursivley
		}else{
			insertRecursive(word, _root);
			System.out.print(_toString);
		}
	}
	
	/*Finds where to insert the word passed as a parameter*/
	public void insertRecursive(String word, LeafNode currentNode){
	
		//if the current node exists
		if(currentNode != null){
	
			//if the first word in the string, dont add space
			if(_toString.equals("")){
				_toString += currentNode._value;
			}else{
				_toString += " " + currentNode._value;
			}
			
			//go right if the word is lexicographically larger than the current node value
			if(word.compareTo(currentNode._value) > 0){
				//if the right subtree is empty
				if(currentNode._right == null){
					//we can add a new leaf in there
					currentNode._right = new LeafNode(word);
					_toString += " " + word + " INSERTED\n";
					return;
				//else keep looking in the right subtree for a space to go
				}else{
					insertRecursive(word, currentNode._right);
					return;
				}
			
			}
			//else go left if the word is lexicographically smaller than the current node value
			//if the left subtree is empty
			if(currentNode._left == null){
				//we can add a new lead there
				currentNode._left = new LeafNode(word);
				_toString += " " + word + " INSERTED\n";
			//else keep looking in the left subtree
			}else{
				insertRecursive(word, currentNode._left);
			}
			
		}
	}
		
	/*Base delete method*/
	public void delete(String word){
	
		//reset the path string
		_toString = "";
		//make sure the word is actually in the tree
		if(find(word)){
			//recursively delete the word
			_root = deleteRecursive(word, _root);
			_toString += " DELETED\n";
		}
		//print the path
		System.out.print(_toString);
	
	}
	
	/*Finds the leaf to delete, then finds a suitable replacement leaf*/
	public LeafNode deleteRecursive(String word, LeafNode currentNode){
	
		//convert word to lower case
		word = word.toLowerCase();
		//if the current node exists
		if(currentNode != null){
			//make a backup of the path
			String backup = _toString;
			//if the first word in the string, dont add space
			if(_toString.equals("")){
				_toString += currentNode._value;
			}else{
				_toString += " " + currentNode._value;
			}
		
			//if this node is the one to delete
			if(currentNode._value.equals(word)){
				
				/*No Child*/
				if(currentNode._left == null && currentNode._right == null){
					//just delete the node outright
					return null;
				}
				
				/*One Child*/
				if(currentNode._left == null){
					//left is empty so set it to the right node
					return currentNode._right;
				}
				
				if(currentNode._right == null){
					//right is empty so set it to the left node
					return currentNode._left;
				}
				
				/*Two Children*/
				if(currentNode._left != null && currentNode._right != null){
					//find the smallest word of the right subTree
					LeafNode smallest = smallestWord(currentNode._right);
					//set the value of the node to delete to the value of the smallest word in right subtree
					currentNode._value = smallest._value;
					//delete the old node
					currentNode._right = deleteRecursive(smallest._value, currentNode._right);
					_toString = backup + " " + word;
					//return the current node with its new value
					return currentNode;
				}
			//else keep looking for the leaf to delete
			}else{
			
			//go right
			if(word.compareTo(currentNode._value) > 0 ){
				//for path formatting
				if(backup.equals("")){
					_toString = currentNode._value;
				}else{
					_toString = backup + " " + currentNode._value;
				}
				//search the right subtree for the word
				currentNode._right = deleteRecursive(word, currentNode._right);
				return currentNode;
			}
			//go left
			//formatting
			if(backup.equals("")){
				_toString = currentNode._value;
			}else{
				_toString = backup + " " + currentNode._value;
			}
			//search the left subtree for the word
			currentNode._left = deleteRecursive(word, currentNode._left);
			return currentNode;
			}
		}
		//if the word wasnt in the tree
		return _root;
		
	
	}
	
	/*finds the furtherest left leaf in the subtree passed in*/
	public LeafNode smallestWord(LeafNode currentNode){
		
		//if we have hit the end of the left subtree path
		if(currentNode._left == null){
			//the current node is the smallest
			return currentNode;
		//else keep traversing the left subtree
		}else{
			return smallestWord(currentNode._left);
		}
	}
	
	/*returns true if the tree contains the passed word*/
	public boolean find(String word){
		
		//set the current node to the root
		LeafNode currentNode = _root;
		
		//while we havent reached the end of the tree
		while(currentNode != null){
			//if the current node value is the word passed in
			if(word.equals(currentNode._value)){
				//the tree contains the word
				return true;
			}
			
			//go right if lexicographically larger
			if(word.compareTo(currentNode._value) > 0 ){
				//current node is now the right subtree
				currentNode = currentNode._right;
			//go left
			}else{
				//current node is now the left subtree
				currentNode = currentNode._left;
			}
		}
		//if it hasnt returned true after going through whole tree then its not in the tree
		return false;
	
	}
	
	/*Returns the BST in lexicographical order as a String*/
	public String toString(){
	
		_toString = "";
		LeafNode currentNode = _root;
		
		//if the tree is not empty
		if(_root._value != ""){
			//calculate the string
			traverse(_root);
		}
		//return the string
		return _toString;
	
	}
	
	/*traverses the BST and adds each nodes string value to the global _toString variable*/
	private void traverse(LeafNode currentNode){
	
		//if there is a left subtree
		if(currentNode._left != null){
			//traverse it
			traverse(currentNode._left);
		}
		
		//deal with the value
		_toString += currentNode._value + "\n";
		
		//if there is a right subtree
		if(currentNode._right != null){
			//traverse it
			traverse(currentNode._right);
		}
	}

	/*A node on a binary search tree*/
	class LeafNode {
	
		public String _value;
		public LeafNode _left;
		public LeafNode _right;
		
		/*Constructor setting value*/
		public LeafNode(String value){
		
			_value = value;
			_left = null;
			_right = null;
		
		}
	}

}
