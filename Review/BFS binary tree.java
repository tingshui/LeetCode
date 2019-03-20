//BFS binary tree
//BFS Interactive
public void visitBFS(Node root){
	Queue<Node> q = new Queue<Node>();
	q.offer(root);
	while(!q.isEmpty()){
		Node current = q.poll();
		print(current.value);
		if (current.left != null){
			q.offer(current.left);
		}
		if (current.right != null){
			q.offer(current.right);
		}
	}	
}

//BFS Recursive(not recommended)
public static void main(Node root){
	Queue<Node> q = new Queue<Node>();
	q.add(root);
	visitBFS(q);
}

public void visitBFS(Queue q){
	if(q.isEmpty()){
		return;
	}
	Node current = q.poll();
	print(current.value);
	if (current.left != null){
		q.offer(current.left);
	}
	if (current.right != null){
		q.offer(current.right);
	}
	visitBFS(q);
}


