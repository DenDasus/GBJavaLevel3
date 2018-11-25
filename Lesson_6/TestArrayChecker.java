package Lesson_6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestArrayChecker {
  HomeWork6 hw;

  @Before
  public void init() {
    hw = new HomeWork6();
  }

  @Test
  public  void test1 () {
    int[] testArr = {};
    Assert.assertFalse(hw.arrayChecker(testArr));
  }

  @Test
  public  void test2 () {
    int[] testArr = {1, 1, 1, 4, 1};
    Assert.assertTrue(hw.arrayChecker(testArr));
  }

  @Test
  public  void test3 () {
    int[] testArr = {1, 1, 1};
    Assert.assertFalse(hw.arrayChecker(testArr));
  }

  @Test
  public  void test4 () {
    int[] testArr = {4, 4, 4, 4};
    Assert.assertFalse(hw.arrayChecker(testArr));
  }
}
