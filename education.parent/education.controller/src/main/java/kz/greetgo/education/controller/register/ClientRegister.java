package kz.greetgo.education.controller.register;

import kz.greetgo.education.controller.model.ClientInfo;

import java.util.List;

public interface ClientRegister {
    ClientInfo getClientInfoMethod(String id);
    List<ClientInfo> getClientsList();
    String saveClient(String id, ClientInfo cl);
    String deleteClient(String id);

}
