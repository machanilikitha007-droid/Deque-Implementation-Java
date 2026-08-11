import java.util.Scanner;

public class Deque {

    static int[] deque;
    static int front = -1;
    static int rear = -1;
    static int size;

    static void insertFront(int value) {
        if ((front == 0 && rear == size - 1) || front == rear + 1) {
            System.out.println("Deque is full.");
            return;
        }

        if (front == -1) {
            front = rear = 0;
        } else if (front == 0) {
            front = size - 1;
        } else {
            front--;
        }

        deque[front] = value;
        System.out.println("Element inserted at front.");
    }

    static void insertRear(int value) {
        if ((front == 0 && rear == size - 1) || front == rear + 1) {
            System.out.println("Deque is full.");
            return;
        }

        if (rear == -1) {
            front = rear = 0;
        } else if (rear == size - 1) {
            rear = 0;
        } else {
            rear++;
        }

        deque[rear] = value;
        System.out.println("Element inserted at rear.");
    }

    static void deleteFront() {
        if (front == -1) {
            System.out.println("Deque is empty.");
            return;
        }

        System.out.println("Deleted element: " + deque[front]);

        if (front == rear) {
            front = rear = -1;
        } else if (front == size - 1) {
            front = 0;
        } else {
            front++;
        }
    }

    static void deleteRear() {
        if (rear == -1) {
            System.out.println("Deque is empty.");
            return;
        }

        System.out.println("Deleted element: " + deque[rear]);

        if (front == rear) {
            front = rear = -1;
        } else if (rear == 0) {
            rear = size - 1;
        } else {
            rear--;
        }
    }

    static void display() {
        if (front == -1) {
            System.out.println("Deque is empty.");
            return;
        }

        System.out.println("Deque elements:");

        int i = front;

        while (true) {
            System.out.print(deque[i] + " ");

            if (i == rear) {
                break;
            }

            i = (i + 1) % size;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter deque size: ");
        size = sc.nextInt();

        deque = new int[size];

        while (true) {
            System.out.println("\n===== DEQUE =====");
            System.out.println("1. Insert Front");
            System.out.println("2. Insert Rear");
            System.out.println("3. Delete Front");
            System.out.println("4. Delete Rear");
            System.out.println("5. Display");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element: ");
                    insertFront(sc.nextInt());
                    break;

                case 2:
                    System.out.print("Enter element: ");
                    insertRear(sc.nextInt());
                    break;

                case 3:
                    deleteFront();
                    break;

                case 4:
                    deleteRear();
                    break;

                case 5:
                    display();
                    break;

                case 6:
                    System.out.println("Program ended.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
