
class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();
        boolean[] visited = new boolean[strs.length];

        for (int i = 0; i < strs.length; i++) {

            if (visited[i])
                continue;

            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            visited[i] = true;

            for (int j = i + 1; j < strs.length; j++) {

                if (!visited[j] && isAnagram(strs[i], strs[j])) {
                    group.add(strs[j]);
                    visited[j] = true;
                }
            }

            result.add(group);
        }

        return result;
    }

    public boolean isAnagram(String a, String b) {

        if (a.length() != b.length())
            return false;

        char[] x = a.toCharArray();
        char[] y = b.toCharArray();

        Arrays.sort(x);
        Arrays.sort(y);

        for (int i = 0; i < x.length; i++) {
            if (x[i] != y[i]) {
                return false;
            }
        }

        return true;
    }
}