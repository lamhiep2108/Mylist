public class MyList<E> {
    private int size=0;
    static  final int DEFAULT_CAPACITY = 10;
    private  Object elements[];
    public MyList() {
    elements = new Object[DEFAULT_CAPACITY];
    }
    public MyList(int capacity){
        elements = new Object[capacity];
    }


    private void ensureCapacity() {
        if (size >= elements.length) {
            E[] newData = (E[]) (new Object[size * 2 + 1]);
            System.arraycopy(elements, 0, newData, 0, size);
            elements = newData;
        }
    }
    public void add(int index, E e) {
        ensureCapacity();

        for (int i = size - 1; i >= index; i--)
            elements[i + 1] = elements[i];

        elements[index] = e;

        size++;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException
                    ("index " + index + " out of bounds");
    }

    public E remove(int index) {
        checkIndex(index);

        E e = (E) elements[index];
        for (int j = index; j < size - 1; j++)
            elements[j] = elements[j + 1];
        elements[size - 1] = null;
        size--;
        return e;
    }
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        for (int i = 0; i < size; i++) {
            result.append(elements[i]);
            if (i < size - 1) result.append(", ");
        }

        return result.toString() + "]";
    }

    public MyList<E> clone(){
        int clone_size = this.size;
        MyList new_list = new MyList(clone_size);
        for (int i = 0; i < clone_size; i++) {
            new_list.add(i,this.elements[i]);
        }
        return new_list;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++)
            if (e.equals(elements[i]))
                return true;
        return false;
    }

    public int indexOf(E e) {
        for (int i = 0; i < size; i++)
            if (e.equals(elements[i])) return i;
        return -1;
    }

    public E get(int index) {
        checkIndex(index);
        return (E) elements[index];
    }
    public void clear() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

}
