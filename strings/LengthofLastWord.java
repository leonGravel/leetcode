package strings;

/**
 * @author Gravel
 * @date 2018/9/7.
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * <p>
 * 如果不存在最后一个单词，请返回 0 。
 * <p>
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: "Hello World"
 * 输出: 5
 */
public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        String [] arr = s.split(" ");
        return arr.length==0?0:arr[arr.length-1].length();
    }
    public static void main(String[] args) throws Exception {
        System.out.println(new LengthofLastWord().lengthOfLastWord("LL sdfsd"));
    }
}
