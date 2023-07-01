T = int(input())
for _ in range(T):
    N,M = map(int, input().split())
  
    important = list(map(int,input().split()))
    
    answer=0
    
    #index를 저장하는 queue를 따로 만듦
    #important queue와 함께 삽입삭제를 수행하여 기존의 index를 기억
    index = [i for i in range(N)]

    while True:
        if important[0] == max(important):
            answer+=1
            
            if index[0] == M:
                print(answer)
                break
            else :
                important.pop(0)
                index.pop(0)
        else:
            important.append(important.pop(0))
            index.append(index.pop(0))