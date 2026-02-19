/**
 * https://www.acmicpc.net/problem/32401
 * 유사 ANA 문자열이 몇 개인지 구해보자.
 * 첫째 줄에 문자열 S의 길이 N(3 <= N <= 100)이 주어진다.
 * 둘째 줄에 길이가 N인 문자열 S가 주어진다. S는 영어 대문자로 이루어져 있다.
 * S의 부분 문자열 중 유사 ANA 문자열의 개수를 출력한다.
 */

const fs = require("fs");
const str = fs.readFileSync("/dev/stdin").toString().trim().split("\n")[1];
const strLength = str.length;

let totalCount = 0;
let aPositions = [];

for (let i = 0; i < strLength; i++) {
  if (str[i] === "A") {
    aPositions.push(i);
  }
}

for (let i = 0; i < aPositions.length - 1; i++) {
  const start = aPositions[i];
  const end = aPositions[i + 1];

  let nCount = 0;

  for (let k = start + 1; k < end; k++) {
    if (str[k] === "N") {
      nCount++;
    }
  }

  if (nCount === 1) {
    totalCount++;
  }
}

console.log(totalCount);
