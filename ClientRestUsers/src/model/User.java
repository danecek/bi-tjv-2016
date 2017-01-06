package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

    private Integer id;
    private String name;

    public User(Integer id, String name) {
        this(name);
        this.id = id;
    }

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", name=" + name + '}';
    }

}
