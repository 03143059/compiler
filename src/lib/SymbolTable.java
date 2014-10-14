package lib;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class SymbolTable {

    private static HashMap<Integer, Scope> scopes;

    static {
        scopes = new HashMap<Integer, Scope>();
    }

//    public static void addScope(int scopeId){
//        addScope(scopeId, 0);
//    }

    public static void addScope(int scopeId, int baseScope){
        scopes.put(scopeId, new Scope(baseScope));
    }

    public static Symbol lookup(String id, int scopeId, boolean doSearch){
        Scope scope = scopes.get(scopeId);
        return scope.containsSymbol(id)? scope.get(id) : doSearch? search(id, scopeId) : null;
    }

    public static Symbol lookup(String id, int scopeId){
        return lookup(id, scopeId, true);
    }

    public static Symbol search(String id, int scopeId){
        Scope scope = scopes.get(scopeId);
        for(Map.Entry<Integer, Scope> entry : scopes.entrySet()) {
            Integer scopeID = entry.getKey();
            Scope value = entry.getValue();
            if (scopeID == scope.getBaseScope()){
                return value.containsSymbol(id)? value.get(id) : null;
            }
        }
        return null;
    }

    public static String getType(String id, int scopeId){
        Symbol symbol = lookup(id, scopeId);
        return symbol != null? symbol.getType() : null;
    }

    public static Symbol store(String id, String type, int scopeId) {
        return store(id, type, null, scopeId);
    }

    public static Symbol store(String id, String type, String params, int scopeId){
        if (scopes.containsKey(scopeId)) {
            Symbol symbol = new Symbol(type, params);
            scopes.get(scopeId).put(id, symbol);
            return symbol;
        }
        return null;
    }

    public static void print(PrintStream out) {
        out.println("Tabla de simbolos:");
        String pad = "";
        int base = 0;
        for(Map.Entry<Integer, Scope> entry : scopes.entrySet()) {
            Integer scopeID = entry.getKey();
            Scope value = entry.getValue();
            if (base != value.getBaseScope()) {
                pad += " ";
                base = value.getBaseScope();
            }
            out.println(pad + "Scope ID: " + scopeID + " (Parent: " + value.getBaseScope() + ")");
            for(Map.Entry<String, Symbol> entry2 : value.entrySet()) {
                String id = entry2.getKey();
                Symbol s = entry2.getValue();
                out.println(pad + pad + "ID: " + id + "\tType: " + s.getType());
                // (s.getParams()==null?"":"\tParams: " + s.getParams())
            }
        }
    }

    public static void addScope(int id, int baseScope, String s) {
        addScope(id, baseScope);
      //  System.err.println("DEBUG adding scope " + id + "," + baseScope + " at " + s);
       // print(System.out);
        //System.out.println();
    }
}

/*
    static class SymbolTableNode {

        private static HashMap<Integer, SymbolTable> scope; // scopeid, symboltables
        private static HashMap<String, Symbol> symbols; // id, symbol

        public SymbolTableNode() {
            scope = new HashMap<Integer, SymbolTable>();
            symbols = new HashMap<String, Symbol>();
        }

        public Symbol lookup(String id, int scopeId){
            HashMap<String, Symbol> symbols = scope.get(scopeId);
            return symbols.containsKey(id)? symbols.get(id) : null;
        }

        public String getType(String id, int scopeId){
            Symbol symbol = lookup(id, scopeId);
            return symbol != null? symbol.getType() : null;
        }

        public Symbol store(String id, String type, int scopeId) {
            return store(id, type, null, scopeId);
        }

        public Symbol store(String id, String type, String params, int scopeId){
            if (scope.containsKey(scopeId)) {
                Symbol symbol = new Symbol(type, params);
                scope.get(scopeId).put(id, symbol);
                return symbol;
            }
            return null;
        }

        public void addScope(int scopeId){
            scope.put(scopeId, new HashMap<String, Symbol>());
        }

        public void print(PrintStream out) {
            out.println("Tabla de simbolos:");
            for(Map.Entry<Integer, HashMap<String, Symbol>> entry : scope.entrySet()) {
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

        public boolean contains(String id) {
            return false;
        }
    }
}
*/
