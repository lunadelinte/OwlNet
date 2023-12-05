package ch.zli.m223.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@NamedQueries({
  @NamedQuery(name = "ApplicationUser.findByEmail", query = "SELECT u FROM ApplicationUser u WHERE u.email = :email")
})
public class ApplicationUser {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(readOnly = true)
  private Long id;
  
  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String password;

  @Column
  private String nickname;

  @OneToMany(mappedBy = "applicationUser")
  @Fetch(FetchMode.JOIN)
  private Set<Booking> bookings;

  @JsonIgnoreProperties("applicationUsers")
  @ManyToMany(mappedBy = "applicationUsers")
  @Fetch(FetchMode.JOIN)
  Set<Event> events;

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
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

public String getNickname() {
    return nickname;
}

public void setNickname(String nickname) {
    this.nickname = nickname;
}

public Set<Booking> getBookings() {
    return bookings;
}

public void setBookings(Set<Booking> bookings) {
    this.bookings = bookings;
}

public Set<Event> getEvents() {
    return events;
}

public void setEvents(Set<Event> events) {
    this.events = events;
}



}
