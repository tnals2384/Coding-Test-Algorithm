import sys

seq = list(sys.stdin.readline().rstrip())
count=0
X=[]
for i in range(len(seq)):
    if seq[i]=='(':
       X.append(seq[i])
    if seq[i]==')':
        if seq[i-1]=='(':
            X.pop()
            count+=len(X)            
        else:
            X.pop()
            count+=1

print(count)