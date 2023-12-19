def main():
    file = open("day1input.txt", "r")
    total = 0

    while True:
        content = file.readline()

        if not content:
            break

        for char in content:
            if char.isnumeric():
                first = char
                break
        
        for char in reversed(content):
            if char.isnumeric():
                second = char
                break

        total += int(str(first) + str(second))
        print(int(str(first) + str(second)))

    print(total)

if __name__ == "__main__":
    main()