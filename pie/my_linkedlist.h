template <class T>
class ListElement{
    public: 
        ListElement(const T &value): next(NULL), data(value){}
        ~ListElement(){}

        ListElement *getNext() const {return next;}
        const T& value() const {return data;}
        void setNext(ListElement *elem){ next = elem;}
        void setValue(const T &value) {data = value;}

    private:
        ListElement *next;
        T data;
};

// c version
typedef struct ListElement{
    struct ListElement * next;
};
typedef struct IntElement{
    struct IntElement *next;
    int data;
};

bool insertInFront(IntElement **head, int data){
    IntElement *newElem= malloc(sizeof(IntElement));
    if(!newElem) return false;

    newElem->data = data;
    newElem->next = *head;
    *head = newElem;
    return true;
}

// insert element while maintaining head and tail pointers as globals
bool insertAfter(IntElement *elem, int data){
    IntElement *newElem = malloc(sizeof(IntElement));
    if(!newElem)
        return false;
    newElem->data = data;

    // insert at the beginning
    if(!elem){
        newElem->next = head;
        head = newElem;
        if(newElem->getNext() == NULL)
            tail = newElem;
        return true;
    }

    IntElement *curPos = head;
    while(curPos){
        if(curPos == elem){
            newElem->next = curPos->getNext();
            curPos->next = newElem;
            if(newElem->getNext() == NULL)
                tail = newElem;
            return true;
        }

        curPos = curPos.getNext();
    }
    
    // insert position not found
    free(newElem);
    return false;
}

IntElement *find(*head, int data){
    IntElement *elem = head;

    while(elem != NULL && elem->value != data)
        elem = elem->next;

    return elem;
}

bool deleteElement(IntElement **head, IntElement *deleteMe){
    IntElement *elem;

    // check for null pointers
    if(!head || !*head || !deleteMe)
            return false;
    elem = *head;
    if(deleteMe == *head){ // special case for head
        *head = elem->next;
        free(deleteMe);
        return true;
    }

    while(elem){
        if(elem->next == deleteMe){
            elem->next = deleteMe->next;
            free(deleteMe);
            return true;
        }
        elem = elem->next;
    }

    // deleteMe not found
    return false;
}

// delete element while maintaining head and tail pointers as globals
bool deleteElement(ListElement *elem){
    ListElement *curPos = head;

    if(!elem)
        return false;

    if(elem == head){
        head = elem->next();
        free(elem);

        if(!head)// 1 element list
            tail = NULL;
        return true;
    }

    while(curPos){
        if(curPos->next() == elem){
            curPos->next() = elem->next();
            free(elem);
            if(curPos->next() == NULL)
                tail = curPos;
            return true;
        }
        curPos = curPos->next();
    }
    return false;
}

void deleteList(IntElement **head){
    IntElement *deleteMe = *head;

    while(deleteMe){
        IntElement *next = deleteMe->next();
        free(deleteMe);
        deleteMe = next;
    }

    *head = NULL;
}

void removeHead(ListElement **head){
    ListElement *temp;

    if(head && *head){
        temp = (*head)->next();
        free(*head);
        *head = temp;
    }
}

ListElement *findMToLastElement( ListElement *head, int m){
    ListElement *current, *mBehind;

    if(!head)
        return NULL;

    // advance current from 0 to m
    current = head;
    for(int i=0; i < m; i++){
        if(current->next == NULL)// already last element
            return NULL;
        else 
            current = current->next;
    }

    // advance both pointer until current reaches the tail
    mBehind = head;
    while(current->next){// until current reaches tail
        currrent = current->next;
        mBehind = mBehind->next;
    }

    return mBehind;
}
        
typedef struct Node {
    struct *Node *next;
    struct *Node *prev;
    struct *Node *child;
    int value;
}

void flattenList(Node *head, Node **tail){
    Node *curNode = head;
    while(curNode){
        if(curNode->child)
            append(curNode->child, tail);
        curNode = curNode->next;
    }
}

void append(Node *child, Node **tail){
    (*tail)->next = child;
    child->prev = tail;

    // find new tail
    Node *curNode = child;
    while(curNode->next != NULL)
        curNode = curNode->next;

    // update tail
    *tail = curNode;
}

void unflattenList(Node *head, Node *tail){
    Node *curNode = head;

    exploreAndSeparate(head);

    // find tail
    while(curNode->next)
        curNode = curNode->next;

    //update tail
    *tail = curNode;
}

void exploreAndSeparate(Node *childListStart){
    Node *curNode = childListStart;

    while(curNode){
        if(curNode->child){
            curNode->child->pre->next = NULL;
            curNode->child->pre = NULL;
            exploreAndSeparate(curNode->child);
        }

        curNode = curNode->next;
    }
}

bool isCyleList(ListNode *head){
   ListNode *fast, *slow;

    show = head;
    fast = head->next;
    while(true){
        if(!fast || !fast->next)
            return false;
        if(fast == slow || fast->next == slow)
            return true;
        slow = slow->next;
        fast = fast->next->next;
    }
}
