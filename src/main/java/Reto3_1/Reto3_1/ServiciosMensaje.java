
package Reto3_1.Reto3_1;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosMensaje {
    @Autowired
    private RepositorioMensaje metodosCrud;

    public List<ModeloMensaje> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<ModeloMensaje> getMessage(int messageId) {
        return metodosCrud.getMessage(messageId);
    }

    public ModeloMensaje save(ModeloMensaje message){
        if(message.getIdMessage()==null){
            return metodosCrud.save(message);
        }else{
            Optional<ModeloMensaje> e= metodosCrud.getMessage(message.getIdMessage());
            if(e.isEmpty()){
                return metodosCrud.save(message);
            }else{
                return message;
            }
        }
    }
    
}
