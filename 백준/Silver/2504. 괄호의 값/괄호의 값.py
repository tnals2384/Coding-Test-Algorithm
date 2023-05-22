
str = list(input())
stack = []

ans=0
temp=1

for i in range(len(str)):
    if str[i]=='(':
        temp*=2
        stack.append(str[i])
    elif str[i]=='[':
        temp*=3
        stack.append(str[i])
    
    elif str[i] == ')':
        if not stack or stack[-1] =='[':
            ans=0
            break
        if str[i-1]=='(':
            ans+=temp
        temp//=2
        stack.pop()
        
    elif str[i] ==']':
        if not stack or stack[-1] =='(':
            ans=0
            break
        if str[i-1]=='[':
            ans+=temp
        temp//=3
        stack.pop()
    
if stack:
    ans=0

print(ans)