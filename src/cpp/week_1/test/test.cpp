#include <bits/stdc++.h>
using namespace std;

// 수의 개수 -> N
// 합을 구해야 하는 횟수 -> M
int n, m, arr[100004], psum[100004];
int a, b;
int main(){
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  cin >> n >> m;
  int arr[n];
  for (int i = 1; i <= n; i++)
  {
    cin >> arr[i];
    psum[i] = psum[i - 1] + arr[i];
  }

  for (int i = 0; i < m; i++)
  {
    cin >> a >> b;
    cout << psum[b] - psum[a - 1] << '\n';
  }

  return 0;
}
