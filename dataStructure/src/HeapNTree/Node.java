package HeapNTree;

public class Node<E> {

    E data;
    Node <E> left, right;

    public Node(E obj){
        this.data = obj;
        left=right=null;
    }

    // 전위 순회 메소드
    public void preorderTraversal(Node<E> node) {
        if (node != null) {
            System.out.print(node.data + " "); // 먼저 루트 노드를 방문
            preorderTraversal(node.left);      // 그 다음 왼쪽 서브트리를 순회
            preorderTraversal(node.right);     // 마지막으로 오른쪽 서브트리를 순회
        }
    }

    // 중위 순회 메소드
    public void inorderTraversal(Node<E> node) {
        if (node != null) {
            inorderTraversal(node.left);     // 왼쪽 서브트리 순회
            System.out.print(node.data + " "); // 노드 방문 (루트 노드)
            inorderTraversal(node.right);    // 오른쪽 서브트리 순회
        }
    }

    public void postorderTraversal(Node<E> node) {
        if (node != null) {
            postorderTraversal(node.left);    // 왼쪽 서브트리 순회
            postorderTraversal(node.right);   // 오른쪽 서브트리 순회
            System.out.print(node.data + " "); // 노드 방문 (루트 노드)
        }
    }

    public static void main(String[] args) {

        // 루트 노드 생성
        Node<Integer> root = new Node<>(1);

        // 자식 노드 추가
        root.left = new Node<>(2);
        root.right = new Node<>(3);

        // 더 깊은 자식 노드 추가
        root.left.left = new Node<>(4);
        root.left.right = new Node<>(5);
        root.right.left = new Node<>(6);
        root.right.right = new Node<>(7);

        // 트리의 전위 순회 출력
        System.out.println("Preorder traversal of binary tree:");
        root.preorderTraversal(root);

    }

}