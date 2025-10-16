package fitness.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fitness.models.Profile;
import fitness.serviceImpl.ProfileService;

@RestController
@RequestMapping("/api/profiles")
@CrossOrigin("*")
public class ProfileController {
@Autowired
private ProfileService service;

@GetMapping("/all")
public List<Profile> getAllProfiles(){
	return service.getAllProfiles();
	}
@GetMapping("/{id}") 
public Profile getById(@PathVariable Long id) {
	return service.getById(id);
}
@PostMapping("/add")
public Profile createProfile(@RequestBody Profile profile) {
	return service.createProfile(profile);
}
@DeleteMapping("/delete{id}")
public void deleteProfile(@PathVariable Long id) {
	service.deleteProfile(id);
}
@PutMapping("/update/{id}")
public Profile updateProfile(@PathVariable Long id, @RequestBody Profile profile) {
    return service.updateProfile(id, profile);
}
}
