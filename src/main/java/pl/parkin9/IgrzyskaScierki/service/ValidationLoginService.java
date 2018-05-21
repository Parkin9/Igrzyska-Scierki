package pl.parkin9.IgrzyskaScierki.service;

import pl.parkin9.IgrzyskaScierki.model.Login;

public interface ValidationLoginService {

    Boolean checkPassword(Login login);
}
