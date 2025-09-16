class Solution {
    // Swap helper function
    void swap(int arr[], int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    // Function to segregate 0s and 1s
    void segregate0and1(int arr[]) {
        int n=arr.length;
        int start = 0;
        int end=n-1;
        while(start<=end){
            if(arr[start]==0){
                start++;
            }
            
            else if(arr[end]==1){
                end--;
            }
            
            else {
                swap(arr,start,end);
            }
        }

        
    }
}
