
N,M=map(int, input().split())


#두 행렬 입력받기
A = []
B = []
for _ in range(N):
    A.append(list(map(int, list(input()))))
for _ in range(N):
    B.append(list(map(int, list(input()))))


#뒤집는 함수
def reverse(i,j) :
    for x in range(i,i+3):
        for y in range(j,j+3):
            A[x][y]=1-A[x][y]


count=0
if (N<3 or M<3) and A!=B : #행렬의 크기가 3X3보다 작고 두 행렬이 같지 않으면 -1
    count = -1
else: #3X3행렬을 만들 수 있는 범위 내에서
    for i in range(N-2):
        for j in range(M-2):
            if A[i][j]!=B[i][j] : # 두 원소가 같지 않으면 뒤집고 count+1
                reverse(i,j)
                count += 1
    #뒤집을 수 있는 경우를 다 뒤집었을 때 두 행렬이 같지 않으면 -1
    if A != B : count = -1 

print(count)
