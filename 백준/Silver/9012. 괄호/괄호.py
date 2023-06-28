N = int(input())

for _ in range(N):
    str = list(input().rstrip())
    S=[]
    for i in range(len(str)):
        if str[i]=='(':
            S.append(str[i])
        elif str[i]==')':
            if len(S)==0 :
                S.append(str[i])
                break
            else: 
                S.pop()
    if len(S)!=0: print('NO')
    else: print('YES')