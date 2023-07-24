import sys
input =sys.stdin.readline
sys.setrecursionlimit(10**6)

tree=[]
while True:
    try:
        tree.append(int(input()))
    except:
        break


def post(s,e):
    
    #순서가 역전되면 종료
    if s>e:
        return
    else:
        mid=e+1 #mid를 e+1로 설정
        for i in range(s+1,e+1):
            #s보다 크면 mid 재설정
            if tree[s]<tree[i]:
                mid=i
                break
        
        #mid기준으로 왼쪽 오른쪽 후위순회
        post(s+1,mid-1)
        post(mid,e)
        #출력
        print(tree[s])

post(0, len(tree)-1)