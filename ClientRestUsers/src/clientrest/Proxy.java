/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientrest;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import model.User;

public class Proxy {

    WebTarget itemsResource;
    public static Proxy instance = new Proxy();

    public Proxy() {
        Client c = ClientBuilder.newClient();
        itemsResource = c.target("http://localhost:8080/RestUsers/users");
    }

    public List<User> all() {
        return itemsResource.request().get(new GenericType<List<User>>() {
        });
    }

    public void add(String name) {
        itemsResource.request().post(Entity.xml(new User(name)));
    }

}
