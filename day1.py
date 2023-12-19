from word2number import w2n
import unicodedata

def main():
    file = open("day1input.txt", "r")
    total = 0
    list = ["one", "two", "three", "four", "five", "six", "seven", "eight", "nine"]
    number = 1

    while True:
        first = 0
        second = 0
        firstIndex = 0
        secondIndex = 0

        content = file.readline()

        if not content:
            break

        for char in content:
            if char.isnumeric():
                first = char
                firstIndex = content.find(char)
                break

        for char in range(len(content) - 1, -1, -1):
            if str(content[char]).isnumeric():
                second = content[char]
                secondIndex = char
                print("SECOND: " + second)
                print("SECONDINDEX: " + str(secondIndex))
                break

        stringIndexOne = len(content)
        stringIndexTwo = 0
        firstString = ""
        secondString = ""

        for num in list:
            if num in content:
                if content.find(num) < stringIndexOne:
                    stringIndexOne = content.find(num)
                    firstString = num
                if content.rindex(num) > stringIndexTwo:
                    stringIndexTwo = content.rindex(num)
                    secondString = num
        
        if firstString != "" and stringIndexOne < firstIndex:
            first = w2n.word_to_num(firstString)
        if secondString != "" and stringIndexTwo > secondIndex:
            second = w2n.word_to_num(secondString)

        total += int(str(first) + str(second))

    print(total)

if __name__ == "__main__":
    main()