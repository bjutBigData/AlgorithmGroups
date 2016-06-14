/**
 * Created by Panda on 2016/3/28.
 */
public class BinarySearch {
    private int rCount = 0;
    private int lCount = 0;

    /*
    * 获取递归次数
    */
    public int getrCount(){
        return rCount;
    }

    /*
    * 获取循环次数
    * */
    public int getlCount(){
        return lCount;
    }

    /*
    * 执行递归二分查找，返回第一次出现该值的位置
    * @param sortedData     已排序的数组
    * @param start          开始的位置
    * @param end            结束的位置
    * @param findValue      需要找的值
    * @return               值在数组中的位置，从0开始，找不到返回-1
    * */
    public int searchRecursive(int[] sortedData, int start, int end, int findValue){
        rCount ++;
        if(start <= end){
            //中间位置
            int middle = (start + end) >> 1;  //相当于(start + end)/2
            //中值
            int middleValue = sortedData[middle];

            if(findValue == middleValue){
                //等于中值直接返回
                return middle;
            }
            else if(findValue < middleValue){
                //小于中值时在中值前面查找
                return searchRecursive(sortedData,start,middle-1,findValue);
            }
            else {
                //大于中值时在中值后面查找
                return searchRecursive(sortedData, middle + 1, end, findValue);
            }
        }
        else{
            return -1;
        }
    }


    /*
    * 循环二分查找，返回第一次出现该值的位置
    * @param sortedData     已排序的数组
    * @param findValue      需要找的值
    * @return               值在数组中的位置，从0开始，找不到返回-1
    * */
    public int searchLoop(int[] sortedDta, int findValue){
        int start = 0;
        int end = sortedDta.length;

        while(start <= end){
            lCount ++;
            //中间位置
            int middle = (start + end) >> 1;
            System.out.println("middle: " + middle);
            //中值
            int middleValue = sortedDta[middle];

            if(findValue == middleValue){
                return middle;
            }
            else if(findValue < middleValue){
                end = middle - 1;
            }
            else {
                start = middle + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

        BinarySearch bs = new BinarySearch();

        int[] Sorteddata = {1,2,3,5,6,7,7,8,9,10,11,12,12,16};
        int findvalue = 12;
        int length = Sorteddata.length;

        int Pos = bs.searchRecursive(Sorteddata,0,length,findvalue);
        System.out.println("Recursive:" + findvalue + "  found in pos " +  Pos + "; count:" + bs.getrCount());
        int Pos2 = bs.searchLoop(Sorteddata, findvalue);
        System.out.println("Loop:" + findvalue + "  found in pos " +  Pos2 + "; count:" + bs.getlCount());

    }
}






























