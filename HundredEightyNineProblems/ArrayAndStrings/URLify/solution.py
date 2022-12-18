test_cases = [
    ("a b c            ", 5, 9),
    ("a  b          ", 4, 8),
    ("hello there  ", 11, 13),
    ("Mr John Smith    ", 13, 17),
    ("Mr John Smith                         ", 13, 17),
    ("asd", 3, 3)
    ]

expected_results = [
    "a%20b%20c",
    "a%20%20b",
    "hello%20there",
    "Mr%20John%20Smith",
    "Mr%20John%20Smith",
    "asd"
    ]


def solution(word, unedited_length):
    # print(f"word before: {word}")
    word = list(word)
    # print(f"word after: {word}")
    num_spaces = 0
    for idx in range(0, unedited_length):
        if word[idx] == " ":
            num_spaces+=1
    
    real_length = unedited_length + num_spaces * 2
    current_pos = real_length - 1
    for real_idx in reversed(range(unedited_length)):
        # print(f"Real idx: {real_idx}")
        c = word[real_idx]
        if c == ' ':
            word[current_pos] = "0"
            word[current_pos-1] = "2"
            word[current_pos-2] = "%"
            current_pos -= 3
        else:
            word[current_pos] = c
            current_pos -= 1
    
    return word



for (case_word, unedited_length, debug_value), expected_result in zip(test_cases, expected_results):
    result = solution(case_word, unedited_length)[0:debug_value]
    print(f"R1: {result}")
    print(f"R2: {list(expected_result)}")
    assert result == list(expected_result)
    



