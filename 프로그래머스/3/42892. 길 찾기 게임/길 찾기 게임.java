import java.util.*;
//이진트리
class Solution {
    
    public class Node {
        int idx;
        int x;
        int y;
        Node lnode;
        Node rnode;
        
        public Node(int idx, int x, int y, Node lnode, Node rnode) {
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.lnode = lnode;
            this.rnode = rnode;
        }
    }
    
    Node[] node;
    int[][] answer;
    int i=0;
    public int[][] solution(int[][] nodeinfo) {
        answer = new int[2][nodeinfo.length];
        node = new Node[nodeinfo.length];
        
        for(int i = 0; i < nodeinfo.length; i++) {
            node[i] = new Node(i+1, nodeinfo[i][0],nodeinfo[i][1],null,null);
        }
        
        //y 내림차순 정렬
        Arrays.sort(node, (o1,o2) -> {
            if(o1.y == o2.y)
                return o1.x - o2.x;
            else return o2.y - o1.y;
        });
        
        //이진트리 생성하기
        Node root = node[0];
        for(int i = 1; i < node.length; i++) {
            makeTree(root, node[i]);
        }
        
        //전위 후위 순회하기
        i=0;
        preOrder(root);
        i=0;
        postOrder(root);
        
        return answer;
    }
    
    public void makeTree(Node p, Node c) {
        if(p.x > c.x) {
            if(p.lnode == null) p.lnode = c;
            else makeTree(p.lnode, c);
        }
        else {
            if(p.rnode == null) p.rnode = c;
            else makeTree(p.rnode, c);
        }
    }
    
    public void preOrder(Node n) {
        if(n!=null) {
            answer[0][i++] = n.idx;
            preOrder(n.lnode);
            preOrder(n.rnode);
        }
    }
    
    public void postOrder(Node n) {
        if(n!=null) {
            postOrder(n.lnode);
            postOrder(n.rnode);
            answer[1][i++] = n.idx;
        }
    }
    
    
}