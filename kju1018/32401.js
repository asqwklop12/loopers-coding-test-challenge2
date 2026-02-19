const input = require("fs")
  .readFileSync("/dev/stdin", "utf8")
  .toString()
  .trim()
  .split("\n");

const TARGET = "ANA";
const result = input[1].replace(/[^AN]/g, "");

let count = 0;
let pos = result.indexOf(TARGET);

while (pos !== -1) {
  count++;
  pos = result.indexOf(TARGET, pos + 1);
}

console.log(count);
