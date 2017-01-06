package data;

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

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}
