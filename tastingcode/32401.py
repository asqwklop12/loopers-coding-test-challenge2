n = int(input())
arr = input()


def find_x(i):
    x = 0

    for j in range(i, n):
        if arr[j] == 'A':
            x = j
            break

    return x


def is_ANA(x1, x2):
    ana = False
    cnt = 0

    for i in range(x1+1, x2):
        if arr[i] == 'N':
            cnt += 1

    if cnt == 1:
        ana = True

    return ana

def simulate():
    answer = 0

    i = 0
    while i in range(n - 3 + 1):
        x1, x2 = 0, 0
        x1 = find_x(i)
        if arr[x1] == 'A':
            x2 = find_x(x1 + 2)

        if x2 == 0:
            break

        if is_ANA(x1, x2):
            answer += 1

        i = x2

    print(answer)

simulate()