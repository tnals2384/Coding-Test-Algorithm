import sys
input = sys.stdin.readline
P = int(input())

for p in range(P):
    case=list(map(int, input().split()))
    line=[]
    count=0
    line.append(case[1])
    for i in range(2,21):
        line.append(case[i])
        for j in range(0,i-1):
            if line[j] > case[i]:
                line.pop()
                line.insert(j,case[i])
                count+=i-1-j
                break   

    print(p+1, count) 
               
        