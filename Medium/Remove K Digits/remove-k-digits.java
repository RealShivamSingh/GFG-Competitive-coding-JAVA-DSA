//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String S = sc.next();
            int K = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.removeKdigits(S, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String removeKdigits(String S, int K) {
        // code here
        int n = S.length();
        if (n == K) {
            return "0";
        }
        Stack<Character> store = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (K > 0 && !store.empty() && store.peek() > S.charAt(i)) {
                store.pop();
                K--;
            }
            store.push(S.charAt(i));
        }
        while (K > 0) {
            store.pop();
            K--;
        }
        StringBuilder ans = new StringBuilder();
        while (!store.empty()) {
            ans.append(store.pop());
        }
        ans.reverse();
        int i = 0;
        while (i < ans.length() && ans.charAt(i) == '0') {
            i++;
        }
        if (i == ans.length()) {
            return "0";
        }
        return ans.substring(i);
    }
}