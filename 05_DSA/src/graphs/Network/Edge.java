package graphs.Network;

public class Edge {
    int from, to;
    long flow, capacity;
    Edge residual;

    public Edge(int from, int to, long capacity) {
        this.from = from;
        this.to = to;
        this.capacity = capacity;
        this.flow = 0;
    }

    public long remainingCapacity() {
        return capacity - flow;
    }

    public void augment(long bottleNeck) {
        flow += bottleNeck;
        residual.flow -= bottleNeck;
    }

    public boolean isResidual() {
        return capacity == 0;
    }

    @Override
    public String toString() {
        return String.format("%d -> %d | flow = %d, cap = %d", from, to, flow, capacity);
    }
}
