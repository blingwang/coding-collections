//implement stack using a single queue
//revQ(queue *q) function reverses contents of a queue recursively.

void revQ(queue *q) {
    int t = dequeue(q);
    if(!isEmpty(q)) revQ(q);
    enqueue(q, t);
}
 
void push(queue *s, int x) {
    enqueue(s, x);
}
 
int pop(queue *s) {
    int t;
    revQ(s);
    t = dequeue(s);
    revQ(s);    
    return t;
}
