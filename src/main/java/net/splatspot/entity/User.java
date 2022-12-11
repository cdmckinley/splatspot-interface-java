package net.splatspot.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * A User of the application, mapped with the database.
 */
@Entity
@Table(name = "user")
public class User {

    /**
     * The user's ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    /**
     * The user's username, used to integrate with AWS Cognito
     */
    @Column(length = 128, nullable = false)
    private String username;

    /**
     * The set of SharedMedia from the User
     */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<SharedMedia> sharedMediaSet =  new HashSet<>();

    /**
     * Instantiates a new User.
     */
    public User() {

    }

    /**
     * Sets the User's id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the User's id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the user's username associated with AWS Cognito
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the user's username to associate them with AWS Cognito
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets shared media set.
     *
     * @return the shared media set
     */
    public Set<SharedMedia> getSharedMediaSet() {
        return sharedMediaSet;
    }

    /**
     * Sets shared media set.
     *
     * @param sharedMedia the shared media
     */
    public void setSharedMediaSet(Set<SharedMedia> sharedMedia) {
        this.sharedMediaSet = sharedMedia;
    }

    /**
     * Add shared media.
     *
     * @param sharedMedia the shared media
     */
    public void addSharedMedia(SharedMedia sharedMedia) {
        sharedMediaSet.add(sharedMedia);
        sharedMedia.setUser(this);
    }

    /**
     * Remove shared media.
     *
     * @param sharedMedia the shared media
     */
    public void removeSharedMedia(SharedMedia sharedMedia) {
        sharedMediaSet.remove(sharedMedia);
        sharedMedia.setUser(null);
    }
}