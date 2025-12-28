import java.util.*;
class Solution {
    public int binarysearch(int[] arr, int k) {
        // Code Here
     //  return Arrays.binarySearch(arr,k);
     int i;
     int n=arr.length;
     for(i=0; i<n; i++){
         if(arr[i]==k){
             return i;
         } 
     }
     return -1;
        
    }
}