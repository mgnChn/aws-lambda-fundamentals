package lambdaapi;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//public class GetEventRequestHandler implements RequestHandler<Void, String> {
public class GetEventRequestHandler {

    private List<String> eventRequests = new ArrayList<>();

    private final DataSourceProperties db;

    public GetEventRequestHandler(){ // No args constructor (env var)
        this.db = new DataSourceProperties();
    }
    public GetEventRequestHandler(DataSourceProperties db){ // Constructor with args
        this.db = db;
    }


//    public List<String> handleRequest(Void input, Context context ){
    public List<String> handleRequest(){

        String jdbcURL = "jdbc:postgresql://dateplanner-rds-db.cpc8ouqicxe2.us-east-2.rds.amazonaws.com:5432/dateplanner_rds_db";
        String username = "dp_admin";
        String password = "(dp12345)";

        try(Connection conn = DriverManager.getConnection(jdbcURL, username, password)){
            if (!conn.isValid(0)){
                System.out.println("Unable to connect to: " + jdbcURL);
                System.exit(0);
            }
            PreparedStatement selectStatement = conn.prepareStatement("select * from event_request");
            ResultSet rs = selectStatement.executeQuery();

            while(rs.next()){
                String eventRequest = rs.getString("description");
                System.out.println("Event Request: " + eventRequest);
                eventRequests.add(eventRequest);
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        return eventRequests;
    }

}