package com.mainpackage.tripPlan.controllers;

import com.mainpackage.tripPlan.DummyModels.DummyDailyBudget;
import com.mainpackage.tripPlan.DummyModels.DummyNotes;
import com.mainpackage.tripPlan.dto.DailyBudgetDTO;
import com.mainpackage.tripPlan.dto.NotesDTO;
import com.mainpackage.tripPlan.services.CommentService;
import com.mainpackage.tripPlan.services.TripPageService;
import com.mainpackage.tripPlan.services.TripService;
import java.text.ParseException;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "tripPage/")
public class UsersTripsPageController {

    @Autowired
    TripService tripService;
    @Autowired
    CommentService commentService;
    @Autowired
    TripPageService tripPageService;

    @GetMapping(value = "{username}/{id}")
    @ResponseBody
    public Map<String, Object> preSubmitTrip(@PathVariable(name = "username") String username,
            @PathVariable(name = "id") String id) {

        try {
            return tripService.getTripsPageDataByUsernameAndTripId(username, id);

        } catch (Exception e) {
            e.printStackTrace();

            Map<String, Object> error = new HashMap<>();
            error.put("error", e.getMessage());

            return error;
        }
    }

    @PostMapping(value = "saveNote", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String saveNote(@RequestBody DummyNotes notes) throws ParseException {
        tripPageService.saveNotes(notes);
        return "successs";
    }

    @PostMapping(value = "saveBudget", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String saveBudget(@RequestBody DummyDailyBudget budget) throws ParseException {
        tripPageService.saveBudget(budget);
        return "successs";
    }

    @GetMapping(value = "getNotes/{tripId}/{date}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<NotesDTO> getNotes(@PathVariable(name = "tripId") String id,
            @PathVariable(name = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) throws ParseException {

        return tripPageService.getNotesByIdAndDate(Integer.parseInt(id),date);
    }

    @GetMapping(value = "getDailyBudget/{tripId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<DailyBudgetDTO> getDailyBudgetWithTripId(@PathVariable(name = "tripId") String tripId) throws ParseException {

        return tripPageService.getDailyBudgetByTripId(Integer.parseInt(tripId));
    }
    
    @GetMapping(value = "getDailyBudget/{tripId}/{date}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<DailyBudgetDTO> getDailyBudgetWithDateAndTripId(@PathVariable(name = "tripId") String id,
           @PathVariable(name = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date ) throws ParseException {

        return tripPageService.getDailyBudgetByTripIdAndDate(Integer.parseInt(id),date);
    }
}
