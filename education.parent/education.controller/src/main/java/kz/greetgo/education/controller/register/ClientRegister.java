package kz.greetgo.education.controller.register;

import kz.greetgo.education.controller.model.ClientInfo;
//import kz.greetgo.education.controller.model.registerInfo;

import java.util.List;
import java.util.Map;

public interface ClientRegister {
    List<ClientInfo> getClientList();
    //List<registerInfo>getRegisterList();
    String getClientDelete(String json);
    String getClientAdd(String json);
    //String getNewUser(String json);
}
