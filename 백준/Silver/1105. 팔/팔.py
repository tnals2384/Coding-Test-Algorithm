import sys
input=sys.stdin.readline
L,R =input().split()

# L<= x <= R 중 8이 가장 적게 들어있는 수에 들어있는 8의 개수
count=0
if len(L)!=len(R) : #길이가 다르면 무조건 0
    print(0)
else :
    for i in range(len(L)): #앞에서부터 숫자가 8로 같으면 count
        if L[i] == R[i]:
            if R[i]=='8':
                count+=1
        else: break
    print(count)