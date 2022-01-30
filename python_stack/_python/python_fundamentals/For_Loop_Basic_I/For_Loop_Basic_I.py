#1-----------------------------
for i in range(151):
    print(i)
#2-----------------------------
for i in range (5,1001):
    if i % 5 == 0:
        print(i)
#3-----------------------------
for i in range (1,101):
    if i % 5 == 0:
        print ("Coding")
    elif i % 10 ==0:
        print ("Coding Dojo")
    else:
        print (i)
#4-----------------------------
sum=0
for i in range (500001):
    if i % 2 != 0:
        sum +=i
print(sum)
#5-----------------------------
for i in range (2018,-1,-4):
    print(i)
#6-----------------------------
lownum=1
highnum=10
mult=2
for i in range (lownum, highnum+1):
    if i % mult == 0:
        print(i)


