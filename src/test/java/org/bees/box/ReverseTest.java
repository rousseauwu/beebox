package org.bees.box;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseTest {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        int[] input = {0, 3, 8, 6, 8, 6, 6, 8, 2, 0, 2, 7};
        int s = maxProfit(input);
        System.out.println(s);
    }

    public void rotate(int[] nums, int k) {

        for (int i = 0; i < nums.length; i++) {
            int nextIndex = (k + i) % nums.length;
            if (nextIndex == i) {
                return;
            }
        }
    }

    public void rotateRecuise(int[] nums,int k,int beReplacedValue,int beReplacedIndex){

    }

    public static int maxProfit(int[] prices) {
        if (prices == null) {
            return 0;
        }

        int profileValue = 0;

        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                profileValue += diff;
            }
        }

        return profileValue;
    }

    public static String longgestPrefix(String[] strs) {
        if (strs.length < 1) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        if (strs[0].equals("")) {
            return "";
        }
        String commonPre = strs[0];
        int i = 1;
        while (i < strs.length) {
            while (strs[i].indexOf(commonPre) != 0) {
                commonPre = commonPre.substring(0, commonPre.length() - 1);
                if (commonPre.equals("")) {
                    return "";
                }
            }
            i++;
        }
        return commonPre.equals("") ? "" : commonPre;
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        List<Integer> retlist = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                retlist.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        int[] ret = new int[retlist.size()];
        for (int k = 0; k < retlist.size(); k++) ret[k] = retlist.get(k);

        return ret;
    }

    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            next.next = head;
            head.next = null;
            head = next;

            newHead = next;
        }

        return newHead;

    }
}
