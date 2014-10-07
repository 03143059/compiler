package lib;

/**
 * Created by Werner on 10/6/2014.
 */
public class Symbol {
    private String type;
    private String params;

    public Symbol(String type, String params) {
        this.type = type;
        this.params = params;
    }

    public String getType() {
        return type;
    }

    public String getParams() {
        return params;
    }

    @Override
    public String toString() {
        return type.toUpperCase() + (params==null?"" : "=" + params);
    }
}
