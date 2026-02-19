    const fs = require('fs');
    const input = fs.readFileSync(0, 'utf-8').trim().split(/\s+/);

    const N = parseInt(input[0]);
    const S = input[1];

    // A 위치 저장
    let aSpots = [];
    for (let i = 0; i < N; i++) {
        if (S[i] === 'A') {
            aSpots.push(i);
        }
    }

    let resultCount = 0;

    for (let i = 0; i < aSpots.length - 1; i++) {
        let start = aSpots[i];
        let end = aSpots[i + 1];

        let nCount = 0;

        // N 갯수 확인
        for (let j = start + 1; j < end; j++) {
            if (S[j] === 'N') {
                nCount++;
            }
        }

        // N이 하나만 있을 경우
        if (nCount === 1) {
            resultCount++;
        }
    }

    console.log(resultCount);