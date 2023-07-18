/*
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity. 
*/

class LRUCache {
public:
    int cap ;
    unordered_map<int,pair<int, list<int>::iterator>> cache;
    list<int> dll;

    LRUCache(int capacity) {
        ios_base::sync_with_stdio(false);
        cin.tie(nullptr);
        cout.tie(nullptr);
        cap = capacity;
    }
    
    int get(int key) {        
        if(cache.find(key) != cache.end()) {
            dll.erase(cache[key].second);
            dll.push_back(key);
            cache[key].second = prev(dll.end());
            return cache[key].first;
        }
        return -1;
    }
    
    void put(int key, int value) {
        if(cache.find(key) == cache.end() && cache.size() == cap) {
            cache.erase(*dll.begin());
            dll.erase(dll.begin());            
        } else if (cache.find(key) != cache.end()) {
            dll.erase(cache[key].second);
        }
        dll.push_back(key);
        cache[key] = make_pair(value, prev(dll.end()));       
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */
