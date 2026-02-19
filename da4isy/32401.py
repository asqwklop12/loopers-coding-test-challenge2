# 유사 ANA 문자열(A 쌍 사이에 N이 1개인 조건) 개수 카운트
n = int(input())
s = input()

count = 0
for start in range(n):
    if s[start] != 'A':
        continue
    
    for end in range(start + 2, n):
        if s[end] != 'A':
            continue
        
        middle = s[start+1:end]
        if 'A' not in middle and middle.count('N') == 1:
            count += 1

print(count)