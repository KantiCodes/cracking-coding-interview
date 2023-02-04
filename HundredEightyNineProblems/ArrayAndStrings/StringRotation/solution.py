test_cases = [
        ("abc", "cba", False),
        ("abc", "bca", True),
        ("waterbottle", "ewaterbottl", True),
        ("", "a", False),
        ("a", "", False),
        ("aaa", "aaaaaa", False),
        ("aaa", "aaa", True),
    ]


def solution(word, candidate):
    if len(word) != len(candidate):
        return False

    xyxy = candidate + candidate
    if word in xyxy:
        return True

    return False

for word, candidate, result in test_cases:
    if solution(word,candidate) != result:
        print(f"Failed for: {word} and {candidate}, expected {result}")

