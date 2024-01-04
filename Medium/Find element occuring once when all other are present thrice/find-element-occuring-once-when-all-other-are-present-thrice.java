//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.singleElement(arr,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int singleElement(int[] arr , int N) {
        // code here
        List<Integer> count = new ArrayList<>(32);
        for (int i = 0; i < 32; i++) {
            count.add(0);
        }
        for (int bit = 0; bit < 32; bit++) {
            for (int i = 0; i < arr.length; i++) {
                if ((arr[i] & (1 << bit)) != 0) {
                    count.set(bit, count.get(bit) + 1);
                }
            }
        }
        int ans = 0;
        for (int bit = 0; bit < 32; bit++) {
            if (count.get(bit) % 3 != 0) {
                ans += (1 << bit);
            }
        }
        return ans;
    }
}