//
//import org.junit.Test;
//
//import java.util.ArrayList;
//
//import static org.junit.Assert.*;
//import static org.junit.Assert.assertTrue;
//import java.util.*;
//
//public class DS4_HashTable_Tests {
//
//    // 1
//    @Test
//    public void testInsertAndContains() {
//        DS4_HashTable<Integer, String> ht = new DS4_HashTable<>(2, 8, 4);
//        assertFalse(ht.contains(1));
//        ht.insert(1, "A");
//        ht.insert(2, "B");
//        assertTrue(ht.contains(1));
//        assertTrue(ht.contains(2));
//        assertEquals(2, ht.size());
//        assertEquals(0, ht.tombstones());
//    }
//
//    // 2
//    @Test
//    public void testReplaceReturnsOldValue() {
//        DS4_HashTable<String, String> ht = new DS4_HashTable<>(2, 8, 4);
//        assertNull(ht.insert("k", "one"));
//        assertEquals("one", ht.insert("k", "two"));
//        assertTrue(ht.contains("k"));
//        assertEquals(1, ht.size());
//        assertEquals(0, ht.tombstones());
//    }
//
//    // 3
//    @Test
//    public void testRemoveCreatesTombstone() {
//        DS4_HashTable<Integer, String> ht = new DS4_HashTable<>(2, 8, 4);
//        ht.insert(10, "X");
//        ht.insert(20, "Y");
//        assertEquals("X", ht.remove(10));
//        assertFalse(ht.contains(10));
//        assertEquals(1, ht.size());
//        assertEquals(1, ht.tombstones());
//    }
//
//    // 4
//    @Test
//    public void testEarlyStopRule() {
//        DS4_HashTable<Integer, String> ht = new DS4_HashTable<>(3, 10, 8);
//        ht.insert(9999, "X");
//        assertFalse(ht.contains(123));
//        assertNull(ht.remove(123));
//    }
//
//    // 5
//    @Test
//    public void testLinearRehashingAcrossBuckets() {
//        DS4_HashTable<Integer, String> ht = new DS4_HashTable<>(1, 20, 4);
//        int base = 4000;
//        int k1 = base;
//        int k2 = base + 4;
//        int k3 = base + 8;
//        ht.insert(k1, "A");
//        ht.insert(k2, "B");
//        ht.insert(k3, "C");
//        assertTrue(ht.contains(k1));
//        assertTrue(ht.contains(k2));
//        assertTrue(ht.contains(k3));
//        assertEquals(3, ht.size());
//    }
//
//    // 6
//    @Test
//    public void testIteratorSnapshot() {
//        DS4_HashTable<String, Integer> ht = new DS4_HashTable<>(2, 10, 4);
//        ht.insert("a", 1);
//        ht.insert("b", 2);
//        ht.insert("c", 3);
//
//        Iterator<String> it = ht.iterator();
//        // mutate after obtaining iterator
//        ht.insert("d", 4);
//
//        HashSet<String> keys = new HashSet<>();
//        it.forEachRemaining(keys::add);
//
//        assertEquals(Set.of("a","b","c"), keys);
//        assertTrue(ht.contains("d"));
//    }
//
//    // 7
//    @Test
//    public void testRebuildOnLoadFactorExceeded() {
//        DS4_HashTable<Integer, Integer> ht = new DS4_HashTable<>(1, 3, 2);
//        ht.insert(1, 10);
//        ht.insert(2, 20);
//        ht.insert(3, 30); // should trigger rebuild
//        assertTrue(ht.contains(1));
//        assertTrue(ht.contains(2));
//        assertTrue(ht.contains(3));
//        assertEquals(3, ht.size());
//        ht.insert(4, 40);
//        ht.insert(5, 50);
//        ht.insert(6, 60);
//        assertTrue(ht.contains(6));
//    }
//
//    // 8
//    @Test
//    public void testSizeExcludesTombstones() {
//        DS4_HashTable<Integer, String> ht = new DS4_HashTable<>(2, 8, 4);
//        ht.insert(1, "A");
//        ht.insert(2, "B");
//        ht.insert(3, "C");
//        assertEquals(3, ht.size());
//
//        ht.remove(2);
//        assertEquals(2, ht.size());
//        assertEquals(1, ht.tombstones());
//    }
//
//    // 9
//    @Test
//    public void testClear() {
//        DS4_HashTable<Integer, String> ht = new DS4_HashTable<>(2, 8, 4);
//        ht.insert(1, "A");
//        ht.insert(2, "B");
//        ht.remove(1);
//        assertEquals(1, ht.tombstones());
//        ht.clear();
//        assertEquals(0, ht.size());
//        assertEquals(0, ht.tombstones());
//        assertFalse(ht.contains(1));
//        assertFalse(ht.contains(2));
//    }
//
//    // 10
//    @Test
//    public void testRemoveNonexistentEarlyStop() {
//        DS4_HashTable<Integer, String> ht = new DS4_HashTable<>(2, 10, 8);
//        ht.insert(100, "X");
//        assertNull(ht.remove(200)); // bucket for 200 not at capacity → early stop
//    }
//
//    // 11
//    @Test
//    public void testInsertDoesNotFillTombstoneHole() {
//        DS4_HashTable<Integer, String> ht = new DS4_HashTable<>(1, 10, 4);
//        // Force one bucket to have 1 element capacity and then tombstone it
//        int k1 = 4;     // hashes to bucket 0 (depends on tableSize=4)
//        int k2 = 8;     // same bucket
//        ht.insert(k1, "A");           // bucket 0: [A]
//        assertEquals("A", ht.remove(k1)); // bucket 0: [null] (tombstone)
//        // Since capacity is 1, bucket.size()==1 (==capacity), so inserting k2 goes to next bucket
//        ht.insert(k2, "B");
//        assertTrue(ht.contains(k2));
//        assertEquals(1, ht.tombstones());
//    }
//
//    // 12
//    @Test
//    public void testReplaceDoesNotChangeCounts() {
//        DS4_HashTable<String, Integer> ht = new DS4_HashTable<>(2, 10, 4);
//        ht.insert("x", 1);
//        assertEquals(1, ht.size());
//        assertEquals(0, ht.tombstones());
//        ht.insert("x", 2);
//        assertEquals(1, ht.size());
//        assertEquals(0, ht.tombstones());
//    }
//
//    // 13
//    @Test
//    public void testMultipleTombstonesThenRebuildClearsTombstones() {
//        DS4_HashTable<Integer, Integer> ht = new DS4_HashTable<>(1, 4, 4);
//        ht.insert(1, 1);
//        ht.insert(2, 2);
//        ht.insert(3, 3);
//        // Remove two to create tombstones
//        ht.remove(1);
//        ht.remove(2);
//        assertEquals(2, ht.tombstones());
//        // Next insert should push (size + tombstones) to loadFactor and trigger cleanup + rebuild
//        ht.insert(4, 4);
//        // After rebuild tombstones should be 0
//        assertEquals(0, ht.tombstones());
//    }
//
//    // 14
//    @Test
//    public void testIteratorExcludesTombstones() {
//        DS4_HashTable<Integer, String> ht = new DS4_HashTable<>(2, 10, 4);
//        ht.insert(1, "A");
//        ht.insert(2, "B");
//        ht.remove(1);
//        List<Integer> keys = new ArrayList<>();
//        Iterator<Integer> it = ht.iterator();
//        while (it.hasNext()) keys.add(it.next());
//        assertEquals(List.of(2), keys);
//    }
//
//    // 15
//    @Test
//    public void testWrapAroundProbing() {
//        DS4_HashTable<Integer, String> ht = new DS4_HashTable<>(1, 10, 3); // small table
//        int a = 3;  // mod 0
//        int b = 6;  // mod 0
//        int c = 9;  // mod 0
//        ht.insert(a, "A"); // bucket 0
//        ht.insert(b, "B"); // bucket 1
//        ht.insert(c, "C"); // bucket 2 (wrap after next)
//        assertTrue(ht.contains(a));
//        assertTrue(ht.contains(b));
//        assertTrue(ht.contains(c));
//        assertEquals(3, ht.size());
//    }
//
//    // 16
//    @Test
//    public void testNullKeyThrows() {
//        DS4_HashTable<String, String> ht = new DS4_HashTable<>(2, 10, 4);
//        assertThrows(NullPointerException.class, () -> ht.contains(null));
//        assertThrows(NullPointerException.class, () -> ht.insert(null, "x"));
//        assertThrows(NullPointerException.class, () -> ht.remove(null));
//    }
//
//    // 17
//    @Test
//    public void testRebuildPreservesAllMappings() {
//        DS4_HashTable<Integer, String> ht = new DS4_HashTable<>(1, 3, 2);
//        Map<Integer,String> map = new HashMap<>();
//        for (int i = 0; i < 20; i++) {
//            map.put(i, "V"+i);
//            ht.insert(i, "V"+i);
//        }
//        for (int i = 0; i < 20; i++) {
//            assertTrue(ht.contains(i));
//        }
//        for (int i = 0; i < 20; i++) {
//            int k = i;
//            assertEquals(map.get(k), ht.remove(k));
//        }
//        assertEquals(0, ht.size());
//    }
//
//    // 18
//    @Test
//    public void testRemoveThenContainsChainStillFindsLaterKey() {
//        DS4_HashTable<Integer, String> ht = new DS4_HashTable<>(1, 20, 4);
//        int b = 8, c = 12, d = 16; // all mod 0 with tableSize 4
//        ht.insert(b, "B"); // bucket 0
//        ht.insert(c, "C"); // bucket 1
//        ht.insert(d, "D"); // bucket 2
//        // Remove middle to create tombstone but bucket sizes are 1, so capacities matter at buckets 0 and 1
//        assertEquals("C", ht.remove(c));
//        // contains(d) must still probe past bucket 1 (which is at capacity size=1) to bucket 2
//        assertTrue(ht.contains(d));
//    }
//
//    // 19
//    @Test
//    public void testRemoveNonExistentWithFullFirstBucketContinues() {
//        DS4_HashTable<Integer, String> ht = new DS4_HashTable<>(1, 10, 4);
//        int a = 4, b = 8; // same start bucket
//        ht.insert(a, "A"); // bucket full at capacity 1
//        assertNull(ht.remove(12)); // not found; first bucket full so we probe next bucket (which is empty)
//        assertTrue(ht.contains(a));
//    }
//
//    // 20
//    @Test
//    public void testInsertReturnNullWhenNoReplacement() {
//        DS4_HashTable<Integer, Integer> ht = new DS4_HashTable<>(2, 10, 4);
//        assertNull(ht.insert(1, 100));
//        assertNull(ht.insert(2, 200));
//        assertEquals(2, ht.size());
//    }
//
//    // 21
//    @Test
//    public void testMultipleReplacements() {
//        DS4_HashTable<String, String> ht = new DS4_HashTable<>(2, 10, 4);
//        assertNull(ht.insert("k", "v1"));
//        assertEquals("v1", ht.insert("k", "v2"));
//        assertEquals("v2", ht.insert("k", "v3"));
//        assertEquals(1, ht.size());
//        assertTrue(ht.contains("k"));
//    }
//
//    // 22
//    @Test
//    public void testTombstonesAccumulateThenResetAfterRebuild() {
//        DS4_HashTable<Integer, Integer> ht = new DS4_HashTable<>(1, 6, 4);
//        for (int i = 0; i < 6; i++) ht.insert(i, i);
//        // Remove a few
//        ht.remove(0);
//        ht.remove(2);
//        assertTrue(ht.tombstones() >= 2);
//        // Insert more to trigger rebuild
//        ht.insert(100, 100);
//        ht.insert(101, 101);
//        ht.insert(102, 102);
//        assertEquals(0, ht.tombstones());
//    }
//
//    // 23
//    @Test
//    public void testIteratorContainsAllKeysNoDuplicates() {
//        DS4_HashTable<Integer, Integer> ht = new DS4_HashTable<>(2, 50, 16);
//        Set<Integer> inserted = new HashSet<>();
//        for (int i = 0; i < 40; i++) {
//            inserted.add(i);
//            ht.insert(i, i);
//        }
//        List<Integer> keys = new ArrayList<>();
//
//        Iterator<Integer> it = ht.iterator();
//        while (it.hasNext()) keys.add(it.next());
//        assertEquals(inserted.size(), new HashSet<>(keys).size());
//        assertTrue(new HashSet<>(keys).containsAll(inserted));
//    }
//
//    // 24
//    @Test
//    public void testClearThenReuse() {
//        DS4_HashTable<Integer, String> ht = new DS4_HashTable<>(2, 8, 4);
//        ht.insert(1, "A");
//        ht.insert(2, "B");
//        ht.clear();
//        ht.insert(3, "C");
//        assertFalse(ht.contains(1));
//        assertTrue(ht.contains(3));
//        assertEquals(1, ht.size());
//    }
//
//    // 25
//    @Test
//    public void testInsertLargeVolume() {
//        DS4_HashTable<Integer, Integer> ht = new DS4_HashTable<>(2, 20, 8);
//        for (int i = 0; i < 1000; i++) {
//            ht.insert(i, i*i);
//        }
//        for (int i = 0; i < 1000; i+=37) {
//            assertTrue(ht.contains(i));
//            assertEquals(i*i, ht.remove(i).intValue());
//        }
//        assertEquals("Remaining size should match removals",1000 - (1000/37 + (1000%37==0?0:1)), ht.size() );
//    }
//}
