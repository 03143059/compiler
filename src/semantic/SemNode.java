package semantic;

public abstract class SemNode {
    protected String type = null;
    public String getType() { return type; }
    public abstract boolean ok();
    @Override
    public String toString() {
        return type.toUpperCase();
    }
}
