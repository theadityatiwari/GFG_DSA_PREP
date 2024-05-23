//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String S)
    {
        // code here 
        int n = S.length();
        StringBuilder sb = new StringBuilder();
        String temp = "";
        for(int i=0;i<n;i++){
            if(S.charAt(i)!='.'){
                temp = temp + S.charAt(i);
                if(i==n-1){
                    sb.insert(0,temp);
                }
            }else{
                sb.insert(0,temp);
                sb.insert(0,'.');
                temp = "";
            }
        }
        
        String s = sb.toString();
        return s;
    }
}