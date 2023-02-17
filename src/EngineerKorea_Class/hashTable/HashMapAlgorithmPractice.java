package EngineerKorea_Class.hashTable;

import java.util.HashMap;
import java.util.Map;

public class HashMapAlgorithmPractice {
    /**
     * 부여된 배열에서 두 값의 합이 Target 값이 되는 인덱스 배열 반환
     * @param num
     * @param target
     * @return new int[]{i, index}
     */
    public static int[] solution(int[] num, int target){
        Map map = new HashMap();
        for(int i=0; i<num.length; i++) map.put(num[i], i);
        for(int i=0; i<num.length; i++) {
            Integer index = (Integer) map.get(target-num[i]);
            if(index != null && i != index) return new int[]{i, index};
        }
        throw new IllegalStateException("Not Found");
    }

    /**
     * 배열을 Hash Map 에 추가하면서 두 값의 합이 Target 값이 되는 인덱스 배열 반환
     * @param num
     * @param target
     * @return new int[]{i, (int)map.get(target - num[i])}
     */
    public static int[] solution2(int[] num, int target){
        Map map = new HashMap();
        for(int i=0; i< num.length; i++){
            if(map.containsKey(target - num[i])) return new int[]{(int)map.get(target - num[i]),i};
            map.put(num[i], i);
        }
        throw new IllegalStateException("Not Found");
    }

    public static void main(String[] args) {
        int [] num = {6,9,8,4,7,5,2};
        for(int print : solution2(num, 6)){
            System.out.print(print + " ");
        }
    }
}
