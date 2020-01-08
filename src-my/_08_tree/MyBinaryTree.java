package _08_tree;

public class MyBinaryTree {

    private Node root;

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }

        Node p = root;
        while (p != null) {
            if (value <= p.value) {
                if (p.left == null) {
                    p.left = new Node(value);
                    return;
                }
                p = p.left;
            } else {
                if (p.right == null) {
                    p.right = new Node(value);
                    return;
                }
                p = p.right;
            }
        }
    }

    public void remove(int value) {
        if (root == null) {
            return;
        }

        // 查找节点
        Node p = root;
        Node pp = null;
        while (p != null && p.value != value) {
            pp = p;
            if (p.value > value) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (p == null) {
            return;
        }

        // 节点有两个子节点情况
        if (p.left != null && p.right != null) { // 查找右子树中最小节点
            Node minP = p.right;
            Node minPP = p;
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            p.value = minP.value;
            p = minP;
            pp = minPP;
        }

        // 删除节点是叶子节点或者仅有一个子节点
        Node child; // p的子节点
        if (p.left != null) child = p.left;
        else if (p.right != null) child = p.right;
        else child = null;

        if (pp == null) root = child; // 删除的是根节点
        else if (pp.left == p) pp.left = child;
        else pp.right = child;
    }

    public Node find(int value) {
        if (root == null) {
            return null;
        }

        Node p = root;
        while (p != null) {
            if (p.value == value) {
                return p;
            } else if (p.value > value) {
                p = p.left;
            } else {
                p = p.right;
            }
        }

        return null;
    }

    public Node findMin() {
        if (root == null) {
            return null;
        }

        Node p = root;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    public Node findMax() {
        if (root == null) {
            return null;
        }

        Node p = root;
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }

    public Node findPrev(int value) {
        return null;
    }

    private Node findNext(int value) {
        return null;
    }

    private void printAll() {
        print(root);
        System.out.println();
    }

    private void print(Node node) {
        if (node == null) {
            return;
        }
        print(node.left);
        System.out.print(" " + node.value + " ");
        print(node.right);
    }

    public static void main(String[] args) {
        var tree = new MyBinaryTree();
        tree.insert(5);
        tree.insert(6);
        tree.insert(3);
        tree.insert(4);
        tree.insert(8);
        tree.insert(1);
        tree.insert(2);
        tree.printAll();
    }
}
