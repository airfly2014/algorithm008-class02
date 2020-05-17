package training;

import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/walking-robot-simulation/
 * 874. 模拟行走机器人
 * 机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
 * <p>
 * -2：向左转 90 度
 * -1：向右转 90 度
 * 1 <= x <= 9：向前移动 x 个单位长度
 * 在网格上有一些格子被视为障碍物。
 * <p>
 * 第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
 * <p>
 * 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
 * <p>
 * 返回从原点到机器人的最大欧式距离的平方。
 */
public class RobotSim {

    public int robotSim(int[] commands, int[][] obstacles) {

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        HashSet<String> hashSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            hashSet.add(obstacle[0] + " " + obstacle[1]);
        }

        int x = 0;
        int y = 0;
        int direction = 0;
        int max_distance = 0;

        for (int command : commands) {

            if (command == -1) {
                direction = (direction + 1) % 4;
            } else if (command == -2) {
                direction = (direction + 3) % 4;
            } else {
                for (int i = 0; i < command; i++) {

                    int nextX = x + directions[direction][0];
                    int nextY = y + directions[direction][1];
                    String pointStr = (nextX + " " + nextY);
                    if (hashSet.contains(pointStr)) {
                        continue;
                    }
                    x = nextX;
                    y = nextY;
                }
                max_distance = Math.max(max_distance, x * x + y * y);
            }
        }

        return max_distance;
    }


}
