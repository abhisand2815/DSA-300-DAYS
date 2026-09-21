# 3524. Find X Value of Array I

**Difficulty:** Medium
**Topics:** Array, Math, Dynamic Programming

## Problem Statement

Given an array of positive integers `nums` and a positive integer `k`, an operation removes any non-overlapping prefix and suffix from `nums` such that the remaining array is non-empty. Either the prefix or the suffix may be empty.

The x-value of `nums` is the number of ways to perform this operation so that the product of the remaining elements leaves remainder `x` when divided by `k`.

Return an array `result` of size `k`, where `result[x]` is the x-value of `nums` for `0 <= x <= k - 1`.

## Examples

| Input | Output |
| --- | --- |
| `nums = [1,2,3,4,5], k = 3` | `[9,2,4]` |
| `nums = [1,2,4,8,16,32], k = 4` | `[18,1,2,0]` |
| `nums = [1,1,2,1,1], k = 2` | `[9,6]` |

## Constraints

- `1 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^9`
- `1 <= k <= 5`

## Approach

Removing a prefix and a suffix is equivalent to choosing a non-empty contiguous subarray. The task reduces to counting, for each remainder `r`, how many subarrays have a product congruent to `r` modulo `k`.

Since `k <= 5`, a DP over remainders is sufficient:

1. Let `cnt[r]` be the number of subarrays ending at the previous index whose product mod `k` equals `r`.
2. For a new element `a`, each such subarray extended by `a` moves from remainder `r` to `(r * (a % k)) % k`.
3. The single-element subarray `[a]` contributes one count to remainder `a % k`.
4. Add the resulting counts for the current index to the global `result`.

Each index is processed in `O(k)`, and every subarray is counted exactly once, at its right endpoint.

## Complexity

- **Time:** `O(n * k)`
- **Space:** `O(k)`

## Notes

- Counts can reach `n * (n + 1) / 2` (about 5 * 10^9), so `long` is required.
- Reducing `a` modulo `k` up front avoids overflow in `r * m`.
