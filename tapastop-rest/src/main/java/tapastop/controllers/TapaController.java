package tapastop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tapastop.converters.TapaRequestConverter;
import tapastop.converters.TapaResponseConverter;
import tapastop.converters.UserRequestConverter;
import tapastop.model.Tapa;
import tapastop.reponses.TapaResponse;
import tapastop.requests.SaveTapaRequest;
import tapastop.services.TapaService;

import java.util.List;

@RestController
public class TapaController {

    @Autowired
    private TapaService tapaService;

    @GetMapping("/tapa")
    public ResponseEntity<List<TapaResponse>> getAllTapas(){
        ResponseEntity<List<TapaResponse>> responseEntity = new ResponseEntity<>(tapaService.findAll(), HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/tapa/{id}")
    public ResponseEntity<TapaResponse> getTapa(@PathVariable Long id){
        ResponseEntity<TapaResponse> responseEntity = new ResponseEntity<>(tapaService.findById(id), HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping("/tapa")
    public ResponseEntity<TapaResponse> saveTapa(@RequestBody SaveTapaRequest tapa){
        TapaRequestConverter tapaRequestConverter = new TapaRequestConverter();
        ResponseEntity<TapaResponse> responseEntity = new ResponseEntity<>(tapaService.save(tapaRequestConverter.convert(tapa)), HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/tapa/{id}")
    public ResponseEntity<String> deleteTapa(@PathVariable Long id){
        tapaService.deleteById(id);
        ResponseEntity<String> responseEntity = new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/tapa/taste/{taste}")
    public ResponseEntity<List<TapaResponse>> findByTaste(@PathVariable String taste) {
        ResponseEntity<List<TapaResponse>> responseEntity = new ResponseEntity<>(tapaService.findByTaste(taste), HttpStatus.OK);
        return responseEntity;
    }

}
