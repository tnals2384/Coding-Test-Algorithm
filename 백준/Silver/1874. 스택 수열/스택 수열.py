n = int(input())

seq=[]
stack=[]
ans=[]

for _ in range(n):
    seq.append(int(input()))

i = 1
index=0
while True:
    if i< n+1:
        if not stack or stack[-1]!=seq[index]:
            stack.append(i)
            ans.append('+')
            i+=1
        elif(stack[-1]==seq[index]) :
            ans.append('-')
            stack.pop()
            index+=1
    else:    
        if not stack: 
            for k in range(len(ans)):
                print(ans[k])
            break
        
        if stack[-1]==seq[index]:
            ans.append('-')
            stack.pop()
            index+=1
        else: 
            print('NO')
            break
        
