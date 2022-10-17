package net.splatspot.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


/**
 * The type Shared media.
 */
@Entity(name = "SharedMedia")
@Table(name = "shared_media")
public class SharedMedia {

    /**
     * The ID of the SharedMedia
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    /**
     * The associated User
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    /**
     * The shared link
     */
    private String link;

    /**
     * The description of the media in the link
     */
    private String description;

    /**
     * Instantiates a new Shared media object.
     */
    public SharedMedia() {

    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the associated user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the associated user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets the link.
     *
     * @return the link
     */
    public String getLink() {
        return link;
    }

    /**
     * Sets the link.
     *
     * @param link the link
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
