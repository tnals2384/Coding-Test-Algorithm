import sys
input= sys.stdin.readline

N = int(input())

paper = [list(map(int,(input().split()))) for _ in range(N)]

     
blue=0
white=0    

def cut(x,y,N) :
    global white,blue
    color=paper[x][y]
    for i in range(x,x+N):
        for j in range(y,y+N):
            if paper[i][j]!=color:
                cut(x,y,N//2)
                cut(x+N//2,y,N//2)
                cut(x,y+N//2,N//2)
                cut(x+N//2,y+N//2,N//2)
                return
    if color==0:
        white+=1
    if color==1:
        blue+=1
     
cut(0,0,N)

print(white)
print(blue)

        