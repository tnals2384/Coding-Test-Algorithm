S = input()

alphabet = [0]*26

for i in range(len(S)):
    alphabet[ord(S[i])-97]+=1
    
for i in range(26):
    print(alphabet[i],end=" ")
