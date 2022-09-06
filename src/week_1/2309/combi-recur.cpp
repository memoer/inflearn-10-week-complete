#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int arr[9];
vector<int> v;

/*
1. 고민 -> 1~2시간
  1. 최소, 최대 범위 확인
  2. 일단 무식하게 풀어라. 여기서 중요한 건, 시간복잡도를 빠르게 파악하는 것
  3. 시간 복잡도가 안되거나 (or) 단순 구현 문제가 아니라면", 다른 여러 알고리즘을 생각한다.
2. 문제 풀이
3. 답지 보고 확인
  - 틀렸으면, 일주일 내내 해당 문제를 처음부터 풀기 [이 문제를 처음 봤을 때, 30분 내에 풀 정도로]
*/
void print(vector<int> v) {
  sort(v.begin(), v.end());
  for (int i : v) cout << i << '\n';
}
void combi(int start, int sum) {
  if (v.size() == 7) {
    if (sum == 100) {
      print(v);
      exit(0);
    }
    return;
  }

  for (int i = start; i < 9; i++) {
    v.push_back(arr[i]);
    combi(i + 1, sum + arr[i]);
    v.pop_back();
  }
}
// O(45)
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  // 9
  for (int i = 0; i < 9; i++) cin >> arr[i];

  // 9C7 -> 9C2 -> 36
  combi(0, 0);

  return 0;
}