import sys
sys.setrecursionlimit(100000)

def solve():
    N, P, Q, X, Y = map(int, input().split())

    memo = {}

    def A(i):
        if i <= 0:
            return 1
        
        if i in memo:
            return memo[i]
        
        memo[i] = A(i // P - X) + A(i // Q - Y)
        return memo[i]

    return A(N)

if __name__ == "__main__":
    print(solve())
