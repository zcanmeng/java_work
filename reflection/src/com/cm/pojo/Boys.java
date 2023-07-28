package com.cm.pojo;

public class Boys {
    private Integer id;

    private String boyName;

    private Integer userCP;

    public Boys(Integer id, String boyName, Integer userCP) {
        this.id = id;
        this.boyName = boyName;
        this.userCP = userCP;
    }

    public Boys() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBoyName() {
        return boyName;
    }

    public void setBoyName(String boyName) {
        this.boyName = boyName;
    }

    public Integer getUserCP() {
        return userCP;
    }

    public void setUserCP(Integer userCP) {
        this.userCP = userCP;
    }

    @Override
    public String toString() {
        return "Boys{" +
                "id=" + id +
                ", boyName='" + boyName + '\'' +
                ", userCP=" + userCP +
                '}';
    }
}
