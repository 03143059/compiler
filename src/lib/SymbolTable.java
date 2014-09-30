package lib;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Werner on 9/23/2014.
 */
public class SymbolTable {
    private HashMap<Integer, HashMap<Integer, Symbol>> list; // scopeid, symbol

    public SymbolTable(){
        list = new HashMap<Integer, HashMap<Integer, Symbol>>();
    }

    public Symbol lookup(int id, int scopeId){
        HashMap<Integer, Symbol> symbols = list.get(scopeId);
        return symbols.containsKey(id)? symbols.get(id) : null;
    }

    public String getType(int id, int scopeId){
        Symbol symbol = lookup(id, scopeId);
        return symbol != null? symbol.getType() : null;
    }

    public Symbol store(int id, String type, int scopeId) {
        return store(id, type, null, scopeId);
    }

    public Symbol store(int id, String type, String params, int scopeId){
        if (list.containsKey(scopeId)) {
            Symbol symbol = new Symbol(type, params);
            list.get(scopeId).put(id, symbol);
            return symbol;
        }
        return null;
    }

    public void addScope(int scopeId){
        list.put(scopeId, new HashMap<Integer, Symbol>());
    }

    private class Symbol {
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

    }

}
