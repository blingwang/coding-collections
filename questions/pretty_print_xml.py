import xml.etree.ElementTree as ET
root = ET.Element("a")
root.text = 'text1 ' #First Text in the Element a
b = ET.SubElement(root, "b")
b.text = 'text2' #Text in the first b
b.tail = ' text3 ' #Text immediately after the first b but before the second
b = ET.SubElement(root, "b")
b.text = 'text4'
b.tail = ' text5'
print ET.tostring(root)
#This prints <a>text1 <b>text2</b> text3 <b>text4</b> text5</a>
