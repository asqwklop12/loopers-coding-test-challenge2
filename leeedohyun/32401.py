N = int(input())
S = input()

count = 0
for i in range(N):
    for j in range(i + 3, N + 1):
        sub = S[i:j]
        if sub[0] == 'A' and sub[-1] == 'A' and sub[1:-1].count('A') == 0 and sub.count('N') == 1:
            count += 1

print(count)
