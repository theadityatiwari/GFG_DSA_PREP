//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        HashMap<Character,Integer> map = new HashMap<>();
        
        int windowStart = 0;
        int maxLength = 0;
        for(int windowEnd = 0;windowEnd<s.length();windowEnd++){
            char rightChar = s.charAt(windowEnd);
            map.put(rightChar,map.getOrDefault(rightChar,0)+1);
            while(map.size()>k){
                char leftChar = s.charAt(windowStart);
                map.put(leftChar,map.get(leftChar)-1);
                if(map.get(leftChar)==0){
                    map.remove(leftChar);
                }
                windowStart++;
            }
            if(map.size()==k)
             maxLength = Math.max(maxLength,windowEnd-windowStart +1);
        }
        
        return maxLength == 0 ? -1:maxLength; 
    }
}