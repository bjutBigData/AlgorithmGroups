/**
 * Created by Panda on 2016/6/13.
 */


public class HeapSort {
    public static void heapSort(int[] array){
        if(array == null || array.length <= 1){
            return;
        }

        buildMaxHeap(array);

        for(int i = array.length - 1; i >= 1; i--){
            ArrayUtils.exchangeElements(array,0,i);
            //System.out.println(i);
            maxHeap(array, i, 0);
        }
        System.out.println("After MaxHeap sort.");
        ArrayUtils.printArray(array);

        bulidMinHeap(array);
        for(int i = array.length - 1; i >= 1; i--){
            ArrayUtils.exchangeElements(array,0,i);
            //System.out.println(i);
            minHeap(array, i, 0);
        }
        System.out.println("After MinHeap sort.");
        ArrayUtils.printArray(array);



    }
    public static void buildMaxHeap(int[] array){
        if(array == null || array.length <= 1){
            return;
        }

        int half = (array.length-1) / 2;
        for (int i = half; i >= 0; i--) {
            maxHeap(array, array.length, i);
        }
    }

    private static void maxHeap(int[] array, int heapSize, int index){
        int left = index * 2 + 1;
        int right = index * 2 + 2;

        int largest = index;
        if(left < heapSize && array[left] > array[index]){
            largest = left;
        }
        if(right < heapSize && array[right] > array[largest]){
            largest = right;
        }
        if(index != largest){
            ArrayUtils.exchangeElements(array,index,largest);
            maxHeap(array,heapSize,largest);
        }
    }


public static void bulidMinHeap(int[] array){
        if(array == null || array.length <=1)
            return;
        int half = (array.length - 1) / 2;
        for(int i = half; i >= 0; i--){
            minHeap(array,array.length,i);
        }
    }

    private static void minHeap(int[] array, int heapSize, int index){
        int left = index * 2 + 1;
        int right = index * 2 + 2;

        int min = index;
        if(left < heapSize && array[left] < array[index]){
            min = left;
        }
        if(right < heapSize && array[right] < array[min]){
            min = right;
        }
        if(index != min){
            ArrayUtils.exchangeElements(array,index,min);
            minHeap(array, heapSize, min);
        }
    }




    public static void main(String[] args) {
        int[] array = {9,8,7,6,5,4,3,2,1,0,-1,-2,-3};
        System.out.println("Before heap.");
        ArrayUtils.printArray(array);
        heapSort(array);

    }
}
