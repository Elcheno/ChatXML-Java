package com.dam.chatsocket_java.model.connections;

import com.dam.chatsocket_java.model.domain.Room;
import com.dam.chatsocket_java.model.domain.Rooms;
import com.dam.chatsocket_java.model.domain.Users;

import javax.xml.bind.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ConnectionXML {
    static final File fileRooms = new File("rooms.xml");
    static final File fileUsers = new File("users.xml");

    public ConnectionXML() {}

    public Rooms loadXMLRooms() throws IllegalArgumentException, JAXBException{
        Rooms result = null;
        if(fileRooms.exists()){
            JAXBContext jc = JAXBContext.newInstance(Rooms.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            result = (Rooms) unmarshaller.unmarshal(fileRooms);
        }
        return result;
    }

    public void writeXMLRooms(Rooms rooms) throws JAXBException, IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileRooms))) {
            JAXBContext jc = JAXBContext.newInstance(Rooms.class);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(rooms, writer);
        }
    }

    public void writeXMLUser(Users userList) throws JAXBException, IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileUsers))) {
            JAXBContext jc = JAXBContext.newInstance(Users.class);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(userList, writer);
        }
    }

    public Users loadXMLUsers() throws IllegalArgumentException, JAXBException{
        Users result = null;
        if(fileUsers.exists()){
            JAXBContext jc = JAXBContext.newInstance(Users.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            result = (Users) unmarshaller.unmarshal(fileUsers);
        }
        return result;
    }

    public Room loadXMLRoom(Room room) throws IllegalArgumentException, JAXBException{
        Room result = null;
        if(room != null){
            JAXBContext jc = JAXBContext.newInstance(Room.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            result = (Room) unmarshaller.unmarshal(new File("room_"+room.getIdRoom()+".xml"));
        }
        return result;
    }

    public void writeXMLRoom(Room room) throws IOException, JAXBException{
        if(room != null){
            try (FileWriter writer = new FileWriter("room_"+room.getIdRoom()+".xml")){
                JAXBContext jc = JAXBContext.newInstance(Room.class);
                Marshaller marshaller = jc.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                marshaller.marshal(room, writer);
            }
        }
    }

}