def treasure(board, start, end):
    ones = []
    for i in range(len(board)):
        for j in range(len(board[i])):
            if board[i][j] == 1:
                ones.append((i, j))
    return dfs(board, start, end, ones, [])


def dfs(board, start, end, ones, visited):
    m = len(board)
    n = len(board[0])
    i, j = start
    if i < 0 or i >= m or j < 0 or j >= n or board[i][j] == -1 or start in visited:
        return None
    newones = ones
    if start in ones:
        find = ones.index(start)
        newones = ones[:find] + ones[find+1:]
    if start == end:
        if len(newones) == 0:
            return [end]
        else:
            return None

    visited.append(start)
    up = dfs(board, (i-1, j), end, newones, visited)
    shortest = up

    down = dfs(board, (i+1, j), end, newones, visited)
    if not shortest or (down and len(shortest) > len(down)):
        shortest = down

    left = dfs(board, (i, j-1), end, newones, visited)
    if not shortest or (left and len(shortest) > len(left)):
        shortest = left

    right = dfs(board, (i, j+1), end, newones, visited)
    if not shortest or (right and len(shortest) > len(right)):
        shortest = right
    visited.pop()
    if shortest:
        shortest.insert(0, start)
    return shortest


def minMoves(maze, x, y):
    coins = []
    for i in range(len(maze)):
        for j in range(len(maze[i])):
            if maze[i][j] == 2:
                coins.append((i, j))
    start = (0, 0)
    ans = 0
    while coins:
        steps, start = bfs(maze, start, coins)
        if steps == -1:
            return -1
        ans += steps
    coins.append((x, y))
    steps, start = bfs(maze, start, coins)
    if steps == -1:
        return -1
    return ans + steps


def bfs(maze, start, coins):
    q = [start]
    visited = []
    ans = 0
    while q:
        nex = []
        while q:
            current = q.pop(0)
            if current in visited\
                    or current[0] < 0 or current[0] >= len(maze)\
                    or current[1] < 0 or current[1] >= len(maze[0])\
                    or maze[current[0]][current[1]] == 1:
                continue
            if current in coins:
                coins.remove(current)
                return ans, current
            visited.append(current)
            nex.append((current[0] - 1, current[1]))
            nex.append((current[0] + 1, current[1]))
            nex.append((current[0], current[1] - 1))
            nex.append((current[0], current[1] + 1))
        q = nex
        ans += 1
    return -1, None


if __name__ == "__main__":

    # Board
    board_1 = [
        [ 1, 0, 0, 0, 0],
        [ 0,-1,-1, 0, 0],
        [ 0,-1, 0, 1, 0],
        [-1, 0, 0, 0, 0],
        [ 0, 1,-1, 0, 0],
        [ 0, 0, 0, 0, 0]
    ]
    # None
    print(treasure(board_1, (5, 0), (0, 4)))

    # Board
    board_1 = [
        [ 1, 0, 0, 0, 0],
        [ 0,-1,-1, 0, 0],
        [ 0,-1, 0, 1, 0],
        [-1, 0, 0, 0, 0],
        [ 0, 1,-1, 0, 0],
        [ 0, 0, 0, 0, 0]
    ]
    # 14
    print(treasure(board_1, (5, 2), (2, 0)))

    # Board
    board_1 = [
        [ 1, 0, 0, 0, 0],
        [ 0,-1,-1, 0, 0],
        [ 0,-1, 0, 1, 0],
        [-1, 0, 0, 0, 0],
        [ 0, 1,-1, 0, 0],
        [ 0, 0, 0, 0, 0]
    ]
    # 10
    print(treasure(board_1, (0, 0), (4, 1)))

    board_2 = [
        [0, 1,-1],
        [0, 0, 0],
        [0, 0, 0]
    ]
    # 7
    print(treasure(board_2, (2, 1), (1, 2)))

    # Board
    maze = [
        [0,0,0,0,0],
        [0,1,1,0,0],
        [2,1,2,1,0],
        [1,2,0,0,0],
        [2,1,1,0,0],
        [0,0,0,0,0]
    ]
    print(minMoves(maze, 5, 4))
