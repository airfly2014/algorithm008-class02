package training;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 * <p>
 * 297. 二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 示例:
 */
public class CodecTreeNode {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public String serialize(TreeNode root) {

        StringBuilder builder = new StringBuilder();
        serialize(root, builder);
        return builder.toString();

    }

    private void serialize(TreeNode root, StringBuilder str) {
        if(root == null){
            str.append("null,");
            return;
        }

        str.append(root.val + ",");
        serialize(root.left, str);
        serialize(root.right,str);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] split = data.split(",");
        LinkedList<String> data_list = new LinkedList<>(Arrays.asList(split));
        return decode(data_list);
    }

    private TreeNode decode(LinkedList<String> data_list) {
        if(data_list.get(0).equals("null")){
            data_list.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(data_list.remove(0)));
        root.left = decode(data_list);
        root.right = decode(data_list);
        return root;
    }
}
