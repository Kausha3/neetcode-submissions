class TimeMap {

    Map<String, List<Pair>> hashmap;

    class Pair {
        private String value;
        private int timeStamp;

        Pair(String value, int timeStamp) {
            this.value = value;
            this.timeStamp = timeStamp;
        }

        public String getValue() {
            return this.value;
        }
        public int getTime() {
            return this.timeStamp;
        }
    }

    public TimeMap() {
        hashmap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {

        if (!hashmap.containsKey(key)) {
            hashmap.put(key, new ArrayList<>());
        }
        hashmap.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {

        List<Pair> val = hashmap.get(key);
        if (val == null) {
            return "";
        }

        int start = 0;
        int end = val.size() - 1;
        String str = "" ;

        while (start <= end) {
            int mid = start + ((end - start) / 2);

            if (val.get(mid).getTime() <= timestamp) {
                
                str = val.get(mid).getValue();
                 start = mid + 1;
            }
            else {
               
                end = mid - 1;
            }
        }
        return str;
    }
}
