package example;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.CORBA.Object;

public class FibonacciServer {
    
    public static void main(String args[]){
        try{
            //creae instancia del ORB
           ORB orb = ORB.init(args, null);
           //crear instancia POA
           POA rootPoa = POAHelper.narrow(orb.resolve_initial_references("rootPoa"));
           //activar POA manager
           rootPoa.the_POAManager().activate();
           
           //Instancia de clase fibonacci
           FibonacciImp fiboImp = new FibonacciImp();
           //Obtine la referencia de la clase FibonacciImp (servat)
           Object ref = rootPoa.servant_to_reference(fiboImp);
           Fibonacci href = FibonacciHelper.narrow(ref);
           //Obtener referencia del servidor de directorios
           Object objRef = orb.resolve_initial_references("NameService");
           NamingContextExt rootContext = NamingContextExtHelper.narrow(objRef);
           
           NameComponent nameComponent[] = rootContext.to_name("Fibonacci");
           rootContext.rebind(nameComponent, href);
           
           //Listo para recibir peticiones
           System.out.println("Servidro > listo y en espera");
           orb.run();
           
        }catch(Exception ex){
            System.err.println("Error: "+ex.getMessage());
        ex.printStackTrace();
        }
    }
}
