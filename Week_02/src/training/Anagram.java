package training;

import java.util.HashMap;

/**
 * * 242. 有效的字母异位词
 * * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * *
 * * 示例 1:
 * *
 * * 输入: s = "anagram", t = "nagaram"
 * * 输出: true
 *
 * 说明:
 * 你可以假设字符串只包含小写字母。
 */
public class Anagram {


    /**
     * 解法一，使用hashmap保存，key为字母，value为出现次数，
     * 第一个循环，不断想hashmap中添加，
     * 第二个循环不断减少，
     * 缺点，需要判断value为null，以便更新出现次数
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char sc = s.charAt(i);
            if (hashMap.containsKey(sc)) {
                hashMap.put(sc, hashMap.get(sc) + 1);
            } else {
                hashMap.put(sc, 1);
            }
        }


        for (int i = 0; i < s.length(); i++) {

            char tc = t.charAt(i);
            Integer count = hashMap.get(tc);
            if (count == null) {
                return false;
            } else if (count == 1) {
                hashMap.remove(tc);
            } else {
                hashMap.put(tc, count - 1);
            }
        }

        return hashMap.size() == 0;
    }


    /**
     * 改进，由于只有26个字母，所以可以用一个长度为26点数组来表示，出现次数
     * 类似字典一样，表示每个字符出现次数
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {


        if (s.length() != t.length()) {
            return false;
        }

        int[] tables = new int[26];

        for (int i = 0; i < s.length(); i++) {
            tables[s.charAt(i) - 'a']++;
        }


        for (int i = 0; i < t.length(); i++) {
            tables[t.charAt(i) - 'a']--;
            if (tables[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }


}
