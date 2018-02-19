package pl.isa.raportmodule.raportCreator;

import pl.isa.raportmodule.domain.Log;

public class ClientKeyOperator {
    public static Boolean checkKey(Log log){
        if(log.getKey()==2137)
            return true;
        return false;
    }
}
