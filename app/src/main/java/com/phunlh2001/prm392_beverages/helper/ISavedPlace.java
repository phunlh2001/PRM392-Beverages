package com.phunlh2001.prm392_beverages.helper;

import com.phunlh2001.prm392_beverages.data.entities.User;

public interface ISavedPlace {
    void onClickEditAddress(User user);

    void onClickDeleteAddress(User user);
}
