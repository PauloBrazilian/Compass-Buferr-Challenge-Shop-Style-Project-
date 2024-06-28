package shopstyle.mscustomer.framework.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CustomerNotFoundException extends RuntimeException{

   public CustomerNotFoundException(String id){
       super("The " + id + " not found");
   }

    public CustomerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}