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
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public List<String> AllPossibleStrings(String s) {
        List<String> ans = new ArrayList<>(); // Convert Set to sorted List
        allSubstrings("", s, ans);
        Collections.sort(ans);
        return ans;
    }
    
    public void allSubstrings(String p, String up, List<String> ans) {
        if (up.isEmpty()) {
            if(p.isEmpty()) return;
            ans.add(p);
            return;
        }
    
        char ch = up.charAt(0);
        allSubstrings(p + ch, up.substring(1), ans); // Exclude ch first
        allSubstrings(p, up.substring(1), ans); // Include ch later
    }
}