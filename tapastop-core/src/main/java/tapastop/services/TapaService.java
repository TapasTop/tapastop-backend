package tapastop.services;

import tapastop.model.Tapa;

import java.util.List;

public interface TapaService {
    public Tapa findById(Long id);
    public Tapa save(Tapa tapa);
    public List<Tapa> findAll();
    public void deleteById(Long id);
}
