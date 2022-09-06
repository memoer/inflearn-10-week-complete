#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int sum, arr[9];
vector<int> result;

pair<int, int> combi() {
  for (int i = 0; i < 9; i++) {
    int a = arr[i];
    for (int j = i + 1; j < 9; j++) {
      int b = arr[j];
      if (sum - (a + b) == 100) return {i, j};
    }
  }
}

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  for (int i = 0; i < 9; i++) {
    cin >> arr[i];
    sum += arr[i];
  }

  pair<int, int> e = combi();
  for (int i = 0; i < 9; i++) {
    if (e.first == i || e.second == i) continue;
    result.push_back(arr[i]);
  }
  sort(result.begin(), result.end());
  for (int i : result) cout << i << '\n';

  return 0;
}