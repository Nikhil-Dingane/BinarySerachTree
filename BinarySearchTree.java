

// Object of this class will be a node of a Binary Search Tree

class TreeNode<T extends Comparable <T>>
{
	T nodeData;
	TreeNode<T> leftChild;
	TreeNode<T> rightChild;
	
	// Default constructorr
	public TreeNode(T nodeData)
	{
		this.nodeData=nodeData;
		this.leftChild=null;
		this.rightChild=null;
	}
}


// This class is a actual implementation of a Binary Search Tree

public class BinarySearchTree<T extends Comparable <T>>
{
	// Root node of Binary Search Tree
	private TreeNode<T> root;
	
	// Default constructorr 
	public BinarySearchTree()
	{
		this.root = null;
	}
	
	// Method which takes accepts data and insert into tree by creating new node
	public void insert(T nodeData)
	{
		TreeNode<T> newNode=new TreeNode<T>(nodeData);
		
		if(this.root==null)
		{
			this.root=newNode;
		}
		else
		{
			TreeNode<T> temp=this.root;
			
			while(temp!=null)
			{
				
				if(newNode.nodeData.compareTo(temp.nodeData)>0)
				{
					if(temp.rightChild==null)
					{
						temp.rightChild=newNode;
						break;
					}
					temp=temp.rightChild;
				}
				else if(newNode.nodeData.compareTo(temp.nodeData)<0)
				{
					if(temp.leftChild==null)
					{
						temp.leftChild=newNode;
						break;
					}
					temp=temp.leftChild;
				}
				else
				{
					break;
				}
			}
		}
		
	}
	
	//Method which displays all nodes of a tree. This method internally calls displayHelper() method
	public void display()
	{
		displayHelper(this.root);
	}
	
	// Method which displays  nodes in ascending order
	private void displayHelper(TreeNode treeNode)
	{
		if(treeNode!=null)
		{
			
			displayHelper(treeNode.leftChild);
			System.out.print(treeNode.nodeData+"\t");
			displayHelper(treeNode.rightChild);
		}
	}
	
	// Method to search element 
	public boolean search(T nodeData)
	{
		TreeNode<T> temp=this.root;
		System.out.println();
		while(temp!=null)
		{
			if(nodeData.compareTo(temp.nodeData)>0)
			{
				temp=temp.rightChild;
			}
			else if(nodeData.compareTo(temp.nodeData)<0)
			{
				temp=temp.leftChild;
			}
			else if(nodeData.compareTo(temp.nodeData)==0)
			{
				break;
			}
		}
		
		if(temp==null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}