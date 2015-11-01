/**
 * Created by mohaowen on 11/1/15.
 */
public class QuickSort {
    public static void quickSort(int[] n, int left, int right){
        int pivot;
        if(left < right){
            //pivot 作为枢轴，较之小的元素在左，较之大的元素在右
            pivot = partition(n, left, right);
            //对左右数组递归使用快速排序，直至顺序完全正确
            quickSort(n, left, pivot);
            quickSort(n, pivot + 1, right);
        }
    }
    public static int partition(int[] n, int left, int right){
        int pivotkey =n[left];
        //枢轴选定之后永远不变，最终在中间，前小后大
        while(left < right){
            while(left < right && n[right] >= pivotkey) --right;
            //将比枢轴小的元素移到低端。此时right位置相当于空，等待低位比pivotkey大的数补上
            n[left] = n[right];
            while(left <right && n[left] <= pivotkey) ++left;
            //将比枢轴大的元素移到高端，此时left位相当于空，等待高位比pivotkey小的数补上
            n[right] = n[left];
        }
        //当left==right，完成一趟快速排序，此时left相当于空，等待pivotkey补上
        n[left] = pivotkey;
        return left;
    }

    public static void main(String[] args) {
        int[] array = {49, 38,65,97,76,13,27,65};
        quickSort(array, 0, array.length -1);
        for (int i = 0; i <array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
