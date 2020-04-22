package Task1;

import java.util.ArrayList;

public class ArrChange {
    public Integer[] arrchange(int[] array) throws RuntimeException {
        ArrayList<Integer> change = new ArrayList<>();

        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == 4) {
                for (int j = i + 1; j < array.length; j++){
                    change.add(array[j]);
                }
                break;
            }
        }

        if (change.isEmpty()){
            throw new RuntimeException("В массиве нет 4!");
        }
        return change.toArray(new Integer[0]);
    }

}
