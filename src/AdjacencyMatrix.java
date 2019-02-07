public class AdjacencyMatrix extends Matrix {
    public final int totalPaths = findTotalPaths();
    public final int size = (this.M == this.N) ? this.M : 0;

    public AdjacencyMatrix(int[][] data) throws IllegalArgumentException {
        super(data);
        if (this.M != this.N) throw new IllegalArgumentException("Nonsquare matrix illegal.");
    }

    private AdjacencyMatrix(int size) {
        super(size, size);
    }

    private int findTotalPaths() {
        int sum = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                sum += this.data[i][j];
            }
        }

        return sum;
    }

    private AdjacencyMatrix times(AdjacencyMatrix B) {
        AdjacencyMatrix A = this;
        AdjacencyMatrix C = new AdjacencyMatrix(size);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    C.data[i][j] += (A.data[i][k] * B.data[k][j]);
                }
            }
        }

        return C;
    }

    public AdjacencyMatrix exp(int n){
        return (n > 1) ? this.times(this.exp(n - 1)) : this;
    }
}
