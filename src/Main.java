public class Main {
    public static void main(String[] args) {
        int[][] adjacencies = {
                { 1, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 1 }
        };
        AdjacencyMatrix A = new AdjacencyMatrix(adjacencies);

        A.show();
        A.exp(2).show();
    }
}
