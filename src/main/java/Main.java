import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 生成 二叉树的后序遍历
 * 题目描述
 * 给定一个二叉树的前序遍历及中序遍历，要求返回该二叉树的后序遍历。
 * 提示：前序遍历可以确定二叉树的根节点，中序遍历可以确定二叉树的结构。
 *
 *
 * Input:
 *
 * ABDECFG DBEAFCG
 * BCAD CBAD
 *
 * Output:
 *
 * DEBFGCA
 * CDAB
 * @author panfuxue
 * @date 2022/02/23 17:08
 */
public class Main {
    public static void main(String[] args) {
        // Scanner input=new Scanner(System.in);
        // String str=input.next();
        System.out.println("hello world");
        // 中序中元素在数组的索引
        String preStr = "ABDECFG";
        String midStr = "DBEAFCG";
        char[] pre = preStr.toCharArray();
        char[] mid = midStr.toCharArray();

        List<Character> post;
        char root = pre[0];
        char rootIndex = 0;


    }

    private char getRightNode(char[] pre, char[] mid, int ps, int pi, char ms, char me) {
        return 'c';
    }
}
