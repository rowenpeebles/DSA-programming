// Implementation of Deque in Java

class Deque {
    
    static final int MAX = 100;
    int arr[];
    int front;
    int rear;
    int size;

    public Deque(int size) {
        arr = new int[MAX];
        front = -1;
        rear = 0;
        this.size = size;
    }

    boolean isFull() {
        return ((front == 0 && rear == size - 1) || front == rear + 1);
    }

    boolean isEmpty() {
        return (front == -1);
    }

    void insertFront(int key) {
        if (isFull()) {
            System.out.println("Overflow");
            return;
        }
        if (front == -1) {
            front = 0;
            rear = 0;
        }
        else if (front == 0) {
            front = size - 1;
        }
        else {
            front = front -1;
        }
        arr[front] = key;
    }
    
    void insertRear(int key) {
        if (isFull()) {
            System.out.println("Overflow");
            return;
        }
        if (front == -1) {
            front = 0;
            rear = 0;
        }
        else if (rear == size - 1) {
            rear = 0;
        }
        else {
            rear = rear + 1;
        }
        arr[rear] = key;
    }

    void deleteFront() {
        if (isEmpty()) {
            System.out.println("Queue Underflow\n");
            return;
        }
        if (front == rear) {
            front = -1;
            rear = -1;
        }
        else if (front == size - 1) {
            front = 0;
        }
        else {
            front = front + 1;
        }
    }

    void deleteRear() {
        if (isEmpty()) {
            System.out.println("Underflow");
            return;
        }
        if (front == rear) {
            front = -1;
            rear = -1;
        }
        else if (rear == 0) {
            rear = size - 1;
        }
        else {
            rear = rear -1;
        }
    }

    int getFront() {
        if (isEmpty()) {
            System.out.println("Underflow");
            return -1;
        }
        return arr[front];
    }

    int getRear() {
        if (isEmpty() || rear < 0) {
            System.out.println("Underflow\n");
            return -1;
        }
        return arr[rear];
    }

    public static void main(String[] args) {
        Deque dq = new Deque(4);
        System.out.println("Insert element at rear end: 12");
        dq.insertRear(12);
        System.out.println("Insert element at rear end: 14");
        dq.insertRear(14);
        System.out.println("Get rear element: " + dq.getRear());
        dq.deleteRear();
        System.out.println("After delete rear element new rear becomes: " + dq.getRear());
        System.out.println("Inserting element at front end");
        dq.insertFront(13);
        System.out.println("Get front element: " + dq.getFront());
        dq.deleteFront();
        System.out.println("After delete front element new front becomes: " + dq.getFront());
    }
}
