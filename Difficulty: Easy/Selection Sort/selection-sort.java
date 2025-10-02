class Solution {
    void selectionSort(int[] arr) {
        // code here
        int n=arr.length;
        for(int i=0; i<n; i++){
            int min=Integer.MAX_VALUE;
            int mindx=-1;// which is never
            for(int j=i; j<n; j++){
              if(arr[j]<min){
                  min=arr[j];
                  mindx=j;
              }  
            }
            
            int temp=arr[i];
            arr[i]=arr[mindx];
            arr[mindx]=temp;
        }
    }
}