from xml.etree import ElementTree

def indent(elem, level=0):
    i = "\n" + level*"  "
    if len(elem):
        if not elem.text or not elem.text.strip():
            elem.text = i + "  "
        if not elem.tail or not elem.tail.strip():
            elem.tail = i
        for elem in elem:
            indent(elem, level+1)
        if not elem.tail or not elem.tail.strip():
            elem.tail = i
    else:
        if level and (not elem.tail or not elem.tail.strip()):
            elem.tail = i

root = ElementTree.parse('/tmp/xmlfile').getroot()
indent(root)
ElementTree.dump(root)

# element: tag, attributes, text, tail, list of children nodes.
# text: text before list of children nodes
# tail: text immediately after a node

# SAX: Is a stream-based processor. 
# You only have a tiny part in memory at any time and you "sniff" the XML stream as it passes. 
# It uses almost no memory, but you can't do "DOM" stuff, like use xpath or traverse trees.

# DOM: You load the whole thing into memory - it's a massive memory hog. 
# You can blow memory with even medium sized documents. 
# But you can use xpath and traverse the tree etc.
