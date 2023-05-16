N,M = map(int ,input().split())


#유클리드 호제법
def gcd(a,b):
    if b == 0:
        return a
    else : 
        return gcd(b,a%b)

def lcm(N,M,gcd) :
    return int(N*M//gcd)

gcdNum = gcd(N,M)
print(gcdNum)
print(lcm(N,M,gcdNum))