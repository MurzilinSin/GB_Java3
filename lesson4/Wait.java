package lesson4;

public class Wait {
    private volatile char current = 'A';
    public static void main(String[] args) {
        Wait wait = new Wait();
        new Thread(() ->{
                wait.printLetter('A','B');
        }).start();
        new Thread(() ->{
                wait.printLetter('B','C');
        }).start();
        new Thread(() ->{
                wait.printLetter('C','A');
        }).start();
    }

    public synchronized void printLetter(char firstLetter, char secondLetter) {
        try {
            for (int i = 0; i < 5; i++) {
                while (current != firstLetter) {
                    wait();
                }
                System.out.print(firstLetter + " ");
                current = secondLetter;
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
