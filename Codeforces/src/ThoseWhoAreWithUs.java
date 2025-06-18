//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class ThoseWhoAreWithUs {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        while (t-- > 0) {
//            int n = sc.nextInt();
//            int m = sc.nextInt();
//            int[][] arr = new int[n][m];
//            List<Node> list = new ArrayList<>();
//
//            int max = arr[0][0];
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    arr[i][j] = sc.nextInt();
//                    if (arr[i][j] > max) {
//                        max = arr[i][j];
//                    }
//                }
//            }
//
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    if (arr[i][j] == max) {
//                        list.add(new Node(i, j));
//                    }
//
//                }
//            }
//
//            if (list.size() > 1) {
//                boolean flag1 = false;
//                int x1 = list.get(0).x;
//                int y1 = list.get(0).y;
//
//                for (int i = 1; i < list.size(); i++) {
//                    int x2 = list.get(i).x;
//                    int y2 = list.get(i).y;
//                    if (x1 != x2 && y1 != y2) {
//                        flag1 = true;
//                        break;
//                    }
//                }
//
//                if (flag1) {
//                    System.out.println(max - 1);
//                } else {
//
//                }
//            } else {
//
//            }
//        }
//    }
//}
//
//class Node {
//    int x;
//    int y;
//
//    public Node(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//}


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class ThoseWhoAreWithUs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[n][m];
            int max = 0;
            List<int[]> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                    if (arr[i][j] > max) {
                        max = arr[i][j];
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == max) {
                        list.add(new int[]{i, j});
                    }
                }
            }


            int res = Integer.MAX_VALUE;
            if (list.size() > 2) {
                for (int i = 0; i < list.size(); i++) {
                    for (int j = 0; j < list.size(); j++) {
                        int r = list.get(i)[0];
                        int c = list.get(j)[1];
                        int cur = Integer.MIN_VALUE;
                        for (int p = 0; p < n; p++) {
                            for (int q = 0; q < m; q++) {
                                int value = arr[p][q];
                                if (p == r || q == c) value--;
                                cur = Math.max(cur, value);
                            }
                        }
                        res = Math.min(cur, res);
                    }
                }
                System.out.println(res);
            } else {
                System.out.println(max - 1);
            }
//            if (set1.size() == 1 && set2.size() == 1) {
//                max--;
//                int indexx = -1;
//                int indexy = -1;
//                for (int num : set1) {
//                    indexx = num;
//                }
//                for (int num : set2) {
//                    indexy = num;
//                }
//
//                for (int i = 0; i < n; i++) {
//                    boolean flag = false;
//                    for (int j = 0; j < m; j++) {
//                        if (arr[i][j] == max) {
//                            if (i != indexx && i != indexy) {
//                                System.out.println(max);
//                                flag = true;
//                                break;
//                            }
//                        }
//                    }
//                    if (flag) {
//                        break;
//                    }
//                }
//                max--;
//                System.out.println(max);
//            }
//            } else {
//                for (int i : set1) {
//                    for (int j : set2) {
//                        int cur = Integer.MIN_VALUE;
//                        for (int p = 0; p < n; p++) {
//                            for (int q = 0; q < m; q++) {
//                                if (p == i || q == j) {
//                                    cur = Math.max(cur, arr[p][q]);
//                                }
//                            }
//                        }
//                        res = Math.min(res, cur);
//                    }
//                }
//                System.out.println(res);
//            }

        }
    }
}