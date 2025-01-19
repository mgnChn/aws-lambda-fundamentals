package lambdaapi_test;

import lambdaapi.DataSourceProperties;
import lambdaapi.GetEventRequestHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GetEventRequestHandlersTest {

    private GetEventRequestHandler sut;
    private DataSourceProperties db;

    @BeforeEach
    void setUp(){
        db = new DataSourceProperties(
                "dateplanner-rds-db.cpc8ouqicxe2.us-east-2.rds.amazonaws.com",
                "5432",
                "dateplanner_rds_db",
                "dp_admin",
                "(dp12345)");

        sut = new GetEventRequestHandler(db);
    }

    @Test
    void shouldGetAllEventRequests() {
        List<String> eventRequests = sut.handleRequest();

        // We should have 5 records that come back (expected, actual)
        assertEquals(3, eventRequests.size());
    }
}
