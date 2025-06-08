import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class lc3170 {

    //错误的
//    class Solution {
//        public String clearStars(String s) {
//            char[] arr = s.toCharArray();
//            StringBuilder sb = new StringBuilder();
//            Stack<Integer> st = new Stack<>();
//            for (int i = 0; i < arr.length; i++) {
//                if (arr[i] != '*') {
//                    if (!st.isEmpty() && arr[i] > arr[st.peek()]) {
//                        continue;
//                    }
//                    while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
//                        st.pop();
//                    }
//                    st.push(i);
//                } else {
//                    arr[i] = ' ';
//                    if (!st.isEmpty()) {
//                        arr[st.pop()] = ' ';
//                    }
//                }
//            }
//
//            for (int i = 0; i < arr.length; i++) {
//                if (arr[i] != ' ') {
//                    sb.append(arr[i]);
//                }
//            }
//            return sb.toString();
//        }
//    }

    class Solution {
        public String clearStars(String s) {
            Queue<Node> q = new PriorityQueue<>(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    if (o1.ch != o2.ch) return o1.ch - o2.ch;
                    return o2.index - o1.index;
                }
            });

            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != '*') {
                    Node cur = new Node(arr[i], i);
                    q.add(cur);
                } else {
                    if (!q.isEmpty()) {
                        Node cur = q.poll();
                        arr[cur.index] = ' ';
                        arr[i] = ' ';
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != ' ') {
                    sb.append(arr[i]);
                }
            }
            return sb.toString();
        }
    }

    class Node {
        char ch;
        int index;

        public Node(Character ch, int index) {
            this.ch = ch;
            this.index = index;
        }

    }
}
