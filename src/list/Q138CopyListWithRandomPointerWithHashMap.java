package list;

import java.util.HashMap;

public class Q138CopyListWithRandomPointerWithHashMap {
    public static void main(String[] args) {
        Integer[][] input = new Integer[][]{{7, null}, {13, 0}, {11, 4}, {10, 2}, {1, 0}};
        Node node = Node.initializeNode(input);
        Node copy = new Q138CopyListWithRandomPointerWithHashMap().copyRandomList(node);
        while (copy != null) {
            System.out.println(copy.val + "," + (copy.random == null ? null : copy.random.val));
            copy = copy.next;
        }
    }

    public Node copyRandomList(Node head) {
        Node start = head;
        HashMap<Node, Node> nodeMap = new HashMap<>();
        while (head != null) {
            nodeMap.put(head, new Node(head.val));
            head = head.next;
        }
        head = start;
        while (head != null) {
            Node value = nodeMap.get(head);
            value.next = nodeMap.get(head.next);
            value.random = nodeMap.get(head.random);
            nodeMap.put(head, value);
            head = head.next;
        }
        return nodeMap.get(start);
    }
}
