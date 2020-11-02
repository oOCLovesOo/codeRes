package codeRes.leetCodeProj.intv;

import codeRes.leetCodeProj.util.ListNode;

public class DeleteMiddleNodeLCCI_02_03 {
    public void deleteNode(ListNode node) {
    	if(node==null||node.next==null) {
    		return;
    	}
    	ListNode pre=null;
        ListNode nowNode=node;
        while(true) {
        	if(nowNode.next!=null) {
        		nowNode.val = nowNode.next.val;
        		pre = nowNode;
        		nowNode = nowNode.next;
        	}else {
        		pre.next=null;
        		break;
        	}	
        }
    }
}
