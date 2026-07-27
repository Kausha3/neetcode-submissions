class Pair<T, U> {
    private T first;
    private U second;

    Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getValue() {
        return this.first;
    }

    public U getIndex() {
        return this.second;
    }
}
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] res = new int[length];
        Stack<Pair<Integer, Integer>> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && stack.peek().getValue() < temperatures[i]) {
                int prevIndex = stack.pop().getIndex();
                res[prevIndex] = i - prevIndex;
            }
            stack.push(new Pair<Integer, Integer>(temperatures[i], i));
        }
        return res;
    }
}
