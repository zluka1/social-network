package entity;
import org.hibernate.annotations.OptimisticLockType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * create songs in database
 */

@Entity
@org.hibernate.annotations.Entity(optimisticLock = OptimisticLockType.ALL, dynamicUpdate = true)
@Table(name= "user_songs")
public class User_songs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;

    @OneToMany
    @JoinColumn(name = "music_id")
    private Set<Music> music_id = new HashSet<>();

    public User_songs() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public Set<Music> getMusic_id() {
        return music_id;
    }

    public void setMusic_id(Set<Music> music_id) {
        this.music_id = music_id;
    }
}