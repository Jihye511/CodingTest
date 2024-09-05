# #방법 1
# import sys
# from itertools import combinations

# N, M = map(int, sys.stdin.readline().split())
# nums = sorted(list(map(int, sys.stdin.readline().split())))

# array = []
# for i in list(combinations(nums, M)):
#     array.append(i)

# array = sorted(list(set(array)))

# for i in array:
#     print(*i)

# 방법 2
import sys

N, M = map(int, sys.stdin.readline().split())
nums = sorted(list(map(int, sys.stdin.readline().split())))

array = []
visited = [False] * N

def dfs(start):
    if len(array) == M:
        print(*array)
        return
    
    overlap = 0
    for i in range(start, N):
        if not visited[i] and overlap != nums[i]:
            visited[i] = True
            overlap = nums[i]
            array.append(nums[i])
            dfs(i+1)
            visited[i] = False
            array.pop()

dfs(0)