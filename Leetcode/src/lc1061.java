public class lc1061 {
    class Solution {
        public String smallestEquivalentString(String s1, String s2, String baseStr) {
            UF uf = new UF(26);
            int n = s1.length();
            for (int i = 0; i < n; i++) {
                uf.union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < baseStr.length(); i++) {
                int index = uf.find(baseStr.charAt(i) - 'a');
                char c = (char) (index + 'a');
                sb.append(c);
            }
            return sb.toString();
        }

    }

    class UF {
        int capacity;
        int[] parent;

        public UF(int n) {
            this.capacity = n;
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) return;
            if (rootA < rootB) {
                parent[rootB] = rootA;
            } else {
                parent[rootA] = rootB;
            }
            capacity--;
        }

        int find(int a) {
            if (parent[a] != a) {
                parent[a] = find(parent[a]);
            }
            return parent[a];
        }
    }
}
