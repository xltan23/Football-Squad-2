package sg.edu.nus.iss.VTTPAddEditRemoveList.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.nus.iss.VTTPAddEditRemoveList.models.Footballer;
import sg.edu.nus.iss.VTTPAddEditRemoveList.services.FootballerService;

@Controller
@RequestMapping(path="/football")
public class FootballerController {
    public List<Footballer> players = new ArrayList<>();

    @Autowired
    FootballerService fbSvc;

    @GetMapping(value="/player-list")
    public String playerList(Model model) {
        players = fbSvc.getPlayers();
        model.addAttribute("players", players);
        return "playerList";
    }
   
    @PostMapping(value="/player-list" ,consumes="application/x-www-form-urlencoded", produces="text/html")
    public String postPlayer(@RequestBody MultiValueMap<String,String> form, Model model) {
        Footballer f = new Footballer();
        f.setFullName(form.getFirst("fullName"));
        f.setPosition(form.getFirst("position"));
        f.setRatings(form.getFirst("ratings"));
        fbSvc.addPlayer(f);
        players = fbSvc.getPlayers();
        model.addAttribute("players", players);
        return "playerList";
    }

    @PostMapping(value="/player-to-edit", consumes="application/x-www-form-urlencoded", produces="text/html")
    public String editPlayer(@RequestBody MultiValueMap<String,String> form, Model model) {
        Footballer f = new Footballer();
        f.setId(form.getFirst("id"));
        f.setFullName(form.getFirst("fullName"));
        f.setPosition(form.getFirst("position"));
        f.setRatings(form.getFirst("ratings"));
        model.addAttribute("footballer", f);
        return "editPlayer";
    }

    @PostMapping(value="/player-edit", consumes="application/x-www-form-urlencoded", produces="text/html")
    public String playerEdit(@RequestBody MultiValueMap<String,String> form, Model model) {
        // Previous Footballer
        Footballer f = new Footballer();
        f.setId(form.getFirst("id"));
        fbSvc.delPlayer(f);

        // New Footballer Creation
        String sameId = form.getFirst("id");
        String newName = form.getFirst("fullName");
        String newPosition = form.getFirst("position");
        String newRatings = form.getFirst("ratings");

        fbSvc.addPlayer2(new Footballer(sameId, newName, newPosition, newRatings));

        return "redirect:/football/player-list";
    }

    @PostMapping(value="/delete-player")
    public String deletePlayer(@RequestBody MultiValueMap<String,String> form, Model model) {
        Footballer f = new Footballer();
        f.setId(form.getFirst("id"));
        fbSvc.delPlayer(f);
        return "redirect:/football/player-list";
    }

}
