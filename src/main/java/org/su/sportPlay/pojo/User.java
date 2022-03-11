package org.su.sportPlay.pojo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

  private int id;
  private String username;
  private String password;
  private String email;
  private String role;
  private Boolean state;


  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", email='" + email + '\'' +
            ", role='" + role + '\'' +
            ", state=" + state +
            '}';
  }
}
