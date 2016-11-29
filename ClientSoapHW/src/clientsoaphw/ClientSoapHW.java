/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientsoaphw;

import gen.HelloWebService;
import gen.HelloWebServiceService;

/**
 *
 * @author danecek
 */
public class ClientSoapHW {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HelloWebServiceService service = new HelloWebServiceService();
        HelloWebService port = service.getHelloWebServicePort();
        System.out.println(port.hello("Tom"));
        // TODO code application logic here
    }
    
}
