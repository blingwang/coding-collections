#include <iostream>
using namespace std;
struct Node
{
        int val;
        Node * next;
        Node(int value):val(value), next(0){}
};

void deleteNode(Node*& node){
    if(!node) return;
    if(!node->next){
        delete node;
        node = NULL;
    }else{
        node->val = node->next->val;
        node->next = node->next->next;
        delete node->next;
    }
}
int main()
{
        Node *head = new Node(1);
        head->next = new Node(2);
        Node *p = head->next;
        deleteNode(p);// should pass head->next, p is copy
        cout << (long long)head->next <<endl;
        cout << head->next->val << endl; 
        return 1;
}
