
test_cases = [
    ([[1, 2, 3], [4, 5, 6], [7, 8, 9]], [[7, 4, 1], [8, 5, 2], [9, 6, 3]]),
    (
        [
            [1, 2, 3, 4, 5],
            [6, 7, 8, 9, 10],
            [11, 12, 13, 14, 15],
            [16, 17, 18, 19, 20],
            [21, 22, 23, 24, 25],
        ],
        [
            [21, 16, 11, 6, 1],
            [22, 17, 12, 7, 2],
            [23, 18, 13, 8, 3],
            [24, 19, 14, 9, 4],
            [25, 20, 15, 10, 5],
        ],
    ),
    (
        [
            [1, 2, 3],
            [4, 5, 6],
            [7, 8, 9],
            [10,11,12]
        ],

        [
            [10, 7,4,1],
            [11, 8,5,2],
            [12, 9,6,3]
        ],
    ),
    (
        [[1]],
        [[1]]
    ),
]

def solution(arr):
    row_size = len(arr[0])
    col_size = len(arr)

    # 4 x 3
    building = []
    for row in range(row_size):
        building.append([-1]*col_size)

    # 3 x 4
    # over columns
    for idx_row, row in enumerate(arr):
        # over row
        for idx_val, val in enumerate(row):
            building[idx_val][- (1+idx_row)] = val



    return building


for idx, (case, expected_result) in enumerate(test_cases):
    print(f"testing case: {case}")
    result = solution(case)

    if result != expected_result:
        print("Failed")
        for row in result:
            print(row)



