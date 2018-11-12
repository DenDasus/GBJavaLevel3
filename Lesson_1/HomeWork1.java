package Lesson_1;

import java.util.ArrayList;
import java.util.Arrays;

public class HomeWork1 {
    public static void main(String[] args) {
        Integer[] arr1 = {0, 1, 2, 3, 4};
        swapElements(arr1, 0, 4);
        System.out.println(Arrays.toString(arr1));
        
        ArrayList<Integer> list1 = convertArrToList(arr1);
        
        Box<Orange> box1 = new Box<>();
        Box<Apple> box2 = new Box<>();
        Box<Apple> box3 = new Box<>();
        
        box1.add(new Orange());
        box1.add(new Orange());
        
        box2.add(new Apple());
        box2.add(new Apple());
        box2.add(new Apple());
        
        box3.add(new Apple());
        box3.add(new Apple());
        box3.add(new Apple());
        box3.add(new Apple());
    
        System.out.println(box2.compare(box1));
        System.out.println(box2.compare(box3));
        
        System.out.println(box2.getWeight());
        System.out.println(box3.getWeight());
        box2.transfer(box3);
        System.out.println(box2.getWeight());
        System.out.println(box3.getWeight());
    }
    
    public static void swapElements(Object[] arr, int index1, int index2) {
        if (index1 >= 0 && index2 >= 0 && index1 < arr.length && index2 < arr.length) {
            Object tmp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = tmp;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
    
    public static <T> ArrayList<T> convertArrToList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }
}

class Fruit {
    private float weighth;
    
    public Fruit(float weighth) {
        this.weighth = weighth;
    }
    
    public float getWeighth() {
        return weighth;
    }
}

class Apple extends Fruit {
    private static final float weighth = 1.0f;
    
    public Apple() {
        super(weighth);
    }
}

class Orange extends Fruit {
    private static final float weighth = 1.5f;
    
    public Orange() {
        super(weighth);
    }
}

class Box<T extends Fruit> {
    private ArrayList<T> fruits = new ArrayList<>();
    
    public void add(T fruit) {
        fruits.add(fruit);
    }
    
    public void add(T[] fruitArr) {
        fruits.addAll(Arrays.asList(fruitArr));
    }
    
    public void add(ArrayList<T> fruitList) {
        fruits.addAll(fruitList);
    }
    
    public float getWeight() {
        if (fruits.size() > 0) {
            return fruits.size() * fruits.get(0).getWeighth();
        }
        return 0;
    }
    
    public boolean compare(Box anotherBox) {
        return Math.abs(getWeight() - anotherBox.getWeight()) < 0.000001;
    }
    
    public void transfer(Box<T> anotherBox) {
        anotherBox.add(fruits);
        fruits.clear();
    }
}