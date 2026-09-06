package com.phnaves.exercises3.section5;

abstract class ReportBase {
    public void generate() {
        System.out.println(header());
        System.out.println(body());
        System.out.println(footer());
    }
    abstract String header();
    abstract String body();
    abstract String footer();
}

class ReportSales extends ReportBase {
    private String title;
    private String description;
    private String resume;

    public ReportSales(String title, String description, String resume) {
        this.title = title;
        this.description = description;
        this.resume = resume;
    }

    @Override
    String header() {
        return title;
    }

    @Override
    String body() {
        return description;
    }

    @Override
    String footer() {
        return resume;
    }
}

public class Ex01 {
    public static void main(String[] args) {
        ReportSales reportSales = new ReportSales("Vendas de Agosto", "Esse mes as vendas crecseram",
                "Resumindo: estamos com saldo posistivo");
        reportSales.generate();
    }
}
