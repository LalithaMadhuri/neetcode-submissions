from collections import defaultdict
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        count = defaultdict(int)
        for c in s:
            count[c] += 1
        
        for c in t:
            count[c] -= 1
            if count[c] < 0:
                return False

        return True
        