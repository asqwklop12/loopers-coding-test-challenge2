const readline = require("readline").createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

readline
  .on("line", function (line) {
    input.push(line.trim());
  })
  .on("close", function () {
    const s = parseInt(input[0]);
    const n = input[1];
    let result = 0;
    let index = -1;

    for (let i = 0; i < n.length; i++) {
      if (n[i] === "A") {
        const str = n.substring(index + 1, i);
        if (index !== -1 && str.split("N").length === 2) {
          result++;
        }

        index = i;
      }
    }

    console.log(result);
  });
