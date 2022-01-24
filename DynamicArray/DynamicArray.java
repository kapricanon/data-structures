package DynamicArray;

import java.util.Iterator;

public class DynamicArray <T> implements Iterable<T> {

    private T[] array;
    private int length = 0;
    private int capacity = 0;

    public DynamicArray() {
        this(16);
    }

    public DynamicArray(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    public int size() {
        return this.length;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T get(int index) {
        return array[index];
    }

    public void set(int index, T element) {
        array[index] = element;
    }

    public void clear() {
        for (int i = 0; i < length; i++) array[i] = null;
        length = 0;
    }

    public void add(T element) {
        if(length + 1 >= capacity) {
            if(capacity == 0) capacity = 1;
            else capacity *= 2; //double the size
            T[] new_array = (T[]) new Object[capacity];
            for(int i = 0; i < length; i++) new_array[i] = array[i];
            array = new_array;
        }

        array[length++] = element;
    }

    public T remoteAt(int index) {

        if(index < 0 || index >= length) throw new IndexOutOfBoundsException();
        T element = array[index];
        T[] new_array = (T[]) new Object[length - 1];
        for(int i = 0, j = 0; i < length; i++, j++) {
            if (i == index) j--;
            else new_array[j] = array[i];
        }
        arr = new_array;
        capacity = --length;
        return element;
    }

    public boolean remote (T element) {
        int index = indexOf(element);
        if(index == -1) return false;
        remoteAt(index);
        return true;
    }

    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new java.utils.Iterator<DynamicArray.T>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < length;
            }

            @Override 
            public T next() {
                return array[index++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
    
}
