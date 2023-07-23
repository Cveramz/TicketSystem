package sistemaTicket.backend.services;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sistemaTicket.backend.entities.AdministradorEntity;
import sistemaTicket.backend.entities.TicketEntity;
import sistemaTicket.backend.repositories.AdministradorRepository;
import org.springframework.stereotype.Service;
import sistemaTicket.backend.repositories.TicketRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@RequestMapping(value = "/administrador")
@RestController
@CrossOrigin(origins = "http://localhost:5173")
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




    public <S extends TicketEntity> S saveAndFlush(S entity) {
        return null;
    }


    public <S extends TicketEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }


    public void deleteAllInBatch(Iterable<TicketEntity> entities) {

    }


    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }


    public void deleteAllInBatch() {

    }


    public TicketEntity getOne(Long aLong) {
        return null;
    }


    public TicketEntity getById(Long aLong) {
        return null;
    }


    public TicketEntity getReferenceById(Long aLong) {
        return null;
    }


    public <S extends TicketEntity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }


    public <S extends TicketEntity> List<S> findAll(Example<S> example) {
        return null;
    }


    public <S extends TicketEntity> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }


    public <S extends TicketEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }


    public <S extends TicketEntity> long count(Example<S> example) {
        return 0;
    }


    public <S extends TicketEntity> boolean exists(Example<S> example) {
        return false;
    }


    public <S extends TicketEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }


    public <S extends TicketEntity> S save(S entity) {
        return null;
    }


    public <S extends TicketEntity> List<S> saveAll(Iterable<S> entities) {
        return null;
    }


    public Optional<TicketEntity> findById(Long aLong) {
        return Optional.empty();
    }


    public boolean existsById(Long aLong) {
        return false;
    }


    public List<TicketEntity> findAll() {
        return null;
    }


    public List<TicketEntity> findAllById(Iterable<Long> longs) {
        return null;
    }


    public long count() {
        return 0;
    }


    public void deleteById(Long aLong) {

    }


    public void delete(TicketEntity entity) {

    }


    public void deleteAllById(Iterable<? extends Long> longs) {

    }


    public void deleteAll(Iterable<? extends TicketEntity> entities) {

    }


    public void deleteAll() {

    }


    public List<TicketEntity> findAll(Sort sort) {
        return null;
    }


    public Page<TicketEntity> findAll(Pageable pageable) {
        return null;
    }
}
