package DesignPatterns.Creational.Builder;

public class UrlReturn {
    private String protocol;
    private String domain;
    private int port;
    private String path;
    private String query;

    public UrlReturn(Builder builder) {
        this.protocol = builder.getProtocol();
        this.domain = builder.getDomain();
        this.port = builder.getPort();
        this.path = builder.getPath();
        this.query = builder.getQuery();
    }


    public String returnUrl() {
        StringBuilder sb = new StringBuilder();
        sb.append(protocol).append("://").append(domain);
        if (port == -1) {
            sb.append("/");
        } else {
            sb.append(":").append(port).append("/");
        }
        sb.append(path);
        if (query == "") {
            sb.append("");
        } else {
            sb.append("?").append(query);
        }
        return sb.toString();
    }


    public static class Builder {
        private String protocol;
        private String domain;
        private int port;
        private String path;
        private String query;


        public Builder(String protocol, String domain) {
            this.protocol = protocol;
            this.domain = domain;
            this.port = -1;
            this.path = "/";
            this.query = "";
        }

        public int getPort() {
            return port;
        }

        public String getPath() {
            return path;
        }

        public String getProtocol() {
            return protocol;
        }

        public String getDomain() {
            return domain;
        }

        public String getQuery() {
            return query;
        }

        public Builder setPort(int port) {
            this.port = port;
            return this;
        }

        public Builder setPath(String path) {
            this.path = path;
            return this;
        }

        public Builder setQuery(String query) {
            this.query = query;
            return this;
        }

        public UrlReturn build() {
            return new UrlReturn(this);
        }
    }
}
