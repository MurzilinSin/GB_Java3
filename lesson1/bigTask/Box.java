package lesson1.bigTask;

import java.util.ArrayList;

public class Box<E extends Fruit> {
    ArrayList<E> fruits ;

    public Box(){
        this.fruits = new ArrayList<>();
    }

    public float getWeight() {
        float sum = 0;
        for (int i = 0; i < fruits.size(); i++) {
            sum += fruits.get(i).getWeight();
        }
        return sum;
    }

    public boolean compareWeight(Box<?> boxToCompare){
        return Math.abs( this .getWeight() - boxToCompare.getWeight()) < 0.0001 ;
    }

    public void addFruit(E e, int size){
        for (int i = 0; i < size; i++) {
            fruits.add(e);
        }
    }

    public void newBox(Box<E> boxToTransfer){
        for (int i = this.fruits.size()-1; i >= 0 ; i--) {
            boxToTransfer.fruits.add(this.fruits.get(i));
            this.fruits.remove(i);
        }
    }

}
