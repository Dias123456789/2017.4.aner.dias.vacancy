package kz.greetgo.education.controller.register;
import kz.greetgo.education.controller.model.registerInfo;

import java.util.List;

public interface RegRegister {
    List<registerInfo>getRegisterList();
    String getNewUser(String json);
    String getUserLog(String json);

    String acceptUser(String num);
}
