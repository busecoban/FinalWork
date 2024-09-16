import java.util.HashMap;

class romanToInt_13 {
    
    public static int romanToInt(String s) {
        int number=0;
        int result=0;
    HashMap <String,Integer> romanToInt=new HashMap<>();
    romanToInt.put("I",1);
    romanToInt.put("V", 5);
    romanToInt.put("X", 10);
    romanToInt.put("L", 50);
    romanToInt.put("C", 100);
    romanToInt.put("D", 500);
    romanToInt.put("M", 1000);

    char[] arr=s.toCharArray();
    
    for (int i= arr.length-1;i>=0 ;i--) {
        switch (arr[i]){
            case 'I': number=1; break;
            case 'V': number=5; break;
            case 'X': number=10; break;
            case 'L': number=50; break;
            case 'C': number=100; break;
            case 'D': number=500; break;
            case 'M': number=1000; break;

        }
        if(4*number<result){
            result-=number;
            }else {
            result+=number;
            }


    }

    return result;

        
    }
}