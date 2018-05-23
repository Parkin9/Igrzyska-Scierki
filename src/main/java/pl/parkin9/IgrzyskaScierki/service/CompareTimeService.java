package pl.parkin9.IgrzyskaScierki.service;

import javax.servlet.http.HttpSession;

public interface CompareTimeService {

    Integer compare(HttpSession sess);
}
