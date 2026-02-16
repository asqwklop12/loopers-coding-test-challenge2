# loopers-coding-test-challenge2
루퍼스 코테챌린지 시즌2

매일 백준 문제를 풀고 PR로 제출하는 코딩테스트 챌린지입니다.

## 초기 세팅 (최초 1회)

### 1. Fork

이 레포를 본인 GitHub 계정으로 Fork합니다.

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

예시: `git checkout -b solution/0217`

### 3. 풀이 파일 저장

**반드시 본인 GitHub 아이디 폴더** 안에 풀이 파일을 저장합니다. (충돌 방지)

```
{본인깃헙아이디}/
  └── 문제번호.py (또는 .java, .cpp 등)
```

### 4. 커밋 & 푸시

```bash
git add .
git commit -m "https://www.acmicpc.net/problem/문제번호"
git push origin solution/MMDD
```

### 5. PR 생성

GitHub에서 Pull Request를 생성합니다:

- **base repository:** `qkrrlgus114/loopers-coding-test-challenge2`
- **base branch:** `algo-submissions`
- **head branch:** `solution/MMDD` (본인 fork)
- **PR 제목:** 백준 문제 URL 포함 필수 (예: `https://www.acmicpc.net/problem/1234`)

PR은 **자동으로 머지**됩니다.

## 주의사항

- PR 제목에 반드시 백준 문제 URL을 포함해주세요 (랭킹 집계용)
- 풀이 파일은 반드시 `{본인깃헙아이디}/` 폴더에 저장해주세요
- 매일 새로운 `solution/MMDD` 브랜치를 만들어 제출합니다
- 머지 충돌 시 `algo-submissions`를 다시 pull 받고 새 브랜치에서 재제출해주세요

## 일일 랭킹

매일 새벽 1시(KST)에 전날 제출된 PR을 기반으로 일일 랭킹이 Slack으로 전송됩니다.

- 최고 티어상 - 가장 높은 난이도 문제를 푼 참여자
- 최저 티어상 - 가장 낮은 난이도 문제를 푼 참여자
- 고정답률상 - 정답률이 가장 높은 문제를 푼 참여자
- 저정답률상 - 정답률이 가장 낮은 문제를 푼 참여자
