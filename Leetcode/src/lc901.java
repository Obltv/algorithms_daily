import java.util.*;

public class lc901 {
    // static class StockSpanner {
    //     Stack<Integer> stack;
    //     int[] arr;
    //     int index;

    //     public StockSpanner() {
    //         stack = new Stack<>();
    //         arr = new int[10005];
    //         index = 0;
    //     }

    //     public int next(int price) {
    //         arr[index] = price;

    //         while (!stack.isEmpty() && arr[stack.peek()] <= price) {
    //             stack.pop();
    //         }

    //         int res = stack.isEmpty() ? index+1 : (index - stack.peek());
    //         stack.push(index);
    //         index++;
    //         return res;
    //     }
    // }

    static class StockSpanner {
        Stack<int[]> stack=new Stack<>();
        public StockSpanner() {

        }

        public int next(int price) {
            int count=1;
            while(!stack.isEmpty()&&stack.peek()[0]<=price){
                int[] temp=stack.pop();
                count+=temp[1];
            }
            int[] c=new int[]{price,count};
            stack.push(c);
            return count;
        }
    }

    public static void main(String[] args) {
        String[] commands = {"StockSpanner", "next", "next", "next", "next", "next", "next", "next"};
        int[][] values = {{}, {100}, {80}, {60}, {70}, {60}, {75}, {85}};

        List<Object> output = new ArrayList<>();
        StockSpanner stockSpanner = null;

        for (int i = 0; i < commands.length; i++) {
            switch (commands[i]) {
                case "StockSpanner":
                    stockSpanner = new StockSpanner();
                    output.add(null); // 对应 "StockSpanner" 初始化返回 null
                    break;
                case "next":
                    int res = stockSpanner.next(values[i][0]);
                    output.add(res);
                    break;
            }
        }

        System.out.println(output);
    }
}
