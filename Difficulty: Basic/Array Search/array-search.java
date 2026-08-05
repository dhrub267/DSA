class Solution {
    public int search(int arr[], int x) {
        // code here
        boolean found=false;
        int i;
        for(i=0; i<arr.length; i++){
            if(arr[i]==x){
              found=true;
                break;
            }
        }
        if(found==true)return i;
        else return -1;
    }
}
