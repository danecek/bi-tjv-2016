/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientresthw;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 *
 * @author danecek
 */
public class ClientRestHW {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Client c = ClientBuilder.newClient();
        WebTarget resource = c.target("http://localhost:8080/RestHW/resources/generic2");
        String r = resource.queryParam("name", "Bob").request().get(String.class);
        System.out.println(r);

    }

}
