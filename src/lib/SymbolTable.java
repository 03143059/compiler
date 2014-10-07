package lib;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Werner on 9/23/2014.
 */
public class SymbolTable {
    private static HashMap<Integer, HashMap<String, Symbol>> list = null; // scopeid, symbol

    static {
        list = new HashMap<Integer, HashMap<String, Symbol>>();
    }

    public static Symbol lookup(String id, int scopeId){
        HashMap<String, Symbol> symbols = list.get(scopeId);
        return symbols.containsKey(id)? symbols.get(id) : null;
    }

    public static String getType(String id, int scopeId){
        Symbol symbol = lookup(id, scopeId);
        return symbol != null? symbol.getType() : null;
    }

    public static Symbol store(String id, String type, int scopeId) {
        return store(id, type, null, scopeId);
    }

    public static Symbol store(String id, String type, String params, int scopeId){
        if (list.containsKey(scopeId)) {
            Symbol symbol = new Symbol(type, params);
            list.get(scopeId).put(id, symbol);
            return symbol;
        }
        return null;
    }

    public static void addScope(int scopeId){
        list.put(scopeId, new HashMap<String, Symbol>());
    }

    public static void print(PrintStream out) {
        out.println("Tabla de simbolos:");
        for(Map.Entry<Integer, HashMap<String, Symbol>> entry : list.entrySet()) {
            Integer scopeID = entry.getKey();
            HashMap<String, Symbol> value = entry.getValue();
            out.println("Scope ID: " + scopeID);
            for(Map.Entry<String, Symbol> entry2 : value.entrySet()) {
                String id = entry2.getKey();
                Symbol s = entry2.getValue();
                out.println("ID: " + id + "\tType: " + s.getType() + (s.getParams()==null?"":"\tParams: " + s.getParams()));
            }
        }
    }
}
