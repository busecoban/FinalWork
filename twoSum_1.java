import java.util.HashMap;
import java.util.Map;


class twoSum_1 {
    public int[] twoSum_1(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                result[0]=map.get(target-nums[i]);
                result[1]=i;
            }
            map.put(nums[i],i);
        }
       return result;
        
    }
        public static void main(String[] args) {
            twoSum_1 obj = new twoSum_1();
            int[] nums = {2, 7, 11, 15};
            int target = 9;
            int[] result = obj.twoSum_1(nums, target);
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        }
}