
while True :
    str = input()
    if str==".":
       break
    
    stack = []
    answer='yes'
    for i in range(len(str)):
        if str[i]=='(':
            stack.append(str[i])
        elif str[i]=='[':
            stack.append(str[i])
            
        elif str[i]==')':
            if not stack or stack[-1]=='[':
                answer='no'
            elif stack[-1]=='(':
                stack.pop()
                
        elif str[i]==']':
            if not stack or stack[-1]=='(':
                answer='no'
            elif stack[-1]=='[':
                stack.pop()
        
    if len(stack)!=0:
        print('no')
    else:print(answer)