class Sort {
    public void mergeHelper(int arr[], int l, int m, int r) {
        //create 2 arrays left and right that need to be merged
        int left[] = new int[(m-l)+1];
        int right[] = new int[r-m];
        for(int i = 0; i < (m-l)+1; i++) left[i] = arr[l+i];
        for(int i = 0; i < (r-m); i++) right[i] = arr[(m+1)+i];
        int leftArrayPointer = 0 , rightArrayPointer = 0, arrPointer = l;
        while(leftArrayPointer < (m-l)+1 && rightArrayPointer < r-m) {
            if(left[leftArrayPointer] < right[rightArrayPointer]) {
                arr[arrPointer] = left[leftArrayPointer];
                leftArrayPointer++;
            }
            else{
                arr[arrPointer] = right[rightArrayPointer];
                rightArrayPointer++;
            }
            arrPointer++;
        }
        //left or the right array may have some elements left, add those to arr
        for(int i = leftArrayPointer; i < left.length; i++, arrPointer++) arr[arrPointer] = left[i];
        for(int i = rightArrayPointer; i < right.length; i++, arrPointer++) arr[arrPointer] = right[i];
    }
    public void mergeSort(int arr[], int l, int r) {
        //base condition is when l >=r 
        int m = (l+r)/2;
        if(l<r) {
            mergeSort(arr,l,m);
            mergeSort(arr, m+1, r);
            mergeHelper(arr, l, m, r);
        }
    }
}
public class DayEleven {
    public static void main(String args[]) {
        int arr[] = new int[]{34,12,1,3,25,75,11};
        Sort s = new Sort();
        s.mergeSort(arr, 0, arr.length-1);
        for(int i:arr){
            System.out.println(i);
        }

    }
}
