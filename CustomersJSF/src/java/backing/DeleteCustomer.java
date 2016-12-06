/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backing;

import data.CustomersData;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@Model
public class DeleteCustomer {

    private String name;

    @Inject
    CustomersData customersData;

    @PostConstruct
    public void init() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletRequest hr = (HttpServletRequest) ec.getRequest();
        name = hr.getParameter("name");
    }

    public String getName() {
        return name;
    }

    public String delete() {
        customersData.delete(name);
        return "index?faces-redirect=true";
    }

}
