package kz.greetgo.education.stand.register_stand_impl;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.education.controller.model.ClientInfo;
import kz.greetgo.education.controller.register.ClientRegister;
import kz.greetgo.education.stand.register_stand_impl.db.Db;
import kz.greetgo.education.stand.register_stand_impl.model.ClientDot;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Bean
public class ClientRegisterStandImpl implements ClientRegister{

    public BeanGetter<Db> db;

    @Override
    public List<ClientInfo> getClientList() {
        List<ClientInfo> clientInfo = new ArrayList<ClientInfo>();
        for(ClientDot clientDot : db.get().clientStorage.values()){
            ClientInfo ci = new ClientInfo(clientDot.id,clientDot.name,clientDot.surname,clientDot.patr,clientDot.age);
            clientInfo.add(ci);
        }
        return clientInfo;
    }


    @Override
    public String getClientDelete(String json) {
        JSONObject obj = new JSONObject(json);
        String id = obj.getString("id");
        System.out.println(id);
        db.get().clientStorage.remove(id);
        return "Ok delete";
    }

    @Override
    public String getClientAdd(String json) {
        System.out.println(json);
        JSONObject obj = new JSONObject(json);
        String id = obj.getString("id");
        String name = obj.getString("name");
        String surname = obj.getString("surname");
        String patr = obj.getString("patr");
        String age = obj.getString("age");

        System.out.print(id);
        if(id.length()==0) {
            Random random =new Random();
            long a=random.nextLong();
            db.get().clientStorage.put(""+a,new ClientDot(""+a,name,surname,patr,age));
            return "Ok insert";
        }
        else{
            ClientDot ci = db.get().clientStorage.get(id);
            ci.setAge(age);
            ci.setPatr(patr);
            ci.setSurname(surname);
            ci.setName(name);
            db.get().clientStorage.put(id,ci);
            return "Ok update";
        }
    }


}
