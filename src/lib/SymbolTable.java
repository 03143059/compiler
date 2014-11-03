package lib;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class SymbolTable {

    private static HashMap<Integer, Scope> scopes;

    static {
        scopes = new HashMap<Integer, Scope>();
    }

    public static void addScope(int scopeId, int baseScope){
        scopes.put(scopeId, new Scope(baseScope));
    }

    /***
     * Find symbol in symbol table in the scope provided.
     * Doing a search in the parent scopes is optional
     * @param id
     * @param scopeId
     * @param doSearch
     * @return
     */
    public static Symbol lookup(String id, int scopeId, boolean doSearch){
        Scope scope = scopes.get(scopeId);
        return scope.containsSymbol(id)? scope.get(id) : doSearch? search(id, scopeId) : null;
    }

    /***
     * Find symbol in symbol table in the scope provided
     * @param id
     * @param scopeId
     * @return
     */
    public static Symbol lookup(String id, int scopeId){
        return lookup(id, scopeId, true);
    }

    /***
     * Find symbol in symbol table searching from scope parent.
     * Useful for methods with double scopes (params and body)
     * @param id
     * @param scopeId
     * @return
     */
    public static Symbol search(String id, int scopeId){
        Scope scope = scopes.get(scopeId);
        for(Map.Entry<Integer, Scope> entry : scopes.entrySet()) {
            Integer scopeID = entry.getKey();
            if (scopeID == scope.getBaseScope()){
                Scope value = entry.getValue();
                return value.containsSymbol(id)? value.get(id) : null;
            }
        }
        return null;
    }

    /***
     * search for a symbol from the scope up to the base scope
     * @param id
     * @param scopeId
     * @return
     */
    public static Symbol locate(String id, int scopeId){
        Symbol s = lookup(id, scopeId, false);
        if (s != null) return s;
        Scope scope = scopes.get(scopeId);
        for(Map.Entry<Integer, Scope> entry : scopes.entrySet()) {
            Integer scopeID = entry.getKey();
            if (scopeID == scope.getBaseScope()){
                if (scopeID == 1) return lookup(id, 1, false);
                return locate(id, scopeID);
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
            Symbol symbol = new Symbol(id, type, params);
            scopes.get(scopeId).put(id, symbol);
            return symbol;
        }
        return null;
    }

    public static void print(PrintStream out) {
        out.println("SYMBOL TABLE");
        out.println("============");
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
                String params = (s.getParams() == null || s.getParams().isEmpty())?"":"\tParams: " + s.getParams();
                out.println(pad + pad + "ID: " + id + "\tType: " + s.getType()+ params);
            }
        }
    }

    public static void addScope(int id, int baseScope, String s) {
        addScope(id, baseScope);
    }
}

