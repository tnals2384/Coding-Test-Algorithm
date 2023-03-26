import sys
input = sys.stdin.readline


while True:
    try:
        N = int(input())
        num=3**N
        string='-'*num

        def change(start,num):
            global string
            num=num//3
            if(num!=0):
                string = string[:start+num]+ ' '*num+string[start+num+num:]
                change(start,num)
                change(start+num+num,num)
            
        change(0,num)
        print(string)
    except :
        break