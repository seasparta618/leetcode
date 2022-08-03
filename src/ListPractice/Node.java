package ListPractice;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public static Node initializeNode(Integer[][] input) {
        if (input.length == 0) {
            return null;
        }
        Node[] nodes = new Node[input.length];
        Node node = new Node(input[0][0]);
        Node head = node;
        nodes[0] = node;
        for (int index = 1; index < input.length; index++) {
            Node newNode = new Node(input[index][0]);
            nodes[index] = newNode;
            node.next = newNode;
            node = node.next;
        }
        node = head;
        int index = 0;
        while (node != null) {
            node.random = input[index][1] == null ? null : nodes[input[index][1]];
            node = node.next;
            index++;
        }
        return head;
    }
}
