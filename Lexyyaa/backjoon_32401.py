## https://www.acmicpc.net/problem/32401

'''
앞뒤가 A로 시작하고 끝나는 부분문자열이면서
가운데가 N으로 이루어진 문자열을 ANA 문자열이라고 한다.

예를 들어 ARENA는 ANA 문자열이지만, AGENDA는 ANA 문자열이 아니다.
문자열 S가 주어졌을 때, S의 부분문자열 중에서 ANA 문자열의 개수를 구하는 프로그램을 작성하시오.
'''

import sys
input = sys.stdin.readline

n = int(input().strip()) # 문자열 길이
s = input().strip() # 문자열

cnt = 0

for i in range(n) :
    for j in range(i+2, n) :
        # A N A 이렇게 3글자 이상이어야 ANA 문자열이 될 수 있기 때문에 j는 i+2부터 시작
        sub = s[i:j+1] # 부분문자열 추출

        if(sub[0] == 'A' and sub[-1] == 'A' and all(c == 'N' for c in sub[1:-1])) :
            cnt += 1

print(cnt)
