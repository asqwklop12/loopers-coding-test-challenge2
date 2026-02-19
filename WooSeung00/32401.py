import sys
input = sys.stdin.readline

N = int(input())
S = input().strip()

answer = 0
n_count = 0
a_check = False

for char in S:
    if char == 'A':
        if a_check and n_count == 1:
            answer += 1
        a_check = True
        n_count = 0
    elif char == 'N' and a_check:
        n_count += 1

print(answer)