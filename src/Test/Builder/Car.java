package Test.Builder;


public class Car {
    private String color;
    private String engine;

    private String model;
    private int downPayment;
    private String transmisson;


    private int paymentMonths;


    public Car(Builder builder) {
        this.color = builder.color;
        this.engine = builder.engine;
        this.downPayment = builder.downPayment;
        this.transmisson = builder.transmisson;
        this.model = builder.model;
        this.paymentMonths = builder.paymentMonths;
    }

    static class Builder {
        private String color;
        private String engine;
        private String model;
        private int downPayment;
        private String transmisson;


        private int paymentMonths;

        public Builder(String color, String engine, String transmisson) {
            this.color = color;
            this.engine = engine;
            this.transmisson = transmisson;
        }

        public Builder setDownPayment(int downPayment) {
            this.downPayment = downPayment;
            return this;
        }

        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        public Builder setPaymentMonths(int paymentMonths) {
            this.paymentMonths = paymentMonths;
            return this;
        }

        public Car build() {
            return new Car(this);
        }

    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Your Build : \n");
        if (color == "") {
            sb.append("Color: Red\n");
        } else {
            sb.append("Color: " + color + "\n");
        }
        if (engine == "") {
            sb.append("engine: 4 cylinder \n");
        } else {
            sb.append("engine: " + engine + "\n");
        }
        if (model == "") {
            sb.append("model : LE Hybrid\n");
        } else {
            sb.append("model : " + model + "\n");
        }
        if (downPayment == -1 || downPayment == 0) {

            sb.append("if down payment is $" + downPayment + " total price : $" + 32000 + "\n");
            downPayment = 32000;

        } else {

            sb.append("if down $" + downPayment + " paid");
            downPayment = 32000 - downPayment + 2000;
            sb.append(" total remaining amount $" + downPayment + "\n");
        }
        if (paymentMonths == 0 || paymentMonths == -1) {
            sb.append("default payment months 36 months\n");
            int monthly = downPayment / 36;
            sb.append("months payments $" + monthly + " for 36 months\n");
        } else {
            int monthly = downPayment / paymentMonths;
            sb.append("monthly payment $" + monthly + "\n");
        }
        if (transmisson == "") {
            sb.append("transmisson: Automatic CVT\n");
        } else {
            sb.append("transmission: " + transmisson + "\n");
        }


        return sb.toString();
    }

}
