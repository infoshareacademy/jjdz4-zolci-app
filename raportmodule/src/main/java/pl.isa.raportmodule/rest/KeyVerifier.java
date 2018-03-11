package pl.isa.raportmodule.rest;

import pl.isa.raportmodule.domain.ClientKey;
import pl.isa.raportmodule.domain.Log;
import pl.isa.raportmodule.repository.ClientKeysRepository;

import javax.inject.Inject;

public class KeyVerifier {
    @Inject
    ClientKeysRepository clientKeysRepository;

    public Boolean checkKey(Log log){
        for(ClientKey clientKey : clientKeysRepository.getAllKeys()){
            if(clientKey.getClientKey().equals(log.getKey()))
                return true;
        }
        return false;
    }
}
