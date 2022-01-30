#1--------------------------------------
from audioop import avg
from math import floor
from re import X


def biggie_size(list):
    for x in range(0,len(list)):
        if list[x] > 0:
            list[x]= 'big'
    return list
print (biggie_size([-1, 3, 5, -5]))

#2---------------------------------------
def count_positives(list):
    count=0
    for x in range(0,len(list)):
        if list[x] > 0:
            count+=1
    list[len(list)-1]= count
    return list
print(count_positives([1,6,-4,-2,-7,-2]))
print(count_positives([-1,1,1,1]))

#3----------------------------------------
def sum_total(list):
    sum=0
    for x in list:
        sum+=x
    return sum
print (sum_total([1,2,3,4]))
print(sum_total([6,3,-2]))

#4-----------------------------------------
def average(list):
    sum=0
    for x in list:
        sum+=x
    return (sum/len(list))
print(average([1,2,3,4]))

#5-----------------------------------------
def length(list):
    count=0
    if list == []:
        return 0
    for x in list:
        count+=1
    return count
print("the length is",length([37,2,1,-9]))
print("the length is",length([]))

#6-----------------------------------------
def minimum(list):
    if list == []:
        return False
    min=list[0]
    for x in list:
        if x < min:
            min = x
    return min 
print ("the minimumnum is",minimum([37,2,1,-9]))
print (minimum([]))
#7-----------------------------------------
def maximum(list):
    if list == []:
        return False
    max=list[0]
    for x in list:
        if x > max:
            max = x
    return max    
print (maximum([37,2,1,-9]))
print(maximum([]))

#8-----------------------------------------
def ultimate_analysis(list):
    sum = sum_total(list)
    avg = average(list)
    min = minimum(list)
    max = maximum(list)
    leng = length(list)
    dict = {
        'sumTotal': sum,
        'average': avg,
        'minimum': min,
        'maximum': max,
        'length':leng
        }
    return dict
print(ultimate_analysis([37,2,1,-9]))

#9-----------------------------------------
def reverse_list(list):
    f = 0
    if len(list) % 2 == 0:
        f = int(len(list)/2)
    else:
        f = int((len(list)-1)/2)
    for i in range(f):
        x=list[i]
        list[i]=list[len(list)-1-i]
        list[len(list)-1-i]=x
    return list
print(reverse_list([37,2,1,-9]))