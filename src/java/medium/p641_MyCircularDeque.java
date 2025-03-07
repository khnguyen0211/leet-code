package java.medium;

import java.util.ArrayList;
import java.util.List;

public class p641_MyCircularDeque {
    private List<Integer> deque;
    private int k;

    public List<Integer> getDeque() {
        return deque;
    }

    public void setDeque(List<Integer> deque) {
        this.deque = deque;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public p641_MyCircularDeque(int k) {
        this.deque = new ArrayList<>();
        this.k = k;
    }

    public boolean insertFront(int value) {
        if (this.deque.size() < k) {
            this.deque.add(0, value);
            return true;
        }
        return false;
    }

    public boolean insertLast(int value) {
        if (this.deque.size() == k) {
            return false;
        }
        if (this.deque.isEmpty()) {
            this.deque.add(value);
        } else {
            this.deque.add(this.deque.size(), value);
        }
        return true;
    }

    public boolean deleteFront() {
        if (this.deque.isEmpty()) {
            return false;
        }
        this.deque.remove(0);
        return true;
    }

    public boolean deleteLast() {
        if (this.deque.isEmpty()) {
            return false;
        }
        this.deque.remove(this.deque.size() - 1);
        return true;
    }

    public int getFront() {
        if (this.deque.isEmpty()) {
            return -1;
        }
        return this.deque.get(0);
    }

    public int getRear() {
        if (this.deque.isEmpty()) {
            return -1;
        }
        return this.deque.get(this.deque.size() - 1);
    }

    public boolean isEmpty() {
        return this.deque.isEmpty();
    }

    public boolean isFull() {
        return this.deque.size() == this.k;
    }
}
