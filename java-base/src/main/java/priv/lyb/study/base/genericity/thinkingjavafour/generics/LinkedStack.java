package priv.lyb.study.base.genericity.thinkingjavafour.generics;

/**
 * @author LiuYingBo 2021/01/13 16:55
 */
public class LinkedStack<T> {
    private static class Node<U> {
        U u;
        Node<U> next;

        Node() {
            this.u = null;
            this.next = null;
        }

        Node(U u, Node<U> next) {
            this.u = u;
            this.next = next;
        }

        boolean end() {
            return u == null && next == null;
        }
    }

    Node<T> top = new Node<T>();

    public void push(T t) {
        top = new Node<T>(t, top);
    }

    public T pop() {
        T t = top.u;
        if (!top.end()) {
            top = top.next;
        }
        return t;
    }

    public static void main(String[] args) {
        LinkedStack<String> a = new LinkedStack<>();
        a.push("a");
        a.push("b");
        System.out.println(a.pop());
        System.out.println(a.pop());

    }
}
