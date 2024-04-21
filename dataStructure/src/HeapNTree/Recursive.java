package HeapNTree;

public class Recursive<E extends Comparable<E>> {

    private Node<E> root;
    private int currentSize;

    public Recursive() {
        root = null;
        currentSize = 0;
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

    private void add(E obj, Node<E> node){
        if (obj.compareTo(node.data) > 0) {
            // go to the right
            if (node.right == null) {
                node.right = new Node<>(obj);
            } else {
                add(obj, node.right);
            }
        } else {
            // go to the left
            if (node.left == null) {
                node.left = new Node<>(obj);
            } else {
                add(obj, node.left);
            }
        }
    }

    // 트리가 비어있을 경우 (오버로딩)
    public void add(E obj) {
        if (root == null) {
            root = new Node<>(obj);
        } else {
            add(obj, root);
        }
        currentSize++;
    }

    public static void main(String[] args) {
        Recursive<Integer> tree = new Recursive<>();
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(2);
        tree.add(7);
        tree.add(12);
        tree.add(18);

        // 트리의 내용을 중위 순회로 출력 (테스트용으로 추가한 메소드)
        tree.inorderTraversal(tree.root);
    }

}