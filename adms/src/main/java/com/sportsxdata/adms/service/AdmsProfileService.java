package com.sportsxdata.adms.service;

import com.sportsxdata.adms.model.DataResult;
import com.sportsxdata.adms.model.SelfProfile;

public interface AdmsProfileService {

    DataResult getProfileData(String userId);

    DataResult saveProfileData(SelfProfile selfProfile);
}
