N = int(input())

arr = [list(input()) for _ in range(N)]


answer= ''

def quardTree(x,y,N) :
    global answer
    num = arr[x][y]
    for i in range(x,x+N):
        for j in range(y,y+N):
            if arr[i][j] !=num :
                answer+= '('
                quardTree(x,y,N//2)
                quardTree(x,y+N//2,N//2)
                quardTree(x+N//2,y,N//2)
                quardTree(x+N//2,y+N//2,N//2)
                answer+= ')'
                return 
    answer+= num

quardTree(0,0,N)

print(answer)