package org.su.sportPlay.mapper;

import org.springframework.stereotype.Repository;
import org.su.sportPlay.pojo.Mainmenu;

import java.util.List;

@Repository
public interface MenuMapper {
    List<Mainmenu> getMainMenu();
}
