class Solution {
    public static int sumSubstrings(String s) {
        // code here
        int sum=0;
        for(int i=0; i<s.length();i++){
            for(int j=i+1; j<=s.length(); j++){
                sum=sum + Integer.parseInt(s.substring(i,j));
            }
        }
        return sum;
    }
}