package Tests;

public class ArraysMethods {

    public int[] tailArr(int[] arr){
//        if (arr[arr.length - 1] == 4) throw new RuntimeException("4 is the last element");
        if(arr.length == 0) throw new RuntimeException("array is empty");
        int count = 0;
        int index = arr.length - 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if(arr[i] == 4) {
                index = i;
                break;
            }
            count++;
            if(count == arr.length - 1) throw new RuntimeException("array doesn't contain 4");
        }
        int[] temp = new int[count];
        for (int i = index + 1, j = 0; i < arr.length; i++, j++) {
            temp[j] = arr[i];
        }
        return temp;
    }

    public boolean checkArr(int[] arr){
        boolean isContainedOne = false;
        boolean isContainedFour = false;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 1) isContainedOne = true;
            if(arr[i] == 4) isContainedFour = true;
        }
        return isContainedOne && isContainedFour;
    }

}
