import java.util.Arrays;

class kakao_2020_blind_WallCheck{
    public static void main(String[] args) {
        System.out.println(new Solution().solution(
                12,
                new int[] {1, 5, 6, 10},
                new int[] {1, 2, 3, 4}
        ));
    }

    /**
     * 최소의 친구를 섭외해야 함
     * 많은거리 갈수 있는 친구부터 배치
     */
    static class Solution {
        public int solution(int n, int[] weak, int[] dist) {
            int answer = 0;
            /**
             * 반시계방향도 커버하는 확장배열 만들기
             */
            int[] weak_append = new int[weak.length*2];
            int i=0;
            while (i<weak.length){
                weak_append[i] = weak[i];
                weak_append[i + weak.length] = weak[i++]+n;
            }

            Arrays.sort(dist, (int o1, int o2)-> o2-o1);// 내림차순


            return answer;
        }
    }
}