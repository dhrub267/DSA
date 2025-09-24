import java.util.*;

class SpecialQueue {

    private Deque<Integer> mainQ; 
    private Deque<Integer> minQ;  
    private Deque<Integer> maxQ;  

    public SpecialQueue() {
        mainQ = new ArrayDeque<>();
        minQ = new ArrayDeque<>();
        maxQ = new ArrayDeque<>();
    }

    public void enqueue(int x) {
        // main queue
        mainQ.add(x);

        // maintain minQ
        while (!minQ.isEmpty() && minQ.peekLast() > x) {
            minQ.pollLast();
        }
        minQ.add(x);

        // maintain maxQ
        while (!maxQ.isEmpty() && maxQ.peekLast() < x) {
            maxQ.pollLast();
        }
        maxQ.add(x);
    }

    public void dequeue() {
        if (mainQ.isEmpty()) return;

        int front = mainQ.poll();
        if (front == minQ.peek()) {
            minQ.poll();
        }
        if (front == maxQ.peek()) {
            maxQ.poll();
        }
    }

    public int getFront() {
        return mainQ.peek();
    }

    public int getMin() {
        return minQ.peek();
    }

    public int getMax() {
        return maxQ.peek();
    }
}
