/**
 * 제목: ANA는 회문이야
 * 링크: https://www.acmicpc.net/problem/32401
 * 조건:
 * 1) 유사 ANA 문자열은 영어 대문자로 이루어진 길이가 3 이상인 문자열
 * 2) 유사 ANA 문자열은 영어 대문자 A로 시작해서 A로 끝나며, 문자열의 다른 위치에서 A가 등장하지 않음
 * 3) 유사 ANA 문자열은 영어 대문자 N을 한 개만 포함
 * 문제: 어떤 문자열 S에서 부분 유사 문자열 ANA 가 몇 개 인지 구하기
 */

fun main() {
    val N = readln().trim().toInt()
    val S = readln().trim()
    var count = 0

    for (i in 0 until N) {
        if (S[i] != 'A') continue
        for (j in i + 2 until N) {
            if (S[j] != 'A') continue
            val mid = S.substring(i + 1, j)
            if ('A' !in mid && mid.count { it == 'N' } == 1) {
                count++
            }
        }
    }

    println(count)
}