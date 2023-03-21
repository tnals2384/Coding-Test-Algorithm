import sys 

input= sys.stdin.readline
N,M = map(int,input().split())

poketmon ={}
for i in range(1,N+1) :
    word=input().rstrip()
    poketmon[i]=word
    poketmon[word]=i
    


for j in range(M) :
    word=input().rstrip()
    if word.isdigit():
        print(poketmon[int(word)])
    else :
        print(poketmon.get(word))