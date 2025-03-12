// Time Complexity : O(1) for all operations.
// Space Complexity : O(B+N) = O(n) B:buckets, N:BucketList   
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
// I used 2D array for this problem as the range of keys is 10^6 so we can distribute max. 1000 elements in each bucket. By applying Double hahsing technique i will place each key into our bucketList i.e column of the 2D array.

class MyHashSet {
    int buckets = 1000;
    int bucketList = 1000;
    boolean arr[][] = new boolean[buckets][];

    public MyHashSet() {
    }
    
    public int primaryIndex(int key){
        return key%1000;
    }

    public int secondaryIndex(int key){
        return key/1000;
    }

    public void add(int key) {
        int primaryIndex = primaryIndex(key);
        int secondaryIndex = secondaryIndex(key);

        if(arr[primaryIndex] == null){
            arr[primaryIndex] = new boolean[bucketList + 1]; 
        }

        arr[primaryIndex][secondaryIndex] = true;

    }
    
    public void remove(int key) {
        
        int primaryIndex = primaryIndex(key);
        int secondaryIndex = secondaryIndex(key);

        if(arr[primaryIndex] == null) return;
        arr[primaryIndex][secondaryIndex] = false;
    }
    
    public boolean contains(int key) {
        
        int primaryIndex = primaryIndex(key);
        int secondaryIndex = secondaryIndex(key);

     return arr[primaryIndex] != null && arr[primaryIndex][secondaryIndex];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
