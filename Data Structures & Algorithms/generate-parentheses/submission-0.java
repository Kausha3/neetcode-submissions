class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backTrack(result, n, n, new StringBuilder());
        return result;
    }

    private void backTrack(List<String> result, int open, int closed, StringBuilder str) {
        if (open == 0 && closed == 0) {
            result.add(str.toString()); 
            
            return;
        }
        if (closed == open) {
            backTrack(result, open - 1, closed, str.append("("));
            str.deleteCharAt(str.length() - 1);
        }
        else if(open < closed && open != 0) {
            backTrack(result, open - 1, closed, str.append("("));
            str.deleteCharAt(str.length() - 1);
            backTrack(result, open , closed - 1, str.append(")"));
            str.deleteCharAt(str.length() - 1);
        }
        else if (open == 0 && closed != 0) {
            backTrack(result,open , closed - 1, str.append(")"));
            str.deleteCharAt(str.length() - 1);
        }
    }
}
