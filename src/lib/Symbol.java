package lib;

/**
 * Created by Werner on 10/6/2014.
 */
public class Symbol {
    private String id;
    private String type;
    private String params;

    public Symbol(String id, String type, String params) {
        this.id = id;
        this.type = type;
        this.params = params;
    }

    public String getType() {
        return type;
    }

    public String getID() {
        return id;
    }

    public String getParams() {
        return params;
    }

    @Override
    public String toString() {
        return type + " " + id + (params==null?"" : "(" + params + ")");
    }
}
