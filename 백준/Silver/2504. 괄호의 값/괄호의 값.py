stack = [] 
temp = 1 
result = 0 
p = list(input()) 


for i in range(len(p)):
  if p[i]=='(':
    temp *= 2
    stack.append(p[i])
    
  elif p[i]=='[':
    temp *= 3
    stack.append(p[i])
    
  elif p[i]==')':
    if not stack or stack[-1]!='(':
      result = 0
      break
    if p[i-1]=='(': result += temp
    temp //= 2
    stack.pop()
    
  elif p[i]==']':
    if not stack or stack[-1]!='[':
      result = 0
      break
    if p[i-1]=='[': result += temp
    temp //= 3
    stack.pop()


if stack:
  print(0)
else:
  print(result)