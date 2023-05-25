height = []
for _ in range(9):
    height.append(int(input()))


sum=sum(height)
remove1=0
remove2=0

for i in range(9):
    for j in range(i+1,9):
        if sum-height[i]-height[j]==100:
            remove1,remove2=height[i],height[j]
            break

        
height.remove(remove1)
height.remove(remove2)
height.sort()

for i in range(7):
    print(height[i])
        