package iohyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * ANA 문자열 조건:
 * 길이 3이상
 * A로 시작해서 A로 끝남
 * 시작과 끝을 제외하고 중간에는 A가 없음
 * N을 정확히 1개 포함
 * : 문자열 S의 부분 문자열 연속 중에서 문자열 조건을 만족하는 개수 구하기.
 *
 * 생각 정리:
 * 중간에는 A가 없어야 함. 예를 들어 1~3번 사이에 A가 있으면 조건 위배
 * 유효한 쌍은 사이에 다른 A가 없는 두 A, 연속된 A쌍만 있다.
 *
 * 예시 :
 * 8
 * A N A C O N D A
 * 0 1 2         7
 * (0, 7) 쌍 -> 중간에 A 있음 -> 위배
 * (0, 2) 쌍 -> 중간에 A 없음 -> 체크
 * (2, 7) 쌓 -> 중간에 A 없음 -> 체크
 *
 */
public class BOJ_32401 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();
        br.close();

        // A의 위치들을 저장할 리스트 생성
        List<Integer> list = new ArrayList<>();

        // S를 한 번 순회하고 A인 인덱스 리스트 추가
        for (int i = 0; i < N; i++) {
            if (S.charAt(i)=='A'){
                list.add(i);
            }
        }
        int res = 0;

        // 연속된 A 쌍을 순회한다.
        for (int k = 0; k < list.size() - 1;  k++) {
            int startPositions = list.get(k);
            int endPositions = list.get(k + 1);

            // 두 A 사이 구간 'N'의 개수 세기
            int count = 0;
            for (int j = startPositions + 1; j < endPositions; j++) {
                if (S.charAt(j) == 'N'){
                    count++;
                }
            }

            // N이 정확히 1개면 카운트 증가
            if (count == 1) {
                res++;
            }

        }
        System.out.print(res);
    }
}
