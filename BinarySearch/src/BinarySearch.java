/**
 * Created by Panda on 2016/3/28.
 */
public class BinarySearch {
    private int rCount = 0;
    private int lCount = 0;

    /*
    * ��ȡ�ݹ����
    */
    public int getrCount(){
        return rCount;
    }

    /*
    * ��ȡѭ������
    * */
    public int getlCount(){
        return lCount;
    }

    /*
    * ִ�еݹ���ֲ��ң����ص�һ�γ��ָ�ֵ��λ��
    * @param sortedData     �����������
    * @param start          ��ʼ��λ��
    * @param end            ������λ��
    * @param findValue      ��Ҫ�ҵ�ֵ
    * @return               ֵ�������е�λ�ã���0��ʼ���Ҳ�������-1
    * */
    public int searchRecursive(int[] sortedData, int start, int end, int findValue){
        rCount ++;
        if(start <= end){
            //�м�λ��
            int middle = (start + end) >> 1;  //�൱��(start + end)/2
            //��ֵ
            int middleValue = sortedData[middle];

            if(findValue == middleValue){
                //������ֱֵ�ӷ���
                return middle;
            }
            else if(findValue < middleValue){
                //С����ֵʱ����ֵǰ�����
                return searchRecursive(sortedData,start,middle-1,findValue);
            }
            else {
                //������ֵʱ����ֵ�������
                return searchRecursive(sortedData, middle + 1, end, findValue);
            }
        }
        else{
            return -1;
        }
    }


    /*
    * ѭ�����ֲ��ң����ص�һ�γ��ָ�ֵ��λ��
    * @param sortedData     �����������
    * @param findValue      ��Ҫ�ҵ�ֵ
    * @return               ֵ�������е�λ�ã���0��ʼ���Ҳ�������-1
    * */
    public int searchLoop(int[] sortedDta, int findValue){
        int start = 0;
        int end = sortedDta.length;

        while(start <= end){
            lCount ++;
            //�м�λ��
            int middle = (start + end) >> 1;
            System.out.println("middle: " + middle);
            //��ֵ
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






























