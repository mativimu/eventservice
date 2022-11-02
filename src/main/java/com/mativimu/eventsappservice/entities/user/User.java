package com.mativimu.eventsappservice.entities.user;

import java.util.List;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

import com.mativimu.eventsappservice.entities.event.Event;

@Table
@Entity(name = "User")
public class User {
    @Id
    @SequenceGenerator(
        name = "user_sequence",
        sequenceName = "user_sequence",
        allocationSize = 10
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "user_sequence")
    private Long id;

    private String name;
    private String username;
    private String email;
    private String password;
    private String occupation;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Participant",
                joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "event_id", referencedColumnName = "id")
                )
    private List<Event> event;

    public User(String name, String username, String email, String password, String occupation) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.occupation = occupation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return occupation;
    }

    public void setoccupation(String occupation) {
        this.occupation = occupation;
    }
    
}