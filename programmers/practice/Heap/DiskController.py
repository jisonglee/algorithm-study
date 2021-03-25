import heapq
import math

#https://programmers.co.kr/learn/courses/30/lessons/42627
def solution(jobs):
    heap = []
    time = 0
    totalTime = 0
    
    for i in sorted(jobs):
        if i[0] <= time:
            heapq.heappush(heap, (i[1], i))
        else:
            while len(heap) > 0:
                if time >= i[0]:
                    break
                elm = heapq.heappop(heap)
                totalTime += time - elm[1][0] + elm[1][1]
                time += elm[1][1]
                
            if time < i[0]:
                time = i[0]
                
            heapq.heappush(heap, (i[1], i))
            
    while len(heap) > 0:
        elm = heapq.heappop(heap)
        if time < elm[1][0]:
            time = elm[1][0]
        totalTime += time - elm[1][0] + elm[1][1]
        time += elm[1][1]
            
    return math.floor(totalTime/len(jobs))