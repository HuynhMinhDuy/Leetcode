
/*
Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

Implement the MyStack class:

void push(int x) Pushes element x to the top of the stack.
int pop() Removes the element on the top of the stack and returns it.
int top() Returns the element on the top of the stack.
boolean empty() Returns true if the stack is empty, false otherwise.
Notes:

You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.
*/

import java.util.*;

class MyStack {

    private Queue<Integer> q; 
    private int top;  

    public MyStack() {
        q = new LinkedList<>();        
    }
    
    public void push(int x) {
        top = x;
        q.add(x);
    }
    
    public int pop() {

        if(q.isEmpty()) throw new NoSuchElementException();
        if(q.size() == 1) return q.poll();
        Queue<Integer> tmp = new LinkedList<>();
      
        while(q.size() > 1) {
            if(q.size() == 2) {
                top = q.peek();
            }
            tmp.add(q.poll());            
        }

        int ans = q.poll();
        q = tmp;
        return ans;
    }
    
    public int top() {    
        if(q.isEmpty()) throw new NoSuchElementException();    
        return top;
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
