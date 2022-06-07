def distance(a, b):
    return ((a[0] - b[0]) ** 2 + (a[1] - b[1]) ** 2) ** (0.5)

def min_points(mst, points, used):
    dis = -1
    ind = -1
    for p in mst:
        for i in range(len(points)):
            if used[i] == 0:
                q = points[i]
                temp = distance(p, q)
                if dis == -1 or dis >= temp:
                    dis = temp
                    ind = i
                    # print("temp : ", temp, " i  : ", i)
    # print("dis : ", dis)
    # print("ind : ", ind)
    mst.append(points[ind])
    used[ind] = 1
    return dis

def min_distance(points, n):
    d = 0.0
    arr = [points[0]]
    used = [0] * n
    used[0] = 1
    for i in range(n - 1):
        dis = min_points(arr, points, used)
        print(used)
        d += dis
    return d

test = [
    [1, 2],
    [3, 4],
    [5, 6],
    [7, 8],
]

test2 = [
    [3, 12],
    [-2, 5],
    [-4, 1],
    [7, 9],
]

res = min_distance(test2, len(test2))
print(res)
# print(distance(test[0], test[1]))

