package pl.isa.raportmodule.raportCreator;


import pl.isa.raportmodule.domain.Log;


public class ClientKeyOperator {

    public Boolean checkKey(Log log) {
        if (log.getKey().equals("2137")) {
            return true;
        }
        return false;
    }
}
