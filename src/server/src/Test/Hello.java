package Test;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "CalculatorWS")
public class Hello {

    @WebMethod
    public int add (@WebParam (name= "value1") int value1, @WebParam( name="value2" ) int value2){
        return value1 + value2;
    }
}
