package org.su.sportPlay.Service.Impl;

import org.springframework.stereotype.Service;
import org.su.sportPlay.Service.MenuService;
import org.su.sportPlay.mapper.MenuMapper;
import org.su.sportPlay.pojo.Mainmenu;

import javax.annotation.Resource;
import java.util.List;

@Service("MenuService")
public class MenuServiceImpl implements MenuService {
    @Resource
    MenuMapper menuMapper;


    @Override
    public List<Mainmenu> getMenu() {
        return menuMapper.getMainMenu();
    }
}
