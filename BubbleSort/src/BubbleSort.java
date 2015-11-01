/**
 * Created by mohaowen on 11/1/15.
 */
public class BubbleSort {
    public static void bubble(int[] data){
        for (int i = 0; i <data.length ; i++) {
            for (int j = 0; j <data.length-1-i ; j++) {
                if(data[j] > data[j+1]){            //如果后一个数小于前一个数， 交换
                    int tmp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] list = {49,38,65,97,76,13,27,14,10};
        bubble(list);
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }
}
