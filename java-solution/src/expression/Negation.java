package expression;

import java.util.Objects;

public class Negation implements Expression{

    private Expression negated;

    public Negation(Expression negated) {
        this.negated = negated;
    }

    public Expression getNegated() {
        return negated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Negation negation = (Negation) o;
        return Objects.equals(negated, negation.negated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(negated);
    }

    @Override
    public String toTree() {
        return "(!" + negated.toTree() + ")";
    }

    @Override
    public String toString() {
        return "!" + negated.toString();
    }
}
