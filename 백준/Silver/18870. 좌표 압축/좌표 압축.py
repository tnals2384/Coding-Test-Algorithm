import sys
input = sys.stdin.readline
N = int(input())
X = list(map(int, input().split()))


listX = sorted(list(set(X)))
dic = {listX[i]: i for i in range(len(listX))}

for i in X :
    print(dic[i],end=' ')
