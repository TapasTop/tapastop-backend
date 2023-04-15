package tapastop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tapastop.model.Tapa;
import tapastop.services.TapaService;

import java.util.List;

@RestController
public class TapaController {

    @Autowired
    private TapaService tapaService;

    @GetMapping("/tapa")
    public ResponseEntity<List<Tapa>> getAllTapas(){
        ResponseEntity<List<Tapa>> responseEntity = new ResponseEntity<>(tapaService.findAll(), HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/tapa/{id}")
    public ResponseEntity<Tapa> getTapa(@PathVariable Long id){
        ResponseEntity<Tapa> responseEntity = new ResponseEntity<>(tapaService.findById(id), HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping("/tapa")
    public ResponseEntity<Tapa> saveTapa(@RequestBody Tapa Tapa){
        ResponseEntity<Tapa> responseEntity = new ResponseEntity<>(tapaService.save(Tapa), HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/tapa/{id}")
    public ResponseEntity<String> deleteTapa(@PathVariable Long id){
        tapaService.deleteById(id);
        ResponseEntity<String> responseEntity = new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
        return responseEntity;
    }
}
