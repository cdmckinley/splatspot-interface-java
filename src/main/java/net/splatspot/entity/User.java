package net.splatspot.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * A User of the application, mapped with the database.
 */
@Entity
@Table(name = "USER")
public class User {

    /**
     * The user's ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "identity")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    /**
     * The user's nickname
     */
    @Column(name = "nickname", length = 25)
    private String nickname;

    /**
     * The user's friend code for Nintendo Switch
     */
    @Column(name = "friend_code", length = 17)
    private String friendCode;

    /**
     * The user's Splatoon 3 splash tag's name
     */
    @Column(name = "splash_tag_name", length = 10)
    private String splashTagName;

    /**
     * The user's Splatoon 3 splash tag's number
     */
    @Column(name = "splash_tag_number", length = 4)
    private String splashTagNumber;

    /**
     * The user's setting to share info with other users or not
     */
    @Column(name = "share_info_with_users", nullable = false, length = 1)
    private boolean shareInfoWithUsers;

    /**
     * The user's setting to share when they're ready to play or not
     */
    @Column(name = "share_when_ready_to_play", nullable = false, length = 1)
    private boolean shareWhenReadyToPlay;

    // TODO Add a field to identify a user by Discord login

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
     * Gets the User's nickname.
     *
     * @return the nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Sets the User's nickname.
     *
     * @param nickname the nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * Gets the User's friend code for Nintendo Switch.
     *
     * @return the friend code
     */
    public String getFriendCode() {
        return friendCode;
    }

    /**
     * Sets the User's friend code for Nintendo Switch.
     *
     * @param friendCode the friend code
     */
    public void setFriendCode(String friendCode) {
        this.friendCode = friendCode;
    }

    /**
     * Gets the User's Splatoon 3 splash tag name.
     *
     * @return the splash tag name
     */
    public String getSplashTagName() {
        return splashTagName;
    }

    /**
     * Sets the User's Splatoon 3 splash tag name.
     *
     * @param splashTagName the splash tag name
     */
    public void setSplashTagName(String splashTagName) {
        this.splashTagName = splashTagName;
    }

    /**
     * Gets the User's Splatoon 3 splash tag number.
     *
     * @return the splash tag number
     */
    public String getSplashTagNumber() {
        return splashTagNumber;
    }

    /**
     * Sets the User's Splatoon 3 splash tag number.
     *
     * @param splashTagNumber the splash tag number
     */
    public void setSplashTagNumber(String splashTagNumber) {
        this.splashTagNumber = splashTagNumber;
    }

    /**
     * Gets the User's setting for sharing info with users.
     *
     * @return the setting for sharing info with users
     */
    public boolean getShareInfoWithUsers() {
        return shareInfoWithUsers;
    }

    /**
     * Sets the User's setting for sharing info with users.
     *
     * @param choice the User's choice for sharing their info
     */
    public void setShareInfoWithUsers(boolean choice) {
        this.shareInfoWithUsers = choice;
    }

    /**
     * Gets the User's setting for sharing when ready to play.
     *
     * @return the share when ready to play
     */
    public boolean getShareWhenReadyToPlay() {
        return shareWhenReadyToPlay;
    }

    /**
     * Sets the User's setting for sharing when ready to play.
     *
     * @param choice the User's choice for haring their ready status
     */
    public void setShareWhenReadyToPlay(boolean choice) {
        this.shareWhenReadyToPlay = choice;
    }

    /**
     * Read splash tag as a String.
     *
     * @return the splash tag string
     */
    public String readSplashTag() {
        String name = this.splashTagName;
        String number = this.splashTagNumber;
        return name + "#" + number;
    }
}