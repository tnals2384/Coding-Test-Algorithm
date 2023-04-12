# 백트래킹 이용하여 풀기
N,M= map(int, input().split())
answer= []
visited = [False]*(N+1)

def backtracking():
    #M개가 되면 출력
    if len(answer) == M:
        print(*answer)
        return
    
    for i in range(1,N+1):
        #방문 했으면 건너뛰기
        if visited[i] == True :
            continue
        #방문 안했을 경우 answer에 추가하고, 함수 다시 실행
        visited[i]=True
        answer.append(i)
        backtracking()
        #다음 i를 위해, 추가한 거 다시 빼주고, 방문도 False로 바꿔두기
        answer.pop()
        visited[i]=False
    
    
backtracking()

#-----------------------------------------------
# 파이썬 itertools permutations 이용하여 풀기
import itertools

N,M= map(int, input().split())

num = [i for i in range(1,N+1)] #1부터 N까지 숫자가 들어있는 배열 만들기

answer= list(itertools.permutations(num,M)) #permutations를 이용하여 NPM 값을 answer에 저장

# 출력
for i in answer:
    print(' '.join(map(str,i)))
