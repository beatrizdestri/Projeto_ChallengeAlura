package org.example;

public class Moedas {
    public class ConversionRates {
        private double ARS; //Peso argentino*
        private double BOB; //Boliviano boliviano*
        private double BRL; //real brasileiro*
        private double CLP; //peso chileno*
        private double COP; //peso colombiano;*
        private double USD; //Dólar americano;*

        public double getARS() {
            return ARS;
        }

        public void setARS(double ARS) {
            this.ARS = ARS;
        }

        public double getBOB() {
            return BOB;
        }

        public void setBOB(double BOB) {
            this.BOB = BOB;
        }

        public double getBRL() {
            return BRL;
        }

        public void setBRL(double BRL) {
            this.BRL = BRL;
        }

        public double getCLP() {
            return CLP;
        }

        public void setCLP(double CLP) {
            this.CLP = CLP;
        }

        public double getCOP() {
            return COP;
        }

        public void setCOP(double COP) {
            this.COP = COP;
        }

        public double getUSD() {
            return USD;
        }

        public void setUSD(double USD) {
            this.USD = USD;
        }

        public double get(String currency) {
            switch (currency) {
                case "ARS":
                    return getARS();
                case "BOB":
                    return getBOB();
                case "BRL":
                    return getBRL();
                case "CLP":
                    return getCLP();
                case "COP":
                    return getCOP();
                case "USD":
                    return getUSD();
                default:
                    throw new IllegalArgumentException("Moeda não suportada: " + currency);
            }
        }
    }
}
