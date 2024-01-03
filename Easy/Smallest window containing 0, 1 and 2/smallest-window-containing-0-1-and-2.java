//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            int ans = ob.smallestSubstring(S);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int smallestSubstring(String S) {
        // Code here
         int zero=-1,one=-1,two=-1,res = 100001;
        
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i)=='0') zero=i;
            if(S.charAt(i)=='1') one=i;
            if(S.charAt(i)=='2') two =i;
            
            if(zero==-1 || one==-1 || two==-1) continue;
            int min = Math.min(Math.min(one,zero),two);
            int max = Math.max(Math.max(one,zero),two);
            res = Math.min(res,max-min+1);

        }
        return res==100001?-1:res;
    }
};
