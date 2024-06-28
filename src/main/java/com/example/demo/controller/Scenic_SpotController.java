package com.example.demo.controller;
import com.example.demo.model.Attraction;
import com.example.demo.model.Point;
import com.example.demo.model.Scenic_Spot;
import com.example.demo.service.AttractionService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.User;

import com.example.demo.service.Scenic_SpotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/select")
public class Scenic_SpotController {


    @Autowired
    private Scenic_SpotService scenic_SpotService;
    @Autowired
    private UserService userService;


    @Autowired
    private AttractionService attractionService;

    @PutMapping("/selectoption")
    public ResponseEntity<?> userSelect(@RequestBody Selectoption selectoption) {




        List<Attraction> attractionList = new ArrayList<>();
        List<Scenic_Spot> newspotlist=scenic_SpotService.getAllScenic_Spot();

        for (Scenic_Spot spot : newspotlist) {
            Attraction myAttraction = new Attraction();
            Point newpoint =new Point();
            String selectInterest = selectoption.getinterest();
            String selectdays = selectoption.getdays();
            String scenicInterest = spot.getClassification();
            String scenicduring = spot.getDuring();
            String scenicprice = spot.getPrice();
            String selectprice = selectoption.gettickets();

            int selectInterestBinary = Integer.parseInt(selectInterest, 2);
            int scenicInterestBinary = Integer.parseInt(scenicInterest, 2);
            int selectdaysBinary = Integer.parseInt(selectdays, 2);
            int scenicduringBinary = Integer.parseInt(scenicduring, 2);
            int price = Integer.parseInt(scenicprice);
            String[] moreprice = selectprice.split("");//
            int[] numbers = new int[moreprice.length];//
            for (int i = 0; i < moreprice.length; i++) {
                numbers[i] = Integer.parseInt(moreprice[i]);
            }

            int result1 = selectInterestBinary & scenicInterestBinary;
            int result2 = selectdaysBinary & scenicduringBinary;
            int countOnes1 = Integer.bitCount(result1);
            int countOnes2 = Integer.bitCount(result2);

            if( (countOnes1 >= 3&&countOnes2 >= 3) &&((price==1&&numbers[0]==1)||(price==0&&numbers[1]==1))){
                myAttraction.setTitle(spot.getName());
                newpoint.setLng(spot.getLocate_x());
                newpoint.setLat(spot.getLocate_y());
                myAttraction.setPoint(newpoint);
                myAttraction.setUserId(selectoption.email);
                System.out.println(myAttraction.getTitle());
                attractionService.saveoneAttraction( myAttraction);
            }

        }
       /* attractionService.saveAttractions(attractionList);*/
        return ResponseEntity.ok(selectoption);
    }

    @PostMapping("/{id}")
    public User deleteattraction(@PathVariable String id) {
        attractionService.deleteall();
        return userService.getUserById(id);
    }

    public static class DeleteRequest {
        private String email;


        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }


    }


    public static class Selectoption {
        public String email;
        public int minage;
        public int maxage;
        public String  sex;
        public String tickets;
        public String days;
        public String interest;

        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public int getMinage() {
            return minage;
        }
        public int getMaxage() {
            return maxage;
        }
        public String getsex() {
            return sex;
        }
        public String gettickets() {
            return tickets;
        }
        public String getdays() {
            return days;
        }
        public String getinterest() {
            return interest;
        }


    }
}
