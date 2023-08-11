package br.com.widsl.paymentconsumer.enums;

import java.util.HashMap;
import java.util.Map;

public enum PaymentMethod {

    CREDIT("C"),
    DEBIT("D");

    private static final Map<String, PaymentMethod> lookup = new HashMap<>();

    static {
        for (PaymentMethod method : PaymentMethod.values()) {
            lookup.put(method.getCode(), method);
        }
    }

    private final String code;

    PaymentMethod(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static PaymentMethod fromCode(String code) {
        return lookup.get(code);
    }
}