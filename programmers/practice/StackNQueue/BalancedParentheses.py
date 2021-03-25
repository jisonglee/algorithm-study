# https://programmers.co.kr/learn/courses/30/lessons/12909
def solution(s):
    stack = []
    for i in s:
        if len(stack) > 0:
            if stack[-1] == "(" and stack[-1] != i:
                stack.pop()
            else:
                stack.append(i)
        else:
            stack.append(i)

    return len(stack) == 0