s = input()
word = input()

i=0
count=0

while i <len(s):
    if s[i:i+len(word)] == word:
        count+=1
        i+=len(word)
    else: i+=1
    
print(count)
    