#include <map>
#include <cstddef>

struct Node {
    struct Node* ptr1;
    struct Node* ptr2;
};

typedef std::map<Node*, Node*> NodeMap;

Node* copy_recursive(Node* cur, NodeMap& nodeMap) {
    if (cur == NULL) {
        return NULL;
    }

    // if already copied, return copy
    NodeMap::iterator i = nodeMap.find(cur);
    if (i != nodeMap.end()) {
        return i->second;
    }

    // copy current node to new node
    Node* node = new Node;
    nodeMap[cur] = node;
    node->ptr1 = copy_recursive(cur->ptr1, nodeMap);
    node->ptr2 = copy_recursive(cur->ptr2, nodeMap);
    
    return node;
}

Node* copy_structure(Node* root) {
    NodeMap nodeMap;
    return copy_recursive(root, nodeMap);
}

