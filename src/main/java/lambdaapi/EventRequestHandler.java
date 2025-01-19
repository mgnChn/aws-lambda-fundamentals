package lambdaapi;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class EventRequestHandler implements RequestHandler<String, String> {

    public String handleRequest(String input, Context context ){


        LambdaLogger logger = context.getLogger();
        logger.log("JDK version - testing from EventRequestHandler: " + System.getProperty("java.version"));
        return input.toUpperCase();
    }

}
