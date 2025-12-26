class Solution {
    public int getSecondLargest(int[] arr) {
        // code here
        int n=arr.length;
        int largest=Integer.MIN_VALUE;
         int secondLargest=Integer.MIN_VALUE;
         
         for(int i=0; i<n; i++){
             if(arr[i]>largest){
                 largest=arr[i];
             }
         }
         
         for(int i=0 ;i<n; i++){
             if((arr[i]> secondLargest) && arr[i]!=largest){
                 secondLargest=arr[i];
             }
         }
         
         if(secondLargest==largest) return -1;
         else{
             return secondLargest;
         }
         
    }
}



