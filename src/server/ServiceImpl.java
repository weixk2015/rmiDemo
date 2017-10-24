package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServiceImpl extends UnicastRemoteObject implements IService {

    private String name;

    protected ServiceImpl(String name) throws RemoteException {
        this.name = name;
    }

    @Override
    public String service(String content) throws RemoteException {
        return "server " + name + ">>" + content ;
    }
}
