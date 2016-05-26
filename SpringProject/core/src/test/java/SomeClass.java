import java.util.HashMap;
import java.util.Map;

public class SomeClass {

    public static void main(String[] args) {
        Map<Integer, Integer> lor = new HashMap<Integer, Integer>();
        lor.put(4, 51);
        lor.put(5, 52);
        lor.put(3, 53);
        lor.put(2, 54);


        Integer maxValue = 0;
        Integer categoryId = 0;
        for(Map.Entry map : lor.entrySet()) {
            if((Integer)map.getValue() > maxValue){
                maxValue = (Integer)map.getValue();
                categoryId = (Integer) map.getKey();
            }
        }
        System.out.println("Most popular category : " + categoryId);
        System.out.println("It uses : " + lor.get(categoryId) + " times");
    }


}
