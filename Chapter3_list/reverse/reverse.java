public class reverse {

    public static void main(String[] args) {
        node list1 = new node();
        node l1 = list1;
        node test = new node();
        for (int i = 1; i <= 10; i++) {
            list1.next = new node(i, null);
            list1 = list1.next;
        }
        l1 = l1.next;
        node l2 = l1.next;
        node l3 = l2.next;
        l1.next = null;
        while (l3 != null) {
            l2.next = l1;
            l1 = l2;
            l2 = l3;
            l3 = l3.next;
        }
        l2.next = l1;
        test = l2;
        while (test != null) {
            System.out.println(test.value);
            test = test.next;
        }
    }
}

