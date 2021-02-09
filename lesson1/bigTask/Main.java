package lesson1.bigTask;


public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box();
        Box<Orange> orangeBox = new Box();
        Box<Apple> appleBoxToTransfer = new Box();
        Box<Orange> orangeBoxToTransfer = new Box();

        appleBox.addFruit(new Apple(),15);
        orangeBox.addFruit(new Orange(),10);

        System.out.println(appleBox.getWeight());
        System.out.println(orangeBox.getWeight());
        System.out.println(appleBox.compareWeight(orangeBox));

        appleBox.newBox(appleBoxToTransfer);
        orangeBox.newBox(orangeBoxToTransfer);
        System.out.println(appleBox.getWeight());
        System.out.println(appleBoxToTransfer.getWeight());
    }
}
