from collections import defaultdict

cases = {
    ("a", True),
    ("", True),
    ("aa!abb", True),
    ("aabbb", True),
    ("aabbcc", True),
    ("daabbcc", True),
    ("daabbccdde", False),
    ("ab", False),
    ("aabbcccd", False),
    ("daabbcc", True),
    ("avc", False),
    }

def hashmap_solution(word):
    d = defaultdict(lambda: False)

    for c in word:
        if int_to_char(c) == -1:
            continue
        if d[c] == False:
            d[c] = True

        else:
            d[c] = False
    
    seen = False
    for v in d.values():
        if v:
            if seen:
                return False
            seen = True
    return True


def int_to_char(char):
    a = 'a'
    z = 'z'
    if char >= a and char <= z:
        return ord(char) - ord(a)

    else: 
        print(f"Char: {char} is -1")

        return -1

def int_as_bit_set_solution(word):
    bit_set = 0
    for c in word:
        c_int = int_to_char(c)
        if c_int != -1:
            bit_set = update_bit_set(bit_set, c_int)
    
    if bit_set == 0:
        return True
    if has_on_bit_flipped(bit_set):
        return True
    return False

def has_on_bit_flipped(bit_set: int):
    return bit_set & (bit_set - 1) == 0

def update_bit_set(bit_set, index):
    # print(f"bitset: {bit_set}")
    value = 1 << index
    # if there isnt a single overlapping bit
    if bit_set & value == 0:
        # take unuin of both
        bit_set = bit_set | value
    
    # if there is a overlapping bit
    # we want to take all the bits from the bit_set but the one overlapping one
    else:
        # book solution
        test_bit_set = bit_set & ~value
        # my solution
        bit_set = bit_set ^ value

        assert test_bit_set == bit_set

    return bit_set


def test(word, result):
    if hashmap_solution(word) != result:
        print(f"Hashmap Solution, The case: {word} failed and returned: {not result}")
    
    if int_as_bit_set_solution(word) != result:
        print(f"Bitset Solution, The case: {word} failed and returned: {not result}")



for case in cases:
    # print(f"case: {case}")
    test(*case)
