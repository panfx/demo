guests = ["tom", 'mic', 'wawa']

def aaa():
    print("我邀请" + guests[0] + "与我共进晚餐")
    print("我邀请" + guests[1] + "与我共进晚餐")
    print("我邀请" + guests[2] + "与我共进晚餐")
def aaa1():
    print("我邀请" + guests[0] + "与我共进晚餐")
    print("我邀请" + guests[1] + "与我共进晚餐")
    print("我邀请" + guests[2] + "与我共进晚餐")
    print("我邀请" + guests[3] + "与我共进晚餐")
    print("我邀请" + guests[4] + "与我共进晚餐")


aaa()

print(guests[0] + '无法赴约')

guests[0] = 'lisa'
aaa()

print('我找到了一个更大的餐桌')
guests.insert(0, 'bob')
guests.insert(int(len(guests)/2), 'xm')
guests.append("wq")
aaa1()

print(guests)
print(guests.pop())
print(guests)
print(guests.pop(2))
print(guests)
print(guests.pop())
print(guests.pop())
print(guests)
print(guests.remove())
del guests[0]
del guests[0]
print(guests)
