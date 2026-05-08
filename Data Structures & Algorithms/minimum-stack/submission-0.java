class MinStack {

    private class Node{
        int val;
        int min;
        Node next;

        Node(int val, int min, Node next){
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    private Node head;

    public MinStack() {
        
    }
    
    public void push(int val) {

        if(head== null){
            head = new Node(val,val,null);
        } else {
            int minVal = Math.min(val,head.min);
            head = new Node(val,minVal,head);
        }
        
    }
    
    public void pop() {
        head = head.next;
        
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}
