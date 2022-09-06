#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

string s;

bool isPalindrome(string s) {
  int size = s.size();
  int mid = size / 2;
  for (int i = 0; i < mid; i++) {
    char left = s.at(i);
    char right = s.at(size - i - 1);
    if (left != right) return false;
  }
  return true;
}

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  cin >> s;
  cout << (isPalindrome(s) ? 1 : 0) << '\n';

  return 0;
}
