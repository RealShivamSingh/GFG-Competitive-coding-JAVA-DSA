//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG {
	public static void main (String[] args)throws IOException {
		
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int t = Integer.parseInt(in.readLine().trim());
        while(t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            
            int gallery[] = new int[n];
            for(int i=0; i<n; i++)
                gallery[i] = Integer.parseInt(s[i]);
            Solution T = new Solution();
            out.println(T.min_sprinklers(gallery,n));
        }
		out.close();
		
	}
}





// } Driver Code Ends


//User function Template for Java

class Solution
{
    int min_sprinklers(int gallery[], int n)
    {
        // code here
             int plant[] = new int[n];
        Arrays.fill(plant,-1);
        for(int i=0;i<n;i++){
            if(gallery[i]!=-1){
                int a = Math.max(0,i-gallery[i]);
                int b = Math.min(n-1,i+gallery[i]);
                for(int j=a;j<=b;j++){
                    plant[j]=Math.max(plant[j],b);
                }
            }
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            if(plant[i]==-1)return -1;
            if(i<=plant[i]){
                ans++;
                i=plant[i];
            }
        }
        return ans;
    }
}
