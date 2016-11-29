package ws;

import javax.jws.WebService;
import javax.jws.WebMethod;

@WebService
public class HelloWebService {

    @WebMethod
    public String hello(String txt) {
        return "Hello " + txt + " !";
    }
}
