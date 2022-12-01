package com.soit.soitfaculty;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soit.soitfaculty.entity.Faculty;

@Controller
@RequestMapping("/Faculties")
public class FacultyController {
	// Upload Faculty info
	private List<Faculty> theFaculties;
	
	@PostConstruct
	private void loadData() {
		
		// Create Faculties
		Faculty fac1 = new Faculty(1, "Kelly", "Miller", "Kelly@uc.edu");
		Faculty fac2 = new Faculty(2, "Robert", "Lee", "Robert@uc.edu");
		Faculty fac3 = new Faculty(3, "Laura", "West", "Laura@uc.edu");
		// Create our List
		theFaculties = new ArrayList<>();
		
		// Add to our List
		theFaculties.add(fac1);
		theFaculties.add(fac2);
		theFaculties.add(fac3);
	}
	//Mapping for "/list"
	@GetMapping("/list")
	public String listFaculties(Model theModel) {
		// Add faculties to Spring Model
		theModel.addAttribute("faculties", theFaculties);
		return "faculties/list-faculties";
	}

	@GetMapping("/viewAddForm")
	public String viewAddForm(Model theModel) {
		
		
		
		//Model attribute for data binding
		Faculty theFaculty = new Faculty();
		
		theModel.addAttribute("faculty", theFaculty);
		
		
		return "faculties/faculty-form";
		
	}
	
	
	@PostMapping("/save")
	public String saveFaculty(@ModelAttribute("faculty") Faculty theFaculty) {
		
		
		
		//Register the Faculty
		facultyService.save(theFaculty);
		
		
		//Block duplicates submission for accidental refresh
		return "redirect:/Faculties/list";
		
	}
}
