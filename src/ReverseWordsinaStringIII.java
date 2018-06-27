/**
 * Created by leebr on 2018/6/27.
 *
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * 示例 1:
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc"
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class ReverseWordsinaStringIII {
    public String reverseWords(String s) {
        String [] wordArr = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for(String word : wordArr){
            char[] arr = word.toCharArray();
            for(int i=arr.length-1;i>=0;i--){
                sb.append(arr[i]);
            }
            sb.append(" ");
        }
        return sb.substring(0,sb.length()-1).toString();
    }
    public static void main(String[] args) throws Exception {
        System.out.println(new ReverseWordsinaStringIII().reverseWords("i love yingzi"));
    }
}
