package test;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.jws.Oneway;


public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public int height;

    public TreeNode(int val) {
        this.val = val;
        this.height = 1; // 新节点的高度初始化为1
    }

    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.writeValueAsString(this);

        } catch (Exception e) {
            return super.toString();

        }

    }
}

