#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int arr[10], psum[10], diff, x[2], result[7];

// O(110)
int main()
{
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  // 10
  for (int i = 1; i < 10; i++)
  {
    cin >> arr[i];
    psum[i] = psum[i - 1] + arr[i];
  }
  diff = psum[9] - 100;

  // 100
  for (int i = 1; i < 10; i++)
  {
    for (int j = 1; j < 10; j++)
    {
      if (diff == arr[i] + arr[j])
      {
        x[0] = i;
        x[1] = j;
      }
    }
  }

  int idx = 0;
  for (int i = 1; i < 10; i++)
  {
    if (find(x, x + 2, i) == x + 2)
    {
      result[idx++] = arr[i];
    }
  }
  sort(result, result + 7);

  for (int i = 0; i < 7; i++)
  {
    cout << result[i] << '\n';
  }

  return 0;
}