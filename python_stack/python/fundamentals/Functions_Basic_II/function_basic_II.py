#1-----------------------------------
def countdown(num):
    list = []
    for i in range (num,-1,-1):
        list.append(i)
    return list
print(countdown(5))

#2-----------------------------------
def print_return(list):
    print (list[0])
    return (list[1])
print (print_return([2,3]))

#3-----------------------------------
def first_plus_length(list):
    return list[0] + len(list)
print (first_plus_length([1,2,3,4,5]))

#4-----------------------------------
def values_greater_than_second(list):
    newlist=[]
    if len(list)<2:
        return False
    for x in list:
        if x> list[1]:
            newlist.append(x)
    print ("number of values is",len(newlist))
    return newlist
print (values_greater_than_second([5,2,3,2,1,4]))
print (values_greater_than_second([3]))

#5------------------------------------
def length_and_value(size, value):
    list = []
    for i in range(0, size):
        list.append(value)
    return list
print(length_and_value(4,7))
print(length_and_value(6,2))