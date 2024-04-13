package src;

public class Currency {
    private String code;
    private String name;
    private String symbolNative;

    public Currency(String code, String name, String symbolNative) {
        this.code = code;
        this.name = name;
        this.symbolNative = symbolNative;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getSymbolNative() {
        return symbolNative;
    }
}