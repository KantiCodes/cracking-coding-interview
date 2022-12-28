
test_cases = [
    ([[1, 2, 3], [4, 5, 6], [7, 8, 9]], [[7, 4, 1], [8, 5, 2], [9, 6, 3]]),
    (
        [
            [1 , 2 , 3 , 4 , 5 ],
            [6 , 7 , 8 , 9 , 10],
            [11, 12, 13, 14, 15],
            [16, 17, 18, 19, 20],
            [21, 22, 23, 24, 25],
        ],

        # [
        #     [21, 16, 11 ,6,  1],
        #     [22 ,17 ,12 ,7,  2],
        #     [23, 18, 13, 8,  3],
        #     [24, 19, 14, 9,  4],
        #     [25, 20, 15, 10, 5],
        # ],

        # [
        #     [21, 16, 11 ,6,  1],
        #     [22 ,17 ,12 ,7,  2],
        #     [23, 18, 13, 8,  3],
        #     [24, 19, 14, 9,  4],
        #     [25, 20, 15, 10, 5],
        # ],
        

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
            [1,  2,  3,  4 ],
            [5,  6,  7,  8 ],
            [9,  10, 11, 12],
            [13, 14, 15, 16]

        ],

        [
            [13, 9 , 5 , 1],
            [14, 10, 6 , 2],
            [15, 11, 7 , 3],
            [16, 12, 8,  4]

        ]
    ),
    (
        [[1]],
        [[1]]
    ),
]

def intermidate_array_solution(arr):
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


def inplace_solution(arr):

    # arr = [
    #         [1 , 2 , 3 , 4 , 5 ],
    #         [6 , 7 , 8 , 9 , 10],
    #         [11, 12, 13, 14, 15],
    #         [16, 17, 18, 19, 20],
    #         [21, 22, 23, 24, 25],
    # ]


    N = len(arr)


    i = 0
    for col_idx, row in enumerate(arr):
        for ridx, first_value in enumerate(row):
            row_idx = ridx + i
            if row_idx > N - 1 - 1 - i:
                break

            top_left_idx = (col_idx, row_idx)
            top_right_idx = (row_idx, N - i - 1)
            bottom_left_idx = (N - row_idx - 1, col_idx)
            bottom_right_idx = (N - col_idx - 1, N - row_idx - 1)

            rotate(top_left_idx, top_right_idx, bottom_left_idx, bottom_right_idx, arr)

            # print(f"{top_left_idx}, {top_right_idx} \n {bottom_left_idx}, {bottom_right_idx}")
            # print("-------------------")
            # print(f"{top_left_value}, {top_right_value} \n {bottom_left_value}, {bottom_right_value}")

            # input("go?")
        i = i + 1
    return arr
    
def get_arr_value(arr, idx):
    return arr[idx[0]][idx[1]]

def set_arr_value(arr, idx, value):
    arr[idx[0]][idx[1]] = value

def rotate(tl_idx, tr_idx, bl_idx, br_idx, arr):
    """
    rotate 4 values 90 degrees clockwise:

        tl, tr,
        bl, br

    result:

        bl, tl,
        br, tr
    
    """

    tl = get_arr_value(arr, tl_idx)
    tr = get_arr_value(arr, tr_idx)
    bl = get_arr_value(arr, bl_idx)
    br = get_arr_value(arr, br_idx)

    set_arr_value(arr, tl_idx, bl)
    set_arr_value(arr, tr_idx, tl)
    set_arr_value(arr, bl_idx, br)
    set_arr_value(arr, br_idx, tr)

            
# inplace_solution(1)


for idx, (case, expected_result) in enumerate(test_cases):
    print(f"testing case: {case}")
    result = inplace_solution(case)

    if result != expected_result:
        print("Failed")
        for row in result:
            print(row)



