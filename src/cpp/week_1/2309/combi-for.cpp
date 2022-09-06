#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int sum, arr[9];

void check() {
  for (int i = 0; i < 9; i++) {
    int a = arr[i];
    for (int j = i + 1; j < 9; j++) {
      int b = arr[j];
      if (sum - (a + b) == 100) {
        arr[i] = -1;
        arr[j] = -1;
        return;
      }
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

  check();
  sort(arr, arr + 9);

  for (int i = 2; i < 9; i++) cout << arr[i] << '\n';

  return 0;
}