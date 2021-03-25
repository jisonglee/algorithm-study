import heapq

#https://programmers.co.kr/learn/courses/30/lessons/42626
def solution(scoville, K):
    answer = 0
    heap = []
    for x in scoville:
        heapq.heappush(heap,x)
    
    while len(heap) >= 2:
        a = heapq.heappop(heap)
        b = heapq.heappop(heap)
        if a < K:
            heapq.heappush(heap, a + b*2)
            answer += 1
        else:
            heapq.heappush(heap, a)
            break
        
    if heapq.heappop(heap) < K:
        answer = -1
        
    return answer