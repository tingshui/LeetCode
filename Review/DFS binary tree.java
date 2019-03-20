//DFS binary tree
//DFS Interactive

public static void main(Node node){
	visitDFS(root);
}

public void visitDFS (Node root){
	Stack<Node> s = new Stack<Node>();
	s.push(root);
	while (!s.isEmpty()){
		Node current = s.pop();
		System.out.print(current.value);
		if (current.left != null){
			s.push(current.left);
		}
		if (current.right != null){
			s.push(current.right);
		}
	}
}

//DFS Recursive
public static void main(){
	visitDFS(root);
}

public void visitDFS (Node node){
	if (node == null){
		return;
	}
	System.out.print(node.value);
	if (node.left != null){
		visitDFS (node.left);
	}
	if (node.right != null){
		visitDFS (node.left);
	}	
}

