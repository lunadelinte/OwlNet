package ch.zli.m223.model;

import java.sql.Time;
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

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Event {
     @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(readOnly = true)
  private Long id;

  @Column(nullable = false)
  private Time title;
  
  @Column(nullable = false, unique = true)
  private Time eventTime;

  @ManyToMany
  @JoinTable(
    name = "event_applicationusers",
    joinColumns = @JoinColumn(name = "applicationuser_id"),
    inverseJoinColumns = @JoinColumn(name = "event_id")
  )
  private Set<ApplicationUser> applicationUsers;

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public Time getTitle() {
    return title;
}

public void setTitle(Time title) {
    this.title = title;
}

public Time getEventTime() {
    return eventTime;
}

public void setEventTime(Time eventTime) {
    this.eventTime = eventTime;
}

public Set<ApplicationUser> getApplicationUsers() {
    return applicationUsers;
}

public void setApplicationUsers(Set<ApplicationUser> applicationUsers) {
    this.applicationUsers = applicationUsers;
}

  
}
