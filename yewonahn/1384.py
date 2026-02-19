import sys
input = sys.stdin.readline

group_num = 1

while True:
    # 마지막 줄에 0 입력하면 종료
    line = input().split()
    if not line:
        break
    n = int(line[0])

    if n == 0:
        break

    names = []
    papers = []

    for i in range(n):
        data = input().split()
        # 첫 번째 이름
        names.append(data[0])
        # 뒤에 메시지
        papers.append(data[1:])

        # 그룹 출력
    if group_num > 1:
        # 그룹 사이 띄움
        print()
    print(f"Group {group_num}")

    is_N = False

    # 종이 주인의 번호 p
    for p in range(n):
        # 종이에 적힌 메시지 순서 q
        for q in range(n-1):
            if papers[p][q] == 'N':
                is_N = True
                N_person_idx = (p-(q+1))%n

                print(f"{names[N_person_idx]} was nasty about {names[p]}")

    if not is_N:
        print("Nobody was nasty")

    group_num += 1