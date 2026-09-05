class Solution {
    int floorSqrt(int n) {
        // code here
        int sqrt=0;
        int i;
        for(i=1; i<=n; i++){
            if(i*i>n){
                break;
            }
            else{
                 sqrt=i;
            }
            
        }
        return sqrt;
    }
}