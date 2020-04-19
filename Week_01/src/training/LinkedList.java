package training;

class LinkedList {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    /**
     * https://leetcode-cn.com/problems/reverse-linked-list/
     * 206. 反转链表
     * 反转一个单链表。
     * <p>
     * 示例:
     * <p>
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * 进阶:
     * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     */

    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }


    /**
     * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
     * 24. 两两交换链表中的节点
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * <p>
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * <p>
     *  
     * <p>
     * 示例:
     * <p>
     * 给定 1->2->3->4, 你应该返回 2->1->4->3.
     */

    /*public ListNode swapPairs(ListNode head) {

        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode temp = pre;
        ListNode first;
        ListNode second;

        while (head != null && head.next != null){

            first = head;
            second = head.next;

            first.next = second.next;
            second.next = first;

            temp.next = second;
            temp = first;
            head = first.next;

        }

        return pre.next;
    }*/
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }


        ListNode next = head.next;
        head.next = swapPairs(head.next.next);
        next.next = head;
        return next;
    }

    /**
     * https://leetcode-cn.com/problems/linked-list-cycle/
     * <p>
     * 141. 环形链表
     * 给定一个链表，判断链表中是否有环。
     * <p>
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
     */

    public boolean hasCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    /**
     * https://leetcode-cn.com/problems/linked-list-cycle-ii/
     * 142. 环形链表 II
     * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     * <p>
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
     * <p>
     * 说明：不允许修改给定的链表。
     */
    public ListNode detectCycle(ListNode head) {

        ListNode meetNode = getMeetNode(head);
        if (meetNode == null) {
            return null;
        }

        ListNode start = head;
        while (start != meetNode) {
            start = start.next;
            meetNode = meetNode.next;
        }

        return start;

    }

    public ListNode getMeetNode(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return fast;
            }
        }

        return null;
    }

    /**
     * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/?utm_source=LCUS&utm_medium
     * =ip_redirect_q_uns&utm_campaign=transfer2china
     * 25. K 个一组翻转链表
     * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
     * <p>
     * k 是一个正整数，它的值小于或等于链表的长度。
     * <p>
     * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     * <p>
     *  
     * <p>
     * 示例：
     * <p>
     * 给你这个链表：1->2->3->4->5
     * <p>
     * 当 k = 2 时，应当返回: 2->1->4->3->5
     * <p>
     * 当 k = 3 时，应当返回: 3->2->1->4->5
     */

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null){
            for(int i = 0; i < k && end != null; i++){
                end = end.next;
            }

            if(end == null){
                break;
            }


            ListNode start = pre.next;
            ListNode next = end.next;

            end.next = null;

            pre.next = reverseList2(start);
            start.next = next;

            pre = start;
            end = start;

        }

        return dummy.next;

    }

    private ListNode reverseList2(ListNode currentNode) {

        ListNode pre = null;
        while (currentNode != null){
            ListNode next = currentNode.next;
            currentNode.next = pre;
            pre = currentNode;
            currentNode = next;
        }

        return pre;
    }


}
