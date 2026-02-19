const fs = require('fs');
const str = fs.readFileSync('/dev/stdin').toString().trim().split('\n')[1];

let answer = 0
let isN = -1

for(let i of str){
    if(i === 'A'){
        if(isN === 1) answer++
        isN = 0
    }else if(i === 'N'){
        isN++
    }
}
console.log(answer)
