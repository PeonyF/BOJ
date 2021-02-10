package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q17088 {
    private static int n;
    static int min = Integer.MAX_VALUE;
    private static int[] nums = new int[100000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");

        for (int i = 0; i < arr.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }

        int gap = nums[0] - nums[1];


        System.out.println("기본 시작");
        backTrack(1, nums[0], gap, 0, "기본1 ");
        System.out.println("기본 끝 더하기 시작");
        backTrack(1, nums[0] + 1, gap + 1, 1, "더하기1 ");
        System.out.println("더하기 끝 빼기 시작");
        backTrack(1, nums[0] - 1, gap - 1, 1, "빼기1 ");
        System.out.println("빼기 끝");

        if (min == Integer.MAX_VALUE) {
            System.out.print(-1);
        } else {
            System.out.print(min);
        }

    }

    private static void backTrack(int currentDepth, int prev, int gap, int cnt, String flag) {
        if (n == currentDepth) {
            min = Math.min(min, cnt);
            return;
        }

        if (currentDepth == 1) {
            System.out.println("1 " + flag + "depth : " + currentDepth + " prev: " + prev + " , num[1] : " + nums[1] + " gap : " + gap + " cnt:" + cnt);
            backTrack(2, nums[1], gap, cnt, "기본2 ");
            System.out.println("2 " + flag + "depth : " + currentDepth + " prev: " + prev + " , num[1] : " + nums[1] + " gap : " + gap + " cnt:" + cnt);

            backTrack(2, nums[1] + 1, gap - 1, cnt + 1, "더하기2 ");
            System.out.println("3 " + flag + "depth : " + currentDepth + " prev: " + prev + " , num[1] : " + nums[1] + " gap : " + gap + " cnt:" + cnt);

            backTrack(2, nums[1] - 1, gap + 1, cnt + 1, "빼기2 ");
            System.out.println("4 " + flag + "depth : " + currentDepth + " prev: " + prev + " , num[1] : " + nums[1] + " gap : " + gap + " cnt:" + cnt);

        } else {
            int val = nums[currentDepth];
            int gapNormal = prev - val;
            int gapAdd = prev - (val + 1);
            int gapSubtract = prev - (val - 1);

            // System.out.println("5-0 : "+ Arrays.toString(nums));
            System.out.println("진입 " + flag + "depth : " + currentDepth + " prev : " + prev + " 현재 nums[currentDepth] :" + val + " gapNormal " + gapNormal + " gapAdd " + gapAdd
                    + " gapSubtract : " + gapSubtract + " gap: " + gap + " cnt:" + cnt);
            if (gap == gapNormal) {
                System.out.println("5 " + flag + "depth : " + currentDepth + " , num[currentDepth] : " + nums[currentDepth] + " gapNormal -  num[currentDepth] : " + prev + " gap : " + gap + " cnt:" + cnt);
                backTrack(currentDepth + 1, val, gapNormal, cnt, "기본3 ");
                System.out.println("6 " + flag + "depth : " + currentDepth + " , num[currentDepth] : " + nums[currentDepth] + " gapNormal -  num[currentDepth] : " + prev + " gap : " + gap + " cnt:" + cnt);

            }

            if (gap == gapAdd) {
                System.out.println("7 " + flag + "depth : " + currentDepth + " , num[currentDepth] : " + nums[currentDepth] + " gapAdd -  num[currentDepth] : " + prev + " gap : " + gap + " cnt:" + cnt);

                backTrack(currentDepth + 1, val + 1, gapAdd, cnt + 1, "더하기3 ");
                System.out.println("8 " + flag + "depth : " + currentDepth + " , num[currentDepth] : " + nums[currentDepth] + " gapAdd -  num[currentDepth] : " + prev + " gap : " + gap + " cnt:" + cnt);

            }

            if (gap == gapSubtract) {
                System.out.println("9 " + flag + "depth : " + currentDepth + " , num[currentDepth] : " + nums[currentDepth] + " gapSubtract -  num[currentDepth] : " + prev + " gap : " + gap + " cnt:" + cnt);

                backTrack(currentDepth + 1, val - 1, gapSubtract, cnt + 1, "빼기3 ");
                System.out.println("10 " + flag + "depth : " + currentDepth + " , num[currentDepth] : " + nums[currentDepth] + " gapSubtract -  num[currentDepth] : " + prev + " gap : " + gap + " cnt:" + cnt);
                // System.out.println("10-1 : "+ Arrays.toString(nums));
            }
        }
    }
}
