public class unionfind {
	public static int[] nums = {0,1,2,3,4,8};
	public static int max = nums[nums.length -1];
	public static int[] parent = new int[max+1];
	
	public static void main(String[] args){

		for (int i = 0; i < nums.length; i++){
			parent[nums[i]] = nums[i];
		}
	}
	public static void union(int a, int b){
		// union a to b
		int pa = findparent(a);
		int pb = findparent(b);
		if (pa != pb){
			parent[pa] = pb;
		}
	}
	public static int findparent(int n){
		while(n != parent[n]){
			n = parent[n];
		}
		return n;
	}
	public void compresspath(int n){
		int par = findparent(n);
		while (parent[n] != par){
			n = parent[n];
			parent[n] = par;
		}

	}	
}
