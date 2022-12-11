package net.splatspot.entity;

import com.google.api.services.youtube.model.VideoSnippet;
import net.splatspot.persistence.YouTubeAccess;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.IOException;


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
     * The id for the shared video
     */
    @Column(length = 11, name = "video_id")
    private String link;

    /**
     * The description of the media in the link
     */
    @Column(length = 500)
    private String description;

    @Transient
    private VideoSnippet snippet = null;

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

    /**
     * Retrieves the YouTube video's snippet and keeps it in memory.
     * @param youTubeAccess The Youtube Access Object
     * @throws IOException
     */
    public void setSnippet(YouTubeAccess youTubeAccess) throws IOException {
        snippet = youTubeAccess.getVideoSnippet(link);
    }

    /**
     * Gets the YouTube video's snippet from memory.
     * @return the video snippet
     */
    public VideoSnippet getSnippet() {
        return snippet;
    }
}
