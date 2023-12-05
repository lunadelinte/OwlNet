package ch.zli.m223.model;

import java.sql.Date;
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
public class Booking {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(readOnly = true)
  private Long id;
  
  @Column(nullable = false, unique = true)
  private Date bookingDate;

  @ManyToOne(optional = false)
  @Fetch(FetchMode.JOIN)
  private Workspace workspace;

@ManyToOne(optional = false)
@Fetch(FetchMode.JOIN)
private ApplicationUser applicationUser;

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public Date getBookingDate() {
    return bookingDate;
}

public void setBookingDate(Date bookingDate) {
    this.bookingDate = bookingDate;
}

public Workspace getWorkspace() {
    return workspace;
}

public void setWorkspace(Workspace workspace) {
    this.workspace = workspace;
}

public ApplicationUser getApplicationUser() {
    return applicationUser;
}

public void setApplicationUser(ApplicationUser applicationUser) {
    this.applicationUser = applicationUser;
}



}
