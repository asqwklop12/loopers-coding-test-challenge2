const fs = require("fs");
const input = fs.readFileSync("dev/stdin").toString().split(" ");

const getCashprice = (arr) => {
  let result = 0;
  const nums = arr.map(Number);
  const [a, b, c] = nums;
  if (a === b && b === c) {
    result = 10000 + a * 1000;
  } else if (a !== b && a !== c && b !== c) {
    result = Math.max(...nums) * 100;
  } else {
    result =
      1000 + nums.filter((item, index) => nums.indexOf(item) !== index) * 100;
  }
  return result;
};

console.log(getCashprice(input));
