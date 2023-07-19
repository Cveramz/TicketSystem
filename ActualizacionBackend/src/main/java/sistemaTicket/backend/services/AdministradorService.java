package sistemaTicket.backend.services;
import sistemaTicket.backend.entities.AdministradorEntity;
import sistemaTicket.backend.entities.TicketEntity;
import sistemaTicket.backend.repositories.AdministradorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdministradorService{
   AdministradorRepository administradorRepository;
   public AdministradorEntity guardar(AdministradorEntity administrador){
       return administradorRepository.save(administrador);
   }
   public Iterable<AdministradorEntity> obtenerTodosAdministradores(){
       return administradorRepository.findAll();
   }

   public Optional<AdministradorEntity> obtenerIdAdministrador(Long id){
       return(administradorRepository.findById(id));
   }
   public void eliminarAdministrador(AdministradorEntity administrador){
       administradorRepository.delete(administrador);
   }
   public void actualizar(AdministradorEntity administrador){
       administradorRepository.save(administrador);
   }

   public void EliminarTicket(Long id){
      administradorRepository.deleteById(id);
   }

}
