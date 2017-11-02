package kz.greetgo.education.stand.register_stand_impl;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;

import kz.greetgo.education.controller.model.registerInfo;
import kz.greetgo.education.controller.register.RegRegister;
import kz.greetgo.education.stand.register_stand_impl.db.Db;

import kz.greetgo.education.stand.register_stand_impl.model.registerDot;
import kz.greetgo.email.Email;
import kz.greetgo.email.EmailSender;
import kz.greetgo.email.EmailSenderController;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Bean
public class RegRegisterStandImpl implements RegRegister {
    public BeanGetter<Db> db;

    public BeanGetter<EmailSender> emailSenderBeanGetter;
    public BeanGetter<EmailSenderController> emailSenderControllerBeanGetter;


    @Override
    public List<registerInfo> getRegisterList() {
        List<registerInfo> registerInfo = new ArrayList<registerInfo>();
        for(registerDot registerDot : db.get().registerStorage.values()){
            registerInfo ri = new registerInfo(registerDot.UserN,registerDot.UserS,registerDot.Email,registerDot.Password, registerDot.Activate, registerDot.Id);
            registerInfo.add(ri);
        }
        return registerInfo;
    }

    @Override
    public String acceptUser(String num){
        System.out.println(num);
        registerDot x= db.get().registerStorage.get(num);
        x.setActivate("1");
        db.get().registerStorage.put(num,x);
        return "ok";
    }

    @Override
    public String getNewUser(String json) {
        System.out.println(json);
        JSONObject obj = new JSONObject(json);
        String UserN = obj.getString("UserN");
        String UserS = obj.getString("UserS");
        String Email = obj.getString("Email");
        String Password = obj.getString("Password");
        String Activate = obj.getString("Activate");
        Random random =new Random();
        long a=random.nextLong();
        db.get().registerStorage.put(""+a,new registerDot(UserN,UserS,Email,Password,Activate,""+a));

        String body = "http://localhost:1314/education/api/email/asd?id="+a;

        Email emailSend = new Email();
        emailSend.setFrom("140103014@stu.sdu.edu.kz");
        emailSend.setTo(Email);
        emailSend.setSubject("Registration Finish");
        emailSend.setBody(body);


        emailSenderBeanGetter.get().send(emailSend);
        emailSenderControllerBeanGetter.get().sendAllExistingEmails();

       return "Ok newUser";
    }


    @Override
    public String getUserLog(String json){
        System.out.println(json);
        JSONObject obj = new JSONObject(json);
        String UserN = obj.getString("UserN");
        String Password = obj.getString("Password");
        return "Ok Login";
    }
}
