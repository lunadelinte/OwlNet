package ch.zli.m223.model;

import java.sql.Time;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Workspace {
      @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(readOnly = true)
  private Long id;
  
  @Column(nullable = false)
  private String name;

  @JsonIgnoreProperties("applicationUser")
  @OneToMany(mappedBy = "workspace")
  @Fetch(FetchMode.JOIN)
  private Set<Booking> bookings;

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public Set<Booking> getBookings() {
    return bookings;
}

public void setBookings(Set<Booking> bookings) {
    this.bookings = bookings;
}

  
}
