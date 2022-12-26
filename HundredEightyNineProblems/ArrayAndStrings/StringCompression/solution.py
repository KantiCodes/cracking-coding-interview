test_cases = [
    ("abc", "abc"),
    ("aaabc", "aaabc"),
    ("aabbcc", "aabbcc"),
    ("aabbbccdeeee", "a2b3c2d1e4"),
    ("aaaaabbbb", "a5b4"),
    ("aaaaabbbbcccdee", "a5b4c3d1e2"),
    ("aabcccccaaa", "a2b1c5a3"),
    ("abcdef", "abcdef"),
    ("aabb", "aabb"),
    ("aaa", "a3"),
    ("a", "a"),
    ("", ""),
    ]



def solution(word):
    if word == "":
        return ""

    count = 1
    res = []
    for idx, c in enumerate(word):
        if idx == 0:
            continue

        if c == word[idx-1]:
            count += 1
        else:
            res.append(word[idx-1])
            res.append(str(count))
            count = 1

    res.append(word[-1])
    res.append(str(count))
    if len(res) >= len(word): return word
    return "".join(res)


for word, expected_result in test_cases:
    print(f"Case: {word}")
    result = solution(word)
    if result != expected_result:
        print(f"Failed, got: {result}, expected: {expected_result}")