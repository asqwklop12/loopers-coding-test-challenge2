##Brute Force
import sys
input = sys.stdin.readline

N=int(input())
S=input()
count=0
for i in range(N):
    if S[i] != 'A':
        continue

    for j in range(i + 2, N):
        if S[j] == 'A':
            substring = S[i : j + 1]

            if substring.count('A') == 2 and substring.count('N') == 1:
                count += 1

            break

print(count)
