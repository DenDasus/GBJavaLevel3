package Lesson_6;

public class HomeWork6 {
  public int[] arrayFinder(int[] arr) {
    if(arr == null) {
      throw new NullPointerException();
    }
    if(arr.length == 0) {
      throw new RuntimeException("Исходный массив пуст");
    }
    int[] newArray;

    int lastIndex = -1;

    for (int i = 0; i < arr.length; i++) {
      if(arr[i] == 4) {
        lastIndex = i;
      }
    }

    if(lastIndex == -1) {
      throw new RuntimeException("В исходном массиве отсутвует цифра 4");
    } else {
      int newLen = arr.length - lastIndex - 1;
      newArray = new int[newLen];
      System.arraycopy(arr, lastIndex + 1, newArray, 0, newLen);
    }

    return newArray;
  }

  public boolean arrayChecker(int[] arr) {
    boolean oneExist = false;
    boolean fourExist = false;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == 1) oneExist = true;
      if (arr[i] == 4) fourExist = true;

      if(oneExist && fourExist) break;
    }

    return oneExist && fourExist;
  }
}
