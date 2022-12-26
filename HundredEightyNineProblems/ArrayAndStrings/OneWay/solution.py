test_cases = [
        ("", "a", True),
        ("", "", True),
        ("a", "", True),
        ("abc", "abcd", True),
        ("abc", "abd", True),
        ("pale", "bale", True),
        ("pale", "balee", False),
        ("abc", "abda", False),
        ("a", "aaaaaaaaaaa", False),
]

def solution(word1, word2):
    if abs(len(word1) - len(word2)) > 1: return False
    if len(word1) == len(word2): return is_one_replaced(word1, word2)

    long, short = (word1, word2) if len(word1) >= len(word2) else (word2, word1)
    return is_one_inserted_removed(short=short, long=long)

def is_one_replaced(word1, word2):
    seen = False
    for c1, c2 in zip(word1, word2):
        if c1 != c2:
            if seen: return False
            seen = True
    
    return True


def is_one_inserted_removed(short, long):
    i = 0
    j = 0

    while i < len(short):
        if short[i] != long[j]:
            if i != j: return False
            j+=1
        else:
            i+=1
            j+=1

    return True


for w1, w2, expected_result in test_cases:
    result = solution(w1, w2)

    if result != expected_result:
        print(f"Test case failed for words: {w1} and {w2}, expected: {expected_result}")