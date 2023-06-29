package DesignPatterns.Builder;


class Main {


    public static void main(String[] args) {
        UrlReturn u = new UrlReturn.Builder("http","www.accesshub.com").setPort(8080).setPath("v2/access/users").setQuery("username=adcbzr").build();
        System.out.println(u.returnUrl());

    }

}
