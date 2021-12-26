package hellgorithm.week07.homework.choi;

public class shaker {

    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }
    static void CocktailShakerSort(int[] a, int n) {
        boolean swap = true;
        int i = 0;
        int j = n -1;

        while (i < j && swap) {
            swap = false;
            for (int k = i; k < j; k++) {
                if(a[k] > a[k+1]) {
                    swap(a,k+1,k);
                    swap = true;
                    //swap = true 구문 빠져있어서 추가.
                }
            }
            j--;
            if (swap) {
                swap = false;
                for (int k = j; k > i; k--) {
                    if ( a[k-1] > a[k] ) {
                        swap(a, k-1, k);
                        swap = true;
                    }
                }
                i++;
            }
        }

    }

}
