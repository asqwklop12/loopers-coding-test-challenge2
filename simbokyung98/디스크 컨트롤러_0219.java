import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        //첫번째 판단
        //시작해도 되는 친구 모두 우선순위 큐에 넣기
        //어떻게 넣을꺼야? while?
        //어떻게 우선순위를 정할꺼야?
        //요청시간이 현재 시점인 경우 -> 첫번쨰가 소요시간, 두번쨰가 요청시간, 세번째가 번호
        //어떻게 작업중인지 판단할꺼야?
        //시점을 카운트 하면서 소요시간은 줄어들도록 하기
        // 소요시간이 0인경우가 작업중인 요청이 없는 것

        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));


        //우선순위 기준: 요청시간,소요시간,번호
        PriorityQueue<CustomTime> pq = new PriorityQueue<>(
                Comparator.comparingInt(CustomTime::getRunningTime)
                        .thenComparingInt(CustomTime::getStartTime)
                        .thenComparingInt(CustomTime::getNum));

        int time = 0;
        int index = 0;
        int done = 0;
        long total = 0;

        while(done < jobs.length){

            //대기 큐에 넣을 수 있는 요청들 넣기
            //요청값이 현재 시간과 같을 경우에만 넣기
            while(index < jobs.length && jobs[index][0] <= time){
                pq.offer(new CustomTime(index,jobs[index][0], jobs[index][1]));
                index++;
            }

            //대기 작업이 없으면 다음
            if(pq.isEmpty()){
                time = jobs[index][0];
                continue;
            }

            //대기 큐 하나씩 실행
            CustomTime now = pq.poll();
            time += now.getRunningTime();
            total += (time - now.getStartTime());
            done++;

        }
        return (int) (total / jobs.length);
    }
}

class CustomTime {
    private int num;
    private int startTime;
    private int runningTime;

    public CustomTime(int num, int startTime, int runningTime){
        this.num = num;
        this.startTime = startTime;
        this.runningTime = runningTime;
    }

    int getNum() { return num; }
    int getStartTime() { return startTime; }
    int getRunningTime() { return runningTime; }
}