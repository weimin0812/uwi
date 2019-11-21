package swordoffer.question25;

import swordoffer.common.RandomListNode;

import java.util.HashMap;

public class Solution {
    // 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
    // 返回结果为复制后复杂链表的head。
    //（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
    public RandomListNode Clone(RandomListNode pHead) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode current = pHead;
        while (current != null) {
            map.put(current, new RandomListNode(current.label));
            current = current.next;
        }
        current = pHead;
        while (current != null) {
            map.get(current).next = map.get(current.next);
            map.get(current).random = map.get(current.random);
            current = current.next;
        }

        return map.get(pHead);
    }

}
