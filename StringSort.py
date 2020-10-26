# String sorting issue

# Function to convert string to list
def string_to_list(string1):
    list1 = list(string1.split(" "))
    return list1


# Taking input
string = input("Enter string : ")
print("Given string : "+string)

# Converting input string to list
final_string = string_to_list(string)

# Removing duplicate elements
revised = []
for word in final_string:
    if word not in revised:
        revised.append(word)

# Sorting list according to alphabetical order
revised.sort(reverse=False)

# Final output
print("Sorted and Unique string : ", end="")
print(revised)
