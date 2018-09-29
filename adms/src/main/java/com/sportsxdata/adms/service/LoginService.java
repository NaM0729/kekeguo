package com.sportsxdata.adms.service;

import com.sportsxdata.adms.model.DataResult;

public interface LoginService {

    DataResult login(String username,String password);
}
