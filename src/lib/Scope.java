package lib;

import java.util.HashMap;

/**
 * Created by Werner on 9/23/2014.
 */
public class Scope extends HashMap<String, Symbol> {
    private int baseScope;

    public Scope(int baseScope) {
        this.baseScope = baseScope;
    }

    public boolean containsSymbol(String id) {
        return containsKey(id);
    }

    public int getBaseScope() {
        return baseScope;
    }
}
