class Solution {

    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();
        for (String s: strs) {
            str.append(s.length() + "#" + s);
        }
        return str.toString();
    }

    public List<String> decode(String str) {
        int i = 0;
        List<String> res = new ArrayList<>();

        while (i < str.length()) {
            int j = i + 1;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));

            String st = str.substring(j + 1, j + 1 + length);
            res.add(st);
            i = j + 1 + length;
        }
        return res;
    }
}
