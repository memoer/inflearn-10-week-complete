#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int n;
int board[64][64];
pair<int, int> mv[] = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
/**
 * 1. 고민 -> 1~2시간
 * 2. 문제 풀이
 * 3. 답지 확인
 *    - 틀렸으면, 해당 문제 일주일 내내 처음부터 풀기 [처음 볼 때 30분 내로 풀 수 있을 정도로]
 */
string make(string s) { return s == "1111" ? "1" : s == "0000" ? "0" : "(" + s + ")"; }

string quard(int sy, int sx, int n) {
  if (n == 2) {
    string s;
    for (pair<int, int> p : mv) s += board[sy + p.first][sx + p.second] ? "1" : "0";
    return make(s);
  }
  int mid = n / 2;
  string a = quard(sy, sx, mid);              // 왼쪽 위
  string b = quard(sy, sx + mid, mid);        // 오른쪽 위
  string c = quard(sy + mid, sx, mid);        // 왼쪽 아래
  string d = quard(sy + mid, sx + mid, mid);  // 오른쪽 아래
  return make(a + b + c + d);
}

int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) scanf("%1d", &board[i][j]);
  }

  string ans = quard(0, 0, n);
  cout << ans << '\n';

  return 0;
}