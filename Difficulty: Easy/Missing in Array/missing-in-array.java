// class Solution {
//     int missingNum(int arr[]) {
//         int n = arr.length;
//         long total = 1L * (n + 1) * (n + 2) / 2; // force long before multiply
//         long sum = 0;
//         for (int x : arr) sum += x;
//         return (int)(total - sum);
//     }
// }


class Solution {
    int missingNum(int arr[]) {
    int n=arr.length+1;
    //sum of natural number of n=n+1;
    long sum1=(long)n*(n+1)/2;
    long sum2=0;
    for(int i=0; i<n-1; i++){
        sum2=sum2+arr[i];
    }
    return (int)(sum1-sum2);
    }
}


