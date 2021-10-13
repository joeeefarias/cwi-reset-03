package br.com.cwi.reset.joacyfarias.service;

import br.com.cwi.reset.joacyfarias.repository.FakeDatabase;

public class DiretorService {

    private FakeDatabase fakeDatabase;

    public DiretorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }


}
