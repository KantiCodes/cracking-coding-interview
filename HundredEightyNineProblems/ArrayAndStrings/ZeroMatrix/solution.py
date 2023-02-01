data1 = [[[1, 2, 3], [0, 2, 1]], [[0, 2, 3], [0, 0, 0]]]

data2 = [[[1, 0, 1]], [[0, 0, 0]]]


data3 = [[[1, 2, 1], [3, 0, 5], [5, 6, 1]], [[1, 0, 1], [0, 0, 0], [5, 0, 1]]]
data4 = [
    [[1, 2, 0], [3, 9, 5], [5, 6, 9]],
    [[0, 0, 0], [3, 9, 0], [5, 6, 0]],
]

data5 = [
    [],
    [],
]

test_cases: list[list,list] = [data1,data2,data3,data4,data5]





def solution(arr):
    cols, rows, = set(), set()
    for i, row in enumerate(arr):
        for j, el in enumerate(row):
            if el == 0:
                cols.add(i)
                rows.add(j)

    for i, row in enumerate(arr):
        for j, _ in enumerate(row):
            if i in cols or j in rows:
                arr[i][j] = 0
    
    return arr


for case in test_cases:
    arr = case[0]
    result = case[1]
    
    assert result == solution(arr)
