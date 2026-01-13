// User function Template for Java

class GFG {
    ArrayList<Integer> find(int arr[], int x) {
        // code here
        ArrayList <Integer> al=new ArrayList<Integer>();
        int low=0;
        int high=arr.length-1;
        int first=-1;
        while(low<=high){
            int mid=(low+high)/2;
            
            if(arr[mid]==x){
                while(mid>0 && arr[mid-1]==x){
                    mid--;
                }
                first= mid;
                break;
            }
            
            else if(arr[mid]<x) low=mid+1;
            else high=mid-1;
            
        }
        
         low=0;
         high=arr.length-1;
        int last=-1;
        while(low<=high){
            int mid=(low+high)/2;
            
            if(arr[mid]==x){
                while(mid<arr.length-1 && arr[mid + 1]==x){
                    mid++;
                }
                last= mid;
                break;
            }
            
            else if(arr[mid]<x) low=mid+1;
            else high=mid-1;
            
        }
        
        al.add(first);
        al.add(last);
        
        return al;
        
            
    }
}
