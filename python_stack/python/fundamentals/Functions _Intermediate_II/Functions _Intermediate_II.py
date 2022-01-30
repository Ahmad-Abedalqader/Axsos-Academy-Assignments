#1. update-----------------------------------------
x = [ [5,2,3], [10,8,9] ] 
students = [
    {'first_name':  'Michael', 'last_name' : 'Jordan'},
    {'first_name' : 'John', 'last_name' : 'Rosales'}
]
sports_directory = {
    'basketball' : ['Kobe', 'Jordan', 'James', 'Curry'],
    'soccer' : ['Messi', 'Ronaldo', 'Rooney']
}
z = [ {'x': 10, 'y': 20} ]

x[1][0]=15
print(x)

students[0]['last_name']='bryant'
print(students)

sports_directory['soccer'][0]='Andress'
print(sports_directory)

z[0]['y'] = 30
print(z)

#2. iterate through ------------------------------------------
students = [
        {'first_name':  'Michael', 'last_name' : 'Jordan'},
        {'first_name' : 'John', 'last_name' : 'Rosales'},
        {'first_name' : 'Mark', 'last_name' : 'Guillen'},
        {'first_name' : 'KB', 'last_name' : 'Tonel'}
    ]

def iterateDictionary(my_list):
    for i in range(len(my_list)):
        for y in my_list [i]:
            print (y,'-', my_list[i][y])

iterateDictionary(students)

#3. Get Values------------------------------------------
def iterateDictionary2(key_name, my_list):
        for i in range(len(my_list)):
            print(my_list[i][key_name])
iterateDictionary2('first_name', students)

#4. Iterate Through a Dictionary with List Values-------
dojo = {
    'locations': ['San Jose', 'Seattle', 'Dallas', 'Chicago', 'Tulsa', 'DC', 'Burbank'],
    'instructors': ['Michael', 'Amy', 'Eduardo', 'Josh', 'Graham', 'Patrick', 'Minh', 'Devon']
}

def printInfo(some_dict):
    for x in some_dict:
        print(len(some_dict[x]), x)
        for value in some_dict[x]:
            print(value)
printInfo(dojo)

