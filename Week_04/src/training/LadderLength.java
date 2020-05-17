package training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javafx.util.Pair;

/**
 * https://leetcode-cn.com/problems/word-ladder/description/
 * 127. 单词接龙
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * <p>
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * <p>
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 * <p>
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 */
public class LadderLength {


    public static void main(String[] args) {
        LadderLength ladderLength = new LadderLength();
//        ladderLength.ladderLength("a", "c", Arrays.asList("a", "b", "c"));
        ladderLength.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog"));
    }


//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//
//        if (beginWord.equals(endWord)) {
//            return 1;
//        }
//
//        if (!wordList.contains(endWord)) {
//            return 0;
//        }
//
//        int length = endWord.length();
//        HashMap<String, ArrayList<String>> allData = new HashMap<>();
//        for (String word : wordList) {
//            for(int i = 0; i < length;i++){
//                String generaStr = word.substring(0, i) + "*" + word.substring(i+ 1);
//                ArrayList<String> generaList = allData.getOrDefault(generaStr, new ArrayList<>());
//                generaList.add(word);
//                allData.put(generaStr, generaList);
//            }
//        }
//
//        LinkedList<Pair<String, Integer>> queue = new LinkedList<>();
//        HashSet<String> visited = new HashSet<>();
//
//        queue.push(new Pair<>(beginWord, 1));
//
//        while (!queue.isEmpty()){
//            Pair<String, Integer> pair = queue.pollFirst();
//            String baseStr = pair.getKey();
//            Integer level = pair.getValue();
//
//            for(int i = 0; i < length; i++){
//                String nextStr = baseStr.substring(0, i) + "*" + baseStr.substring(i+ 1);
//                for(String str : allData.getOrDefault(nextStr, new ArrayList<>())){
//                    if(str.equals(endWord)){
//                        return level + 1;
//                    }
//
//                    if(!visited.contains(str)){
//                        visited.add(str);
//                        queue.addLast(new Pair<>(str, level + 1));
//                    }
//                }
//
//            }
//        }
//
//        return 0;
//    }


    HashMap<String, ArrayList<String>> allData = new HashMap<>();
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {


        if (beginWord.equals(endWord)) {
            return 1;
        }

        if (!wordList.contains(endWord)) {
            return 0;
        }


        int length = endWord.length();
        for (String word : wordList) {
            for (int i = 0; i < length; i++) {
                String generaStr = word.substring(0, i) + "*" + word.substring(i + 1);
                ArrayList<String> generaList = allData.getOrDefault(generaStr, new ArrayList<>());
                generaList.add(word);
                allData.put(generaStr, generaList);
            }
        }

        LinkedList<Pair<String, Integer>> begin_Q = new LinkedList<>();
        LinkedList<Pair<String, Integer>> end_Q = new LinkedList<>();
        HashMap<String, Integer> begin_visited = new HashMap<>();
        HashMap<String, Integer> end_visited = new HashMap<>();

        begin_Q.push(new Pair<>(beginWord, 1));
        end_Q.push(new Pair<>(endWord, 1));
        begin_visited.put(beginWord, 1);
        end_visited.put(endWord, 1);


        while (!begin_Q.isEmpty() && !end_Q.isEmpty()){

            int ans =  checkNode(begin_Q, begin_visited, end_visited);
            if(ans > -1){
                return ans;
            }

            ans =  checkNode(end_Q, end_visited, begin_visited);
            if(ans > -1){
                return ans;
            }

        }



        return 0;
    }




//    * beginWord = "hit",
//            * endWord = "cog",
//            * wordList = ["hot","dot","dog","lot","log","cog"]

    private int checkNode(LinkedList<Pair<String, Integer>> queue, HashMap<String,Integer> visited, HashMap<String,Integer> other_visited) {


        Pair<String, Integer> pair = queue.pollFirst();
        String baseStr = pair.getKey();
        Integer level = pair.getValue();

        for(int i = 0; i < baseStr.length(); i++){
            String nextStr = baseStr.substring(0 , i) + "*" + baseStr.substring(i + 1);
            for(String str : allData.getOrDefault(nextStr, new ArrayList<>())){



                if(other_visited.containsKey(str)){
                    return level + other_visited.get(str);
                }

                if(!visited.containsKey(str)){
                    visited.put(str, level + 1);
                    queue.addLast(new Pair<>(str, level  + 1));
                }
            }
        }
        return  -1;
    }

}
