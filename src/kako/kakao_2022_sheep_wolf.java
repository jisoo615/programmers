package kako;

import java.util.ArrayList;

public class kakao_2022_sheep_wolf {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(
				s.solution(new int[] {0,0,1,1,1,0,1,0,1,0,1,1},
				new int[][] {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}} )
				);
	}

	static class Solution {
		Node[] nodes;

		public int solution(int[] info, int[][] edges) {
			createTree(info, edges);
			int answer = sol(nodes[0], new ArrayList<Node>(), new int[2]);
			return answer;
		}

		private int sol(Node node, ArrayList<Node> wolf, int[] cnt) {
			dfs(node, wolf, cnt);
			int max = cnt[0];

			if(cnt[0]>cnt[1]+1) {
				for(int i=0; i<wolf.size(); i++) {
					ArrayList<Node> wolf1 = new ArrayList<>(wolf);
					Node node1 = wolf1.get(i);
					wolf1.remove(i);
					int result = sol(node1, wolf1, cnt.clone());
					if(result > max) max = result;
				}
			}
			return max;
		}

		private void dfs(Node node, ArrayList<Node> wolf, int[] cnt) {//cnt[0]:양 cnt[1]:늑대
			cnt[node.animal]++;
			if(node.left!=null) {
				if(node.left.animal==1) wolf.add(node);
				else {
					dfs(node.left, wolf, cnt);
				}
			}
			if(node.right!=null){
				if(node.right.animal==1) wolf.add(node);
				else {
					dfs(node.right, wolf, cnt);
				}
			}
		}

//---------트리만들기--------------
		static class Node{
			int animal;//0:양, 1:늑대
			Node left, right;
		}
		private void createTree(int[] info, int[][] edges) {
			nodes = new Node[info.length];
			for(int i=0; i<info.length; i++) {
				nodes[i] = new Node();
				nodes[i].animal = info[i];
			}
			for(int[] edge : edges) {
				Node parent = nodes[edge[0]];
				if(parent.left==null) {
					parent.left = nodes[edge[1]];
				}else {
					parent.right = nodes[edge[1]];
				}
			}

		}

	}
}
