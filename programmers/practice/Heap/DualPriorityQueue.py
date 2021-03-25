import heapq

#https://programmers.co.kr/learn/courses/30/lessons/42628
def solution(operations):
    heap = []
    
    for i in operations:
        a, b = i.split(" ")
        if a == "I":
            heapq.heappush(heap, int(b))    
        else:
            if len(heap) > 0:
                if b == "1":
                    heap.pop(heap.index(heapq.nlargest(1, heap)[0]))
                else:
                    heapq.heappop(heap)
        
    if len(heap) < 1:
        return [0, 0]
    
    return [heapq.nlargest(1, heap)[0], heapq.nsmallest(1, heap)[0]]