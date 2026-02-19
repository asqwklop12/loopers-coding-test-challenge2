package main.baekjoon.bronze

/**
 * BOJ 32401 - ANA는 회문이야
 * https://www.acmicpc.net/problem/32401
 *
 * 분류: 문자열, 회문
 */
fun main() = with(java.lang.System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    // 풀이 작성
    val length = java.io.BufferedReader.readLine()!!.trim().toInt()
    val string = java.io.BufferedReader.readLine()!!.trim()

    var result = 0

    val aIndex = mutableListOf<Int>()
    val nIndex = mutableListOf<Int>()

    string.forEachIndexed { i, char ->
        if (char == 'A') aIndex.add(i)
        if (char == 'N') nIndex.add(i)
    }

    // 2개씩 슬라이딩 윈도우
    aIndex.windowed(2).forEach { (left, right) ->
        if (left + 1 == right) {
            return@forEach
        }

        // nIndex에서 'left < n && n < right' count
        val nCount = nIndex.count { it in (left + 1)..<right }
        if (nCount == 1) result++
    }

    print(result)
}
