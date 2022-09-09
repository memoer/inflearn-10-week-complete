#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
// 숫자는 N개로 이루어진 수열, 모두 C보다 작거나 같다. -> 이 숫자를 자주 등장하는 빈도순대로 정렬
//    - 두 수 X,Y 있으면, 자주 등장하는 X가 더 앞 / 획수가 같다면 먼저 나온 것이 앞
// 1 <= N <= 1,000 / 1 <= C <= 1,000,000,000
int n, c, idx = 0;
struct Data {
  int idx;
  int cnt;
};
bool cmp(const pair<int, Data> &a, const pair<int, Data> &b) {
  if (a.second.cnt != b.second.cnt) return a.second.cnt > b.second.cnt;
  return a.second.idx < b.second.idx;
}
map<int, Data> mp;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  //
  cin >> n >> c;
  for (int i = 0; i < n; i++) {
    int temp;
    cin >> temp;
    auto s = mp.find(temp);
    if (s == mp.end()) {
      mp[temp].idx = idx++;
      mp[temp].cnt += 1;
    } else {
      mp[temp].cnt += 1;
    }
  }
  vector<pair<int, Data>> v(mp.begin(), mp.end());
  sort(v.begin(), v.end(), cmp);

  for (pair<int, Data> p : v) {
    for (int i = 0; i < p.second.cnt; i++) {
      cout << p.first << " ";
    }
  }

  return 0;
}