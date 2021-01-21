public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList();
        myList.add(0, 1);
        myList.add(1, 2);
        myList.add(2, 3);
        myList.add(3, 4);
        myList.add(4, 5);
        myList.add(5, 9);
        myList.add(6, 12);
        myList.add(7, 6);

        MyList<Integer> new_list = myList.clone();
        System.out.println(myList.toString());
        System.out.println(new_list);
    }
}
