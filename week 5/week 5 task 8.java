class Solution {

    public List<String> findAndReplacePattern(String[] words, String pattern) {

        List<String> result = new ArrayList<>();

        for (String word : words) {

            if (matches(word, pattern)) {
                result.add(word);
            }
        }

        return result;
    }

    private boolean matches(String word, String pattern) {

        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> used = new HashSet<>();

        for (int i = 0; i < pattern.length(); i++) {

            char p = pattern.charAt(i);
            char w = word.charAt(i);

            // Pattern character already has a mapping
            if (map.containsKey(p)) {

                if (map.get(p) != w) {
                    return false;
                }

            } else {

                // Another pattern character is already mapped to this word character
                if (used.contains(w)) {
                    return false;
                }

                map.put(p, w);
                used.add(w);
            }
        }

        return true;
    }
}