//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaximum(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int findMaximum(int[] arr, int n) {
        // code here
        int s = 0;
        int e = n-1;
        if(arr[s]<arr[e] && arr[e] > arr[e-1]){
            return arr[e];
        }
        while(s<e){
            int m = s + (e-s)/2;
            if(arr[m] > arr[m-1] && arr[m] > arr[m+1]){
                return arr[m];
            }else if(arr[m]<arr[m+1]){
                s = m + 1;
            }else if(arr[m]>arr[m+1]){
                e = m;
            }
        }
        return arr[s];
    }
}