package kz.greetgo.education.stand.register_stand_impl;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.education.controller.model.ClientInfo;
import kz.greetgo.education.controller.register.ClientRegister;
import kz.greetgo.education.stand.register_stand_impl.db.Db;
import kz.greetgo.education.stand.register_stand_impl.model.ClientDot;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Bean
public class ClientRegisterStandImpl implements ClientRegister{
    public BeanGetter<Db> db;

    @Override
    public ClientInfo getClientInfoMethod(String id){
        ClientDot tmp =  db.get().clientStorage.get(id);
        ClientInfo out = new ClientInfo(tmp.id,tmp.name,tmp.surname,tmp.patr,tmp.age);
        return out;
    }

    @Override
    public List<ClientInfo> getClientsList(){
        List<ClientInfo> list = new ArrayList<>();
        for(String id: db.get().clientStorage.keySet()){
            ClientDot db_cl = db.get().clientStorage.get(id);
            ClientInfo ctrl_cl = new ClientInfo(db_cl.id,db_cl.name,db_cl.surname, db_cl.patr, db_cl.age);
            list.add(ctrl_cl);
        }
        return list;
    }

    @Override
    public String saveClient(String id, ClientInfo cl){
        if(id==""){
            String uuid = UUID.randomUUID().toString();
            ClientDot tmp = new ClientDot(uuid, cl.name, cl.surname, cl.patr, cl.age);
            db.get().clientStorage.put(uuid, tmp);
        }else{
            ClientDot x = new ClientDot(id, cl.name, cl.surname, cl.patr, cl.age);
            db.get().clientStorage.remove(id);
            db.get().clientStorage.put(id, x);
        }
        return "Ok";
    }


    @Override
    public String deleteClient(String id){
        db.get().clientStorage.remove(id);
        return "Ok";
    }
}
