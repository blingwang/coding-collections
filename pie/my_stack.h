class Stack
{
public:
    Stack(): head(NULL) {}
    ~Stack();
    // TODO need to include a copy constructor and assignment operator
    // because default versions could lead to multiple deletes of the same 
    // data since elements maybe shared between copies of a Stack.
    void push(void *data);
    void *pop();
protected:
    class Element{
    public: 
        Element(Element *n, void *d): next(n), data(d){}
        Element *getNext() const {return next;}
        void *value() const{return data;}
    private:
        Element *next;
        void *data;
    }

    Element *head;
}

Stack::~Stack(){
    while(head){
        Element *next = head->getNext();
        delete head;
        head = next;
    }
}

Stack::push(void *data){
    Element *element = new Element(head, data);
    head = element;
}

Stack::pop(){
    Element *popElement = head;
    void *data;
    
    /* assume StackError exception class is defined elsewhere */
    if(head == NULL)
        throw StackError(E_EMPTY);
    
    data = head->value();
    head = head->getNext();
    delete popElement;
    return data;
}; 
