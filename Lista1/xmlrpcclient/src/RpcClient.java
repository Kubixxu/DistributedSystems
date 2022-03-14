import org.apache.xmlrpc.XmlRpcClient;

import java.util.Vector;

public class RpcClient {
    public static void main(String[] args) {
        try {
            XmlRpcClient srv = new XmlRpcClient("http://25.84.32.3:10005");
            Vector<Integer> params = new Vector<>();
            params.addElement(new Integer(13));
            params.addElement(new Integer(21));
            Object result = srv.execute("MojSerwer.echo", params);
            System.out.println((Integer) result);
            AC callback = new AC();
            Vector<Integer> params2 = new Vector<>();
            params2.addElement(new Integer(3000));
            srv.executeAsync("MojSerwer.execAsy", params2, callback);
            System.out.println("Invoked asynchronously");
        } catch (Exception e) {
            System.err.println("XML-RPC Client: " + e);
        }
    }
}
