package Lesson_6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestArrayFinder { ;
  HomeWork6 hw;

  @Before
  public void init() {
    hw = new HomeWork6();
  }

  @Test
  public void test1() {
    //Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
     int[] testArr = {1, 2, 4, 4, 2, 3, 4, 1, 7};
     int[] retArr = {1, 7};
     Assert.assertArrayEquals(retArr, hw.arrayFinder(testArr));
  }

  @Test
  public void test2() {
    //Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
    int[] testArr = {1, 2, 4, 4, 2, 3, 3, 1, 7};
    int[] retArr = {2, 3, 3, 1, 7};
    Assert.assertArrayEquals(retArr, hw.arrayFinder(testArr));
  }

  @Test
  public void test3() {
    //Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
    int[] testArr = {4, 2, 9, 0, 2, 3, 3, 1, 7};
    int[] retArr = {2, 9, 0, 2, 3, 3, 1, 7};
    Assert.assertArrayEquals(retArr, hw.arrayFinder(testArr));
  }

  @Test
  public void test4() {
    //Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
    int[] testArr = {1, 2, 4, 4, 2, 3, 3, 1, 4};
    int[] retArr = {};
    Assert.assertArrayEquals(retArr, hw.arrayFinder(testArr));
  }

  @Test(expected = RuntimeException.class)
  public void test5() {
    int[] testArr = {1, 2, 5, 8, 2, 3, 3, 1, 7};
    hw.arrayFinder(testArr);
  }

  @Test(expected = RuntimeException.class)
  public void test6() {
    int[] testArr = new int[0];
    hw.arrayFinder(testArr);
  }

  @Test(expected = NullPointerException.class)
  public void test7() {
    int[] testArr = null;
    hw.arrayFinder(testArr);
  }
}
