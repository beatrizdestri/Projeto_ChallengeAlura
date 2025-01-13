package org.example;

public class RespostaCambio {
    private String result;
    private String documentation;
    private String terms_of_use;
    private String error_type;
    private Moedas.ConversionRates conversion_rates;

    public Moedas.ConversionRates getConversion_rates() {
        return conversion_rates;
    }

    public void setConversion_rates(Moedas.ConversionRates conversion_rates) {
        this.conversion_rates = conversion_rates;
    }

    public String getBase_code() {
        return base_code;
    }

    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }

    private String base_code;

    // Getters e Setters
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    public String getTerms_of_use() {
        return terms_of_use;
    }

    public void setTerms_of_use(String terms_of_use) {
        this.terms_of_use = terms_of_use;
    }

    public String getError_type() {
        return error_type;
    }

    public void setError_type(String error_type) {
        this.error_type = error_type;
    }

}
