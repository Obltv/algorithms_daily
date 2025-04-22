import java.util.Stack;

public class lc1475 {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack=new Stack<>();
        int n=prices.length;
        int[] arr=new int[n];
        //int[] res=new int[n];
        for(int i=n-1;i>=0;i--){
        	while(!stack.isEmpty()&&stack.peek()>prices[i]){
        		stack.pop();
        	}
        	arr[i]=stack.isEmpty()?prices[i]:prices[i]-stack.peek();
        	stack.push(prices[i]);
        }
        return arr;
    }
}
