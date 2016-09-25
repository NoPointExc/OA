void giveMoney(vector<int> &nums) {
    int n = nums.size();
    int sum = 0;
    for (int i : nums)
	sum += i;
    for (int i = 1; i < n; ++ i) {
	int cur = (n * nums[i] - sum) * 1.0 / n;
	cout << "gives " << i << " $" << cur << endl;
    }
}
