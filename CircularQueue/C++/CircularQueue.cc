// Implementation of Circular Queue in C++

#include <iostream>

#define SIZE 5

using namespace std;

class CircularQueue {
    private:
        int items[SIZE], front, rear;
    public:
        CircularQueue() {
            front = -1;
            rear = -1;
        }

    bool isFull() {
        if (front == 0 && rear == SIZE - 1) {
            return true;
        }
        if (front == rear + 1) {
            return true;
        }
        return false;
    }

    bool isEmpty() {
        if (front == -1) {
            return true;
        }
        else {
            return false;
        }
    }

    void enQueue(int element) {
        if (isFull()) {
            cout << "Queue is full\n";
        }
        else {
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % SIZE;
            items[rear] = element;
            cout << endl << "Inserted " << element << endl;
        }
    }

    int deQueue() {
        int element; 
        if (isEmpty()) {
            cout << "Queue is empty" << endl;
            return (-1);
        }
        else {
            element = items[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            }
            else {
                front = (front + 1) % SIZE;
            }
            return (element);
        }
    }

    void display() {
        int i;
        if (isEmpty()) {
            cout << endl << "Empty Queue" << endl;
        }
        else {
            cout << "Front -> " << front;
            cout << endl << "Items -> ";
            for (i = front; i != rear; i = (i + 1) % SIZE) {
                cout << items[i];
            }
            cout << items[i];
            cout << endl << "Rear -> " << rear << endl;
        }
    }
};

int main() {
    CircularQueue q;
    q.deQueue();
    q.enQueue(1);
    q.enQueue(2);
    q.enQueue(3);
    q.enQueue(4);
    q.enQueue(5);
    q.enQueue(6);
    q.display();
    int elem = q.deQueue();
    if (elem != -1) {
        cout << endl << "Deleted Element is " << elem << endl;
    }
    q.display();
    q.enQueue(7);
    q.display();
    q.enQueue(8);
    return 0;
}
