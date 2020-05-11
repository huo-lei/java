package com.company;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class TopKFreq {
  private class Freq implements Comparable<Freq> {
    int e, freq;

    public Freq(int e, int freq) {
      this.e = e;
      this.freq = freq;
    }

    @Override
    public int compareTo(Freq o) {
      if (this.freq > o.freq) return 1;
      else if (this.freq < o.freq) return -1;
      else return 0;
    }
  }

  public int[] topKFrequent(int[] nums, int k) {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    for (int num : nums) {
      if (map.containsKey(num)) map.put(num, map.get(num) + 1);
      else map.put(num, 1);
    }
    PriorityQueue<Freq> pq = new PriorityQueue<>();
    for (int key : map.keySet()) {
      if (pq.size() < k) pq.add(new Freq(key, map.get(key)));
      else if (map.get(key) > pq.peek().freq) {
        pq.remove();
        pq.add(new Freq(key, map.get(key)));
      }
    }
    int[] res = new int[k];
    int i = 0;
    while (!pq.isEmpty()) {
      res[i] = pq.remove().e;
      i++;
    }
    return res;
  }
}
