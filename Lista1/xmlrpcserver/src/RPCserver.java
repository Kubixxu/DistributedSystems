import org.apache.xmlrpc.WebServer;
public class RPCserver {
    public static void main(String[] args) {
        try {
            System.out.println("XML-RPC Server starts...");
            int port = 10004;
            WebServer server = new WebServer(port);
            server.addHandler("MyServer", new RPCserver());
            server.start();
            System.out.println("Server has started correctly.");
            System.out.println("It listens on port: " + port);
            System.out.println("To stop server, press ctrl+c");
        } catch (Exception e) {
            System.err.println("XML-RPC Server: " + e);
        }
    }
    public Integer echo(int x, int y) {
        return new Integer(x * y);
    }
    public int execAsy(int x) {
        System.out.println("... asy invoked - started counting");
        try {
            Thread.sleep(x);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            Thread.currentThread().interrupt();
        }
        System.out.println("... asy - finished counting");
        return 123;
    }
}
