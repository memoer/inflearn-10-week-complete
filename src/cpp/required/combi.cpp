#include <bits/stdc++.h>
using namespace std;
int n = 5, k = 3;

void combi(int start, vector<int> b) {
  if (b.size() == k) {
    // logic
    return;
  }

  for (int i = start; i < n; i++) {
    b.push_back(i);
    combi(i + 1, b);
    b.pop_back();
  }
}
int main() {
  vector<int> b;
  combi(0, b);
  return 0;
}