package tapastop.services;

import tapastop.model.Tapa;
import tapastop.reponses.TapaResponse;
import tapastop.requests.TapaCoreRequest;

import java.util.List;

public interface TapaService {
    public TapaResponse findById(Long id);
    public TapaResponse save(TapaCoreRequest tapa);
    public List<TapaResponse> findAll();
    public void deleteById(Long id);
}
