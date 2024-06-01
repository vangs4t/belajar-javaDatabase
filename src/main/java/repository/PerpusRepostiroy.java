package repository;

import enitiy.Perpus;

import java.util.List;

public interface PerpusRepostiroy {
    void save(Perpus perpus);

    Perpus searchByTitle(String title);

    List<Perpus> findAll();

    List<Perpus> findAllByEmail(String email);
}
