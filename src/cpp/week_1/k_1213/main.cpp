#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

string s, ret;
int sl;
string toString(vector<char> &v) {
  string tmp(v.begin(), v.end());
  return tmp;
}
bool isPalindrome(string tmp) {
  int mid = sl / 2;
  for (int i = 0; i < mid; i++) {
    char a = tmp.at(i);
    char b = tmp.at(sl - i - 1);
    if (a != b) return false;
  }
  return true;
}

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  //
  cin >> s;
  vector<char> v;
  sl = s.size();
  for (int i = 0; i < sl; i++) v.push_back(s.at(i));
  sort(v.begin(), v.end());

  do {
    string tmp = toString(v);
    if (isPalindrome(tmp)) {
      ret = tmp;
      break;
    }
  } while (next_permutation(v.begin(), v.end()));

  if (ret.size() != 0) {
    cout << ret << '\n';
  } else {
    cout << "I'm Sorry Hansoo" << '\n';
  }

  return 0;
}