#include <iostream>
using namespace std;

bool han(int n) {
	if (n < 100)
		return true;
	int a, b, c;
	a = n / 100;
	b = n % 100 /10;
	c = n % 10 ;

	if (a - b == b - c) {
		return true;
	}
	else
		return false;
}

int main() {
	int n, count = 0;
	cin >> n;
	for (int i = 1; i < n+1; i++) {
		if (han(i))
			count++;
	}

	cout << count;
	return 0;
}