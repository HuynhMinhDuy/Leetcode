/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    private Map<Node, Node> map = new HashMap<>();

    public Node getCloneNode(Node node) {        
        if(node == null) return null;
        if(!map.containsKey(node)) {
            Node clonedNode = new Node(node.val, null, null);
            map.put(node, clonedNode);
        }   
        return map.get(node);
    }
    
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node oldNode = head;
        Node newNode = new Node(oldNode.val, null, null);
        Node newHeadNode = newNode;
        map.put(oldNode, newNode);

        while(oldNode != null) {
            newNode.next = this.getCloneNode(oldNode.next);
            newNode.random = this.getCloneNode(oldNode.random);
            oldNode = oldNode.next;
            newNode = newNode.next;
        }

        return newHeadNode;
    }
}
