A,B,C = map(int, input().split())

time = [0]*100
count=0
for _ in range(3):
    a,b = map(int ,input().split())
    
    for i in range(a,b):
        time[i]+=1

for t in range(100):
    if time[t]==1:
        count+=A
    elif time[t]==2:
        count+=2*B
    elif time[t]==3:
        count+=3*C

print(count)