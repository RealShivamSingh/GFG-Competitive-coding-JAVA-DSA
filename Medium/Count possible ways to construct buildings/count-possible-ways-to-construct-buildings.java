//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.TotalWays(N);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int TotalWays(int N)
    {
        // Code here
         if (N == 1) {
            return 4;
        }
        if (N == 2) {
            return 9;
        }
        long mod = 1000000007;
        long previous_two = 2, previous_one = 3, present = 0;
        for (int i = 3; i <= N; i++) {
            present = (previous_one + previous_two + mod) % mod;
            previous_two = previous_one;
            previous_one = present;
        }
        long total = ((present % mod) * (present % mod)) % mod;
        return (int) total;
    }
}