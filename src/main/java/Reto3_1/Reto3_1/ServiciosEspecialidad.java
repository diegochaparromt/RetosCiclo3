
package Reto3_1.Reto3_1;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosEspecialidad {
    @Autowired
    private RepositorioEspecialidad metodosCrud;
    
    public List<ModeloEspecialidad> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<ModeloEspecialidad> getSpecialty(int idSpecialty){
        return metodosCrud.getSpecialty(idSpecialty);
    }
    
    public ModeloEspecialidad save(ModeloEspecialidad specialty){
        if(specialty.getId()==null){
            return metodosCrud.save(specialty);
        }else{
            Optional<ModeloEspecialidad> e= metodosCrud.getSpecialty(specialty.getId());
            if(e.isEmpty()){
                return metodosCrud.save(specialty);
            }else{
                return specialty;
            }
        }
    }
    
}
