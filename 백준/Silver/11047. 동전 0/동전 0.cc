#include <bits/stdc++.h>
using namespace std;
int n,k;
int coins[1000005];
int main(void) {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL); cout.tie(NULL);

  cin >> n >> k;

  for(int i = 0; i<n;i++) {
    cin >> coins[i];
  }

  int count = 0;
  for(int i = n-1; i> -1;i--) {
    count += k/coins[i];
    k = k%coins[i];
  }

  cout << count;

} 