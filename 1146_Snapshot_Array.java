/*
Implement a SnapshotArray that supports the following interface:

SnapshotArray(int length) initializes an array-like data structure with the given length. Initially, each element equals 0.
void set(index, val) sets the element at the given index to be equal to val.
int snap() takes a snapshot of the array and returns the snap_id: the total number of times we called snap() minus 1.
int get(index, snap_id) returns the value at the given index, at the time we took the snapshot with the given snap_id
*/
class SnapshotArray {

    private int snapId;   
    private TreeMap<Integer, ArrayList> snapArray;   

    public SnapshotArray(int length) {
        snapId = 0;        
        snapArray = new TreeMap<>(); 
        for (int i = 0 ; i < length; ++i) {
            snapArray.put(i, new ArrayList<>());
        }       
    }
    
    public void set(int index, int val) {   
        int []data = new int[2];
        data[0] = snapId;
        data[1] = val;
        snapArray.get(index).add(data);
    }
    
    public int snap() {        
        return snapId++;
    }
    
    public int get(int index, int snap_id) {
        ArrayList<int []> data = snapArray.get(index);
        int left = 0; 
        int right = data.size() - 1;
        int ans = Integer.MAX_VALUE;
        while(left <= right) {
            int mid = left + (right - left) / 2;           
            int currentSnapID = data.get(mid)[0];           
            if (currentSnapID <= snap_id) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }        
        return ans != Integer.MAX_VALUE ? data.get(ans)[1] : 0;      
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
