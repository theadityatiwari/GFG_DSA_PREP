class Solution {
    int countFreq(int[] arr, int target) {
        // code here
        int firstInd = firstInd(arr,target);
        int lastInd = lastInd(arr,target);
        int ans = 0;
        if(firstInd != -1){
            ans = lastInd - firstInd + 1;
        }
        
        return ans;
    }
    
    int firstInd(int[] arr,int target){
        int s = 0;
        int e = arr.length -1;
        int ans = -1;
        
        while(s<=e){
            int m = s + (e-s)/2;
            if(arr[m] == target){
                ans = m;
                e = m - 1;
            } 
            else if(arr[m] < target){
                s = m + 1;
            }else{
                e = m - 1;
            }
           
        }
      
        return ans;
    }
    
    int lastInd(int[] arr,int target){
        int s = 0;
        int e = arr.length -1;
        int ans = -1;
        
        while(s<=e){
            int m = s + (e-s)/2;
            if(arr[m] == target){
                ans = m;
                s = m + 1;
            } 
            else if(arr[m] > target){
                e = m - 1;
            }else{
                s = m + 1;
            }
           
        }
      
        return ans;
    }
}
