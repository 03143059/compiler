package semantic;

public abstract class SemNode {
    protected String type = null;
    public String getType() { return type; }
    public abstract boolean ok();

    public SemNode(String type) {
        this.type = type;
    }
    public SemNode() {
        this(null);
    }

    @Override
    public String toString() {
        return type==null?"null":type.toUpperCase();
    }
}
