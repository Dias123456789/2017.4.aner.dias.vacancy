package kz.greetgo.education.controller.controller;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.education.controller.model.ClientInfo;
import kz.greetgo.education.controller.register.ClientRegister;
import kz.greetgo.education.controller.utils.Controller;
import kz.greetgo.mvc.annotations.Mapping;
import kz.greetgo.mvc.annotations.Par;
import kz.greetgo.mvc.annotations.ToJson;

import java.util.List;

@Bean
@Mapping("/client")
public class ClientController implements Controller {
    public BeanGetter<ClientRegister> clientRegister;


    @ToJson
    @Mapping("/getById")
    public ClientInfo getClientByIdInController(@Par("id") String id){
        return clientRegister.get().getClientInfoMethod(id);
    }


    @ToJson
    @Mapping("/getAll")
    public List<ClientInfo> getAll(){
        return clientRegister.get().getClientsList();
    }

    @ToJson
    @Mapping("/saveCl")
    public String saveClient(@Par("name") String name, @Par("surname") String surname, @Par("patr") String patr, @Par("age") String age){
        String id = "";
        ClientInfo tmp = new ClientInfo(id,name,surname,patr, age);
        return clientRegister.get().saveClient(id,tmp);
    }

    @ToJson
    @Mapping("/updateCl")
    public String updateClient(@Par("id") String id,@Par("name") String name, @Par("surname") String surname, @Par("patr") String patr, @Par("age") String age){
        ClientInfo tmp = new ClientInfo(id,name,surname,patr, age);
        return clientRegister.get().saveClient(id,tmp);
    }

    @ToJson
    @Mapping("/deleteCl")
    public String deleteClient(@Par("id") String id){
        return clientRegister.get().deleteClient(id);
    }

}
