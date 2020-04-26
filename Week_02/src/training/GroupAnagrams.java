package training;

/**
 * https://leetcode-cn.com/problems/group-anagrams/
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 考虑通过hash表，key为排序后字符串，value为原始字符串，
 *  外层变了时间复杂度O(n) n为strs长度
 *  字符串排序时间复杂度O(klogK) k为字符串长度
 *  总时间复杂度为O(nklogk)
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.copyValueOf(chars);
            if (!hashMap.containsKey(key)) {
                hashMap.put(key, new ArrayList<>());
            }

            hashMap.get(key).add(str);
        }

        return new ArrayList<>(hashMap.values());
    }


    /**
     * 改进，使用字母表方式表示排序后点str，就不用排序了。。
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {

        HashMap<String, List<String>> hashMap = new HashMap<>();
        int[] count = new int[26];
        for(String str: strs){
            Arrays.fill(count, 0);
            for(char c : str.toCharArray()){
                count[c - 'a']++;
            }

            StringBuilder builder = new StringBuilder();
            for(int val : count){
                builder.append("#");
                builder.append(val);
            }

            String key = builder.toString();
            if(!hashMap.containsKey(key))
            {
                hashMap.put(key,new ArrayList<>());
            }

            hashMap.get(key).add(str);
        }

        return new ArrayList<>(hashMap.values());
    }
}
