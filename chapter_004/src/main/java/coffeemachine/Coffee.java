package coffeemachine;

import java.util.ArrayList;
import java.util.List;

public class Coffee {
    public boolean check = false;
    public int entire;
    public int fractional = 1;
    public int[] mas = {10, 5, 2, 1};
    public int masindex = 0;

    public List<Integer> changes(int value, int price) {
        List<Integer> result = new ArrayList<>();
        int difference = value - price;
        do {
           if (operation(difference, mas[masindex]) >= 1) {
                for (int i = 0; i < entire; i++) {
                    result.add(mas[masindex]);
                }
               difference = fractional;
           }
            masindex++;
        } while (fractional > 0);
        return result;
    }

    public int operation(int remain, int index) {
        entire = (int) Math.floor(remain / index);
        fractional = (int) remain % index;
        return entire;
    }
}
