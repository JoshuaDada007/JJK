package org.example.twitter.Tweets;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.coyote.RequestInfo;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;


@Component
@RestController
public class TwitterController {
    public static int id = 1;
    // This is used to put your txt in the builder folder for deployment
    private ApplicationHome home = new ApplicationHome(TwitterApplication.class);
    RestTemplate restTemplate = new RestTemplate();


    @RequestMapping(value = "/helloWorld", method = RequestMethod.GET)

    public String hello(){
        return "Hello World";
    }
    @RequestMapping(value = "/getSorcerer/{id}", method = RequestMethod.GET)
    public Twitter getSorcerer(@PathVariable int id) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Scanner sc = new Scanner(new File(home.getDir() + "twitter.txt"));
        while(sc.hasNext()){
            String line = sc.nextLine();
            Twitter sorcerer = mapper.readValue(line, Twitter.class);
            if(sorcerer.getId() == id){
                return sorcerer;
            }
        }
        return null;
    }



    @RequestMapping(value = "/createSorcerer", method = RequestMethod.POST)
    public Twitter createSorcerer(@RequestBody String str) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Twitter newSorcerer = new Twitter(++id, str, "Yooooo", true);
        String user = mapper.writeValueAsString(newSorcerer);
        FileUtils.writeStringToFile(new File(home.getDir() + "twitter.txt"),  user + "\n", "UTF-8", true);
        return newSorcerer;
    }

    @RequestMapping(value = "/cullingGames", method = RequestMethod.POST)
    public Twitter cullingGames() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
    String randomString = UUID.randomUUID().toString();
        Twitter newSorcerer = new Twitter(++id,randomString , "Yooooo", true);
        int randnum = (int)Math.floor(Math.random() * 35000) + 15000;
        newSorcerer.setId(randnum);
        String sorcerer = mapper.writeValueAsString(newSorcerer);
        FileUtils.writeStringToFile(new File(home.getDir() + "twitter.txt"),"\n" + sorcerer, "UTF-8", true);
        return newSorcerer;
    }























    }


//@RequestMapping(value = "/updateUser/{id}", method = RequestMethod.PATCH)
//public Twitter updateUser(@PathVariable int id, @RequestBody String str)throws IOException{
//    List <String> myList = FileUtils.readLines(new File("twitter.txt"));
//    ObjectMapper mapper = new ObjectMapper();
//
//    for(int i = 0; i < myList.size(); i++){
//        Twitter user = mapper.readValue(myList.get(i), Twitter.class);
//        if(user.getId() == id){
//            user.setUserName(str);
//            String message = mapper.writeValueAsString(user);
//            myList.set(i, message);
//            for(String lists: myList){
//                System.out.println(lists);
//            }
//            break;
//        }
//    }
//    FileUtils.writeStringToFile(new File("twitter.txt"), "", "UTF-8");
//    for(String list : myList){
//        FileUtils.writeStringToFile(new File("twitter.txt"), list + "\n", "UTF-8", true);
//    }
//    return null;
//}



//@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
//public void deleteUser(@PathVariable int id) throws IOException {
//    List <String> myList = FileUtils.readLines(new File("twitter.txt"));
//    ObjectMapper mapper = new ObjectMapper();
//    for(int i = 0; i < myList.size(); i++){
//        Twitter user = mapper.readValue(myList.get(i), Twitter.class);
//        if(user.getId() == id){
//            myList.remove(i);
//            System.out.println(user.getUserName() + "has been deleted");
//
//        }
//        break;
//    }
//
//    FileUtils.writeStringToFile(new File("twitter.txt"), "", "UTF-8");
//    for(String list: myList){
//        FileUtils.writeStringToFile(new File("twitter.txt"), "\n" + list, "UTF-8", true);
//    }
//    System.out.println("Invalid id");
//}















































//        allVehicles.add(file);
//
//        System.out.println(file);










