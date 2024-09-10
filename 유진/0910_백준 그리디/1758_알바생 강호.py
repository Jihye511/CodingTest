import sys

N = int(sys.stdin.readline())

tip = []

for i in range(N):
    tip.append(int(sys.stdin.readline()))

tip.sort(reverse=True)  # 내림차순 정렬

for j in range(N):
    tip[j] = tip[j] - (1+j-1)
    if tip[j] < 0:   # 팁이 음수일 때 0 으로
        tip[j] = 0

print(sum(tip))