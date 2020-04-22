package Task2;

public class CheckArray {
    public boolean check (int[] array) {
        boolean forOne = false;
        boolean forFour = false;
        boolean checkResult;

        for (int i = 0; i < array.length; i++){
            if (array[i] == 1){
                forOne = true;
            } else if (array[i] == 4){
                forFour = true;
            } else {
                checkResult = false;
                return checkResult;
            }
        }
        checkResult = forOne & forFour;
        return checkResult;
    }
}
