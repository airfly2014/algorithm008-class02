package training;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/minimum-genetic-mutation/
 */
public class MinMutation {

    public int minMutation(String start, String end, String[] bank) {


        if(start.equals(end)){
            return 0;
        }

        HashSet<String> bankSet = new HashSet<>();
        HashSet<String> visited = new HashSet<>();
        for(String str:bank){
            bankSet.add(str);
        }

        LinkedList<WrapStep> stack = new LinkedList<>();
        stack.push(new WrapStep(0, start));
        while (!stack.isEmpty()){
            WrapStep step = stack.pop();
            String stepStr = step.stepStr;
            if(stepStr.equals(end)){
                return step.count;
            }

            for(int i = 0; i < stepStr.length(); i++){
                for(char c: new char[]{'A', 'C', 'G', 'T'}){
                    String tempStr = stepStr.substring(0, i) + c + stepStr.substring(i + 1);
                    if(!visited.contains(tempStr) && bankSet.contains(tempStr)){
                        visited.add(tempStr);
                        stack.add(new WrapStep(step.count + 1, tempStr));
                    }
                }
            }
        }

        return -1;
    }


//    public int minMutation(String start, String end, String[] bank) {
//        if(start == end)
//            return 1;
//        Set<String> visited = new HashSet<>();
//        Set<String> bankSet = new HashSet<>();
//        for(String b : bank) {
//            bankSet.add(b);
//        }
//        Queue<GeneHop> queue = new LinkedList<>();
//        visited.add(start);
//        queue.add(new GeneHop(start , 1));
//        while(! queue.isEmpty()) {
//            GeneHop next = queue.poll();
//            if(next.mutation.equals(end)) {
//                return next.count - 1;
//            }
//            for(int i = 0 ; i < 8 ; i++) {
//                for(char c : new char[] {'A', 'C', 'G', 'T'}) {
//                    String temp = next.mutation.substring(0, i) + c + next.mutation.substring(i
// + 1);
//                    if(bankSet.contains(temp) && !visited.contains(temp)) {
//                        visited.add(temp);
//                        queue.add(new GeneHop(temp , next.count + 1));
//                    }
//                }
//            }
//        }
//        return -1;
//    }
//}

    class WrapStep {
        int count;
        String stepStr;

        public WrapStep(int step, String stepStr) {
            this.count = step;
            this.stepStr = stepStr;
        }
    }
}
