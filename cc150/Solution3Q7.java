import java.util.*;
public class Solution3Q7 {
    private abstract class Animal {
        private int order;
        protected String name;
        public Animal(String n) {
            name = n;
        }

        public void setOrder(int ord) {
            order = ord;
        }

        public int getOrder() {
            return order;
        }

        public boolean isOlderThan(Animal a) {
            return this.order < a.getOrder();
        }
    }

    private class Dog extends Animal {
        public Dog(String n) {
            super(n);
        }
    }

    private class Cat extends Animal {
        public Cat(String n) {
            super(n);
        }
    }

    LinkedList<Dog> dogs = new LinkedList<Dog>();
    LinkedList<Cat> cats = new LinkedList<Cat>();
    private int order = 0; // acts as timestamp

    public void enqueue(Animal a) {
        // order is used as a sort of timestamp, so that we can compare 
        // the insertion order of a dog to a cat
        a.setOrder(order);
        order++;

        // I would prefer overloading enqueue with diff types to using instanceof
        if (a instanceof Dog) {
            dogs.addLast((Dog) a);
        } else if (a instanceof Cat) {
            cats.addLast((Cat) a);
        }
    }

    public Animal dequeueAny() {
        // look at tops of dog and cat queues, and dequeue the oldest one
        if (dogs.size() == 0) {
            return cats.poll(); // pop
        } else if (cats.size() == 0) {
            return dogs.poll();
        }

        Dog dog = dogs.peek();
        Cat cat = cats.peek();

        if (dog.isOlderThan(cat)) {
            return dogs.poll();
        } else {
            return cats.poll();
        }
    }

    public Dog dequeueDogs() {
        return dogs.getFirst();
    }

    public Cat dequeueCats() {
        return cats.getFirst();
    }
}

