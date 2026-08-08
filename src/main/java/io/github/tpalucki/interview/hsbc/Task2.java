/**
 * Print the tree like:
 *
 * 1
 * 0 1
 * 1 0 1
 * 0 1 0 1
 * 1 0 1 0 1
 * 0 1 0 1 0 1
 * ...
 *
 * It should depend on the input n meaning number of rows to print
 */
void main() {

    int n = 10;

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= n; i++) {
        var current = i % 2;

        sb.insert(0, " " + current);
        IO.println(sb.toString());
    }

}