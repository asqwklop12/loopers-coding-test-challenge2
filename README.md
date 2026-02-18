# loopers-coding-test-challenge2
루퍼스 코테챌린지 시즌2

매일 백준 문제를 풀고 PR로 제출하는 코딩테스트 챌린지입니다.

## 초기 세팅 (최초 1회)

### 1. Fork

이 레포를 본인 GitHub 계정으로 Fork합니다.

<img width="1241" height="143" alt="image" src="https://github.com/user-attachments/assets/ca9eff03-9992-40d0-93e4-67692d1a1001" />
<img width="848" height="504" alt="image" src="https://github.com/user-attachments/assets/abf6c360-4a50-422b-9024-e21ceffc7cff" />


> 우측 상단 **Fork** 버튼 클릭 → **Create fork**

### 2. Clone

```bash
git clone https://github.com/{본인깃헙아이디}/loopers-coding-test-challenge2.git
cd loopers-coding-test-challenge2
```

### 3. Upstream 등록

```bash
git remote add upstream https://github.com/qkrrlgus114/loopers-coding-test-challenge2.git
```

### 4. algo-submissions 브랜치 체크아웃

```bash
git fetch upstream
git checkout -b algo-submissions upstream/algo-submissions
```

여기까지 하면 초기 세팅 완료입니다.

---

## 매일 제출 방법

### 1. algo-submissions 브랜치 최신화

```bash
git checkout algo-submissions
git pull upstream algo-submissions
```

### 2. 날짜별 브랜치 생성

```bash
git checkout -b solution/MMDD
```

> 예시: 2월 17일이면 `git checkout -b solution/0217`

### 3. 풀이 파일 저장
<img width="627" height="232" alt="image" src="https://github.com/user-attachments/assets/24883941-8aaf-46d5-bee0-09e5e80ce1e2" />


**반드시 본인 GitHub 아이디 폴더** 안에 풀이 파일을 저장합니다.

없으면 생성하면 됩니다.
ex) qkrrlgus9797


<img width="663" height="173" alt="image" src="https://github.com/user-attachments/assets/45e76ee7-c6fa-4c69-b380-0ce4cab87cb0" />

```
{본인깃헙아이디}/
  └── 1234.py (또는 .java, .cpp 등 자유)
```

> 폴더명은 본인 GitHub 아이디와 정확히 같아야 합니다.

### 4. 커밋 & 푸시

```bash
git add .
git commit -m "solve: 문제번호"
git push origin solution/MMDD
```

### 5. PR 생성

push 후 GitHub에 접속하면 **Compare & pull request** 버튼이 나타납니다.
<img width="926" height="60" alt="image" src="https://github.com/user-attachments/assets/9bbf1d29-c685-4590-9ad3-081d7da0d982" />


1. **Compare & pull request** 클릭
2. base repository를 `qkrrlgus114/loopers-coding-test-challenge2`, base branch를 `algo-submissions`로 설정
<img width="1006" height="260" alt="image" src="https://github.com/user-attachments/assets/b13b1262-c389-45af-823b-211961b5b47c" />

3. **PR 제목에 백준 문제 URL을 넣어주세요**
(프로그래머스는 집계에는 포함 안됩니다.)
<img width="1254" height="656" alt="image" src="https://github.com/user-attachments/assets/826b5552-c2ce-4f40-96e2-7a200b70ae30" />

```
https://www.acmicpc.net/problem/1234
```

4. **Create pull request** 클릭

> PR은 자동으로 머지됩니다. 별도 리뷰 없이 바로 반영됩니다.

---

## 주의사항

- **PR 제목 = 백준 문제 URL** (랭킹 집계에 사용됩니다)
- 풀이 파일은 반드시 `{본인깃헙아이디}/` 폴더에 저장
- 매일 새로운 `solution/MMDD` 브랜치를 만들어서 제출
- 머지 충돌 시 `algo-submissions`를 다시 pull 받고 새 브랜치에서 재제출

---

## 일일 랭킹

매일 아침 9시(KST)에 전날 제출된 PR을 기반으로 일일 랭킹이 Slack으로 전송됩니다.

| 상 | 기준 |
|----|------|
| 꺼드럭상 | 가장 높은 난이도 문제를 푼 참여자 |
| 쫄보상 | 가장 낮은 난이도 문제를 푼 참여자 |
| 안전운전상 | 정답률이 가장 높은 문제를 푼 참여자 |
| 미친하이리스크도전자상 | 정답률이 가장 낮은 문제를 푼 참여자 |
