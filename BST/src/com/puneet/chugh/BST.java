package com.puneet.chugh;

public class BST{

	Node head;

	public BST(){
		this.head = new Node();
	}

	public Node getHead(){
		return head;
	}
	/*return created node*/
	public Node createNode(int data){
		return new Node(data);
	}

	/*return head*/
	public Node addNode(Node head, int data){
		System.out.println("Inside addNode()");
		Node newNode = createNode(data);

		if(head == null){

			System.out.println("Need to initialize the BST first");
			return null;
		}
		else if(head.getRight() == null){
			System.out.println("First node is being added");
			head.setRight(newNode);
			return head;
		}

		Node whereToAdd =  findNode(head, data, false);
		if((whereToAdd != null) && (data > whereToAdd.getData())){
			whereToAdd.setRight(newNode);
		}
		else if((whereToAdd != null) && (data < whereToAdd.getData())){
			whereToAdd.setLeft(newNode);
		}

		else{
			System.out.println("Can't add a duplicate node");
		}
		return head;
	}

	public Node deleteNode(Node head, int data){

		System.out.println("Inside deleteNode()");
		if(head == null || head.getRight()==null){
			System.out.println("Can't delete from an empty/null BST");
			return head;
		}

		if(head.getRight().getData() == data){

			System.out.println("Node to be deleted is at the root");
			if(head.getRight().getRight() == null &&
				head.getRight().getLeft() == null){
				
				head.setRight(null);
				return head;
			}
			
			else if(head.getRight().getRight() == null){
				head.setRight(head.getRight().getLeft());
			}

			else if(head.getRight().getLeft() == null){
				Node node = findParentOfInorderSuccessor(head.getRight().getRight());
				if(node == null){
					head.getRight().setData(head.getRight().getRight().getData());
					head.getRight().setRight(head.getRight().getLeft());
					head.setRight(head.getRight().getRight());
				}
				else{
					head.getRight().setData(node.getLeft().getData());
					node.setLeft(null);
				}
			}
			else{
				
			}
			return head;
		}	

		Node parentOfNodeToDelete = findNode(head, data, true);
		if(parentOfNodeToDelete == null){
			System.out.println("There's no node with data : "+data);
			return head;
		}
		
		if(parentOfNodeToDelete.getRight()!=null &&
			parentOfNodeToDelete.getRight().getData() == data){
			
			if(parentOfNodeToDelete.getRight().getRight() == null &&
				parentOfNodeToDelete.getRight().getLeft() == null){
				
				parentOfNodeToDelete.setRight(null);
			}
			else if(parentOfNodeToDelete.getRight().getRight() == null){
				parentOfNodeToDelete.setRight(parentOfNodeToDelete.getRight().getLeft());
			}
			else if(parentOfNodeToDelete.getRight().getLeft() == null){
				parentOfNodeToDelete.setRight(parentOfNodeToDelete.getRight().getRight());
			}
			else{
				//find the Inorder successor
			}
		}
		else if(parentOfNodeToDelete.getLeft()!=null &&
			parentOfNodeToDelete.getLeft().getData() == data){
		
			System.out.println("Node to be deleted is on the left");	
			if(parentOfNodeToDelete.getLeft().getRight() == null &&
				parentOfNodeToDelete.getLeft().getLeft() == null){
				
				parentOfNodeToDelete.setLeft(null);
			}
			else if(parentOfNodeToDelete.getLeft().getRight() == null){
				parentOfNodeToDelete.setLeft(parentOfNodeToDelete.getLeft().getLeft());
			}
			else if(parentOfNodeToDelete.getLeft().getLeft() == null){
				parentOfNodeToDelete.setLeft(parentOfNodeToDelete.getLeft().getRight());
			}
			else{
				//find the Inorder successor
				Node node = findParentOfInorderSuccessor(parentOfNodeToDelete.getLeft().getRight());
				parentOfNodeToDelete.getLeft().setData(node==null ? 
									parentOfNodeToDelete.getLeft().getRight().getData() : 
									node.getLeft().getData());
				if(node == null){
					
					parentOfNodeToDelete.getLeft().setData(parentOfNodeToDelete.getLeft().getRight().getData());
					parentOfNodeToDelete.getLeft().setRight(null);
				}
				else{
					parentOfNodeToDelete.getLeft().setData(node.getLeft().getData());
					node.setLeft(null);
				}
			}
		}
		return head;
	}

	public Node findParentOfInorderSuccessor(Node node){
		if(node.getLeft() == null){
			return null;
		}

		while(node.getLeft().getLeft() != null){
			node = node.getLeft();
		}
		
		return node;
	}

	/*For adding node, return the node to whose right/left new node*/
	/*is to be added					       */
	/*For deleting node, return the parent node of the node to be */
	/*deleted							*/
	public Node findNode(Node root, int data, boolean isDelete){
	
		System.out.println("Inside findNode()");	
		Node temp = root.getRight();

/*
		if(temp.getRight() == null && 
			temp.getLeft() == null){

			if(temp.getData() == )
		}*/
		while(temp!=null){
			System.out.println("Inside loop : "+temp.getData());	
			if(isDelete && ((temp.getLeft() != null && temp.getLeft().getData() == data) || 
					(temp.getRight() != null && temp.getRight().getData() == data))){
				System.out.println("Found node ");
				break;
			}
			
			if(!isDelete){
				
				if(temp.getRight() == null && data > temp.getData()){
					break;
				}
				else if(temp.getLeft() == null && data < temp.getData()){
					break;
				}
				else if(temp.data == data){
					temp = null;
					break;
				}
			}
			
			if(data > temp.getData() && temp.getRight() != null){
				System.out.println("Inside findNode().. data : "+data+" is greater than "+temp.getData());
				temp = temp.getRight();
			}
			else if(data < temp.getData() && temp.getLeft() != null){
				temp = temp.getLeft();
			}
			else{
				
			}
		}
		return temp;
	}


	public void inOrder(Node root){

		if(root == null)
			return;
		
		inOrder(root.getLeft());
		System.out.println(root.getData());
		inOrder(root.getRight());
	}

	public void preOrder(Node root){
		
		if(root == null){
			return;
		}
		System.out.println(root.getData());
		preOrder(root.getLeft());
		preOrder(root.getRight());
	}

	public void postOrder(Node root){
		
		if(root == null)
			return;

		postOrder(root.getLeft());
		postOrder(root.getRight());
		System.out.println(root.getData());
	}

	
	public static void main(String[] args){

		BST bst = new BST();
		Node head = bst.addNode(bst.getHead(), 50);
		head = bst.addNode(head, 40);
		bst.inOrder(head.getRight());
		head = bst.addNode(head, 30);
		head = bst.addNode(head, 20);
		head = bst.addNode(head, 35);
		head = bst.addNode(head, 45);
		head = bst.addNode(head, 60);
		head = bst.addNode(head, 70);
		head = bst.addNode(head, 55);
		head = bst.addNode(head, 54);
		head = bst.deleteNode(head, 50);
		System.out.println("Printing inOrder");
		bst.inOrder(head.getRight());
		System.out.println("Printing preOrder");
		bst.preOrder(head.getRight());
		System.out.println("Printing postOrder");
		bst.postOrder(head.getRight());
	}
}
