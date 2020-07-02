package com.teak1.clojurecraft;


import clojure.lang.IFn;
import clojure.lang.Symbol;
import clojure.lang.Var;

class Clojure {
    private static Symbol asSym(Object o) {
        Symbol s;
        if (o instanceof String) {
            s = Symbol.intern((String) o);
        } else {
            s = (Symbol) o;
        }
        return s;
    }

    /**
     * Returns the var associated with qualifiedName.
     *
     * @param qualifiedName a String or clojure.lang.Symbol
     * @return a clojure.lang.IFn
     */
    public static IFn var(Object qualifiedName) {
        Symbol s = asSym(qualifiedName);
        return var(s.getNamespace(), s.getName());
    }

    /**
     * Returns an IFn associated with the namespace and name.
     *
     * @param ns   a String or clojure.lang.Symbol
     * @param name a String or clojure.lang.Symbol
     * @return a clojure.lang.IFn
     */
    public static IFn var(Object ns, Object name) {
        return Var.intern(asSym(ns), asSym(name));
    }

    /**
     * Read one object from the String s. Reads data in the
     * <a href="http://edn-format.org">edn format</a>.
     *
     * @param s a String
     * @return an Object, or nil.
     */
    public static Object read(String s) {
        return EDN_READ_STRING.invoke(s);
    }

    static {
        Symbol edn = (Symbol) var("clojure.core", "symbol").invoke("clojure.edn");
        var("clojure.core", "require").invoke(edn);
    }
    private static final IFn EDN_READ_STRING = var("clojure.edn", "read-string");
}


public class ClojureInterface {
//    private static IFn nil = Clojure.var("nil");
    private static IFn eval = Clojure.var("clojure.core", "eval");
    public static Object compile(String str){
        return eval.invoke(Clojure.read(str));
    }
    public static Object invoke(IFn func, Object[] args){
        switch (args.length){
            case 0: return func.invoke();
            case 1: return func.invoke(args[0]);
            case 2: return func.invoke(args[0], args[1]);
            case 3: return func.invoke(args[0], args[1], args[2]);
            case 4: return func.invoke(args[0], args[1], args[2], args[3]);
            case 5: return func.invoke(args[0], args[1], args[2], args[3], args[4]);
            case 6: return func.invoke(args[0], args[1], args[2], args[3], args[4], args[5]);
            case 7: return func.invoke(args[0], args[1], args[2], args[3], args[4], args[5], args[6]);
            case 8: return func.invoke(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7]);
            case 9: return func.invoke(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8]);
            case 10: return func.invoke(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8], args[9]);
            case 11: return func.invoke(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8], args[9], args[10]);
            case 12: return func.invoke(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8], args[9], args[10], args[11]);
            case 13: return func.invoke(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8], args[9], args[10], args[11], args[12]);
            case 14: return func.invoke(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8], args[9], args[10], args[11], args[12], args[13]);
            case 15: return func.invoke(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8], args[9], args[10], args[11], args[12], args[13], args[14]);
            case 16: return func.invoke(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8], args[9], args[10], args[11], args[12], args[13], args[14], args[15]);
            case 17: return func.invoke(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8], args[9], args[10], args[11], args[12], args[13], args[14], args[15], args[16]);
            case 18: return func.invoke(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8], args[9], args[10], args[11], args[12], args[13], args[14], args[15], args[16], args[17]);
            case 19: return func.invoke(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8], args[9], args[10], args[11], args[12], args[13], args[14], args[15], args[16], args[17], args[18]);
            default:
                return null;
        }
    }
}
