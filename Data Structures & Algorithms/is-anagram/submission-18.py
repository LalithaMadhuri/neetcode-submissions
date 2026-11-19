from collections import Counter
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        count = Counter(s)
        
        
        for c in t:
            count[c] -= 1
            if count[c] < 0:
                return False

        return True
        