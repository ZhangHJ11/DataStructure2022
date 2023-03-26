public class node {
    public int value;
    public node next;

    public node() {
        value = 0;
        next = null;
    }

    public node(int val, node nextnode) {
        value = val;
        next = nextnode;
    }
}
