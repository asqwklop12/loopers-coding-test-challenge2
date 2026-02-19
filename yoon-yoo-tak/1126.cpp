#include <algorithm>
#include <cmath>
#include <iostream>
#include <map>
#include <numeric>
#include <queue>
#include <string.h>
#include <vector>
#include <set>
#include <unordered_map>

#define INF 0x3f3f3f3f
#define LINF 1e18+5
#define NM 1001010
#define endl '\n'
#define all(x) x.begin(), x.end()

using namespace std;
using ll = long long;
using ull = unsigned long long;
using pii = pair<int, int>;
using pll = pair<ll, ll>;

int dx[8] = {1, 0, -1, 0, 1, 1, -1, -1};
int dy[8] = {0, 1, 0, -1, -1, 1, -1, 1};

int kdx[8] = {-2, -2, -1, -1, 1, 1, 2, 2};
int kdy[8] = {-1, 1, -2, 2, -2, 2, -1, 1};


int main() {
#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif

    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int n;
    cin >> n;
    vector<int> arr(n);
    int total = 0;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
        total += arr[i];
    }

    vector<vector<int>> dp(n + 1, vector<int>(total + 1, -1));

    auto recur = [&](const auto& self, int cur, int h) -> int {
        if (cur == n) return (h == 0 ? 0 : -INF);
        int &ret = dp[cur][h];
        if (~ret) return ret;
        ret = -INF;
        int x = arr[cur];
        ret = max(ret, self(self, cur + 1, h));
        if (h + x <= total) {
            ret = max(ret, self(self, cur + 1, h + x));
        }
        return ret = max(ret, self(self, cur + 1, abs(h - x)) + min(h, x));
    };

    int ans = recur(recur, 0, 0);
    cout << (ans == 0 ? -1 : ans) << endl;
    return 0;
}
