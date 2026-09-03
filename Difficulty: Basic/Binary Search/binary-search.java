class Solution {
    public boolean binarySearch(int[] arr, int k) {
        // code here
        
        int low=0;
        int high=arr.length-1;
        
        while(low<=high){
            int mid=(low+high)/2;
            if(k<arr[mid]){
                high=mid-1;
            }
            
            else if(k>arr[mid]){
                low=mid+1;
            }
            
            else{
                return true;
            }
            
            
        }
        
        return false;
    }
}