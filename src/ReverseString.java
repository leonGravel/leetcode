/**
 * @author Gravel
 * @date 2018/6/27.
 * 请编写一个函数，其功能是将输入的字符串反转过来。
 * 示例：
 * 输入：s = "hello"
 * 返回："olleh"
 */
public class ReverseString {
    public String reverseString(String s) {
        char[] arr = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for(int i=arr.length-1;i>=0;i--){
            sb.append(arr[i]);
        }
        return sb.toString();
    }
    public static void main(String[] args) throws Exception {
        System.out.println(new ReverseString().reverseString("gravel"));
    }}
