class Solution {
    // Function to find equilibrium point in the array.
    public static int findEquilibrium(int arr[]) {
        // code here
        int n=arr.length;
        int total=0;
        int leftSum=0;
        
        for(int i=0; i<n; i++){
            total=total + arr[i];
        }
        
        for(int i=0; i<n; i++){
            total=total-arr[i];
            
            if(leftSum==total){
                return i;
            }
            
            leftSum=leftSum+arr[i];
        }
        return -1;
    }
}
































