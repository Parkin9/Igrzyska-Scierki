package pl.parkin9.IgrzyskaScierki.implementation;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.parkin9.IgrzyskaScierki.model.Login;
import pl.parkin9.IgrzyskaScierki.model.PlayerGroup;
import pl.parkin9.IgrzyskaScierki.repository.PlayerGroupRepository;
import pl.parkin9.IgrzyskaScierki.service.ValidationLoginService;

@Service
public class ValidationLoginServiceImpl implements ValidationLoginService {

    private final PlayerGroupRepository playerGroupRepository;

    @Autowired
    public ValidationLoginServiceImpl(PlayerGroupRepository playerGroupRepository) {
        this.playerGroupRepository = playerGroupRepository;
    }

/////////////////////////////////////////////////////////////////////////////

    public Boolean checkPassword(Login login) {

        PlayerGroup playerGroup = playerGroupRepository.findFirstByName(login.getLoginName());

        return playerGroup != null && BCrypt.checkpw(login.getPassword(), playerGroup.getPassword());
    }
}
