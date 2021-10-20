/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int currSum;
    int maxSum;
    public int maxPathSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        maxSum = Integer.MIN_VALUE;
        helper(root);
        
        return maxSum;
    }
    
    private int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        maxSum = Math.max(maxSum, left + right + root.val);
        return Math.max(Math.max(left,right) + root.val, 0);
        
        
    }
}

class Bank {
    HashMap<Integer, Long> map;
    public Bank(long[] balance) {
        int i = 1;
        map = new HashMap<>();
        for(long b : balance) {
            map.put(i++, b);
        }
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(!map.containsKey(account1) || !map.containsKey(account2)) {
            return false;
        }
        long current = map.get(account1);
        
        if(current < money) {
            return false;
        }
        map.put(account1, current - money);
        map.put(account2, map.get(account2) + money);
        return true;
    }
    
    public boolean deposit(int account, long money) {
        if(!map.containsKey(account)) {
            return false;
        }
        map.put(account, map.get(account) + money);
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if(!map.containsKey(account) || map.get(account) < money) {
            return false;
        } else {
            map.put(account, map.get(account) - money);
            return true;
        }
        
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */