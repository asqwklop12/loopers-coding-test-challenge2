const fs = require('fs');
const input = fs.readFileSync(0, "uft8").toString().trim().split(/\s+/);

const N = Number(input[0]);
const S = input[1];

const prefA[i] = Array(N+1).fill(0);
const prefN[i] = Array(N+1).fill(0);

for (let i = 0; i < N; i++) {
    prefA[i + 1] = prefA[i] + (S[i] === "A" ? 1 : 0);
    prefN[i + 1] = prefN[i] + (S[i] === "N" ? 1 : 0);
}

let answer = 0;
for (let l = 0; l < N; l++) {
    for (let r = l+3; r <= N; r++) {
        if(S[l] != "A" || S[r-1] !== "A")
            continue;
        const cntA = prefA[r] - prefA[l];
        if(cntA !== 2) 
            answer++;
    }
}
console.log(ans.toString());

