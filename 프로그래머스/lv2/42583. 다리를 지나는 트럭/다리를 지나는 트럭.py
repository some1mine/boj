def solution(bridge_length, weight, truck_weights):
    answer = 0
    truck_weights.sort()
    queue = []
    queue.append([truck_weights[0], bridge_length])
    truck_weights.remove(truck_weights[0])
    while(len(queue) > 0):
        total = 0
        for i in range(len(queue)):
            if i == len(queue) or len(queue) == 0:
                break
            total += queue[i][0]
            truck = queue[i]
            queue.remove(truck)
            if truck[1] > 0:
                queue.insert(i, [truck[0], truck[1] - 1])
        if len(truck_weights) > 1:
            if total + truck_weights[0] <= weight:
                queue.append([truck_weights[0], bridge_length])
                truck_weights.remove(truck_weights[0])
        answer += 1
    return answer