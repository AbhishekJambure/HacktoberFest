def left_rotate(st1):
    l_1 = st1[0:1]
    l_2 = st1[1:]
    return l_2 + l_1


def right_rotate(st1):
    r_1 = st1[0:len(st1)-1]
    r_2 = st1[len(st1)-1:]
    return r_2 + r_1


string = input("Enter string :- ")
direction = input("Enter Rotation Direction :- ")
rotationAmount = int(input("Enter Rotation Amount :- "))
if direction == "L":
    for i in range(rotationAmount):
        string = left_rotate(string)
    print("Left Rotated String : ", string)
elif direction == "R":
    for i in range(rotationAmount):
        string = right_rotate(string)
    print("Right Rotated String : ", string)
else:
    print("Invalid operation")
