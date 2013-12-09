import java.util.*;
public class Solution3Q7 {
    Queue<Dog> dogs = new ArrayDeque<Dog>();
    Queue<Cat> cats = new ArrayDeque<Cat>();
    private int order = 0; // acts as timestamp

    public void enqueue(Dog dog) {// polymorphism by overloading
        dog.setOrder(order++);
        dogs.offer(dog);
    }
    
    public void enqueue(Cat cat) {
        cat.setOrder(order++);
        cats.offer(cat);
    }

    public Animal dequeueAny() {
        if (dogs.isEmpty()) {
            return cats.poll();
        } else if (cats.isEmpty()) {
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
        return dogs.poll();
    }

    public Cat dequeueCats() {
        return cats.poll();
    }
    
    public static void main(String[] args) {
        
    }
    
    private abstract class Animal {
        private int order;
        protected String name;
        
        public Animal(String name) {
            this.name = name;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public int getOrder() {
            return order;
        }

        public boolean isOlderThan(Animal a) {
            return this.order < a.getOrder();
        }
    }

    private class Dog extends Animal {
        public Dog(String name) {
            super(name);
        }
    }

    private class Cat extends Animal {
        public Cat(String name) {
            super(name);
        }
    }
}
