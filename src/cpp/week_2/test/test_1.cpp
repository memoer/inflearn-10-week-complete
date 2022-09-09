#include <bits/stdc++.h>
using namespace std;
int a[1004][1004];
const int dy[] = {-1, 0, 1, 0};
const int dx[] = {0, 1, 0, -1};
int main() {
  int y = 1;
  int x = 1;
  for (int i = 0; i < 4; i++) {
    int ny = y + dy[i];
    int nx = x + dx[i];
    cout << ny << " : " << nx << '\n';
  }
  return 0;
}
