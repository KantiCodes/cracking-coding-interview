from collections import defaultdict

trueCases = [
    ("", ""),
    (" ", " "),
    ("  ", "  "),
    ("abc", "bca"),
    ("abc", "bca"),
    ("aaa", "aaa"),
    ("bbaaaabb", "babababa"),
]

falseCases = [
    ("", "  "),
    ("a", "aa"),
    ("b", "a"),
    ("abc", "bcca"),
    ("cccc", "ccc"),
    ("abcdef", "abcdefabcdef"),
    ("", "  "),
]


def hash_map_solution(s1: str, s2: str) -> bool:
    if len(s1) != len(s2):
        return False
    d1 = defaultdict(lambda: 0)
    d2 = defaultdict(lambda: 0)

    for i in range(len(s1)):
        c1 = s1[i]
        c2 = s2[i]
        d1[c1] += 1
        d2[c2] += 1
    return d1 == d2


def sorting_solution(s1: str, s2: str) -> bool:
    if len(s1) != len(s2):
        return False
    return sorted(s1) == sorted(s2)


print("True cases:")
for case in trueCases:
    print(case)
    assert hash_map_solution(*case)
    assert sorting_solution(*case)

print("False cases:")
for case in falseCases:
    print(case)
    assert not hash_map_solution(*case)
    assert not sorting_solution(*case)
