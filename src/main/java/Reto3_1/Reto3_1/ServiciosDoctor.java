
package Reto3_1.Reto3_1;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosDoctor {
    @Autowired
    private RepositorioDoctor metodosCrud;

    public List<ModeloDoctor> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<ModeloDoctor> getDoctor(int idDoctor) {
        return metodosCrud.getDoctor(idDoctor);
    }

    public ModeloDoctor save(ModeloDoctor doctor){
        if(doctor.getId()==null){
            return metodosCrud.save(doctor);
        }else{
            Optional<ModeloDoctor> e=metodosCrud.getDoctor(doctor.getId());
            if(e.isEmpty()){
                return metodosCrud.save(doctor);
            }else{
                return doctor;
            }
        }
    }
    
}
