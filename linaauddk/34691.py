import sys
input = sys.stdin.readline

info = {
    "animal": "Panthera tigris",
    "tree": "Pinus densiflora",
    "flower": "Forsythia koreana"
}
while True :
    question = input().strip()

    if question == "end":
        break
    if question in info :
        print(info[question])
