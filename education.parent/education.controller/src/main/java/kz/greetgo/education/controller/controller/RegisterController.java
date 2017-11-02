package kz.greetgo.education.controller.controller;

import kz.greetgo.education.controller.model.registerInfo;
import kz.greetgo.education.controller.register.RegRegister;
import kz.greetgo.education.controller.utils.Controller;
import kz.greetgo.mvc.annotations.Mapping;
import kz.greetgo.mvc.annotations.RequestInput;
import kz.greetgo.mvc.annotations.ToJson;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;

import java.util.List;

@Bean
@Mapping("/reg")
public class RegisterController implements Controller {
    public BeanGetter<RegRegister> regRegister;
    @ToJson
    @Mapping("/NewUser")
    public String getNewUser(@RequestInput String json) { return regRegister.get().getNewUser(json); }
    @ToJson
    @Mapping("/user")
    public List<registerInfo> getNewUser(){return regRegister.get().getRegisterList();}
    @ToJson
    @Mapping("/UserLog")
    public List<registerInfo> getUserLog(){return regRegister.get().getRegisterList();}
}
