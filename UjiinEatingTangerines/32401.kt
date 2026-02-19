package UjiinEatingTangerines

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    // 1. 첫 번째 줄 숫자 읽기
    val stringParameterLength = br.readLine().toInt()

    // 2. 두 번째 줄 문자열 읽기
    val stringParameter = br.readLine()

    // 3. 로직 처리 (예시: ANA 문자열 개수 세기)
    var result = solution(stringParameterLength, stringParameter)

    // 4. 출력 (BufferedWriter 사용 시 끝에 \n을 붙이거나 newLine() 호출)
    bw.write("$result\n")

    // BufferedWriter는 반드시 flush와 close를 해줘야 출력이 보입니다.
    bw.flush()
    bw.close()
}

/**
 * 유사 ANA 문자열의 개수를 구하는 함수
 * @param n 문자열의 길이
 * @param s 검사할 문자열
 * @return 조건에 맞는 부분 문자열의 개수
 */
fun solution(stringParameterLength: Int, stringParameter: String): Int {
    var result = 0
    val aIndexes = mutableListOf<Int>()

    // 1. 모든 'A'의 위치(인덱스)를 저장합니다.
    for (i in 0 until stringParameterLength) {
        if (stringParameter[i] == 'A') {
            aIndexes.add(i)
        }
    }

    // 2. 저장된 'A'들 사이의 구간을 하나씩 검사합니다.
    // i가 마지막 인덱스면 i+1이 없으므로 'until aIndexes.size - 1'을 사용합니다.
    for (i in 0 until aIndexes.size - 1) {
        val start = aIndexes[i]
        val end = aIndexes[i + 1]

        var nCount = 0
        // 두 'A' 사이(start + 1 부터 end - 1 까지)를 훑습니다.
        for (j in (start + 1) until end) {
            if (stringParameter[j] == 'N') {
                nCount++
            }
        }

        // 'N'이 정확히 1개만 있다면 유사 ANA 문자열입니다.
        if (nCount == 1) {
            result++
        }
    }

    return result
}