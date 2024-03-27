package com.Themfg.ELearn.service.Interface;

import com.Themfg.ELearn.dto.User;
import com.Themfg.ELearn.entity.Ogrenci;

public interface UserService {
    User profilBilgileriniDoldur(Ogrenci ogrenci);

    Ogrenci profiliGuncelle(Ogrenci ogrenci, User user);
}
