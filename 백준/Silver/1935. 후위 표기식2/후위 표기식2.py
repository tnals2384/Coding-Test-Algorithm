import sys
input=sys.stdin.readline

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
        stack.append(num[ord(fomula[i])-65])

print(f"{stack[0]:.2f}")
