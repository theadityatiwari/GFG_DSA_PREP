//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

    
            long ans = new Solution().maxProduct(arr, n);
            System.out.println(ans);
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    long maxProduct(int[] arr, int n) {
        // code here
        long max = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        long secondMin = Long.MAX_VALUE;
        
        for(int i =0;i<n;i++){
            if(arr[i]<min){
              long tempMin = min;
              min = arr[i];
              secondMin = Math.min(tempMin,secondMin);
            }else if(arr[i]<secondMin){
                secondMin = arr[i];
            }
            if(arr[i]>max){
                Long tempMax = max;
                max = arr[i];
                Long tempSecondMax = secondMax;
                secondMax = Math.max(tempMax,secondMax);
                thirdMax = Math.max(tempSecondMax,thirdMax);
            }else if(arr[i]> secondMax){
                Long tempSecondMax = secondMax;
                secondMax = arr[i];
                thirdMax = Math.max(tempSecondMax,thirdMax);
            }else if(arr[i]>thirdMax){
                thirdMax = arr[i];
            }
        }
    
        
        long p1 = max * secondMax * thirdMax;
        long p2 = max * min * secondMin;
        return Math.max(p1,p2);
    }
}
