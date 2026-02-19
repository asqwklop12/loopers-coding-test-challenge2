input = __import__('sys').stdin.readline

N, P, Q, X, Y = map(int, input().split())
memo = {0 : 1}
memo[1] = max((1 // P - X), 1) + max((1 // Q - Y), 1)

def dfs(num):
    if num in memo:
        return memo[num]
    
    memo[num] = dfs(max(0, (num // P - X))) + dfs(max(0, num // Q - Y))
    return memo[num]

print(dfs(N))