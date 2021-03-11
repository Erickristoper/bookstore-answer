package com.itech.bookstore.domain;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private int id;
    @Column(name = "USER_NAME")
    private String name;
    @Column(name = "USER_PERMISSIONS")
    private String permissions;

    public User(){}

    public User(int id, String name, String permissions){
        this.id = id;
        this.name = name;
        this.permissions = permissions;
    }

    public User(String name, String permissions){
        this.name = name;
        this.permissions = permissions;
    }

    public String getPermissions() {
        return permissions;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override public String toString() {
        return "User(" + this.getId() + ", " + this.getName() + ", " + this.getPermissions() + ")";
    }

    protected boolean canEqual(Object other) {
        return other instanceof User;
    }

    @Override public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof User)) return false;
        User other = (User) o;
        if (!other.canEqual(this)) return false;
        if (this.getId() != other.getId()) return false;
        if (this.getName() == null ? other.getName() != null : !this.getName().equals(other.getName())) return false;
        if (this.getPermissions() == null ? other.getPermissions() != null : !this.getPermissions().equals(other.getPermissions())) return false;
        return true;
    }
}
