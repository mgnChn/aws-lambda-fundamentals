package lambdaapi;

public class DataSourceProperties {
    private final String host;
    private final String port;
    private final String database;
    private final String username;
    private final String password;

    // No args constructor (get values from env variables)
    public DataSourceProperties(){
        this.host = System.getenv("RDS_HOSTNAME");
        this.port = System.getenv("RDS_PORT");
        this.database = System.getenv("RDS_DB_NAME");
        this.username = System.getenv("RDS_USERNAME");
        this.password = System.getenv("RDS_PASSWORD");
    }

    public DataSourceProperties(String host, String port, String database, String username, String password){
        this.host = host;
        this.port = port;
        this.database = database;
        this.username = username;
        this.password = password;
    }

    public String getHost(){
        return host;
    }
    public String getPort(){
        return port;
    }
    public String getDatabase(){
        return database;
    }
    public String getUsername(){
            return username;
    }
    public String getPassword(){
        return password;
    }

}
