#include <bits/stdc++.h>
using namespace std;

string s;

int main() {
  getline(cin, s);
  for (char ch : s) {
    char t = ch + 13;
    if (ch >= 65 && ch <= 90) {
      if (t > 90) t -= 26;
    } else if (ch >= 97 && ch <= 122) {
      if (t > 122) t -= 26;
    }
    cout << ch;
  }
  return 0;
}