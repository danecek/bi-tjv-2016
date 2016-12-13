/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backing;

import business.CustomersFacade;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import model.Customer;

@Model
public class DeleteCustomer {


    public Customer getC() {
        return c;
    }

    
    private Customer c;

    @Inject
    CustomersFacade customersData;

    @PostConstruct
    public void init() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletRequest hr = (HttpServletRequest) ec.getRequest();
        Long id = Long.parseLong(hr.getParameter("id"));
        c = customersData.find(id);
    }

    public String delete() {
        customersData.delete(c.getId());
        return "index?faces-redirect=true";
    }

}
