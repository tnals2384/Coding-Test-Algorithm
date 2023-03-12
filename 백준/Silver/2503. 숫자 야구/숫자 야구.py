import itertools

N= int(input()) 


arr = ['1','2','3','4','5','6','7','8','9']
#123~987 순열
li = itertools.permutations(arr,3)
permutation = list(li)


for _ in range(N):
    guess, strike, ball=map(int, input().split())
    guess_list= list(str(guess))
    
    count=0
    for i in range(len(permutation)) : #모든 순열에 대해서
        s=0
        b=0

        i-=count
        for j in range(3):
            if permutation[i][j]==guess_list[j]:
                s+=1
            elif guess_list[j] in permutation[i]:
                b+=1
                
        if s!=strike or b!=ball :
            permutation.remove(permutation[i])
            count+=1
            
            

print(len(permutation))   
        
        