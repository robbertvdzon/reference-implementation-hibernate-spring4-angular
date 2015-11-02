package com.vdzon.contactdb.authenticatie.mapper;

import com.vdzon.contactdb.authenticatie.data.User;
import com.vdzon.contactdb.authenticatie.model.UserModel;

public class UserModelMapper {

    public static void mergeModel(final UserModel model, User user) {
        user.setUsername(model.getUsername());
    }

    public static UserModel toModel(final User user) {
        if (user == null) return null;
        UserModel userModel = new UserModel();
        userModel.setUsername(user.getUsername());
        userModel.setUuid(user.getUuid());
        return userModel;
    }

}
