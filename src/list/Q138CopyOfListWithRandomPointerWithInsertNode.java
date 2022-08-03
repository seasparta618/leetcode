package list;

public class Q138CopyOfListWithRandomPointerWithInsertNode {

    public static void main(String[] args) {
        Integer[][] input = new Integer[][]{{7, null}, {13, 0}, {11, 4}, {10, 2}, {1, 0}};
        Node node = Node.initializeNode(input);
        Node copy = new Q138CopyOfListWithRandomPointerWithInsertNode().copyRandomList(node);
        while (copy != null) {
            System.out.println(copy.val + "," + (copy.random == null ? null : copy.random.val));
            copy = copy.next;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node start = head;
        while (head != null) {
            Node nodeCopy = new Node(head.val);
            nodeCopy.next = head.next;
            head.next = nodeCopy;
            head = nodeCopy.next;
        }
        head = start;
        Node copyHead = start.next;
        while (start != null) {
            Node node = start.next;
            node.random = start.random == null ? null : start.random.next;
            start = node.next;
        }
        start = head;
        while (start != null) {
            Node node = start.next;
            start.next = node.next;
            start = node.next;
            node.next = start == null ? null : start.next;
        }
        return copyHead;
    }
}
