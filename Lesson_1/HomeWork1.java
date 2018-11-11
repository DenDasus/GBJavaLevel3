package Lesson_1;

import java.util.ArrayList;
import java.util.Arrays;

public class HomeWork1 {
  public static void main(String[] args) {
    Integer[] arr1 = {0, 1, 2, 3, 4};
    swapElements(arr1, 0, 4);
    System.out.println(Arrays.toString(arr1));

    ArrayList<Integer> list1 = convertArrToList(arr1);
  }

  public static void swapElements(Object[] arr, int index1, int index2) {
    if(index1 >= 0 && index2 >= 0 && index1 < arr.length && index2 < arr.length) {
      Object tmp = arr[index1];
      arr[index1] = arr[index2];
      arr[index2] = tmp;
    }
  }

  public static <T> ArrayList<T> convertArrToList(T[] array) {
    return new ArrayList<>(Arrays.asList(array));
  }
}
