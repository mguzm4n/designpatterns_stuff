package Strategy;

import java.util.List;

public interface FactorizationStrategy {
    void execute(double[][] M);
    List<double[][]> getResults();
}
