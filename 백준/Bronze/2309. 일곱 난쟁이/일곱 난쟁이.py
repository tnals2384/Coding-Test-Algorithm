from itertools import combinations

height = [int(input()) for _ in range(9)]

li = list(combinations(height,7))

for i in li :
    if sum(i)==100:
        answer=list(i)
        break
answer.sort()
for x in answer:
    print(x)