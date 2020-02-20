package Generics;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    //1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
    static <V> void  swap(int firstIndex,int secondIndex, V[] array){
        V temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    //2. Написать метод, который преобразует массив в ArrayList;
    //Arrays.asList(T... a) - исходник и ArrayList взаимозависимы,
    //Collections.addAll(ArrayList strList, T[] strArr) - исходник и ArrayList независимы друг от друга
    static <T> ArrayList<T> arrayAsList(T[] array) {
        if(array == null) return null;
        ArrayList<T> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        Integer[] nums = {5, 8, 9, 12, 3};
        String[] strs = {"first", "second", "third"};
        //Проверка 1 задания.
        swap(1, 4, nums);
        System.out.println(Arrays.toString(nums));
        swap(0,2, strs);
        System.out.println(Arrays.toString(strs));

        //Проверка 2 задания.
        System.out.println(arrayAsList(strs));

        //Проверка 3 задания.
        Apple a = new Apple();
        Orange o = new Orange();
        Box <Fruit> appleBox = new Box<>(a);
        Box <Fruit> orangeBox = new Box<>(o);
        appleBox.put(a);
//        appleBox.put(o);
        for (int i = 0; i < 10; i++) {
            orangeBox.put(o);
        }
        System.out.println(orangeBox.getWeight());
        for (int i = 0; i < 14; i++) {
            appleBox.put(a);
        }
        System.out.println(appleBox.getWeight());
        System.out.println(appleBox.compare(orangeBox));
//        orangeBox.toEmptyBox(appleBox);
        Box<Fruit> newOrBox = new Box<>(o);
        for (int i = 0; i < 7; i++) {
            newOrBox.put(o);
        }
        orangeBox.toEmptyBox(newOrBox);
        System.out.println(orangeBox.getNumberOfFruits());
        System.out.println(newOrBox.getNumberOfFruits());
    }
}
