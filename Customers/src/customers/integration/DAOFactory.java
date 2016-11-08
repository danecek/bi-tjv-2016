/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customers.integration;

public interface DAOFactory {

    public static DAOFactory getDAOFactory() {

        //       if (derby) {
        return new DerbyDAOFactory();
//        } else if (oracle) {
//            return new OracleDAOFactory();
//        }

    }

    CustomerDAO getCustomerDAO();

}
