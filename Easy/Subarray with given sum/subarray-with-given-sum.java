//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
	static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            
            String s[] = br.readLine().trim().split(" ");
            
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                a[i] = Integer.parseInt(s[i]);
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(a, n, k);
            for(int ii = 0;ii<res.size();ii++)
                ot.print(res.get(ii) + " ");
            ot.println();
        }
        ot.close();
    }

}
// } Driver Code Ends


class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
         int start =0 , end =0 ,currSum =0;
         ArrayList<Integer> ans = new ArrayList<>();
        while(end < n){
         currSum += arr[end];
         while(currSum > s && start <end){
             currSum -=arr[start];
             start++;
         }
           if (currSum == s) {
                ans.add(start + 1); // Adding 1 to convert from 0-indexed to 1-indexed
                ans.add(end + 1);
                return ans;
            }
            
            end++;
        }
        
        ans.add(-1); // If no sub-array is found
        return ans;
     
}
    
}