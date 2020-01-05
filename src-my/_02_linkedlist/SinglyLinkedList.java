package _02_linkedlist;

public class SinglyLinkedList {

    private Node head = null;

    public Node findByValue(int value) {
        Node p = head;
        while (p != null && p.data != value) {
            p = p.next;
        }

        return p;
    }

    public Node findByIndex(int index) {
        Node p = head;
        int pos = 0;
        while (p != null && pos != index) {
            p = p.next;
            ++pos;
        }

        return p;
    }

    public void insertToHead(int data) {
        insertToHead(createNode(data));
    }

    public void insertToHead(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertToTail(int data) {
        insertToTail(createNode(data));
    }

    public void insertToTail(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            Node p = head;
            while (p.next != null) {
                p = p.next;
            }
            p.next = newNode;
        }
    }

    public void insertAfter(Node p, int value) {
        Node newNode = new Node(value, null);
        insertAfter(p, newNode);
    }

    public void insertAfter(Node p, Node newNode) {
        if (p == null) return;

        newNode.next = p.next;
        p.next = newNode;
    }

    public void insertBefore(Node p, int value) {
        Node newNode = new Node(value, null);
        insertBefore(p, newNode);
    }

    public void insertBefore(Node p, Node newNode) {
        if (p == null) return;
        if (head == p) {
            insertToHead(newNode);
            return;
        }

        Node q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }

        if (q == null) {
            return;
        }

        newNode.next = p;
        q.next = newNode;

    }

    public void deleteByNode(Node p) {
        if (p == null || head == null) {
            return;
        }

        Node q = head;
        while (q.next != null && q.next != p) {
            q = q.next;
        }

        if (q == null) {
            return;
        }

        q.next = q.next.next;
    }

    public void deleteByValue(int value) {
        if (head == null) return;

        Node p = head;
        Node q = null;
        while (p != null && p.data != value) {
            q = p;
            p = p.next;
        }

        if (p == null) return;

        if (q == null) {
            head = head.next;
        } else {
            q.next = q.next.next;
        }
    }

    public void deleteLastKth(int k) {
        if (head == null) return;

        Node f = head;
        int pos = 1;
        while (f != null && pos < k) {
            f = f.next;
            pos++;
        }

        if (f == null) {
            return;
        }

        Node l = head, prev = null;
        while (f.next != null) {
            f = f.next;
            prev = l;
            l = l.next;
        }

        if (prev == null) {
            head = head.next;
        } else {
            prev.next = prev.next.next;
        }
    }

    public void reverse() {
        if (head == null || head.next == null) {
            return;
        }

        Node curr = head, prev = null;
        while (curr != null) {
            Node tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        head = prev;
    }

    public Node findMiddleNode() {
        if (head == null) {
            return null;
        }

        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    boolean checkCircle() {
        if (head == null) {
            return false;
        }

        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    public Node mergeTwoLists(Node l1, Node l2) {
        Node s = createNode(0); //利用哨兵节点简化难度
        Node p = s;
        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if(l1 != null) {
            p.next = l1;
        }

        if (l2 != null) {
            p.next = l2;
        }

        return s.next;
    }

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static Node createNode(int value) {
        return new Node(value, null);
    }

    public static void main(String[] args) {
        var link = new SinglyLinkedList();
        System.out.println("hello");
        int data[] = {1,2,5,3,1};
        for(int i =0; i < data.length; i++){
            link.insertToTail(data[i]);
        }
        System.out.println("中间节点："+link.findMiddleNode().data);
        link.printAll();
        link.reverse();
        link.printAll();
        link.deleteLastKth(2);
        link.printAll();

        var l1 = new SinglyLinkedList();
        int d1[] = {1,2,5};
        for(int i =0; i < d1.length; i++){
            l1.insertToTail(d1[i]);
        }

        var l2 = new SinglyLinkedList();
        int d2[] = {2,3,6};
        for(int i =0; i < d2.length; i++){
            l2.insertToTail(d2[i]);
        }

        Node p = link.mergeTwoLists(l1.head, l2.head);
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }
}

