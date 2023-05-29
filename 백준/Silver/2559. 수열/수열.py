N, K = map(int, input().split())

temperature = list(map(int, input().split()))
maxSum= sum(temperature[:K])
window = sum(temperature[:K])
for i in range(K, N):
    window += temperature[i]-temperature[i-K]
    maxSum=max(maxSum,window)

print(maxSum)