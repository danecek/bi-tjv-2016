package jpatest2;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpatest2.Order;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-22T14:25:55")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, String> name;
    public static volatile CollectionAttribute<Customer, Order> orders;
    public static volatile SingularAttribute<Customer, Long> id;

}