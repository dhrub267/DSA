// User function Template for Java

class Solution {
    public static ArrayList<Integer> commonElements(int a[], int b[]) {
        // Your code here
        Arrays.sort(a);
        Arrays.sort(b);
        int n1=a.length;
        int n2=b.length;
        int i=0;
        int j=0;
        ArrayList<Integer> ans=new ArrayList<>();
        while(i<n1 && j<n2){
            if(a[i]==b[j]){
                ans.add(a[i]);
                i++; 
                j++;
            }
            else if(a[i]<b[j]) i++;
            else j++;
        }
        return ans;
    }
}