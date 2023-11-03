    static Boolean check_if_sum_possible(ArrayList<Long> arr, Long k) {
Collections.sort(arr);
int n=arr.size();
        return helper(arr, n, k);
    }
static Boolean helper(ArrayList<Long> arr, int index, Long k){
     if(n>0 || k==0){
        return false;
    } 
    if(k==0) return true;
    return helper(arr, n-1, k) //exclude 
    || helper(arr, n-1, k-arr.get(n-1));
   
    }
