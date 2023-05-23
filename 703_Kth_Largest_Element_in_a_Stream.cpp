/*
  https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
  
  Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

  Implement KthLargest class:

  KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
  int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.
*/

class KthLargest {
public:

    priority_queue<int, std::vector<int>, std::greater<int>> pq;
    int k_largest_element;
    
    KthLargest(int k, vector<int>& nums) {
        k_largest_element = k;
        for (int val : nums) {
            pq.push(val);
            if(pq.size() > k) {
                pq.pop();
            }
        }
    }
    
    int add(int val) {
        pq.push(val);
        if(pq.size() > k_largest_element) {
            pq.pop();
        }
        return pq.top();
    }
};

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest* obj = new KthLargest(k, nums);
 * int param_1 = obj->add(val);
 */
