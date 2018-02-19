package pl.isa.raportmodule.raportCreator;

//import pl.isa.raportmodule.domain.ClientKey;

import pl.isa.raportmodule.domain.Log;

//import pl.isa.raportmodule.repository.ClientKeyRepository;

public class ClientKeyOperator {
//    @Inject
//    ClientKeyRepository clientKeyRepository;

    public Boolean checkKey(Log log) {
//        for (ClientKey clientKey : clientKeyRepository.getKeys()) {
//            if (log.getKey() == clientKey.getKey())
        if(log.getKey()==2137){
                return true;
        }
        return false;
    }
}
