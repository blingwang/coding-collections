import java.util.*;
class IteratorWrapper<T> { // peekable iterator
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
            throw new NoSuchElementException();
        }
        
        return nextValue;
    }

    public boolean hasNext() {
        return hasNext;
    }

    public T next() {
        if (!hasNext) {
            throw new NoSuchElementException();
        }
    
        T result = nextValue;
        hasNext = it.hasNext();
        
        if (hasNext) {
            nextValue = it.next();
        }

        return result;
    }
}
