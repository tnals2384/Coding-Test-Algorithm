import sys
from itertools import combinations
str = sys.stdin.readline().rstrip()

bracket=[]
open=[]
ans=set() #중복을 막기위함.
# ((0)) 같은 경우 괄호쌍 1개를 제거한다면 (0),(0)으로 중복이 발생

for i in range(len(str)) :
    if str[i]=='(':
        open.append(i)
    elif str[i]==')':
        bracket.append((open.pop(), i))

#가능한 조합을 모두 탐색
#총 괄호쌍이 3개라면, 괄호쌍이 1개일 때,2개일 때, 
#3개일 때 가능한 조합을 차례대로 탐색
for i in range(1, len(bracket)+1):
    #괄호쌍이 i개일 때
    com = list(combinations(bracket, i))
    #모든 조합에 대해
    for c in com:
    #괄호쌍을 temp에서 제거하고 join으로 합쳐 ans에 추가
        temp = list(str)
        for x,y in c:
            temp[x]=""
            temp[y]=""
    
        ans.add(''.join(temp))

#사전 순 정렬
for i in sorted(ans):
    print(i)
    