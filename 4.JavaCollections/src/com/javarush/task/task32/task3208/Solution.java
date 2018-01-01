package com.javarush.task.task32.task3208;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/* 
RMI-2
*/
public class Solution {
    public static Registry registry;
    public static final String UNIC_BINDING_NAME = "server.animal";

    //pretend we start rmi client as CLIENT_THREAD thread
    public static Thread CLIENT_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                for (String bindingName : registry.list()) {
                    Animal service = (Animal) registry.lookup(bindingName);
                    service.printName();
                    service.say();
                }
            } catch (RemoteException e) {
                System.err.println(e.getStackTrace());
            } catch (NotBoundException e) {
                System.err.println(e.getStackTrace());
            }
        }
    });

    //pretend we start rmi server as SERVER_THREAD thread
    public static Thread SERVER_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                registry = LocateRegistry.createRegistry(2099);
                Cat cat = new Cat("Vasilii");
                Dog dog = new Dog("Sharik");
                Remote stub1 = UnicastRemoteObject.exportObject(cat,2099);
                Remote stub2 = UnicastRemoteObject.exportObject(dog,2099);
                try {
                    registry.bind(UNIC_BINDING_NAME,stub1);
                    registry.bind(UNIC_BINDING_NAME,stub2);
                } catch (AlreadyBoundException e) {
                    System.err.println(e.getStackTrace());


                }
            } catch (RemoteException e) {
                System.err.println(e.getStackTrace());
            }
            //напишите тут ваш код
        }
    });

    public static void main(String[] args) throws InterruptedException {
        //start rmi server thread
        SERVER_THREAD.start();
        Thread.sleep(1000);
        //start client
        CLIENT_THREAD.start();
    }
}