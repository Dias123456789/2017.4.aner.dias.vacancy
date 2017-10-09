package kz.greetgo.education.stand.register_stand_impl;


        import kz.greetgo.depinject.core.Bean;
        import kz.greetgo.depinject.core.BeanGetter;
        import kz.greetgo.education.controller.model.DictionaryInfo;
        import kz.greetgo.education.controller.model.DictionaryListDetails;
        import kz.greetgo.education.controller.register.DictionaryRegister;
        import kz.greetgo.education.stand.register_stand_impl.db.Db;

@Bean
public class DictionaryRegisterStandImpl implements DictionaryRegister {
    public BeanGetter<Db> db;

    @Override
    public DictionaryListDetails getDictionaryListDetails(){
        DictionaryListDetails ret = new DictionaryListDetails();

        db.get().dictionaryStorage.values().forEach(r->{
            DictionaryInfo dictionaryInfo = new DictionaryInfo();
            dictionaryInfo.code = r.code;
            dictionaryInfo.title = r.title;
            ret.dictionaryInfoList.add(dictionaryInfo);
        });
        return ret;
    }
}