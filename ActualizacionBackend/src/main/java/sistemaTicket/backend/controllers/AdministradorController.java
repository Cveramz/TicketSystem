package sistemaTicket.backend.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sistemaTicket.backend.entities.AdministradorEntity;
import sistemaTicket.backend.services.AdministradorService;
import java.net.URI;
import java.net.URISyntaxException;


@RestController
@RequestMapping("/Administrador")
@CrossOrigin(origins = "http://localhost:5173") //Solicitar peticiones
public class AdministradorController{
    @Autowired
    AdministradorService administradorService;
    @GetMapping(value = "/{idAdministrador}")
    @CrossOrigin("*")
    /*Funcion para obtener a un administrador mediante su id
      Recibe como parametros idAdministrador
      Retorna como id a traves del getmapping el administrador
     */
    public ResponseEntity<AdministradorEntity> obtenerAdministrador(@PathVariable Long idAdministrador){
        return ResponseEntity.ok(administradorService.getAdministradorByUser_id(idAdministrador)); //Se obtiene el administrador por id
    }
    @GetMapping
    @CrossOrigin("*")

    /*Funcion para guardar un administrador
      Recibe como parametros administradorEntity y nuevoAdministrador
      Retorna la informacion guardada de un administrador del sistema
     */
    public ResponseEntity<AdministradorEntity> guardar(AdministradorEntity nuevoAdministradorEntity){
        AdministradorEntity NuevoAdmin = administradorService.guardar(nuevoAdministradorEntity);
        return new ResponseEntity<>(NuevoAdmin, HttpStatus.OK);
    }

    @GetMapping
    @CrossOrigin("*")
    /*Funcion para actualizar los administradores
      Recibe como parametros AdministradorEntity X Administrador
      Retorna la actualizacion de un administrador en el sistema
     */
    public ResponseEntity<AdministradorEntity> updateAdministrador(@RequestBody AdministradorEntity administrador){
        try{
            AdministradorEntity administrador1 = administradorService.save(administrador);
            return ResponseEntity.created(new URI("/Administrador"+administrador1.getId())).body(administrador1);
        }catch (URISyntaxException e){
            throw new RuntimeException(e);
        }
    }
}
