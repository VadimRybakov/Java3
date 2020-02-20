package Generics;

import java.util.ArrayList;
import java.util.List;

public class Box <F extends Fruit>{
    private float weight;
    private List<F> fruits = new ArrayList<>();
    private F fruit;
    private int numberOfFruits;

    public F getFruit() {
        return fruit;
    }

    public int getNumberOfFruits() {
        return numberOfFruits;
    }

    public void setNumberOfFruits(int numberOfFruits) {
        this.numberOfFruits += numberOfFruits;
    }

    public Box(F fruit){
        this.weight = 0;
        this.fruit = fruit;
        this.numberOfFruits = 0;
    }

    public void put(F fr){
        if(fruit.getClass() == fr.getClass()) {
            fruits.add(fr);
            numberOfFruits++;
        }
        else throw new RuntimeException("choose the box with another type");
    }

    public float getWeight(){
        if(fruit.getClass().getName() == "Generics.Apple")
            return numberOfFruits * 1.0f;
        else
            return numberOfFruits * 1.5f;
    }

    public boolean compare(Box <?> box){
        if(this.getWeight() == box.getWeight()) return true;
        else return false;
    }

    public void toEmptyBox(Box <?> box){
        if(this.getFruit().getClass() == box.getFruit().getClass()) {
            box.setNumberOfFruits(numberOfFruits);
            numberOfFruits = 0;
        }
        else throw new RuntimeException("Wrong type of box");
    }
}
