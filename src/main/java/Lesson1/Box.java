package Lesson1;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> box = new ArrayList<T>();

    public Box() {
    }

    public float getWeight() {
        float boxWeight = 0.0f;
        for (T o : box) {
            boxWeight += o.getWeight();
        }
        return boxWeight;
    }

    public boolean compare(Box anotherBox) {
        return getWeight() == anotherBox.getWeight();
    }


    public void addFruit(T fruit, int amount) {
        for (int i = 0; i < amount; i++) {
            box.add(fruit);
        }
    }
    public void changeBox(Box<T> anotherBox){
        anotherBox.box.addAll(box);
        box.clear();
        System.out.println("Фрукты пересыпаны в новую коробку.");
    }
}
