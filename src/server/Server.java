package server;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args){
        try {
            IService service01 = new ServiceImpl("service01");
            LocateRegistry.createRegistry(8888);
            Naming.bind("rmi://localhost:8888/service01",service01);
        } catch (RemoteException | MalformedURLException | AlreadyBoundException e) {
            e.printStackTrace();
        }
        System.out.println("one remote object has been registered");
    }

}
