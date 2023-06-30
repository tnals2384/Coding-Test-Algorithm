N = int(input())

fomula = input().rstrip()
num=[]
stack=[]
for _ in range(N):
    num.append(int(input()))

for i in range(len(fomula)) :
    if fomula[i]=='*':
        stack.append(stack.pop()*stack.pop())
    elif fomula[i]=='+':
        stack.append(stack.pop()+stack.pop())
    elif fomula[i]=='/':
        y=stack.pop()
        x=stack.pop()
        stack.append(x/y)   
    elif fomula[i]=='-':
        y=stack.pop()
        x=stack.pop()
        stack.append(x-y)
    else:
        stack.append(num[ord(fomula[i])-65]) #ord(문자)로 ascii 변환

print(format(stack[0],".2f"))
