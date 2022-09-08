#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
/**
 * 1. 고민 -> 1~2시간
 * 2. 풀이
 *    1. 최대/최소 범위 확인
 *    2. 일단 무식하게 푼다. 중요한 건 시간 복잡도 파악
 *      - 반례 파악 중요!
 *    3. 시간 복잡도가 안되거나, 단순 구현이 아니라면, 다른 알고리즘 생각
 * 3. 답지 확인
 *    - 틀렸으면, 해당 문제 일주일 내내 복기 [처음 볼 때 30분 내로 풀수 있을 정도로]
 */
/**
 * 측정한 온도가 어떤 정수의 수열로 주어짐. 연속적인 며칠 동안의 온도의 합이 가장 큰 값을 알아낼 것
 * Ex) 이틀간의 온도의 합은 배열에서 연속적으로 2개를 합친 값들 중, 최대 큰 값을 구한다.
 * Ex) 5일간의 온도의 합은 배열에서 연속적으로 2개를 합친 값들 중, 최대 큰 값을 구한다.
 */
/**
 * N -> 정수의 개수 [2 <= N <= 100,000]
 * K -> 합을 구하기 위한 연속적인 날짜의 수 [1 <= K <= N]
 * -100 <= 온도 <= 100
 */
int n, k, ret = INT_MIN;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  //
  cin >> n >> k;
  int psum[n + 1];
  psum[0] = 0;
  for (int i = 1; i <= n; i++) {
    cin >> psum[i];
    psum[i] += psum[i - 1];
  }

  for (int i = k; i <= n; i++) ret = max(ret, psum[i] - psum[i - k]);

  cout << ret << '\n';
  return 0;
}