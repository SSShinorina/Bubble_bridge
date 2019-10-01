package com.company;
class Node {
    public int value;
    public Node prev, next;

    public Node(int value) {
        this.value = value;
    }
}

class StackArray {
    private int[] items;
    private int size = -1;

    public StackArray() {
        this.items = new int[12];
    }

    public StackArray(int cells) {
        this.items = new int[cells];
    }

    public void push(int i) {
        if (!isFull()) {
            items[++size] = i;
        }
    }

    public boolean isEmpty() {
        return size == -1;
    }

    public boolean isFull() {
        return size == items.length - 1;
    }

    public int top() {
        if (isEmpty()) {
            return -1;
        }
        return items[size];
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        return items[size--];
    }
}

class StackList {
    private Node last;
    public void push(int i) {
        if (last == null)
            last = new Node(i);
        else {
            last.next = new Node(i);
            last.next.prev = last;
            last = last.next;
        }
    }
    public boolean isEmpty() {
        return last == null;
    }
    public boolean isFull() {
        return false;
    }
    public int top() {
        if (isEmpty()) {
            return -1;
        }
        return last.value;
    }
    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        int ret = last.value;
        last = last.prev;
        return ret;
    }
}

class StackFIFO extends StackArray {
    private StackArray stackArray = new StackArray();
    public int pop() {
        while (!isEmpty()) {
            stackArray.push(super.pop());
        }
        int ret = stackArray.pop();
        while (!stackArray.isEmpty()) {
            push(stackArray.pop());
        }
        return ret;
    }
}

class StackHanoi extends StackArray {
    private int totalRejected = 0;
    public int reportRejected() {
        return totalRejected;
    }
    public void push(int in) {
        if (!isEmpty() && in > top()) {
            totalRejected++;
        } else {
            super.push(in);
        }
    }
}

public class BubbleSort implements SortingStrategy
{

    public int[] sort( int[] inputArray )
    {
        int n = inputArray.length;
        for( int i = 0; i < n; i++ )
        {
            for( int j = 1; j < (n - i); j++ )
            {
                if( inputArray[j - 1] > inputArray[j] )
                {
                    swap(j - 1, j, inputArray);
                }
            }
        }
        System.out.println("Array is sorted using Bubble Sort Algorithm");
        return inputArray;
    }

    private void swap( int k, int l, int[] inputArray )
    {
        int temp = inputArray[k];
        inputArray[k] = inputArray[l];
        inputArray[l] = temp;
    }
}