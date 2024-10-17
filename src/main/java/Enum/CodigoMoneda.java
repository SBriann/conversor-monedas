package Enum;

public enum CodigoMoneda {
    ARS("ARS", "Peso argentino"),
    AUD("AUD", "Dólar australiano"),
    BOB("BOB", "Bolívar boliviano"),
    BRL("BRL", "Real brasileño"),
    CAD("CAD", "Dólar canadiense"),
    CLP("CLP", "Peso chileno"),
    COP("COP", "Peso colombiano"),
    CRC("CRC", "Colón costarricense"),
    EUR("EUR", "Euro"),
    JPY("JPY", "Yen japonés"),
    KRW("KRW", "Won surcoreano"),
    MXN("MXN", "Peso mexicano"),
    RUB("RUB", "Rublo ruso"),
    USD("USD", "Dólar estadounidense"),
    VES("VES", "Bolívar venezolano");

    private final String codigo;
    private final String nombre;

    CodigoMoneda(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigoMoneda() {
        return codigo;
    }

    public String getNombreMoneda() {
        return nombre;
    }

    public static boolean exists(String codigo) {
        try {
            CodigoMoneda.valueOf(codigo);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
