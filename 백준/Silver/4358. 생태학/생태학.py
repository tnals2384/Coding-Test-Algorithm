import sys
from collections import Counter
input= sys.stdin.readline

arr = []

count = 0
while True:
    s = input().rstrip()
    if not s:
        break
    
    arr.append(s)
    count+=1

arr = sorted(Counter(arr).items())

for i in range(len(arr)):
    print(arr[i][0], "{:.4f}".format(arr[i][1]/count *100))