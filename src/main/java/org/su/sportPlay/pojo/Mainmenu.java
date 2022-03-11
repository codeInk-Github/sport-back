package org.su.sportPlay.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Mainmenu {

  private long id;
  private String title;
  private String path;
  private List<Submenu> sList;

}
