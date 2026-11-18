class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        res = dict()
        for string in strs:

            charCount = [0] * 26
            
            for c in string:
                charCount[ord(c) - ord('a')] += 1
            key = str(charCount)
            if key in res:
                res.get(key).append(string)
            else:
                res[key] = [string]
        return [val for val in res.values()]

        