//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxAverage(arr, n, k);
            for(int i=ans; i<ans+k; i++)
                System.out.print(arr[i]+" ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int findMaxAverage(int[] arr, int n, int k) {
        // code here
        int windowStart = 0;
        int windowSum = 0;
        double maxAverage = Double.NEGATIVE_INFINITY;
        int maxInd = 0;
        for(int windowEnd = 0;windowEnd<n;windowEnd++){
            windowSum += arr[windowEnd];
            int currSize = windowEnd - windowStart + 1;
            if (currSize == k) {
                double average = (double) windowSum / k;
                if (maxAverage < average) {
                    maxInd = windowStart;
                    maxAverage = average;
                }
                windowSum -= arr[windowStart];
                windowStart++;
            }

        }
        
        return maxInd;
        
    }
}
