import java.util.*;
class IteratorWrapper<T> {
    private Iterator<T> it;
    private T nextValue;
    private boolean hasNext;

    public IteratorWrapper(Iterator<T> it) {
        this.it = it;
        hasNext = it.hasNext();
        if (hasNext) {
            nextValue = it.next();
        }
    }

    public T peek() {
        if (!hasNext) {
            throw new RuntimeException();
        }
        return nextValue;
    }

    public boolean hasNext() {
        return hasNext;
    }

    public T next() {
        if (!hasNext) {
            throw new RuntimeException();
        }
    
        T result = nextValue;
        hasNext = it.hasNext();
        if (hasNext) {
            nextValue = it.next();
        }

        return result;
    }
}
