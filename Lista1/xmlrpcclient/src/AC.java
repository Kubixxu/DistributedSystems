import org.apache.xmlrpc.AsyncCallback;

import java.net.URL;

public class AC implements AsyncCallback {

    @Override
    public void handleResult(Object result, URL url, String method) {
        System.out.println("Invocation of method " + method + " has finished with the result: " + result);
    }

    @Override
    public void handleError(Exception e, URL url, String method) {
        System.out.println("Invocation of method " + method + " has finished with the exception: " + e);
    }
}
