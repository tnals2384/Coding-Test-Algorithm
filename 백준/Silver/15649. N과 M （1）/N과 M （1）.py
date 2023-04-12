import itertools

N,M= map(int, input().split())

num = [i for i in range(1,N+1)] #1부터 N까지 숫자가 들어있는 배열 만들기

answer= list(itertools.permutations(num,M)) #permutations를 이용하여 NPM 값을 answer에 저장

# 출력
for i in answer:
    print(' '.join(map(str,i)))