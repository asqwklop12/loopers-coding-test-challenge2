let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const N = parseInt(input[0]);
const str = input[1].replace(/[^AN]/g, '');
let result = 0;

for (let i = 0; i < N-2; i++) {

    if (str[i] === 'A' && str[i+1] === 'N' && str[i+2] === 'A') {
        result++;
    }
}

console.log(result);