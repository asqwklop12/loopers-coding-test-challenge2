// https://www.acmicpc.net/problem/32401

/*
앞뒤가 A로 시작하고 끝나는 부분문자열이면서
가운데가 N으로 이루어진 문자열을 ANA 문자열이라고 한다.

예를 들어 ARENA는 ANA 문자열이지만, AGENDA는 ANA 문자열이 아니다.
문자열 S가 주어졌을 때, S의 부분문자열 중에서 ANA 문자열의 개수를 구하는 프로그램을 작성하시오.
*/

const fs = require('fs');

function solve() {
    const input = fs.readFileSync(0, 'utf8').split('\n');
    const N = parseInt(input[0]);
    const S = input[1];

    const aIndices = [];
    for (let i = 0; i < N; i++) {
        if (S[i] === 'A') {
            aIndices.push(i);
        }
    }

    let count = 0;

    for (let i = 0; i < aIndices.length - 1; i++) {
        const start = aIndices[i];
        const end = aIndices[i + 1];
        let nCount = 0;
        let isValid = true;

        for (let j = start + 1; j < end; j++) {
            if (S[j] === 'N') {
                nCount++;
            } else if (S[j] === 'A') {
                isValid = false;
                break;
            }
        }
        if (isValid && nCount === 1) {
            count++;
        }
    }

    console.log(count);
}

solve();
