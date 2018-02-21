package pl.isa.raportmodule.raportCreator;


import pl.isa.raportmodule.domain.ClientKey;
import pl.isa.raportmodule.domain.Log;
import pl.isa.raportmodule.repository.ClientKeysRepository;

import javax.inject.Inject;


public class ClientKeyOperator {
    @Inject
    ClientKeysRepository clientKeysRepository;

    public Boolean checkKey(Log log) {
//        if (log.getKey().equals("2137")) {
//            return true;
//        }
        try {
            for (ClientKey clientKey : clientKeysRepository.getAllKeys()) {
                if (log.getKey().equals(clientKey.getClientKey())) {
                    return true;
                }
            }
        } catch (NullPointerException e) {
            return false;
        }
        return false;
    }
}
