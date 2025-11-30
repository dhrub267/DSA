class Solution {
    static class State {
        int len, link;
        int next[] = new int[26];

        State() {
            link = -1;
        }
    }

    public static int countSubs(String s) {
        int n = s.length();
        State st[] = new State[2 * n];
        for (int i = 0; i < 2 * n; i++) st[i] = new State();

        int last = 0, size = 1;
        long result = 0;

        for (char ch : s.toCharArray()) {
            int c = ch - 'a';
            int cur = size++;
            st[cur].len = st[last].len + 1;

            int p = last;
            while (p != -1 && st[p].next[c] == 0) {
                st[p].next[c] = cur;
                p = st[p].link;
            }
            if (p == -1) {
                st[cur].link = 0;
            } else {
                int q = st[p].next[c];
                if (st[p].len + 1 == st[q].len) {
                    st[cur].link = q;
                } else {
                    int clone = size++;
                    st[clone].len = st[p].len + 1;
                    st[clone].next = st[q].next.clone();
                    st[clone].link = st[q].link;

                    while (p != -1 && st[p].next[c] == q) {
                        st[p].next[c] = clone;
                        p = st[p].link;
                    }
                    st[q].link = st[cur].link = clone;
                }
            }
            last = cur;
        }

        // Count distinct substrings
        for (int i = 1; i < size; i++) {
            result += st[i].len - st[st[i].link].len;
        }
        return (int) result;
    }
}
