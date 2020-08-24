public class DayTen {

    static int merge(int arr[],int l, int m, int r) {
        int left[] = new int[m-l+1];
        int right[] = new int[r-m];
        for(int i=0; i<(m-l+1);i++) left[i] =arr[l+i];
        for (int j = 0; j <(r-m); j++) right[j] = arr[m + 1 + j]; 
        int i = 0, j = 0, k=l, count =0;
        while (i < left.length && j < right.length) { 
            if (left[i] <= right[j]) arr[k++] = left[i++]; 
            else { 
                arr[k++] = right[j++]; 
                count += (m + 1) - (l + i); 
            } 
        }  
        while (i < left.length) arr[k++] = left[i++]; 
        while (j < right.length) arr[k++] = right[j++]; 
        return count;  
    }
   static int sort(int arr[], int l, int r) {
        int count =0;
        if(l<r) {
            int m = (l+r)/2;
            count += sort(arr,l,m);
            count += sort(arr,m+1,r);
            count += merge(arr,l,m,r);
        }
        return count;
    }
    public static void main(String args[]) {
        int[] arr = { 1,5,3,2 }; 
        System.out.println(sort(arr, 0, arr.length - 1));
    }
}
