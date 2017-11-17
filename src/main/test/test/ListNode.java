package test;

@CacheAble(name = "nihao", id = 3, gid = Long.class)
public class ListNode {
    public ListNode next;
    public int val;
    public ListNode(int val){
        this.val = val;
    }
}
