template<class T>
class IteratorWrapper {
public:
    IteratorWrapper(T& container)
        :d_container(container), d_iter(container.begin()) {
    }

    bool hasNext() {
        return d_iter != d_container.end();
    }

    T& next() {
        T v = *d_iter;
        ++d_iter;
        return v;
    }

private:
    T& d_container;
    typename T::iterator d_iter;
};