//public static int id = 0;
//ArrayList<Vehicle> allVehicles = new ArrayList();
//File file = new File("vehicle.txt");
//Scanner scanner;
//ObjectMapper mapper;
//
//@RequestMapping(value = "/addVehicle", method = RequestMethod.POST)
//public Vehicle addVehicle(@RequestBody String model) throws IOException {
//    Vehicle newVehicle = new Vehicle(id, model, 2023, 2900);
//    ObjectMapper mapper = new ObjectMapper();
//    String json = mapper.writeValueAsString(newVehicle);
//    FileUtils.writeStringToFile(new File("vehicle.txt"), json + "\n", "UTF-8", true);
//    return newVehicle;
//}
//@RequestMapping("/getVehicle/{id}")
//public Vehicle getVehicle(@PathVariable int id) throws IOException {
//    try {
//        scanner  = new Scanner(file);
//
//    } catch(FileNotFoundException e) {
//        System.out.println("File not found");
//    }
//    while(scanner.hasNext()){
//        String line = scanner.nextLine();
//
//        Vehicle vehicle = mapper.readValue(line, Vehicle.class);
//        if(vehicle.getId() == id){
//            return vehicle;
//        }
//
//    }
//    return null;
//
//}
//
//
//@RequestMapping(value = "/updateVehicle", method = RequestMethod.PUT)
//public Vehicle updateVehicle(@RequestBody Vehicle updatedVehicle) throws IOException {
//    List<String> myList = FileUtils.readLines(file, "UTF-8");
//    ObjectMapper mapper = new ObjectMapper();
//    boolean updated = false;
//
//    for (int i = 0; i < myList.size(); i++) {
//        Vehicle vehicle = mapper.readValue(myList.get(i), Vehicle.class);
//        if (vehicle.getId() == updatedVehicle.getId()) {
//            myList.set(i, mapper.writeValueAsString(updatedVehicle));
//            updated = true;
//            break;
//        }
//    }
//    if (updated) {
//        FileUtils.writeLines(file, myList, false);
//    }
//
//    return updatedVehicle;
//}
//
//@RequestMapping(value = "/deleteVehicle", method = RequestMethod.DELETE)
//public String deleteVehicle(@RequestBody Vehicle deleteVehicle) throws IOException {
//    List<String> myList = FileUtils.readLines(file, "UTF-8");
//    ObjectMapper mapper = new ObjectMapper();
//    boolean deleted = false;
//    for (int i = 0; i < myList.size(); i++) {
//        Vehicle vehicle = mapper.readValue(myList.get(i), Vehicle.class);
//        if (vehicle.getId() == deleteVehicle.getId()) {
//            myList.remove(i);
//            deleted = true;
//            break;
//        }
//    }
//    if (deleted) {
//        FileUtils.writeLines(file, myList, false);
//        return "Vehicle deleted successfully";
//    } else {
//        return "Vehicle not found";
//    }
//}
//
//@RequestMapping(value = "/helloVehicle", method = RequestMethod.GET)
//public String helloVehicle() throws IOException {
//    return "Hello World";
//}
//@RequestMapping(value = "/addToVehicle", method = RequestMethod.POST)
//public ArrayList addToVehicle(@RequestBody String model){
//    id++;
//    Vehicle newVehicle = new Vehicle(id, model, 2023, 29000);
//    allVehicles.add(newVehicle);
//    return allVehicles;
//}
//

//
//@RequestMapping(value = "/readScanner", method = RequestMethod.POST)
//public void readScanner(@RequestBody String model) throws IOException{
//    ArrayList<String> vehicles = new ArrayList<>();
//    for(Vehicle vehicle: allVehicles){
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.writeValue(new File("vehicle.txt"), vehicle);
//        String item = FileUtils.readFileToString(new File("vehicle.txt"), "UTF-8");
//        vehicles.add(item);
//    }
//    for(String item: vehicles){
//        System.out.println(item);















//    @RequestMapping(value = "/addTest", method = RequestMethod.POST)
//    public Vehicle addTest(@RequestBody String model) throws IOException{
//        id++;
//        Vehicle addVehicle = new Vehicle(id, model, 2023, 29000);
//        ObjectMapper mapper = new ObjectMapper();
//        String cars = mapper.writeValueAsString(addVehicle);
//        FileUtils.writeStringToFile(new File("vehicle.txt"), cars + "\n", "UTF-8", true);
//        return addVehicle;
//    }
//
//    @RequestMapping(value = "/updateTest/{id}", method = RequestMethod.PUT)
//
//    public void updateTest(@PathVariable int id) throws FileNotFoundException, IOException{
//        ObjectMapper mapper = new ObjectMapper();
//        Scanner scanner = new Scanner(new File("vehicle.txt"));
//
//             if(scanner.hasNext()) {
//                 String line = scanner.nextLine();
//                Vehicle item = mapper.readValue(line, Vehicle.class);
//                if(item.getId() == id){
//                    item.setMakeModel("Chevrolet Camaro");
//                } else{
//                    System.out.println("No such ID");
//                }
//                 System.out.println("null");
//             }
//        System.out.println("File has been read");
//    }
//
//}
//
//




















//
//{"id":69,"makeModel":"Honda Accord","year":2023,"retailPrice":27000.99}
//        {"id":2,"makeModel":"Hyundai Sonata","year":2021,"retailPrice":69000.99}
//        {"id":99,"makeModel":"Toyota Camry","year":2021,"retailPrice":12000.99}


