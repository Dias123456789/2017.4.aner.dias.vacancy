package kz.greetgo.education.controller.controller;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.education.controller.register.ClientRegister;
import kz.greetgo.education.controller.register.RegRegister;
import kz.greetgo.education.controller.utils.Controller;
import kz.greetgo.mvc.annotations.Mapping;
import kz.greetgo.mvc.annotations.Par;
import kz.greetgo.mvc.annotations.ParPath;

@Bean
@Mapping("/email")
public class EmailControler implements Controller{
    public BeanGetter<RegRegister> userRegisterBeanGetter;

    @Mapping("/asd")
    public void sentEmail(@Par("i" +
            "d") String num){
        System.out.println(num);
        String username = userRegisterBeanGetter.get().acceptUser(num);
        System.out.println(username);
    }
}
