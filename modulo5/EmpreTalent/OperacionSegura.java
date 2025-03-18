package modulo5.EmpreTalent;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@interface OperacionSegura {
    String descripcion();    
}
