package HeapNTree;

public class Rotate<E> {

    public static class Node<E> {
        E data;
        Node<E> left, right;

        public Node(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // 좌측 회전: 조부모 노드를 부모 노드의 왼쪽 자식 노드 위치로 옮깁니다.
    public Node<E> leftRotate(Node<E> node) {
        Node<E> tmp = node.right;
        node.right = tmp.left;
        tmp.left = node;
        return tmp; // tmp becomes the new root of this subtree
    }

    // 우측 회전: 조부모 노드를 부모 노드의 오른쪽 자식 노드 위치로 옮깁니다.
    public Node<E> rightRotate(Node<E> node) {
        Node<E> tmp = node.left;
        node.left = tmp.right;
        tmp.right = node;
        return tmp; // tmp becomes the new root of this subtree
    }

    // 우측 회전 후 좌측 회전
    public Node<E> rightLeftRotate(Node<E> node) {
        node.right = rightRotate(node.right);
        return leftRotate(node);
    }

    // 좌측 회전 후 우측 회전
    public Node<E> leftRightRotate(Node<E> node) {
        node.left = leftRotate(node.left);
        return rightRotate(node);
    }
    public static void main(String[] args) {
        Rotate<Integer> rotator = new Rotate<>();

        // Building a simple tree: root(20) with left child(10) and right child(30)
        // Introducing imbalance that needs a left-right rotation
        Node<Integer> root = new Node<>(20);
        root.left = new Node<>(10);
        root.left.right = new Node<>(15);

        System.out.println("Root before left-right rotate: " + root.data);
        root = rotator.leftRightRotate(root);
        System.out.println("Root after left-right rotate: " + root.data); // Should be 15

        // Reset the tree to introduce an imbalance that needs a right-left rotation
        root = new Node<>(20);
        root.right = new Node<>(30);
        root.right.left = new Node<>(25);

        System.out.println("Root before right-left rotate: " + root.data);
        root = rotator.rightLeftRotate(root);
        System.out.println("Root after right-left rotate: " + root.data); // Should be 25
    }

}