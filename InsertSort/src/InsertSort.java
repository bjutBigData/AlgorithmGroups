/**
 * Created by Panda on 2016/6/14.
 */
public class InsertSort {
    public static void insertSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            for (int j = i-1; j >=0 ; j--) {
                if(array[j] > temp)
                    array[j+1] = array[j];
                else
                    break;
                array[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array ={49,38,65,97,76,13,27,49,78,34,12,64,1};
        System.out.println("Before Sort:");
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");

        System.out.println();
        System.out.println("After Sort:");
        insertSort(array);
        for(int a : array)
            System.out.print(a + " " );

    }
}
