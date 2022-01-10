package DataStructure;

import java.util.HashMap;
import java.util.TreeMap;

class TimeMap {

	HashMap<String, TreeMap<Integer, String>> map;

	public TimeMap() {
		map = new HashMap<>();
	}

	public void set(String key, String value, int timestamp) {
		if (!map.containsKey(key))
			map.put(key, new TreeMap<>());
		TreeMap<Integer, String> m = map.get(key);
		m.put(timestamp, value);
	}

	public String get(String key, int timestamp) {
		if (!map.containsKey(key))
			return "";

		TreeMap<Integer, String> m = map.get(key);
		if (m.containsKey(timestamp))
			return m.get(timestamp);

		Integer max_time = m.floorKey(timestamp);
		if (max_time == null)
			return "";
		return m.get(max_time);
	}
}
