#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main()
{
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  string dopa = "life is limited";

  cout << dopa.substr(0, 3) << '\n';

  reverse(dopa.begin(), dopa.end());
  cout << dopa << '\n';

  dopa.append("dopa!!");
  cout << dopa << '\n';

  return 0;
}