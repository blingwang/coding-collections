class Solution17Q10 {}
class Element {
    private String tag;
    public Attribute[] attributes;
    public Element[] children;
    public String value;

    public String getNameCode() {
        return "";
    }

    public void accept(XmlVisitor visitor) {
        visitor.visit(this);
    }
}

class Attribute {
    private String tag;
    public String value;

    public String getTagCode() {
        return "";
    }

    public void accept(XmlVisitor visitor) {
        visitor.visit(this);
    }
}

class XmlVisitor {
    private StringBuilder result;
    public static final String END = "0";

    public void visit(Element elem) {
        String name = elem.getNameCode();
        visit(name);

        for (Attribute a : elem.attributes) {
            a.accept(this);
        }

        visit(END);

        if (elem.value != null) {
            if (elem.value != "") {
                visit(elem.value);
            }
        } else {
            for (Element e : elem.children) {
                e.accept(this);
            }
        }
        visit(END);
    }

    public void visit(Attribute attr) {
        visit(attr.getTagCode());
        visit(attr.value);
    }

    public void visit(String s) {
        result.append(s);
        result.append(" ");
    }

    public String getResult() {
        return result.toString();
    }
}
        


        
