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
            String s = br.readLine().trim();
            int k = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.characterReplacement(s, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int characterReplacement(String s, int k)
    {
        // code here
        HashMap<Character,Integer> map = new HashMap<>();
        
        int windowStart = 0;
        int maxLength = 0;
        int maxRepeatLetterCount = 0;
        for(int windowEnd = 0;windowEnd<s.length();windowEnd++){
            char rightChar = s.charAt(windowEnd);
            map.put(rightChar,map.getOrDefault(rightChar,0)+1);
            maxRepeatLetterCount  = Math.max(maxRepeatLetterCount,map.get(rightChar));
            if(windowEnd - windowStart + 1 - maxRepeatLetterCount > k ){
                char leftChar = s.charAt(windowStart);
                map.put(leftChar,map.get(leftChar)-1);
                windowStart++;
            }
             maxLength = Math.max(maxLength,windowEnd-windowStart +1);
        }
        
        return maxLength; 
    }
}