class Solution {
    public String decodeString(String s) {
        if (s == "" || s.length() == 0) return "";

		Stack<Integer> count = new Stack<>();
		Stack<String> stringBuilt = new Stack<>();
		
		int currNumber = 0;
		String currString = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '[') {
				count.push(currNumber);
				stringBuilt.push(currString);
				currNumber = 0;
				currString = "";
			}
			else if (s.charAt(i) == ']') {
				int prevCount = count.pop();
				String prevString = stringBuilt.pop();
				StringBuilder sb = new StringBuilder();
                sb.append(prevString);
				while (prevCount > 0) {
					sb.append(currString);
					prevCount--;
				}
				currString = sb.toString();
			}
			else if (Character.isDigit(s.charAt(i))) {
				currNumber = currNumber * 10 + (s.charAt(i) - '0');
			}
			else {
				currString += s.charAt(i);
			}
		}
        return currString;
    }
}